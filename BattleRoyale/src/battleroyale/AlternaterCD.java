/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleroyale;

/**
 *
 * @author 13026
 */
public class AlternaterCD extends Player {

    public AlternaterCD(){
        String name = "Alternater CD";
    }
    
public int makeMove(int oppLastMove,int myLastMove){
if(myLastMove==0 || myLastMove==2){
return 1;
    } else {
    return 0;
        }
    }


}
