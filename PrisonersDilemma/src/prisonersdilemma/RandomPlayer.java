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
public class RandomPlayer implements Player{
    
    double r = Math.random();
    

public int makeMove(){
Random r = new Random();
return(r.nextInt(2));
    }


    public void setScore(int myMove, int oppMove, int myScore, int oppScore) {
           System.out.println("Score "+myScore+" over "+oppScore);
                   
    }

}