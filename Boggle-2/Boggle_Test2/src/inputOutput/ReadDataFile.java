/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AJ Rogers
 */
public class ReadDataFile {
    private static Scanner diceData;
    private static Scanner dictData;
    
    private static String boggleData;
    private ArrayList box = new ArrayList();
    private ArrayList box2 = new ArrayList();
    
    //constructor
    public ReadDataFile(String boggleData){
        
    }

    public ArrayList populateData2(){
        try{
            dictData = new Scanner(ReadDataFile.class.getResourceAsStream("TemporaryDictionary.txt"));
            
            while(dictData.hasNext()){
                box2.add(dictData.next().toUpperCase());
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        finally{
            dictData.close();
        }

        return box2;
    }  
    public void populateData(){
                           
    try{
        
      // read from your scanner
      diceData = new Scanner(ReadDataFile.class.getResourceAsStream("BoggleData.txt"));
 
         //loops through data
     
      while(diceData.hasNext()){
             box.add(diceData.next());
           }  
            
    }
    catch(Exception e){
        System.out.println(e.toString());
        e.printStackTrace();
        
    }
    finally{
        diceData.close();
    
         }
              
    }
    
    
   
   
    public ArrayList getData(){
        return box;
    }
    
   


}


