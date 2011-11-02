/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalcEnergy;

import java.util.List;

/**
 *
 * @author 13026
 */
public class EnergyCalculator {
 
    double oldEnergy; 
    double newEnergy;

                


    
        public EnergyCalculator (){
 

        oldEnergy = 1000000000;
        newEnergy = 0;

    }
        
        public double getOldEnergy (){
 
        return oldEnergy;
    }
        
        public double getNewEnergy (){
 
        return newEnergy;
    }
    
        public void setOldEnergy (double oe){
 
        oldEnergy = oe;
    }
        
        public void setNewEnergy (double ne){
 
        newEnergy = ne;
    }
        
    public boolean energyCheck() {
    
        boolean keepGoing = true;
        //update newEnergy;
        if(newEnergy - oldEnergy<-100){
        keepGoing = false;
        }
        
        return keepGoing; 
    
}
}
