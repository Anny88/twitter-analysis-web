/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaclasses.ConnectDB.selectSentScore;
import static javaclasses.ConnectDB.selectTags;
import static javaclasses.FindTweets.connectToTwitter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;

import twitter4j.TwitterException;


public class JavaTweet  {

    public static void mainy (String type, double lat, double lon, String keyword) throws TwitterException, IOException {  
        ConnectDB con = new ConnectDB();
        //FindTweets findTweets = new FindTweets();
        //NLP.init();
        //String keyword = "#fun";
        int MAX_QUERIES = 1;
        int TWEETS_PER_QUERY = 55;
        int Id = 2459115; //city WOEID
        //double lat = 40.730610;
        //double lon = -73.935242;       
        //String type = "hs";
        
        int[] rootSent;
        TreeNode Tree = null;
        TreeNode BaumTree;
        
               
        try {
            
            ConnectDB.dropTable();
            ConnectDB.createTable();            
            FindTweets.findByLoc(keyword, MAX_QUERIES,TWEETS_PER_QUERY, lat, lon, 500, type);            
            //sentiment score for the whole set of tweets (root, keyword)
            
            /*
            rootSent = ConnectDB.selectSentScore(15, keyword.toLowerCase(), true);             
            BaumTree = new TreeNode (keyword.toLowerCase(), 100, rootSent);            
            Tree = createHashtagsTree(BaumTree, 15, keyword, false, 0, con);            
           
            System.out.println("\nPlace WOEID: \n");
            int woeid = getWOEID(lat,lon);
            
            if (woeid > 0){
                System.out.println("\n\nTrending topics: \n");
                getHotTopics(Id);
            }
            
            System.out.println("\n\nSentiments: \n");
            getSents(con);
                        
            System.out.println ("BAUM : \n\n");            
            Tree.recursivePrint(); */
            
         } 
        catch (Exception ex) {
            Logger.getLogger(JavaTweet.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }  
    
    
    
     public static TreeNode createHashtagsTree(TreeNode baum, int numberOfTags,  
                                            String tagToSearch, boolean analyseSents, int layer, ConnectDB con){
        System.out.println("Layer " + Integer.toString(layer));
        System.out.println("We search " + tagToSearch+ "\n");
        
        JavaTweet jt = new JavaTweet();
        //JavaTweet.recursivePrint(baum);        
                
        String[] popTags = new String[15];
        double[] popValues = new double[15];
        int count = 0;
        HashMap <String, Integer> tags = new HashMap<String, Integer>();
        ResultSet rs = null;
        int [] Scores = {0,0,0,0,0,0,0};
        tagToSearch = tagToSearch.toLowerCase();        
        
        try{
            if (layer == 0) {
                rs = selectTags(numberOfTags, "0");
            }
            else{
                rs = selectTags(numberOfTags, tagToSearch);
            }                        
            System.out.println("Tags : ");
            while (rs.next()) {
                count++;
                for (int j = 1; j <= numberOfTags; j++){
                    String tag = (rs.getString(j));                    
                    if (tag!= null){                        
                        String tagLC = tag.toLowerCase();
                        if (baum.recursiveSearch(tagLC)== null){
                            if (tags.get(tagLC) == null){
                                tags.put(tagLC, 1);
                            } 
                            else {
                                Integer t = tags.get(tagLC) + 1;
                                tags.put(tagLC, t);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e){
            System.out.println("Exception in resultset: " + e);     }
        System.out.println("Count : " + count + "\n");                       
          
        try{   
            for (int k = 0; k <15; k++){
                //iterate through Map
                Iterator<Map.Entry<String, Integer>> itr = tags.entrySet().iterator();
                int maxValueInMap=(Collections.max(tags.values())); 
                while(itr.hasNext()){
                    Map.Entry<String, Integer> entry = itr.next();
                    if (entry.getValue()==maxValueInMap) {
                        //save relevant tags and values
                        popTags[k] = entry.getKey();
                        popValues[k] =  (entry.getValue()*100)/count;                        
                        itr.remove();
                        break;
                    } 
                }    
                //work with flexible number of tags
                if (((k == 2)|| (k==3))&& (popValues[k] < 10) && (popValues[k-1]/popValues[k]>1.2) ){
                    popValues[k]=0;
                    break;
                }    
                if ((k>3)&& (popValues[3]/popValues[k]>1.1) ){
                    popValues[k]=0;
                    break;
                }  
                //remove added tags from map - for next searches  
                tags.remove(popTags[k]);
                
                System.out.println("Tag " + (k+1) + ": " + popTags[k] + " with value " + popValues[k]+"%");
            
                if (analyseSents){
                    try{
                        Scores = selectSentScore(numberOfTags, popTags[k], false);
                    }
                    catch (Exception e){
                        System.out.println("Exception in Sentiment Scores Select: " + e);
                    }
                }
                //add a new Node with Hashtag, Value and Sentiment Score to the Tree
                baum.recursiveSearch (tagToSearch).addChild(popTags[k], popValues[k], Scores);
            }
            
        } catch (Exception e){
            System.out.println("Exception in map: " + e);
        }
        layer++;
        
        try{
            if (layer <4){
                for (int m = 0; m <popTags.length; m++){
                    if(popValues[m] == 0){
                        break;
                    }
                    createHashtagsTree(baum, numberOfTags, popTags[m], analyseSents, layer, con);
                }    
            }
        }
         catch (Exception e){
             System.out.println("Exception in recursion: " + e);
        } 
        return baum;
    }        
      
    
    public static List getHotTopics(int id) {
        List<String> trendsList = new ArrayList();
        try {
            Twitter twitter = connectToTwitter();
            Trends trends = twitter.getPlaceTrends(id);            
            int count = 0;
            for (Trend trend : trends.getTrends()) {
                if (count < 10) {
                    trendsList.add(trend.getName());                    
                    count++;
                }
            }       
        } 
        catch (TwitterException e) {
            Logger.getLogger(JavaTweet.class.getName()).log(Level.SEVERE, null, e);
        }      
        
        return trendsList;
    }
    
    
    public static int getWOEID(double Latitude, double Longitude){
        
        try {
            String url = "https://query.yahooapis.com/v1/public/yql?q=select%20woeid%20from%20geo.places%20where%20text%3D%22(" + Latitude + "," + Longitude + ")%22%20limit%201&diagnostics=false";
            
            Document yahooApiResponse = Jsoup.connect(url).timeout(10 * 1000).get();
            String xmlString = yahooApiResponse.html();
            Document doc = Jsoup.parse(xmlString, "", Parser.xmlParser());
            
            System.out.println(doc.select("woeid").first().text());
            return Integer.parseInt(doc.select("woeid").first().text().toString());
        } 
        catch (IOException ex) {
            Logger.getLogger(JavaTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    
    
    public static int[] getSents (){
        ResultSet sents = ConnectDB.selectSentiments();
        int sum = 0;
        int count[] = {0,0,0,0,0,0,0};
        int c = 0; //total quantity
        try {
            while (sents.next()){
                int score = sents.getInt(1);
                if (score >= 0 && score <5){
                    sum+=score;
                    c++;
                    count[score]++;
                }
            }
            count [5] = c;
            count [6] = sum;
        } catch (SQLException ex) {
            Logger.getLogger(JavaTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("AAAWsum: " + sum + " count: " + c);
        for (int i=0; i< 5; i++){
            System.out.println("Sentiment " + i + ": " + (float)count[i]/c*100 + "%");
        }
        return count;
        
    }
}
    

    
    
