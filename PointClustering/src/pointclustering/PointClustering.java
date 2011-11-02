/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointclustering;

import CalcEnergy.EnergyCalculator;
import Distance.ManhattanDistance;
import Distance.EuclidianDistance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 13026
 */
public class PointClustering {
//max value not working
            
    
    public static void main(String[] args) {
        
        int numClusters = 3;
        int numPoints = 100;
        int spaceSize = 1000;
        double minEnergyDifference = 10;
        
        
        ArrayList <Cluster> Clusters = new ArrayList();

// CREATE ENERGYCALCULATOR
        
        EnergyCalculator ec = new EnergyCalculator();
        

// CREATE CLUSTERS        
        
        for (int a = 0; a<numClusters;a++){
            Cluster x = new Cluster(new Random().nextInt(spaceSize), new Random().nextInt(spaceSize));
            Clusters.add(x);
            clusterOverlapCheck(Clusters, spaceSize);
        }
        
// CREATE MASTER LIST OF POINTS
        
        ArrayList <Point> allPoints = new ArrayList();
        
// CREATE POINTS        

        for (int a = 0; a<numPoints;a++){
            int reassignCluster = new Random().nextInt(Clusters.size());
            Point x = new Point(new Random().nextInt(spaceSize), new Random().nextInt(spaceSize), reassignCluster);
            Clusters.get(x.reassignCluster).addPoint(x);
            allPoints.add(x);
            System.out.println(x.x+";"+x.y);
        }
        
// Alternate CREATE POINTS         
//                for (int a = 0; a<numPoints-50;a++){
//            int reassignCluster = new Random().nextInt(Clusters.size());
//            Point x = new Point(10, 10, reassignCluster);
//            Clusters.get(x.reassignCluster).addPoint(x);
//            allPoints.add(x);
//            System.out.println(x.x+";"+x.y);
//        }
//                for (int a = 0; a<25;a++){
//            int reassignCluster = new Random().nextInt(Clusters.size());
//            Point x = new Point(25, 25, reassignCluster);
//            Clusters.get(x.reassignCluster).addPoint(x);
//            allPoints.add(x);
//            System.out.println(x.x+";"+x.y);
//        }
//                for (int a = 0; a<25;a++){
//            int reassignCluster = new Random().nextInt(Clusters.size());
//            Point x = new Point(45, 45, reassignCluster);
//            Clusters.get(x.reassignCluster).addPoint(x);
//            allPoints.add(x);
//            System.out.println(x.x+";"+x.y);
//        }
        
        clusterSizeCheck(Clusters);
        
// DO ITERATION
        int counter = 0;
        boolean emptyClusters = true;
        while(counter < 100 && (Math.abs(ec.getOldEnergy()-ec.getNewEnergy()) > minEnergyDifference || emptyClusters == true)){

            doIteration(Clusters);
            reassignAndRecord(Clusters, allPoints, ec);
            recalculateCentroids (Clusters, spaceSize);
//            System.out.println(clusterSizeCheck(Clusters));
            emptyClusters = clusterSizeCheck(Clusters);
            counter = counter+1;
            System.out.println(ec.getOldEnergy()-ec.getNewEnergy()+" versus "+ minEnergyDifference+" Counter = "+counter);
        }
//        System.out.println("End: "+(ec.getOldEnergy()-ec.getNewEnergy())+" versus "+ minEnergyDifference+" Counter = "+counter);
    }
    
        
public static void doIteration (ArrayList<Cluster> Clusters){
    
    for(Cluster a: Clusters){
        double d;
        for(Point p: a.members){
              
              for(int c = 0; c < Clusters.size(); c++){
              d = Distance.EuclidianDistance.getDistance(p.x,Clusters.get(c).x,p.y,Clusters.get(c).y);
//              System.out.println("Point "+p.hashCode()+" ("+p.x+", "+p.y+") is "+d+" from "+Clusters.get(c).hashCode()
//                      +" ("+Clusters.get(c).x+", "+Clusters.get(c).y+") old distance is "+p.dist);  
              if(d<p.dist){
              p.dist = d;
              p.reassignCluster = c;
//              System.out.println("Point "+p.hashCode()+" will be moved from "+p.removeCluster+" to "+p.reassignCluster);
              }
              
              }
            
        }
    }
}
public static void reassignAndRecord (ArrayList<Cluster> Clusters, ArrayList<Point> allPoints, EnergyCalculator ec){


ec.setOldEnergy(ec.getNewEnergy());        
ec.setNewEnergy(0);        
int counter = 0;
    for(Point p: allPoints){
            
            if(p.reassignCluster != p.removeCluster){
                Clusters.get(p.removeCluster).members.remove(p);
                Clusters.get(p.reassignCluster).members.add(p);
                counter = counter +1;
                p.removeCluster = p.reassignCluster;

            
                }
            ec.setNewEnergy(ec.getNewEnergy()+p.dist);
            }
    System.out.println("Old Energy: "+ec.getOldEnergy()+"; New Energy: "+ec.getNewEnergy()+" Reasigned: "+counter);
        }
       
    public static boolean clusterSizeCheck (ArrayList<Cluster> Clusters){
       boolean anyZeroes = false;
        for (Cluster a: Clusters){
         System.out.println("Cluster "+a.hashCode()+" size is "+a.members.size()+" X Value = "+a.x+"; Y Value: "+a.y);
         if (a.members.isEmpty()){anyZeroes = true;}
        }
        return anyZeroes;
    }
    
    public static void clusterOverlapCheck (ArrayList<Cluster> Clusters, int spaceSize){
//        System.out.println("Starting clusterOverlapCheck");
        
        for (Cluster a: Clusters){
            for (Cluster b: Clusters){
                if (!a.equals(b)){
                    if ((a.x - b.x == 0 && a.y - b.y == 0)){
                        System.out.println("Dupe found.");
                        b.x = new Random().nextInt(spaceSize);
                        b.y = new Random().nextInt(spaceSize);
                        clusterOverlapCheck(Clusters, spaceSize);
                    }
            }
         }
    }
//            System.out.println("End of clusterOverlapCheck");
    }
    
    public static void recalculateCentroids (ArrayList<Cluster> Clusters, int spaceSize){
    //  CLUSTER SIZE CHECK    

    for(Cluster a: Clusters){
        if (a.members.size()>0){
        int clusterXSum = 0;
        int clusterYSum = 0;
        for(Point p: a.members){
            clusterXSum = clusterXSum + p.x;
            clusterYSum = clusterYSum + p.y;
            }

        a.setCluster(Math.round(clusterXSum / a.members.size()),Math.round(clusterYSum / a.members.size()));
    } else {
            a.randomCentroid(Clusters, spaceSize);
        }
}
    
    }
}
