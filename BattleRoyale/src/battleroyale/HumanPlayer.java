/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleroyale;

import java.util.Scanner;

/**
 *
 * @author 13026
 */
public class HumanPlayer extends Player {

    public int makeMove(int oppLastMove, int myLastMove) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Make move:");
        int i = scan.nextInt();
        return i;

    }
    

}
