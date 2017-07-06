/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author AJ Rogers
 */
public class Board {
    //constants
    private final static int NUMBER_OF_DICE = 16;
    private final static int NUMBER_OF_SIDES = 6;
    private final static int GRID = 4;
    
// stores all dice data
    private static ArrayList allData = new ArrayList(); 
    
    // stores 16 dice objects
    private static ArrayList<Die> allDice = new ArrayList<Die>();
    
    //constructor
    public Board(ArrayList x){
        allData = x;
}
    public static void populateDice(){
    Die x = new Die();
    int z = 0;
    
    for(int i = 0; i < NUMBER_OF_DICE; i++){
        x = new Die();
        
            for(int j = 0; j < NUMBER_OF_SIDES; j++){
            
            x.addLetter((String)allData.get(z));
            z++;
            }
         //System.out.print("Die "+ i + ": ");
         //x.displayAllLetters();
         System.out.print("\n");
        allDice.add(x);
    }
   
    }
    
    public static ArrayList shakeDice(){
   populateDice();
   ArrayList tempArray = new ArrayList();
   String holdsLetter = "";
     //System.out.println("Boggle Board");
        for(int i = 0; i < NUMBER_OF_DICE; i++){
     
        if(i == 3 || i == 7 || i == 11){
            holdsLetter = allDice.get(i).getLetter();
             //System.out.println(holdsLetter +" ");
             
             tempArray.add( holdsLetter.toString());
        }else{
            holdsLetter = allDice.get(i).getLetter();
             //System.out.print(holdsLetter + " ");
             tempArray.add(holdsLetter.toString());
            }
        }
    Collections.shuffle(tempArray);
     
    return tempArray;
    }
}
