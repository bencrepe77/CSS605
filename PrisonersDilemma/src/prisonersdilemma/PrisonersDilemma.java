/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonersdilemma;

/**
 *
 * @author 13026
 */
public class PrisonersDilemma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Judge Ballard = new Judge (new RandomPlayer(), new RandomPlayer (), 10);
    }
}
//axelrod paper implement six classic strategies
//Centralized scorekeeping
//add unique id for each player UUID
//Roundrobin tournement of strategies against each other
