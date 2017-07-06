/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;



import javax.swing.Timer;
import core.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author AJ Rogers
 */
public class BoggleUi {
    private JFrame frame;
    
    private Timer timer;
    private int min;
    private int sec;
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    
   
    
    private JPanel panel;
    private JPanel centerPanel;
    private JPanel centerBottom;
    private JLabel bottomLabel;
   
    
    private JButton shakeButton;
    private JLabel score;
    
    private JScrollPane scroll;
    
    private JLabel centerLabel;
    private JButton centerButton;
    private JTextArea textArea;

    private ArrayList usedWords=new ArrayList();
    private ArrayList buttonText;
    private ArrayList dictWords;
    
    private ArrayList<JButton>  buttons;
    private boolean[] disabledButtons;
    private String letter = ""; 
    //private Timer timer;   
    private String[] tempWord;
    private int tempScore;
    private String scoreText;
    private boolean timerActive;
   
    private int x = 0; 
    private String guess;
    private ArrayList compSubmittedWords = new ArrayList();
    
    private int compScore;
    private int sameScore;
    
       //constructor
 public BoggleUi(Board board){
    
     buttonText = board.shakeDice();
     initComponents();
     
}
 
        void initComponents(){
        
         //initialize all JComponents
         frame = new JFrame("Boggle");
         panel = new JPanel();
         centerPanel = new JPanel();
         menuBar = new JMenuBar();
         menu = new JMenu("Boggle");
         menuItem1 = new JMenuItem("New Game");
         menuItem2 = new JMenuItem("Exit");
        
         bottomLabel = new JLabel ("     " + letter + "     ");
         centerPanel = new JPanel();
         textArea = new JTextArea(); 
         scroll = new JScrollPane(textArea);
         score = new JLabel(scoreText);
         
         shakeButton = new JButton("Shake Dice");
         centerButton = new JButton("    Submit    ");
         timer = new Timer(1000, new TimerListener());
         min = 3;
         sec = 01;
         buttons = new ArrayList<JButton>();
         timerActive = false;
        
           disabledButtons = new boolean[16];
           
        for(int x = 0;x < 16;x++){
                disabledButtons[x] = false;
            }   
        
       
        
    }
    
