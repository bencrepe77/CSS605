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
    
    double r = Math.random();
    

public int makeMove(lastOppMove){
if(lastOppMove==0){
return(0);
    } else {
    return(1);
        }
    }

    public void setScore(int myMove, int oppMove, int myScore, int oppScore) {
           System.out.println("Score "+myScore+" over "+oppScore);
                   
    }
}