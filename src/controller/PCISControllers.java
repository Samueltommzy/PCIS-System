/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datastore.DatastoreQuery;
import java.util.Scanner;

/**
 *
 * @author samuel
 */
public class PCISControllers {
    static Scanner scanner;
    public static String selectedPatientId;
    public static DatastoreQuery q;
    public static void startConsoleApp(DatastoreQuery query){
        q = query;
        q.listPatients();
        System.out.println("-------- Welcome to the Physiotherapy&Sports Injury Center --------\n"
                + "You will be provided with a couple of commands,kindly type the command number to assess a particular functionality\n\n");
        
        System.out.println("Select an option below");
        System.out.println("1. View all available patients\n2. View all available physicians\n3. View all areas of Expertise\n4. Create a patient\n5. Exit\n6. Back to home");
        scanner = new Scanner(System.in);
        String input = scanner.next();
        switch(input){
            case "1":
                patientEntryPoint();
                break;
            default:
                System.out.println("Invalid option selected,exiting app.....");
                exitApp();
        }
    }
    
    public static void backToHome(){
        startConsoleApp(q);
    }
    
    public static void exitApp(){
        System.exit(0);
    }
    
    private static void  patientEntryPoint(){
         q.listPatients();
         System.out.println("0. Exit App  \n00. Back to previous menu");
         System.out.println("KIndly select a patient to use from the list above");
         scanner = new Scanner(System.in);
         String input = scanner.next();
         switch(input){
             case "0":
                exitApp();
             case "00":
                 backToHome();
             default:
                 System.out.println("The test looks good");
                 exitApp();
         }
    }
}
