/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleroyale;
import java.util.Random;
/**
 *
 * @author 13026
 */
public class PessimisticPlayer extends Player {
    
    public PessimisticPlayer(){
        String name = "Pessimistic TFT Player";  
    }
    double r = Math.random();
//    int lastMove = 2;
    
    
public int makeMove(int oppLastMove, int myLastMove){
if(oppLastMove==2){
return 0;
    } else {
    return(oppLastMove);
        }
    }

}
