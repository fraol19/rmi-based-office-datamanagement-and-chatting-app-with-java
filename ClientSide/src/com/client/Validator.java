package com.client;


public class Validator {
   
    
    public static boolean isAlpha(String x){
       boolean is = true;
         for(int i=0; i<x.length() ; i++){
             if(Character.isAlphabetic(x.charAt(i))){
                is = true;
             }else{
                is = false;
                break;
             }
         }
       return is;
    }
    
    public static boolean isDigit(String x){
       boolean is = true;
         for(int i=0; i<x.length() ; i++){
             if(Character.isDigit(x.charAt(i))){
                is = true;
             }else{
                is = false;
                break;
             }
         }
       return is;
    }
    
    
}
