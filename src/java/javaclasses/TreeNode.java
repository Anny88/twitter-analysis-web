/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Anna
 */
//implements Iterable<TreeNode<T>>
public class TreeNode  {

    //private Datas datas;
    private final String tag;
    private final double value;
    private final int[] scores;
    TreeNode parent;
    List<TreeNode> children;

    public TreeNode(String s, double v, int[] score) {
        this.tag = s;
        this.value = v;
        this.scores = score;
        this.children = new LinkedList<TreeNode>();
    }

    public String getTag(){
        return tag;
    }
    public String getValue(){
        return Double.toString(value);
    }
    public int[] getScores(){
        return scores;
    }
    public TreeNode getParent(){
        if (parent != null){
                return parent;
        }
        else 
        return new TreeNode ("noparent", 0, null);
    }
    public void addChild(String s, double v, int[] scores) {
        TreeNode childNode = new TreeNode(s,v,scores);
        
        childNode.parent = this;
        this.children.add(childNode);
        //return childNode;
    } 
     
    public List<TreeNode> getChildren (){
        if (children != null){
            return children;
        }
        else return null;
    }
       
    
    
    
    public void recursivePrint(){   
        //TreeNode node = this;
        System.out.print (this.getTag()+ " "+ this.getValue()+ "  ");
        List<TreeNode> children = this.getChildren(); 
        //if (node.parent.getTag() != null){
        System.out.println ("parent: " + this.getParent().getTag());
        int[] scores = this.getScores();
        for (int j = 0; j < 5; j++){
            System.out.println ("   Score"+ j + ": " + scores[j]);
        }    
        System.out.print ("Count: "+ scores[5] + " Sum: " + scores[6]);
        System.out.println (" Average: "+ (float)scores[6]/scores[5]);
        TreeNode result = null;
        
        for (int i = 0; result == null && i < children.size(); i++) {         
            children.get(i).recursivePrint();
        }
    }
    
    
    public TreeNode recursiveSearch(String s){
    
        if (this.getTag() == null ? s == null : this.getTag().equals(s)) {
            return this;
        }
        else {   
            List<TreeNode> children = this.getChildren(); 
            TreeNode result = null;

            for (int i = 0; result == null && i < children.size(); i++) {         
                result = children.get(i).recursiveSearch(s);
            }
            return result;
        }

    }
    
    // other features ...

}