package javaclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaclasses.FindTweets.getWords;

/**
 *
 * @author Anna
 */
public class ConnectDB {
     public static Connection getConnection() throws Exception {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3307/twitter";
            String username = "root";
            String password = "SleepyTiger7744@";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("connected");
            return conn;
        }
        catch (Exception e){
            System.out.println(e);
            
        }
        return null;
    }
     
     public static void createTable() throws Exception {
         try{
            Connection con = getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS tweets("
                     + "id int NOT NULL AUTO_INCREMENT,"
                     + "maintweet VARCHAR(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL, "
                     + "score int,"
                     + "tag1 VARCHAR(280), "
                     + "tag2 VARCHAR(280),"
                     + "tag3 VARCHAR(280),"
                     + "tag4 VARCHAR(280),"
                     + "tag5 VARCHAR(280),"
                     + "tag6 VARCHAR(280),"
                     + "tag7 VARCHAR(280),"
                     + "tag8 VARCHAR(280),"
                     + "tag9 VARCHAR(280),"
                     + "tag10 VARCHAR(280),"
                     + "tag11 VARCHAR(280),"
                     + "tag12 VARCHAR(280),"
                     + "tag13 VARCHAR(280),"
                     + "tag14 VARCHAR(280),"
                     + "tag15 VARCHAR(280),"
                     + "PRIMARY KEY (id) )";
            String alterTable = "ALTER TABLE tweets CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_bin"; 
            PreparedStatement create = con.prepareStatement(createTable);
            create.executeUpdate();
            PreparedStatement alter = con.prepareStatement(alterTable);
            alter.executeUpdate();
         }
         catch (Exception e){
             System.out.println(e);
         }
         finally {System.out.println("Create table complete");}
     }
         
     public static void dropTable() throws Exception{
         try{
             Connection con = getConnection();
             PreparedStatement drop = con.prepareStatement("DROP table tweets");
             drop.executeUpdate();
         }
         catch (Exception e){
             System.out.println(e);
         }
         finally {System.out.println("Drop complete");}
     }    
    
    public static void insertSents(String tweetReady, int score, Connection con) throws SQLException {
       //int score = 0;
       String insert = null;
       //Connection con;
        try{            
            con = getConnection();
            //dropTable();
            //createTable();
            
            insert = "INSERT INTO tweets(maintweet,score) VALUES ('"+tweetReady+"', '"+score+"')";
            PreparedStatement posted = con.prepareStatement (insert);
            posted.executeUpdate();
        }
        catch (Exception e){
            System.out.println("Error in insert : " + e);
            System.out.println(tweetReady);
        }
        
    } 
    
    
    public static void insertHashtags(String tweetReady, int score, Connection con) throws SQLException {
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
            PreparedStatement posted = con.prepareStatement (insert+values);
            posted.executeUpdate();
        }
        catch (Exception e){
            System.out.println("Error in insert : " + e);
            System.out.println(tweetReady);
        }
        
    } 
    
    
    public static ResultSet selectSentiments(){
        ResultSet rs = null;
        String selectScore = "select score from tweets";
                
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(selectScore);            
            return rs;
            //stmt.close();
           
        } catch (Exception e){
            System.out.println("Exception in select " + e);
        }
        return rs;
         
    } 
     
    public static ResultSet selectTags(int numberOfTags, String tagToSearch){
        ResultSet rs = null;
        String selectTags = "select tag1";
                 
        for (int i=1; i<numberOfTags; i++){
            String num = Integer.toString(i+1);
            selectTags += ", tag" + num;
        }
        selectTags+= " from tweets"; 
        
        if (tagToSearch != null){
            selectTags+= " where tag1 = '"+tagToSearch+"' ";
            for (int i=1; i<numberOfTags; i++){
                String num = Integer.toString(i+1);
                selectTags += " OR tag" + num + " = '"+tagToSearch+"'";
            }
        }
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(selectTags);            
            return rs;
           
        } catch (Exception e){
            System.out.println("Exception in select " + e);
        }
        return rs;         
    }
     
    public static int[] selectSentScore (int numberOfTags, String tagToSearch, boolean isRoot){
        int[] result = {0,0,0,0,0,0,0};
        result[0] = 0;
        ResultSet rs = null;
        String selectTags = "";     
             
        if (tagToSearch != null){
            if (isRoot){
                selectTags = "select score from tweets;";
            }
            else{
                selectTags = "select score from tweets where tag1 =  '"+tagToSearch+"' ";
                for (int i=1; i<numberOfTags; i++){
                    String num = Integer.toString(i+1);
                    selectTags += " OR tag" + num + " = '"+tagToSearch+"'";
                }
            }
            try {
                Connection con = getConnection();
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(selectTags);           

            } catch (Exception e){
                System.out.println("Exception in select " + e);
            }
        }
        
        if (rs != null){
            
                        
            try {
                while (rs.next()){
                    int score = rs.getInt(1);
                    if (score >= 0 && score <5){

                        result[score]++;
                        result[5]++; //count all scores
                        result[6]+=score; //sum of all scores
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JavaTweet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        return result;
    }
    
    
    
     
    
    
  
}
