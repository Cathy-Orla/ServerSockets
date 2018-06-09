/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Cathy
 */
public class TempServer {

   
    public static void main(String[] args) throws IOException{
       ServerSocket listener = new ServerSocket(8080);  //Creating a ServerSocket to listen and take in connections
       
        try {                   
            while (true) {          //implementing a while loop so that as long as the connection remains.. do this method
                Socket ss = listener.accept();
                try {
                    double monday;       //declaring variables
                    double tuesday;
                    double wednesday;
                    double thursday;
                    double friday;
                    double saturday;
                    double sunday;
                    double average;
                    double max;
                    double min;
                    
               
        Scanner sc = new Scanner(ss.getInputStream());          //Takes input 
        monday = sc.nextDouble();
        tuesday = sc.nextDouble();
        wednesday = sc.nextDouble();
        thursday = sc.nextDouble();
        friday = sc.nextDouble();
        saturday = sc.nextDouble();
        sunday = sc.nextDouble();
        
       double sum = monday + tuesday + wednesday + thursday + friday + saturday + sunday;
       average = sum/7; //could also use for loop through arraylist to sum and calculate average.
       
       
       List<Double> list = new ArrayList<Double>();
       list.add(monday);
       list.add(tuesday);
       list.add(wednesday);
       list.add(thursday);
       list.add(friday);
       list.add(saturday);
       list.add(sunday);
       
     
       max = Collections.max(list);         //calling collections class to calculate min and max.
       min = Collections.min(list);
       
       
        
        PrintStream p = new PrintStream(ss.getOutputStream()); //Declares and creates printStream to send output to the client and receive input
        p.println(average);             //Sending values back to the client
        p.println(max);
        p.println(min);
                } finally {
                    ss.close();         //Closing the connection from the Socket/Client
                }
            }
        }
        finally {
            listener.close();           //Closing the listening serverSocket so no more requests come through
        }
    }
    
}
