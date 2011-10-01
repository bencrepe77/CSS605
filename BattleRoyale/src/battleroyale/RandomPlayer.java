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
public class RandomPlayer extends Player{
    
    public RandomPlayer(){
    String name = "Random Player";
    }
    double r = Math.random();
    
public int makeMove(int oppLastMove, int myLastMove){
Random r = new Random();
return(r.nextInt(2));
    }                   
}
