package javaclasses;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import twitter4j.GeoLocation;
import twitter4j.Query;
import static twitter4j.Query.RECENT;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class FindTweets {
    
    public static List<String>  findByLoc(String keyword, int MAX_QUERIES, int TWEETS_PER_QUERY, double lat, double lon, double res, String type) throws TwitterException, IOException, Exception{
        System.out.println ("TYPE is " + type);
        Twitter twitter = connectToTwitter();    
        if ((type == "s")|| (type=="hs")){
            System.out.println ("TYPE is " + type);
            NLP.init();   
           
        }
        
        ConnectDB conDB = new ConnectDB();
        Connection con = ConnectDB.getConnection();
        ConnectDB.dropTable();
        ConnectDB.createTable(); 
        List<String> lines = new ArrayList<>();   
        
        //int MAX_QUERIES, int TWEETS_PER_QUERY - as parameters 
        
        String resUnit = "mi"; //miles               
         
        int	totalTweets = 0; //number of retrieved Tweets - may be less than TWEETS_PER_QUERY
        long maxID = -1; //variable for lowest Tweet Id
        
        //There are time limits on search calls to Twitter API
        //This returns all the various rate limits in Twitter API
        Map<String, RateLimitStatus> rateLimitStatus = twitter.getRateLimitStatus("search");
        //This finds the rate limit specifically for doing the search API calls
        RateLimitStatus searchTweetsRateLimit = rateLimitStatus.get("/search/tweets");
              
        System.out.printf("You have %d calls remaining out of %d, Limit resets in %d seconds\n",
            searchTweetsRateLimit.getRemaining(),
            searchTweetsRateLimit.getLimit(),
            searchTweetsRateLimit.getSecondsUntilReset());        
        
        try{     
            //retrieve multiple blocks of tweets from Twitter
            for (int queryNumber = 0; queryNumber < MAX_QUERIES; queryNumber++) {
                System.out.printf("\n! Starting loop %d\n", queryNumber);
                
                //check if delay needed - rate limits
                if (searchTweetsRateLimit.getRemaining() == 0) {
                    System.out.printf("!!! Sleeping for %d seconds due to rate limits\n", 
                            searchTweetsRateLimit.getSecondsUntilReset());
                    Thread.sleep((searchTweetsRateLimit.getSecondsUntilReset()+2) * 1000l);
                }
                Query query = new Query(keyword);      
                
                query.geoCode(new GeoLocation(lat,lon), res, resUnit); 
                query.count(TWEETS_PER_QUERY);
                query.resultType(RECENT);
                if ((type == "s")|| (type=="hs")){                       
                    query.setLang("en");
                }
                
                QueryResult result = twitter.search(query);

                if (maxID != -1) {
                    query.setMaxId(maxID - 1);
                }         
                if (result.getTweets().size() == 0) {
                    break; // Nothing? We must be done
                }

                for (Status s: result.getTweets()) {
                    totalTweets++;
                    int sentimentScore;
                    String tweetReady = null;
                    
                    if (maxID == -1 || s.getId() < maxID) {
                        maxID = s.getId();
                    }
                    if (!s.isRetweet()){
                       tweetReady = cleanText(s.getText());                                     
                    }                   
                    if (s.isRetweet()){
                       tweetReady = "RT " + cleanText(s.getRetweetedStatus().getText()); 
                    }                  
                    
                    if (tweetReady != null){
                        if (type == "s"){
                        
                        sentimentScore = NLP.findSentiment(tweetReady);   //identify sentiment of tweet 
                        //insert tweets with sentiments
                        ConnectDB.insertSents (tweetReady, sentimentScore, con);
                        }
                        if (type == "hs"){
                        //identify sentiment of tweet 
                        sentimentScore = NLP.findSentiment(tweetReady);     
                        //insert tweets with sentiments and tags
                        ConnectDB.insertHashtags (tweetReady, sentimentScore,con);
                        }
                        if (type == "h"){                                               
                        //insert tweets with tags
                        ConnectDB.insertHashtags (tweetReady, 0,con);
                        }
                    }                                       
                }
                searchTweetsRateLimit = result.getRateLimitStatus();
            }
        }
        catch (Exception e) {
            System.out.println("Error in findByLoc"); 
            e.printStackTrace();
        }
        System.out.printf("\n\nA total of %d tweets retrieved\n", totalTweets);
        return lines;      
    }
    /*
    public static String createInsertString(String tweetReady, int score) {
       //int score = 0;
       String insert = null, values = null;
       int size = 0;
        try{
            List <String> tags = getWords(tweetReady);
            insert = "INSERT INTO tweets(maintweet,score";
            values = " VALUES ('"+tweetReady+"', '"+score+"'";
            if (tags.size() > 15) {
                size = 15;
            }
            else { 
                size = tags.size();
            }
            for (int j = 0; j<size; j++){
               String num = Integer.toString(j+1);
               insert += ", tag" + num;
               values += ", '"+tags.get(j)+"' ";
            }
            insert += ")";
            values += ")";
        }
        catch (Exception e){
            System.out.println("Error in insert : " + e);
            System.out.println(tweetReady);
        }
        return (insert+values);
    } */
    
    
  
    //extract tags from tweet
    public static List getWords(String tweet) throws Exception{
        
        String[] subStr;
        char[] c;
        List <String> tags = new ArrayList();
        
        int hash = 0;
        int end = 0;
        boolean found = false; //checks if the beginning of hashtag was found
        
        if (tweet.length() > 0){
            try{
                String tweet2 =  tweet.replaceAll("[^a-zA-Z0-9#_]+"," ")+" ";
                c = tweet2.toCharArray();
                for(int i = 0; i < c.length; i++) { 
                                                      
                    if ((c[i]==' ' || c[i] == '#')&& found){
                        found = false;
                        end = i;
                        if (hash < (end-1)){
                            tags.add(tweet2.substring(hash, end).toLowerCase());                            
                        }
                        //System.out.println(" 2 found =" + found + " hash = " + hash + " end= " + end);
                    }
                    if (c[i] == '#' && !found){                        
                        found = true;
                        hash = i;                     
                    }  
                }
                
                /*char first = subStr[i].charAt(0);
                    if (first == '#'){
                        tags.add(subStr[i].toLowerCase());*/
                if (tags.isEmpty()) {
                    tags.add("notag");
                }
                return tags;
            }
            catch (Exception e){
               System.out.println("Error in getWords " + tags.get(0)+ " " + e);  
            }
        }
        if (tags.isEmpty()) {
                    tags.add("notag");
                }
        return tags;
        
        
    }
    
    
    
     public static String cleanText(String text) {
        text = text.replace("\n", " ");
        text = text.replace("\t", " ");
        text = text.replace("'", "\\'");
        //text = text.replaceAll("[^a-zA-Z0-9#@ ]+","");
        return text;
     }
    
     
    public static Twitter connectToTwitter() throws TwitterException{
        try {
            String consumerKey = "ku7BH6QZD1pUq3iQ4ZDzE0dXw";
            String consumerSecret = "3QYliH3QJ5pKhmjcAHsWSRjhzStfX3dDu5vSNuAm85Po1aGdnp";
            String accessToken = "970942326284615680-tiLuPn73gBUkAtXEYokoPFDGv0AOFow";
            String accessTokenSecret = "mVqDgh7u6MzxI11pyHf8gC6FjMBqJsfj4rA1EJAxXIpFs";
                    
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(consumerKey)
                    .setOAuthConsumerSecret(consumerSecret)
                    .setOAuthAccessToken(accessToken)
                    .setTweetModeExtended(true)
                    .setOAuthAccessTokenSecret(accessTokenSecret);
                    
            TwitterFactory factory = new TwitterFactory(cb.build());
            Twitter twitter = factory.getInstance();
            return twitter;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }    

}