   //ui Method to make the frame
    public void UiMethod(){
    
   
     initComponents();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setJMenuBar(UiMenu());  
    frame.add(UiButtons());
    frame.add(UiText());
        centerBottom.setBorder(BorderFactory.createTitledBorder("Current Word"));
      
        centerBottom.add(bottomLabel);
        //centerButton = new JButton("    Submit    ");
        centerBottom.add(centerButton);
           
         centerButton.setPreferredSize(new Dimension(110,60));
         centerButton.addActionListener(new SubmitListener());
         centerBottom.add(score);
          
       bottomLabel.setBorder(BorderFactory.createTitledBorder("Current Word"));
       bottomLabel.setPreferredSize(new Dimension(450,60));
       score.setBorder(BorderFactory.createTitledBorder("score"));
       score.setPreferredSize(new Dimension(100,60));
        frame.add(panel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(centerBottom, BorderLayout.SOUTH);
        panel.setVisible(true); 
        centerPanel.setVisible(true); 
        frame.setVisible(true);
       
        
     
      
    
   }   
    //setup menu method
    public JMenuBar UiMenu(){
         menu.setMnemonic(KeyEvent.VK_B);
         //menu items 1
       menuItem1.setMnemonic(KeyEvent.VK_N);
       
        //menu items 2
       menuItem2.setMnemonic(KeyEvent.VK_E);
       
       menu.add(menuItem1);
       menu.add(menuItem2);
       menuBar.add(menu);
     menuItem2.addActionListener(new ExitListener());
     menuItem1.addActionListener(new ResetListener());
    return menuBar;
    }
        //letter buttons
    
    public JPanel UiButtons(){  
           
      panel = new JPanel(new GridLayout(4,4));
      panel.setBorder(BorderFactory.createTitledBorder("Boggle"));
        
      int x = 0;
      for(int i = 0; i <16; i++){
          
                
         buttons.add(new JButton( buttonText.get(x).toString()));
        //buttons[i].addActionListener (new LetterButtonsAction());
         buttons.get(i).setText(buttonText.get(i).toString());
         panel.add( buttons.get(i) );
      }

      buttons.get(0).addActionListener(new buttonListener0());
        buttons.get(1).addActionListener(new buttonListener1());
        buttons.get(2).addActionListener(new buttonListener2());
        buttons.get(3).addActionListener(new buttonListener3());
        buttons.get(4).addActionListener(new buttonListener4());
        buttons.get(5).addActionListener(new buttonListener5());
        buttons.get(6).addActionListener(new buttonListener6());
        buttons.get(7).addActionListener(new buttonListener7());
        buttons.get(8).addActionListener(new buttonListener8());
        buttons.get(9).addActionListener(new buttonListener9());
        buttons.get(10).addActionListener(new buttonListener10());
        buttons.get(11).addActionListener(new buttonListener11());
        buttons.get(12).addActionListener(new buttonListener12());
        buttons.get(13).addActionListener(new buttonListener13());
        buttons.get(14).addActionListener(new buttonListener14());
        buttons.get(15).addActionListener(new buttonListener15());
         panel.setPreferredSize(new Dimension(450,500));
      
      
      
        
       return panel;
     }
    
    public JPanel UiText(){
        int x = 100;
        int y = 100;
        String z = "";
    centerLabel = new JLabel("        3:00        ");
    centerPanel = new JPanel();
    centerBottom = new JPanel();
    textArea = new JTextArea(); 
    scroll = new JScrollPane(textArea);
    
    
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
                //textbox 
            centerPanel.add(scroll);
           centerPanel.setBorder(BorderFactory.createTitledBorder("Enter words here"));
                        
          //timer
          centerPanel.add(centerLabel);
          centerLabel.setBorder(BorderFactory.createTitledBorder("Timer"));
          centerLabel.setFont(new Font("Serif", Font.BOLD, 50));
          
          //button - shake
          /*
          centerButton = new JButton("Shake Dice");
          centerPanel.add(centerButton);
          centerButton.setPreferredSize(new Dimension(100,60));
          centerButton.addActionListener(new ResetListener());*/
          centerPanel.add(shakeButton);
          shakeButton.setPreferredSize(new Dimension(100,60));
          shakeButton.addActionListener(new shakeListener());
          
          //button - submit
          
          
          
         return centerPanel;
    }
    
    private int determineMove(int i){
            disabledButtons[i] = true;
            int num = 0;
    //if(tryAgain)
            if(i == 0){
                num = (int)Math.floor(Math.random() * 3);
                
                if(num == 0){
                    if(disabledButtons[1] == false){
                        return determineFunction(1);
                        //guess = guess + dieText.get(1).toString();
                        //disabledButtons[1] = true;
                        //return 1;
                    }
                }//num == 0
                else if(num == 1){
                    if(disabledButtons[4] == false){
                        return determineFunction(4);
                        //guess = guess + dieText.get(4).toString();
                        //disabledButtons[4] = true;
                        //return 4;
                    }
                }//num == 1
                else if(num == 2){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                        //guess = guess + dieText.get(5).toString();
                        //disabledButtons[5] = true;
                        //return 2;
                    }
                }//num == 2
                
            }//ends if(i == 0)
            else if(i == 1){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[0] == false){
                        return determineFunction(0);
                    }
                }//num == 0
                else if(num == 1){
                    if(disabledButtons[2] == false){
                        return determineFunction(2);
                    }
                }//num == 1
                else if(num == 2){
                    if(disabledButtons[4] == false){
                        return determineFunction(4);
                    }
                }//num == 2
                else if(num == 3){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }//num == 3
                else if(num == 4){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }//num == 4
            }//ends if(i == 1)
            
            else if(i == 2){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[1] == false){
                        return determineFunction(1);
                    }
                }//num == 0
                else if(num == 1){
                    if(disabledButtons[3] == false){
                        return determineFunction(3);
                    }
                }//num == 1
                else if(num == 2){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }//num == 2
                else if(num == 3){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }//num == 3
                else if(num == 4){
                    if(disabledButtons[7] == false){
                        return determineFunction(7);
                    }
                }//num == 4
            }//ends if(i == 2)
            else if(i == 3){
                num = (int)Math.floor(Math.random() * 3);
                
                if(num == 0){
                    if(disabledButtons[2] == false){
                        return determineFunction(2);
                    }
                }//num == 0
                else if(num == 1){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }//num == 1
                else if(num == 2){
                    if(disabledButtons[7] == false){
                        return determineFunction(7);
                    }
                }//num == 2
            }//ends if(i == 3)
            else if(i == 4){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[0] == false){
                        return determineFunction(0);
                    }
                }//num == 0
                else if(num == 1){
                    if(disabledButtons[1] == false){
                        return determineFunction(1);
                    }
                }//num == 1
                else if(num == 2){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }//num == 2
                else if(num == 3){
                    if(disabledButtons[8] == false){
                        return determineFunction(8);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
            }//ends if(i == 4)
            else if(i == 5){
                num = (int)Math.floor(Math.random() * 8);
                
                if(num == 0){
                    if(disabledButtons[0] == false){
                        return determineFunction(0);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[1] == false){
                        return determineFunction(1);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[2] == false){
                        return determineFunction(2);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[4] == false){
                        return determineFunction(4);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }
                else if(num == 5){
                    if(disabledButtons[8] == false){
                        return determineFunction(8);
                    }
                }
                else if(num == 6){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 7){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
            }//ends if(i == 5)
            else if(i == 6){
                num = (int)Math.floor(Math.random() * 8);
                
                if(num == 0){
                    if(disabledButtons[1] == false){
                        return determineFunction(1);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[2] == false){
                        return determineFunction(2);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[3] == false){
                        return determineFunction(3);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[7] == false){
                        return determineFunction(7);
                    }
                }
                else if(num == 5){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 6){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 7){
                    if(disabledButtons[11] == false){
                        return determineFunction(11);
                    }
                }
            }//ends if(i == 6)
            else if(i == 7){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[2] == false){
                        return determineFunction(2);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[3] == false){
                        return determineFunction(3);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[11] == false){
                        return determineFunction(11);
                    }
                }
            }//ends if(i == 7)
            else if(i == 8){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[4] == false){
                        return determineFunction(4);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[12] == false){
                        return determineFunction(12);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[13] == false){
                        return determineFunction(13);
                    }
                }
            }//ends if(i == 8)
            else if(i == 9){
                num = (int)Math.floor(Math.random() * 8);
                
                if(num == 0){
                    if(disabledButtons[4] == false){
                        return determineFunction(4);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[8] == false){
                        return determineFunction(8);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 5){
                    if(disabledButtons[12] == false){
                        return determineFunction(12);
                    }
                }
                else if(num == 6){
                    if(disabledButtons[13] == false){
                        return determineFunction(13);
                    }
                }
                else if(num == 7){
                    if(disabledButtons[14] == false){
                        return determineFunction(14);
                    }
                }
            }//ends if(i == 9)
            else if(i == 10){
                num = (int)Math.floor(Math.random() * 8);
                
                if(num == 0){
                    if(disabledButtons[5] == false){
                        return determineFunction(5);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[7] == false){
                        return determineFunction(7);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[11] == false){
                        return determineFunction(11);
                    }
                }
                else if(num == 5){
                    if(disabledButtons[13] == false){
                        return determineFunction(13);
                    }
                }
                else if(num == 6){
                    if(disabledButtons[14] == false){
                        return determineFunction(14);
                    }
                }
                else if(num == 7){
                    if(disabledButtons[15] == false){
                        return determineFunction(15);
                    }
                }
            }//ends if(i == 10)
            else if(i == 11){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[6] == false){
                        return determineFunction(6);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[7] == false){
                        return determineFunction(7);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[14] == false){
                        return determineFunction(14);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[15] == false){
                        return determineFunction(15);
                    }
                }
            }//ends if(i == 11)
            else if(i == 12){
                num = (int)Math.floor(Math.random() * 3);
                
                if(num == 0){
                    if(disabledButtons[8] == false){
                        return determineFunction(8);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[13] == false){
                        return determineFunction(13);
                    }
                }
            }//ends if(i == 12)
            else if(i == 13){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[8] == false){
                        return determineFunction(8);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[12] == false){
                        return determineFunction(12);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[14] == false){
                        return determineFunction(14);
                    }
                }
            }//ends if(i == 13)
            else if(i == 14){
                num = (int)Math.floor(Math.random() * 5);
                
                if(num == 0){
                    if(disabledButtons[9] == false){
                        return determineFunction(9);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[11] == false){
                        return determineFunction(11);
                    }
                }
                else if(num == 3){
                    if(disabledButtons[13] == false){
                        return determineFunction(13);
                    }
                }
                else if(num == 4){
                    if(disabledButtons[15] == false){
                        return determineFunction(15);
                    }
                }
            }//ends if(i == 14)
            else if(i == 15){
                num = (int)Math.floor(Math.random() * 3);
                
                if(num == 0){
                    if(disabledButtons[10] == false){
                        return determineFunction(10);
                    }
                }
                else if(num == 1){
                    if(disabledButtons[11] == false){
                        return determineFunction(11);
                    }
                }
                else if(num == 2){
                    if(disabledButtons[14] == false){
                        return determineFunction(14);
                    }
                }
            }//ends if(i == 15)
    //}//ends bool thing
            return 78;
    }//ends determineMove()
       private int determineFunction(int i){
        System.out.println("determineFunction, i = "+i+" = "+buttonText.get(i).toString());
        System.out.println(guess+" + "+buttonText.get(i).toString()+" = "+(guess = guess + buttonText.get(i).toString()));
        System.out.println("in determineFunction()");
        for(int q =0;q<16;q++){
            if(q==3||q==7||q==11||q==15){
            System.out.print(buttonText.get(q).toString()+" \n");}
            else{
            System.out.print(buttonText.get(q).toString()+" ");}
        }
        
        //System.out.println("guess = "+guess);
        //guess = guess + dieText.get(i).toString();
        disabledButtons[i] = true;
        //gridButtons.get(i).setEnabled(false);
        //System.out.println("disabledButtons["+i+"] = "+disabledButtons[i]);
        return i;
    }
   
     private void simulateComputer(){
        for(int i = 0;i < 16;i++){
            disabledButtons[i] = false;
            //gridButtons.get(1).setEnabled(true);
        }
//        textThing.append("The computer is comparing it's words to yours\n");
        //System.out.println("The computer is comparing it's words to yours");
        /*
        System.out.println("In simulateComputer()");
        for(int w = 0; w < 16; w++){
            if(w == 3 || w == 7 || w == 11 || w == 15)
                System.out.print(dieText.get(w) + " \n");
            else
                System.out.print(dieText.get(w) + " ");
        }*/
        int x;
        
        for(int i = 0;i < 200; i++){
            x = (int)Math.floor(Math.random() * 16);
            guess = "";
            
            for(int j = 0;j < 16;j++){
                disabledButtons[j] = false;}
            
            for(int p = 0;p < 7;p++){
                if(p == 0){
                    System.out.println("in simulateComputer()");
                    guess = guess + buttonText.get(x).toString();}
                //System.out.println("guess = "+guess);
                
                x = determineMove(x);//this will take a random leter & add it to compGuess
                //if the word is in the dictionary, is longer than 1 letter, compSubmittedWords doesn't already have it
                //if(dictWords.contains(guess) && p > 0 && !compSubmittedWords.contains(guess)){
                if(dictWords.contains(guess) && !compSubmittedWords.contains(guess)){
                    compSubmittedWords.add(guess);
                    x = 78;
                }
                if(x == 78){
                    p = 7;}
            }
        }
        
        
        System.out.println("compSubmittedWords.size() = "+compSubmittedWords.size());
        int cSWLength = compSubmittedWords.size();
        //for(int i = 0;i < compSubmittedWords.size();i++){
        for(int i = 0;i < cSWLength;i++){
           // textThing.append("["+i+"] = "+compSubmittedWords.get(i)+"\n");
            //System.out.println("compSubmittedWords["+i+"] = "+compSubmittedWords.get(i));
            //compScore += wordScore(compSubmittedWords.get(i).toString());
            if(compSubmittedWords.get(i).toString().length() < 5){
                compScore = compScore + 1;
                }
                if(compSubmittedWords.get(i).toString().length() == 5){
                compScore = compScore + 2;
                }
                if(compSubmittedWords.get(i).toString().length() == 6){
                compScore = compScore + 3;
                }
                if(compSubmittedWords.get(i).toString().length() == 7){
                compScore = compScore + 4;
                }
                if(compSubmittedWords.get(i).toString().length() == 8){
                compScore = compScore + 5;
                }
                if(compSubmittedWords.get(i).toString().length() > 8){
                compScore = compScore + 11;
                }
        
                
            //for(int q = 0;q < 16;q++)
                //System.out.println("disabledButtons["+q+"] = "+disabledButtons[q]);
        }
        System.out.println("compScore = "+compScore);
        System.out.println("Score = "+score);
        System.out.println("Post Word comparison");
        compareWords();
        System.out.println("compScore = "+compScore);
        System.out.println("Score = "+score);
       // score.setText("     "+score+"     ");
        compSubmittedWords.removeAll(compSubmittedWords);
        

    }
        private int wordScore(String word){
            if(word.length() < 5){
                return 1;
            }
            else if(word.length() == 5){
             return 2;   
            }
            else if(word.length() == 6){
                return 3;
            }
            else if(word.length() == 7){
                return 4;
            }
            else if(word.length() == 8){
                return 5;
            }
            else if(word.length() > 8){
                return 11;
            }
            return 0;
            
        }
     
        private void compareWords(){
            JOptionPane.showMessageDialog(frame, "Generating Computer Words!");
        for(int i = 0;i < usedWords.size();i++){
            
            for (int j = 0; j < compSubmittedWords.size(); j++) {                
                if(usedWords.get(i).toString().equals(compSubmittedWords.get(j).toString())){
                tempScore -= wordScore(usedWords.get(i).toString());
                compScore -= wordScore(usedWords.get(i).toString());
                score.setText(Integer.toString(tempScore));
          }
            }          
                 
        //}
                    
                    tempScore -= sameScore;
                    compScore -= sameScore;
                    score.setText(Integer.toString(tempScore));
    }
        JOptionPane.showMessageDialog(frame, "Computers Words are: "+ compSubmittedWords.toString());
        JOptionPane.showMessageDialog(frame, "Computer Score =" + compScore + "\n" + "Player Score =" + tempScore);
        }//
    

    public void getDictionary(ArrayList dictWordsArray){
        dictWords = dictWordsArray;
    }
    
    //exit method for exit in the menu
     private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
