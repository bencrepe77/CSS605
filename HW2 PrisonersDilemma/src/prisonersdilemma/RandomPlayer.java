/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonersdilemma;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author 13026
 */
public class RandomPlayer implements Player{
    
    public RandomPlayer(){
    String name = "Random Player";
    }
    double r = Math.random();
    
public int makeMove(int oppLastMove, int myLastMove){
Random r = new Random();
return(r.nextInt(2));
    }


    public void setScore(int myMove, int oppMove, int myScore, int oppScore) {
//           System.out.println("Score "+myScore+" over "+oppScore);
                   
    }

}