/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonersdilemma;

/**
 *
 * @author 13026
 */
public interface Player {
    int makeMove();
    void setScore (int myMove, int oppMove, int myScore, int oppScore);
}
