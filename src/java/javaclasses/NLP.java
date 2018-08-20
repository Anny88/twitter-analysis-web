/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;



public class NLP {
    private static StanfordCoreNLP pipeline;

    public static void init() {
         pipeline = new StanfordCoreNLP("MyPropFile.properties");
    }

    public static int findSentiment(String tweet) {
            
        int mainSentiment = 0;
        if (tweet != null && tweet.length() > 0) {
                tweet = preprocess(tweet);                
                int longest = 0;
                Annotation annotation = pipeline.process(tweet);                
                for (CoreMap sentence : annotation
                                .get(CoreAnnotations.SentencesAnnotation.class)) {
                        Tree tree = sentence
                                        .get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                        int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                        
                        String partText = sentence.toString();
                        if (partText.length() > longest) {
                                mainSentiment = sentiment;                                
                                longest = partText.length();
                        }
                }
        }        
        return mainSentiment;
        
    }
    
    //preprocessing = clean text
    public static String preprocess (String s){
       
        String str = "";        
        StringTokenizer st = new StringTokenizer(s);
        List<String> stopWords = Arrays.asList("RT", "URL", "the", "The","A","a", 
                                               "An", "an", "Is", "is", "to", "it", "of");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            //delete URLs, usernames and stop words
           if (!((stopWords.contains(token)) || (token.matches("(http|@|#).*"))) ){
                str = str + token + " ";
            }
        };
        //replace symbols except letters and punctuation
        str = str.replaceAll("[^,!?:.a-zA-Z ]+","");
        return str;
    }
}


