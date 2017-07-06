/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AJ Rogers
 */
public class Die {
    private final int NUMBER_OF_SIDES = 6;
    
    private ArrayList numSide = new ArrayList(NUMBER_OF_SIDES);
    private String faceLetter = new String();
    
    
    
    
    
   //constructor 
   public Die(){}
    
   public void randomLetter(){
   Random letters = new Random();
   faceLetter = (String)numSide.get(letters.nextInt(6));
   
   
   }
   
   
   public String getLetter(){
   randomLetter();
   return faceLetter;
   }
   
   public void addLetter(String face){
         numSide.add(face);
   }
   
   
   public void displayAllLetters(){
   
      for(int i = 0; i < NUMBER_OF_SIDES; i++){
            System.out.print(numSide.get(i)+" ");
        

}
   
   
   }
   
   
  
   
   
   
}
