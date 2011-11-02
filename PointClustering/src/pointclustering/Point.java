/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointclustering;

/**
 *
 * @author 13026
 */
class Point {
    
    int x;
    int y;
    double dist = 10000000;
    int removeCluster;
    int reassignCluster;
    
    public Point (int xvalue, int yvalue, int cluster){
        x = xvalue;
        y = yvalue;
        reassignCluster = cluster;
        removeCluster = cluster;
    }
    
    public void setPoint (int xvalue, int yvalue){
        x = xvalue;
        y = yvalue;
    }
    
        public int[] getPoint (){
        int [] coordinates = new int [2];
        coordinates[0]=x;
        coordinates[1]=y;
        return coordinates;
        }
}
