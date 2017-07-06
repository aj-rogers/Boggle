/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggle;

import core.Board;
import inputOutput.ReadDataFile;
import java.util.ArrayList;
import java.util.Scanner;
import userInterface.BoggleUi;
//import javax.swing.JFrame;

/**
 *
 * @author AJ Rogers
 */
public class Boggle {
private static String x = "t";
    

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList letters = new ArrayList();
     

        //reading the txt file
        ReadDataFile read = new ReadDataFile(x);
            read.populateData();
            letters = read.getData();
       
       
        
      Board board = new Board(letters);
      //randomize
      board.shakeDice(); 
      
      //User Interface Object
      BoggleUi ui = new BoggleUi(board); 
      ui.getDictionary(read.populateData2());
      ui.UiMethod();
     //read in dictionary
    }
    
  
    
    //constructor
    public Boggle(){
        System.out.println ("hello");
    }
    
}
