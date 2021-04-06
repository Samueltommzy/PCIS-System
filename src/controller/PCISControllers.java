/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datastore.DatastoreQuery;
import java.util.Scanner;
import model.Appointment;
import model.Patient;
import model.Treatment;

/**
 *
 * @author samuel
 */
public class PCISControllers {
    static Scanner scanner;
    public static String selectedPatientId = "1";
    public static DatastoreQuery q;
    
    public static void startConsoleApp(DatastoreQuery query){
        q = query;
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
            case "2":
                physicianEntryPoint();
                break;
            case "3":
                expertiseEntryPoint();
                break;
            case "4":
                createPatient();
                break;
            case "5":
                exitApp();
            case "6":
                startConsoleApp(q);
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
         System.out.println("Kindly select a patient by their Id to use from the list above");
         scanner = new Scanner(System.in);
         String input = scanner.next();
         if(input.equals("0")){
             exitApp();
         }
         else if(input.equals("00")){
             backToHome();
         }
         else {
             try{
                 int iput = Integer.parseInt(input);
                 if(iput <1 || iput > 15){
                     System.err.println("You have input a wrong patient id,try again");
                     patientEntryPoint();
                 }
                 else{
                     selectedPatientId = input;
                    System.out.println("You have chosen to use "+q.getPatientName(iput).toUpperCase());
                    System.out.println("You will be taken back to home page to view physicians or expertises in order to book a treatment");
                    backToHome();
                 }
             }
             catch(Exception e){
                 System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 patientEntryPoint();
             }
         }
    }
    
    private static void physicianEntryPoint(){
        System.err.println("Please if you have not previously selected a patient,kindly do so by going back to the previous menu");
        q.listPhysicians();
        System.out.println("0. Exit App  \n00. Back to previous menu\n");
         System.out.println("Kindly select a physician id to view his/her available treatments from the list above");
         scanner = new Scanner(System.in);
         String input = scanner.next();
         if(input.equals("0")){
             exitApp();
         }
         else if(input.equals("00")){
             backToHome();
         }
         else{
             try{
                 int iput = Integer.parseInt(input);
                 if(iput <1 || iput > 5){
                     System.err.println("You have input a wrong physician id,try again");
                     physicianEntryPoint();
                 }
                 else{
                     bookTreatmentByPhysician(iput);
                 }
             }
             catch(Exception e){
                 System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 physicianEntryPoint();
             }
         }
    }
    
    private static void expertiseEntryPoint(){
        System.err.println("Please if you have not previously selected a patient,kindly do so by going back to the previous menu");
        q.listExpertise();
        System.out.println("0. Exit App  \n00. Back to previous menu\n");
         System.out.println("Kindly select an expertise to view all its available treatments from the list above");
         scanner = new Scanner(System.in);
         String input = scanner.next();
         if(input.equals("0")){
             exitApp();
         }
         else if(input.equals("00")){
             backToHome();
         }
         else{
             try{
                 int iput = Integer.parseInt(input);
                 if(iput <1 || iput > 3){
                     System.err.println("You have input a wrong command,choose an expertise from one of the above");
                     expertiseEntryPoint();
                 }
                 else{
                     bookTreatmentByExpertise(iput);
                 }
             }
             catch(Exception e){
                 System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 physicianEntryPoint();
             }
         }
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
    
    private static void bookTreatmentByPhysician(int id){
        q.viewTreatmentByPhysician(id);
        String physicianName = q.getPhysicianName(id);
        System.out.println("0. Exit App \n00. Back to physicians menu");
        System.out.println("Select a ***TREATMENTID*** to book");
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.equals("0")){
            exitApp();
        }
        else if(input.equals("00")){
            physicianEntryPoint();
        }
        else{
            try{
                int iput = Integer.parseInt(input);
                Treatment t = q.getTreatment(iput);
                if(t.getStatus().equals("Booked")){
                    System.err.println("This treatment has been booked,try another option");
                    bookTreatmentByPhysician(id);
                }
                else{
                    q.setTreatmentStatus("Booked", iput);
                    createAppointment(input,selectedPatientId,physicianName,t.getDate(),"Booked",t.getRoom(),t.getName());
                    
                }
            }
            catch(Exception e){
                System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 bookTreatmentByPhysician(id);
            }
        }
    }
    
        private static void bookTreatmentByExpertise(int id){
        q.viewTreatmentByExpertise(id);
        String physicianName = q.getPhysicianName(id);
        System.out.println("0. Exit App \n00. Back to physicians menu");
        System.out.println("Select a ***TREATMENTID*** to book");
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.equals("0")){
            exitApp();
        }
        else if(input.equals("00")){
            physicianEntryPoint();
        }
        else{
            try{
                int iput = Integer.parseInt(input);
                Treatment t = q.getTreatment(iput);
                if(t.getStatus().equals("Booked")){
                    System.err.println("This treatment has been booked,try another option");
                    bookTreatmentByPhysician(id);
                }
                else{
                    q.setTreatmentStatus("Booked", iput);
                    createAppointment(input,selectedPatientId,physicianName,t.getDate(),"Booked",t.getRoom(),t.getName());
                    
                }
            }
            catch(Exception e){
                System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 bookTreatmentByPhysician(id);
            }
        }
    }
    
    public static void createAppointment(String treatmentId,String patientId,String physicianName,String date,String status,String room,String treatmentName){
        Appointment appointment = new Appointment(patientId,physicianName,treatmentName,date,room,status);
        q.addAppointment(appointment);
        System.out.println("your "+ treatmentName+" appointment with "+physicianName+" has been successfully booked for "+ date );
//       scanner = new Scanner(System.in);
        q.listAppointments();
        physicianEntryPoint();
    }

    private static void createPatient() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        scanner = new Scanner(System.in);
        System.out.println("Enter name to use: ");
        String name = scanner.next();
        System.out.println("Enter phoneNumber: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter your address: ");
        String address = scanner.next();
        int patientId = 16;
        selectedPatientId = String.valueOf(patientId);
        Patient newp = new Patient(patientId,name,address,phoneNumber);
        q.addPatient(newp);
        System.out.println("Patient successfully created" );
        patientEntryPoint();
    }
}
