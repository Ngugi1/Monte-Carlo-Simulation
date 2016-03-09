/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package montecarlo;

import java.text.DecimalFormat;

/**
 *
 * @author ngugi
 */
public class MonteCarlo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        //Run the simulation
        String tenPoints =  runSimulationNTimes(10, 0, Math.PI);
        String twentyPoints = runSimulationNTimes(20, 0, Math.PI);
        String fortyPoints = runSimulationNTimes(40, 0, Math.PI);
        String eightyPoints = runSimulationNTimes(80,0, Math.PI);
        String one160Points = runSimulationNTimes(160,0, Math.PI);
   
         //Format output 
        System.out.println("n\t|10\t|20\t|40\t|80\t|160");
        System.out.println("Y(n)\t|"+tenPoints+"\t|"+twentyPoints+"\t|"
                + ""+fortyPoints+"\t|"+eightyPoints+"\t|"+one160Points);
       
        
    }
    public static String runSimulationNTimes(int n , double a , double b)
    {
        DecimalFormat formater = new DecimalFormat("0.000");
        double summation = 0;
        for(int i = 0;i<n ;i++)
        {
            //Get a number between 0-1 , 1 excluded
            double rand = Math.random();
            //get a point to feed to the sine function
            double point = a + (rand*(b-a));
            //Do the summation
            summation =  summation + Math.sin(point);
        }   
        //Using the mathematical formula get the result
        return (formater.format(((b-a)*summation)/n));
    }
    
}
