/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.TwitterException;


public class JavaTweet  {

    public static TreeNode mainy(String keyword) throws TwitterException, IOException {  
        ConnectDB con = new ConnectDB();
        FindTweets findTweets = new FindTweets();
        //String keyword = "#usa";
        int MAX_QUERIES = 1;
        final int TWEETS_PER_QUERY = 100;
        List<String> tree = new ArrayList();
        tree.add(keyword.toLowerCase());
         TreeNode Baum = null;      
        try {
            con.drop();
            con.createTable();
            //List <String> tweets = findTweets.findByLoc(keyword, MAX_QUERIES,TWEETS_PER_QUERY);
            findTweets.findByLoc(keyword, MAX_QUERIES,TWEETS_PER_QUERY);
            
           //con.post(tweets);
            Baum  = con.getRelatedTags(tree, 15, MAX_QUERIES*TWEETS_PER_QUERY , keyword,null, 0);
            
            /*for(String tweet : tweets) {
                System.out.println(tweet + " : " + NLP.findSentiment(tweet));        
            }*/
         } 
        catch (Exception ex) {
            Logger.getLogger(JavaTweet.class.getName()).log(Level.SEVERE, null, ex);
        }       
        //System.out.println ("\n\n\n"+Baum.getTag()+ " "+ Baum.getValue());
        recursivePrint(Baum);
        return Baum;
    }       
    
    private static void recursivePrint(TreeNode node){
    
    System.out.println (node.getTag()+ " "+ node.getValue());
         
 
    List<TreeNode> children = node.getChildren(); 
    TreeNode result = null;
 
    System.out.println ("BAUM : \n\n");
    for (int i = 0; result == null && i < children.size(); i++) {         
        recursivePrint(children.get(i));
    }
    /* System.out.println ("NODE : \n\n");
     
     System.out.println (node.getChildren().get(0).getChildren().get(0).getTag()+ 
             " "+ node.getChildren().get(0).getChildren().get(0).getValue());
    */
 } 
}
    

    
    
