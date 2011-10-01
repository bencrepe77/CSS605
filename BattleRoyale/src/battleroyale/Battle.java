/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleroyale;

import java.util.ArrayList;

/**
 *
 * @author 13026
 */
public class Battle{


    Battle (int tribe1start, int tribe2start){
    
        //TRIBE 1
        
        java.util.ArrayList<Player> tribe1 = new ArrayList();
        
        for (int i=0;i<tribe1start;i++){
        tribe1.add(new AllDefect0());
        tribe1.get(i).setTribeIndexNum(i);
        tribe1.get(i).setTribe(tribe1);
//            System.out.println(tribe1.get(i).getTribeIndexNum());
//            System.out.println(tribe1.get(i).getTribe().hashCode());

        }
        
        //TRIBE 2
        
        java.util.ArrayList<Player> tribe2 = new ArrayList();
        
        for (int i=0;i<tribe2start;i++){
        tribe2.add(new OptimisticPlayer());
        tribe2.get(i).setTribeIndexNum(i);
        tribe2.get(i).setTribe(tribe2);
        }   
        
        //ALL PLAYERS 
        
        java.util.ArrayList<Player> allPlayers = new ArrayList();
        
        for (int i=0;i<tribe1.size();i++){
        allPlayers.add(tribe1.get(i));
        tribe1.get(i).setAllPlayersIndexNum(allPlayers.size());
        tribe1.get(i).setAllPlayers(allPlayers);
//            System.out.println(tribe1.get(i).getAllPlayersIndexNum());
//            System.out.println("allPlayers size: "+allPlayers.get(i).getAllPlayers().size());
 
        }
        
        for (int i=0;i<tribe2.size();i++){
        allPlayers.add(tribe2.get(i));
        tribe2.get(i).setAllPlayersIndexNum(allPlayers.size());
        tribe2.get(i).setAllPlayers(allPlayers);
//            System.out.println(tribe2.get(i).getAllPlayersIndexNum());
//            System.out.println("allPlayers size: "+tribe2.get(i).getAllPlayers().size());
        }
//        for (int i=0; i<allPlayers.size();i++){
//            System.out.println("Rollcall: "+allPlayers.get(i).getAllPlayersIndexNum()+" "+allPlayers.get(i).getAllPlayers().size());
//        } 
        
        System.out.println(tribe1.size()+" "+tribe2.size()+" "+allPlayers.size());
            
                
               
for (int a=0; a<allPlayers.size();a++){ 
    for (int b=0; b<allPlayers.size();b++){ 
        if (a > b && allPlayers.get(a).getAlive()==true && allPlayers.get(b).getAlive()==true){
            int [] faceOffScores = faceOff(allPlayers.get(a),allPlayers.get(b));
            
            if (faceOffScores[4] == 2){
                
            
            
            allPlayers.get(a).setScore(faceOffScores[0]);
            allPlayers.get(b).setScore(faceOffScores[1]);
            
            int[] playerAmoves = {faceOffScores[2], faceOffScores[3]};
            allPlayers.get(a).setLastMoves(playerAmoves);
            
            int[] playerBmoves = {faceOffScores[3], faceOffScores[2]};
            allPlayers.get(b).setLastMoves(playerBmoves);
            }
//        System.out.println("P1: "+a+", "+allPlayers.get(a).getTribeIndexNum()+", "+allPlayers.get(a).getAllPlayersIndexNum()+", "+allPlayers.get(a).getScore()+", P2: "+b+", "+allPlayers.get(b).getTribeIndexNum()+", "+allPlayers.get(b).getAllPlayersIndexNum()+", "+allPlayers.get(b).getScore());
        
        } 
        }
   
}
System.out.println("Tribe 1 Survivors: "+tribe1.size()+" Tribe 2 Survivors: "+tribe2.size());
    }

    
    public int[] faceOff(Player p1, Player p2){
        
        int[] Scores = new int[5];
        System.out.println("P1 Score "+p1.getScore()+" P2 Score "+p2.getScore());
        
        if (p1.getScore() - p2.getScore() > 2){
            
//            p2.getTribe().remove(p2.getTribeIndexNum());
//            p2.getAllPlayers().remove(p2.getAllPlayersIndexNum());
            p2.makeDead();
            System.out.println("Player 2 Removed");
            Scores[0]=0;
            Scores[1]=0;
            Scores[2]=p1.getLastMoves()[0];
            Scores[3]=p2.getLastMoves()[0];   
            Scores[4]=0;
            
        } else if (p1.getScore() - p2.getScore() < -2){
            
//            System.out.println(p1.getTribeIndexNum());
//            System.out.println(p1.getTribe().size());
//            System.out.println(p2.getAllPlayersIndexNum());
//            System.out.println(p2.getAllPlayers().size());
//            p1.getTribe().remove(p1.getTribeIndexNum());
//            System.out.println("Got through tribe "+p1.getTribe().size());
            p1.makeDead();
//            p2.getAllPlayers().remove(p2.getAllPlayersIndexNum());
//            System.out.println("Got through allPlayers "+p2.getAllPlayers().size());

            System.out.println("Player 1 Removed");
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

        return Scores;
        


        }    
    
}
