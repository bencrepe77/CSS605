/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Distance;

/**
 *
 * @author 13026
 */
public class ManhattanDistance {
      
    public static double getDistance(int pointAX, int pointBX, int pointAY, int pointBY) {
    
        double dist = Math.abs(pointAX - pointBX) + Math.abs(pointAY - pointBY) ;
        
        return dist; 
    
}
}
