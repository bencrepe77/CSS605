/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleroyale;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 13026
 */
public class Battle{


    Battle (int tribe1start, int tribe2start){
    
        //TRIBE 1
        
        java.util.ArrayList<Player> allPlayers = new ArrayList();
        java.util.ArrayList<Player> tribe1 = new ArrayList();
        java.util.ArrayList<Player> tribe2 = new ArrayList();

        //Create defectors   
        
        for (int i=0;i<tribe1start;i++){
        AllDefect0 a = new AllDefect0();
        allPlayers.add(a);
        tribe1.add(a);
        }
        
        for (int i=0;i<tribe2start;i++){
        OptimisticPlayer a = new OptimisticPlayer();
        allPlayers.add(a);
        tribe2.add(a);
        }
        System.out.println("Players created. Tribe 1 Size: "+tribe1.size()+" Tribe 2 Size: "+tribe2.size()+" All Players Size: "+allPlayers.size());

        
        
        boolean continuemore = evaluate(tribe1, tribe2);
//        System.out.println("Passed first evaluate.");
        int rounds = 0;
        while (continuemore == true){
            rounds = rounds+1;
            int [] faceOffScores = faceOff(allPlayers.get(new Random().nextInt(allPlayers.size())), allPlayers.get(new Random().nextInt(allPlayers.size())));
            continuemore = evaluate(tribe1, tribe2);
            if (rounds>1000000){
                break;
            }
                }
//        ending sCore
        
        System.out.println("End");
        
                int x = 0;
        int y = 0;
        for (int i=0;i<tribe1.size();i++){
            x = x + tribe1.get(i).alive;
        }
        for (int i=0;i<tribe2.size();i++){
            y = y + tribe2.get(i).alive;

        }
        
        System.out.println("Evaluate: Tribe 1 "+x+"/"+tribe1.size()+" and Tribe 2 "+y+"/"+tribe2.size());

        
    }

//public  boolean evaluate(ArrayList<Player> tribe1, ArrayList<Player> tribe2){     
//return continuemore;
//}    
        
    
    public int[] faceOff(Player p1, Player p2){

        int[] Scores = new int[5];
                
        if(p1.equals(p2) == false && p1.alive == 1 && p2.alive ==1){

//X        System.out.println("P1 Pre-Play Score "+p1.getScore()+" P2 Pre-Play Score "+p2.getScore());
        
        if (p1.getScore() - p2.getScore() > 20){
            
            p2.makeDead();
//X            System.out.println("Player 2 Removed");
            Scores[0]=0;
            Scores[1]=0;
            Scores[2]=p1.getLastMoves()[0];
            Scores[3]=p2.getLastMoves()[0];   
            Scores[4]=0;
            
        } else if (p1.getScore() - p2.getScore() < -20){
            
            p1.makeDead();
//X            System.out.println("Player 1 Removed");
            Scores[0]=0;
            Scores[1]=0;
            Scores[2]=p1.getLastMoves()[0];
            Scores[3]=p2.getLastMoves()[0];   
            Scores[4]=1;
        } 
                
        else {
        int m1=p1.makeMove();
        int m2=p2.makeMove();



            if (m1==0 && m2==0){
            Scores[0]=1;
            Scores[1]=1;
            Scores[2]=m1;
            Scores[3]=m2;
            Scores[4]=2;
            
        } else if (m1==1 && m2==0){
            Scores[0]=0;
            Scores[1]=5;
            Scores[2]=m1;
            Scores[3]=m2;
            Scores[4]=2;
            
        } else if (m1==0 && m2==1){
            Scores[0]=5;
            Scores[1]=0;
            Scores[2]=m1;
            Scores[3]=m2; 
            Scores[4]=2;
            
        } else if (m1==1 && m2==1){
            Scores[0]=3;
            Scores[1]=3;
            Scores[2]=m1;
            Scores[3]=m2; 
            Scores[4]=2;
        }
        }
            p1.setScore(Scores[0]);
            p2.setScore(Scores[1]);
            
            int[] playerAmoves = {Scores[2], Scores[3]};
            p1.setLastMoves(playerAmoves);
            
            int[] playerBmoves = {Scores[3], Scores[2]};
            p2.setLastMoves(playerBmoves);

        } else {
//X            System.out.println("Game canceled.");
            Scores[0]=0;
            Scores[1]=0;
            Scores[2]=p1.getLastMoves()[0];
            Scores[3]=p2.getLastMoves()[0];   
            Scores[4]=0;
            
        }
        return Scores;

        }

    private boolean evaluate(ArrayList<Player> tribe1, ArrayList<Player> tribe2) {
                
        boolean continuemore = true; 
        int x = 0;
        int y = 0;
        for (int i=0;i<tribe1.size();i++){
            x = x + tribe1.get(i).alive;
//             System.out.println("time around="+i+x);
        }
        for (int i=0;i<tribe2.size();i++){
            y = y + tribe2.get(i).alive;
//            System.out.println("time around="+i+y);
        }
        
        if (x ==0 || y==0){
            continuemore = false;
        }
//X        System.out.println("Evaluate: Tribe 1 "+x+"/"+tribe1.size()+" and Tribe 2 "+y+"/"+tribe2.size());
       
        return continuemore;
    }
    
}
