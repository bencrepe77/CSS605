/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonersdilemma;
import java.util.Random;
/**
 *
 * @author 13026
 */
public class OptimisticPlayer implements Player{
    
    public OptimisticPlayer(){
        String name = "Optimistic TFT Player";
    }
    
    double r = Math.random();
//    int lastMove = 2;
    
    
public int makeMove(int oppLastMove, int myLastMove){
if(oppLastMove==2){
return 1;
    } else {
    return(oppLastMove);
        }
    }

    public void setScore(int myMove, int oppMove, int myScore, int oppScore) {
//           System.out.println("Score "+myScore+" over "+oppScore);
           
                   
    }
}