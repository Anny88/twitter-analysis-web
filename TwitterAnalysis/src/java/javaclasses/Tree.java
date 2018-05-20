/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anna
 */
public class Tree<Data> {
    
    Node<Data> root;

    public Tree(Data rootData) {
        root = new Node<Data>();
        root.data = rootData;
        root.children = new ArrayList<Node<Data>>();
    }

    public static class Node<Data> {
        private Data data;
        private Node<Data> parent;
        List<Node<Data>> children;
    }
    
    
    
    public static class Data {
        private String tagName;
        private int value;
        
        public Data (String name, int value){
            this.tagName = name;
            this.value = value;
        }
        public String getName(){
            return tagName;
        }
        public int getValue(){
            return value;
        }
        public void setName (String name){
            this.tagName = name;
        }
        public void setName (int value){
            this.value = value;
        }
    }

}