//            System.exit(0);	
            frame.dispose();
        }	
     }
     private class LetterButtonsAction implements ActionListener
     {
         
        
         public void actionPerformed(ActionEvent event)
         {
             
             letter = letter +((JButton)event.getSource()).getText();
             //System.out.println("OK");
             ((JButton)event.getSource()).setEnabled(false);
           
             
             bottomLabel.setText("     " + letter + "     ");
             //System.out.println(bottomLabel.getText());
             //bottomLabel.setText(letter);
             /*
             System.out.println(letter);
            bottomLabel.setText(letter);
             */
             //System.out.println(timer);
        
            /*if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }*/
            }
            
            
             
         
     }
     
     private class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
                timer.stop();
                tempScore = 0;
                textArea.setText("");
                
                buttonText = Board.shakeDice();
                frame.dispose();
                UiMethod();
               shakeButton.setEnabled(true);
                letter = "";
                
                bottomLabel.setText("     " + letter + "     ");
                
                 if (e.getActionCommand() == "Reset"){
                     
                 }
         {
             
        // stuff in here to reset 
            	
         }
        }	
     } 
     
     
     private class TimerListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                
                sec--;
                
                timerActive = true;
                shakeButton.setEnabled(false);
                if(sec == 0 && (min == 3 || min == 2 || min == 1)){
                    centerLabel.setText("        "+min+":00"+"        ");
                    min--;
                    sec = 60;
                }
                
                else{
                    if(sec < 10)
                        centerLabel.setText("        "+min+":0"+sec+"        ");
                    else
                        centerLabel.setText("        "+min+":"+sec+"        ");
                }
                if(sec == 0 && min == 0){
                    timerActive = false;
                    centerButton.setEnabled(false);
                    simulateComputer();
                    timer.stop();
                }

         }
     }
     
     private class shakeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
                tempScore = 0;
                textArea.setText("");
                
                buttonText = Board.shakeDice();
                frame.dispose();
                UiMethod();
                
               //shakeButton.setEnabled(false);
                letter = "";
                
                bottomLabel.setText("     " + letter + "     ");
                if(!timerActive){
                    //System.out.println("timerActive = "+timerActive);
                timer.start();}
                 if (e.getActionCommand() == "Reset"){
                     
                 }
         {
             
        // stuff in here to reset 
            	
         }
        }	
     }
     
      private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
          
            for(int i = 0; i <16; i++){
                      
                for(int x = 0;x < 16;x++){
                    disabledButtons[i] = false;
            }   
            buttons.get(i).setEnabled(true);
           }
          
          
           System.out.println(tempWord);
            //subitting text to the textArea in box
           
            System.out.println(usedWords);
            
            if(usedWords.contains(letter)){
               JOptionPane.showMessageDialog(frame, "You already used this word");
            }
            else if(dictWords.contains(letter) && letter.length() > 1){
                textArea.append(letter + "\n"); 
                
                usedWords.add(letter);
               System.out.println(usedWords); 
               
                
                
                if(letter.length() < 5){
                tempScore = tempScore + 1;
                }
                if(letter.length() == 5){
                tempScore = tempScore + 2;
                }
                if(letter.length() == 6){
                tempScore = tempScore + 3;
                }
                if(letter.length() == 7){
                tempScore = tempScore + 4;
                }
                if(letter.length() == 8){
                tempScore = tempScore + 5;
                }
                if(letter.length() > 8){
                tempScore = tempScore + 11;
                }
                
                }
            
            
            
            letter = "";
            score.setText(Integer.toString(tempScore));
            
           
          
            bottomLabel.setText("     " + letter + "     ");
            
            //frame.setVisible(false);
            //bottomLabel.setFont(new Font("Serif", Font.BOLD, 50));
            //frame.setVisible(true);
        } 
           
     } 
      
    private class buttonListener0 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[0] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 1 || i == 4 || i == 5)
                    checkEnabled(i);
                    
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }

    
    private class buttonListener1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[1] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 0 || i == 2 || i == 4 || i == 5 || i == 6)
                    checkEnabled(i);
                    //gridButtons.get(i).setEnabled(true);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[2] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
           if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 1 || i == 3 || i == 5 || i == 6 || i == 7)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[3] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 2 || i == 6 || i == 7)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[4] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 0 || i == 1 || i == 5 || i == 8 || i == 9)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[5] = true;
           letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            for(int i = 0; i < 16; i++){
                if(i == 0 || i == 1 || i == 2 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener6 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[6] = true;
           letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 10 || i == 11)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener7 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[7] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 2 || i == 3 || i == 6 || i == 10 || i == 11)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener8 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[8] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 4 || i == 5 || i == 9 || i == 12 || i == 13)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener9 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[9] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 4 || i == 5 || i == 6 || i == 8 || i == 10 || i == 12 || i == 13 || i == 14)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener10 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[10] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 5 || i == 6 || i == 7 || i == 9 || i == 11 || i == 13 || i == 14 || i == 15)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener11 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[11] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 6 || i == 7 || i == 10 || i == 14 || i == 15)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener12 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[12] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 8 || i == 9  || i == 13)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private class buttonListener13 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[13] = true;
           letter = letter + ((JButton)e.getSource()).getText();
           bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            
            for(int i = 0; i < 16; i++){
                if(i == 8 || i == 9 || i == 10 || i == 12 || i == 14)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }

        }
    }
    
    private class buttonListener14 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[14] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 9 || i == 10 || i == 11 || i == 13 || i == 15)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }

        }
    }
    
    private class buttonListener15 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(timerActive == true){
            disabledButtons[15] = true;
            letter = letter + ((JButton)e.getSource()).getText();
            bottomLabel.setText(letter);
            if(usedWords.contains(letter)){
                bottomLabel.setForeground(Color.red);
            }
            else if(dictWords.contains(letter) && letter.length() > 1){             
                   bottomLabel.setForeground(Color.green);            
                }
            else {
                bottomLabel.setForeground(Color.red); 
            }
            
            for(int i = 0; i < 16; i++){
                if(i == 10 || i == 11 || i == 14)
                    checkEnabled(i);
                else 
                    buttons.get(i).setEnabled(false);
            }
            
            }
            

        }
    }
    
    private void checkEnabled(int i){
        if(disabledButtons[i] == false){
            buttons.get(i).setEnabled(true);}
        else
            buttons.get(i).setEnabled(false);
    }
      
      public void timerStart(){
          int x = 1, y = 3;
          for(int i = 0;i < 181; i++){
              try{
                Thread.sleep(10);
                x--;
                if(x == 0 && (y == 3 || y == 2 || y == 1)){
                    centerLabel.setText(y+":00");
                    //System.out.println(y+":00");
                    
                    y--;
                    x = 60;
                }
                
                else{
                    if(x < 10)
                        centerLabel.setText(y+":0"+x);
                        //System.out.println(y+":0"+x);
                    else
                        centerLabel.setText(y+":"+x);
                        //System.out.println(y+":"+x);
                }
                
                if(i == 180){
                    System.out.println("Error in first for loop");
                }
              }
              catch(InterruptedException e){
                  System.out.println("Das functions run here");
              }
          }
          
      }
      

}


       

