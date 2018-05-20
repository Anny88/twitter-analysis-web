/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

/**
 *
 * @author Anna
 */
 public  class Datas {
        private String tagName;
        private int value;
        
        public Datas (String name, int value){
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
