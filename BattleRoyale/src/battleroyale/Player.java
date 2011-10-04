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
public class Player {
//    java.util.ArrayList<Integer> myScoreRef = new ArrayList<Integer>();
    
    
    int myScore = 0;
    int myLastMovea = 2;
    int oppLastMovea = 2;
    int tribeIndexNum = -1;
    int allPlayersIndexNum = -1;
    ArrayList tribea;
    ArrayList allPlayersa;
    int alive = 1;
        
    public int makeMove(){
        return 2;
    }

public void makeDead(){
        alive = 0;
//        System.out.println("Killed.");
}

public int getAlive(){
    return alive;
}
        

public void setScore (int score){
myScore = myScore + score;
}

public int getScore(){
return myScore;    
}

public void setLastMoves (int[] lastMoves){
myLastMovea = lastMoves[0];
oppLastMovea = lastMoves[1];
}

public int[] getLastMoves(){
int[] lastMoves = new int[2];
lastMoves[0] = myLastMovea;
lastMoves[1] = oppLastMovea;
return lastMoves;
}  

public void setTribeIndexNum (int index){
tribeIndexNum = index;
}

public int getTribeIndexNum (){
return tribeIndexNum;
}

public void setAllPlayersIndexNum (int index){
allPlayersIndexNum = index-1;
}

public int getAllPlayersIndexNum (){
return allPlayersIndexNum;
}

public void setTribe (ArrayList tribe){
tribea = tribe;
}

public ArrayList getTribe (){
return tribea;
}

public void setAllPlayers (ArrayList allPlayers){
allPlayersa = allPlayers;
}

public ArrayList getAllPlayers (){
return allPlayersa;
}

}