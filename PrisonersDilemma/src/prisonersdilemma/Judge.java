/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonersdilemma;

/**
 *
 * @author 13026
 */
public class Judge {
 
    public Judge(Player p1, Player p2, int rounds){
        for (int  i=0; i<rounds; i++){
            playRound (p1,p2);
    
    }
       
}
    public void playRound(Player p1, Player p2){
        int m1=p1.makeMove();
        int m2=p2.makeMove();
        
        if (m1==0 && m2==0){
            p1.setScore(m1, m2, 1, 1);
            p2.setScore(m1, m2, 1, 1);
            
        } else if (m1==1 && m2==0){
            p1.setScore(m1, m2, 0, 6);
            p2.setScore(m1, m2, 0, 6);
            
        } else if (m1==0 && m2==1){
            p1.setScore(m1, m2, 6, 0);
            p2.setScore(m1, m2, 6, 0);
            
        } else if (m1==1 && m2==1){
            p1.setScore(m1, m2, 5, 5);
            p2.setScore(m1, m2, 5, 5);
            
        } 
    }
    
//    public void playGame(){
//        
//    }
    
}
