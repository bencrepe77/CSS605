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
public interface Player {
//    java.util.ArrayList<Integer> myScoreRef = new ArrayList<Integer>();
    
    int makeMove(int oppLastMove, int myLastMove);
    void setScore (int myMove, int oppMove, int myScore, int oppScore);
}
