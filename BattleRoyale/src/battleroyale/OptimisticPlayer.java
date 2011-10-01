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
public class OptimisticPlayer extends Player{
    
//    int myScore = 0;
//    int myLastMovea = 2;
//    int oppLastMovea = 2;
//    int tribeIndexNum = -1;
//    int allPlayersIndexNum = -1;
//    ArrayList tribea;
//    ArrayList allPlayersa;
//    
    double r = Math.random();
//    int lastMove = 2;


    
    public int makeMove() {
    if(oppLastMovea==2){
return 1;
    } else {
    return(oppLastMovea);
        }
    }

//public void setAllPlayersIndexNum (int index){
//allPlayersIndexNum = index -1;
//}
//
//public int getAllPlayersIndexNum (){
//return allPlayersIndexNum;
//}

}