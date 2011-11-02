/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointclustering;


import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


/**
 *
 * @author 13026
 */
public class Cluster {
    int x; 
    int y;
    List<Point> members;
    
    
    public Cluster (int xvalue, int yvalue){
        x = xvalue;
        y = yvalue;
        members = new LinkedList<Point>();
    }
    
    public void setCluster (int xvalue, int yvalue){
        x = xvalue;
        y = yvalue;
    }
    
        public int[] getCluster (){
        int [] coordinates = new int [2];
        coordinates[0]=x;
        coordinates[1]=y;
        return coordinates;
        }
        
        public void addPoint (Point p){
//        System.out.println("Point about to be added "+members.size());
        members.add(p);
//        System.out.println("Point added "+members.size());
        }
        
    public void randomCentroid (ArrayList<Cluster> Clusters, int spaceSize){
//        System.out.println("Starting clusterOverlapCheck");
        
        
        boolean noDupes = false;
        
        while (noDupes == false){
            
        x = new Random().nextInt(spaceSize);
        y = new Random().nextInt(spaceSize);
        System.out.println("Cluster "+this.hashCode()+" randomized: ("+x+", "+y+")");
        for (Cluster b: Clusters){

               if (!this.equals(b)){
                    if ((x - b.x == 0 && y - b.y == 0)){
                        System.out.println("noDupe = false, randomizing again");
                        break;

                    } else {
               noDupes = true;    
               System.out.println("noDupe = true");
                    }
            
         }

    }

}
        
}
}