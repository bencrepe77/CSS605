/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Distance;

/**
 *
 * @author 13026
 */
public class EuclidSqDistance implements Distance {

    @Override
    public double getDistance(int pointAX, int pointBX, int pointAY, int pointBY) {
    
        double dist = Math.pow(pointAX - pointBX,2) + Math.pow(pointAY - pointBY,2) ;
        
        return dist; 
    
}
}
