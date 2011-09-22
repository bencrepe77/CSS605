/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonersdilemma;

import java.util.ArrayList;

/**
 *
 * @author 13026
 */
 

public class Judge {
 
    public Judge(int rounds){
        
//CREATE PLAYERS
        
        RandomPlayer p0RandomPlayer = new RandomPlayer();
        AllDefect0 p1AllDefect0 = new AllDefect0();
        AllCooperate1 p2AllCooperate1 = new AllCooperate1();
        OptimisticPlayer p3OptimisticPlayer = new OptimisticPlayer();
        PessimisticPlayer p4PessimisticPlayer = new PessimisticPlayer();
        AlternaterCD p5AlternaterCD = new AlternaterCD();
//        OptimisticPlayer p1OptimisticPlayer = new OptimisticPlayer();
         
//CREATE ARRAY FOR PLAYERS, THEIR RUNNING SCORES, AND THEIR MOVES     
        
        java.util.ArrayList<Player> Players = new ArrayList<Player>();
        java.util.ArrayList<ArrayList> Scoreboard = new ArrayList<ArrayList>();
        
        Players.add (p0RandomPlayer);

        java.util.ArrayList<Integer> p0Score = new ArrayList<Integer>();
        Scoreboard.add(p0Score);
     
        Players.add (p1AllDefect0);
        java.util.ArrayList<Integer> p1Score = new ArrayList<Integer>();
        Scoreboard.add(p1Score);
        
        Players.add (p2AllCooperate1);
        java.util.ArrayList<Integer> p2Score = new ArrayList<Integer>();
        Scoreboard.add(p2Score);
        
        Players.add (p3OptimisticPlayer);
        java.util.ArrayList<Integer> p3Score = new ArrayList<Integer>();
        Scoreboard.add(p3Score);
        
        Players.add (p4PessimisticPlayer);
        java.util.ArrayList<Integer> p4Score = new ArrayList<Integer>();
        Scoreboard.add(p4Score);
        
        Players.add (p5AlternaterCD);
        java.util.ArrayList<Integer> p5Score = new ArrayList<Integer>();
        Scoreboard.add(p5Score);

        
        
        
//        LOOPS
        
        int pAlastMovea;
        pAlastMovea = 2;
        int pBlastMoveb;
        pBlastMoveb = 2;
        int pAroundScore;
        pAroundScore = 0;
        int pBroundScore;
        pBroundScore = 0;        
        
        for (int a=0; a<6; a++){
            for (int b=0; b<6; b++){
                    pAroundScore = 0;
                    pBroundScore = 0;

                                for (int  i=0; i<rounds; i++){

                    int[] Scores = playRound (Players.get(a),Players.get(b),pAlastMovea,pBlastMoveb);
                    Scoreboard.get(a).add(Scores[0]);
                    Scoreboard.get(b).add(Scores[1]);
                    pAlastMovea = Scores[2];
                    pBlastMoveb = Scores[3];  
                    pAroundScore = pAroundScore + Scores[0];
                    pBroundScore = pBroundScore + Scores[1];

                }

                                //System.out.println(pAroundScore);
//                  System.out.println(sumLastRoundScores(Scoreboard.get(a)));
//                  System.out.println(sumLastRoundScores(Scoreboard.get(b)));
                               
                  System.out.println(Players.get(a).getClass()+": "+pAroundScore+" versus "+Players.get(b).getClass()+": "+pBroundScore);
//                  System.out.println(Players.get(a).getClass()+": "+sumScores(Scoreboard.get(a))+" versus "+Players.get(b).getClass()+": "+sumScores(Scoreboard.get(b)));

            }
            
        }        

        
            System.out.println("RandomPlayer: "+sumScores(p0Score));
            System.out.println("All Defect Player:"+sumScores(p1Score));
            System.out.println("All Cooperate Player: "+sumScores(p2Score));
            System.out.println("Optimistic TFT Player: "+sumScores(p3Score));
            System.out.println("Pessimistic TFT Player: "+sumScores(p4Score));
            System.out.println("Alternater CD: "+sumScores(p5Score));    
    }
    
    public int sumScores(ArrayList ScoresfromPlay){
        
        Object ScoresforSum[] = ScoresfromPlay.toArray(); 
        int sum = 0;
        for(int i=0; i<ScoresforSum.length; i++) {
        sum += ((Integer) ScoresforSum[i]).intValue(); 
//        System.out.println("Sum is: " + sum); 
        }
        
        return sum;
        
    }
    
//        public int sumLastRoundScores(ArrayList ScoresfromPlay){
//        
//        Object ScoresforSum[] = ScoresfromPlay.toArray(); 
//        int sum = 0;
//        int length = 1;
//        System.out.println(ScoresforSum.length);
//        if (ScoresforSum.length<11){
//            return sumScores(ScoresfromPlay);
//        } else 
//        for(int i=0; i<10; i++) {
//
//        sum += ((Integer) ScoresforSum[length]).intValue(); 
//        System.out.println("Sum is: " + sum); 
//        }
//        
//        return sum;
//        
//    }
    
    public int[] playRound(Player p1, Player p2, int pAlastMove, int pBlastMove){
        int m1=p1.makeMove(pBlastMove, pAlastMove);
        int m2=p2.makeMove(pAlastMove, pBlastMove);
                
        int[] Scores = new int[4];
        
        if (m1==0 && m2==0){
            p1.setScore(m1, m2, 1, 1);
            p2.setScore(m1, m2, 1, 1);
            Scores[0]=1;
            Scores[1]=1;
            Scores[2]=m1;
            Scores[3]=m2;
                        
        } else if (m1==1 && m2==0){
            p1.setScore(m1, m2, 0, 5);
            p2.setScore(m1, m2, 0, 5);
            Scores[0]=0;
            Scores[1]=6;
            Scores[2]=m1;
            Scores[3]=m2;
            
        } else if (m1==0 && m2==1){
            p1.setScore(m1, m2, 5, 0);
            p2.setScore(m1, m2, 5, 0);
            Scores[0]=6;
            Scores[1]=0;
            Scores[2]=m1;
            Scores[3]=m2;        
        } else if (m1==1 && m2==1){
            p1.setScore(m1, m2, 3, 3);
            p2.setScore(m1, m2, 3, 3);
            Scores[0]=5;
            Scores[1]=5;
            Scores[2]=m1;
            Scores[3]=m2;
        } 
        return Scores;
     }
    
//    public void playGame(){
//        
//    }
    
}
