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
                + "You will be provided with a couple of commands,"
                + "kindly type the command number to assess a particular functionality\n\n");
        
        System.out.println("Select an option below");
        System.out.println("1. View all available patients\n2. View all available physicians\n3. View all areas of Expertise "
                + "\n4. Create a patient\n5. View all Appointments\n6. Attend an appointment\n7. Cancel an appointment"
                + "\n8. Miss an appointment" +"\n9. View all attended appointments\n10. View all cancelled appointments"
                + "\n11.View all missed appointments\n12.Exit");
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
                viewAllAppointments();
                break;
            case "6":
                attendAnAppointment();
                break;
            case "7":
                cancelAnAppointment();
                break;
            case "8":
                missAnAppointment();
                break;
            case  "9":
                viewAppointments("Attended");
                break;
             case  "10":
                viewAppointments("Cancelled");
                break;
             case  "11":
                viewAppointments("Missed");
                break;
            case "12":
                exitApp();
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
                 if(iput <1 || iput > q.getPatientSize()){
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
         String patientName = q.getPatientName(Integer.parseInt(selectedPatientId));
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
                    createAppointment(input,selectedPatientId,patientName,physicianName,t.getDate(),"Booked",t.getRoom(),t.getName());
                    
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
        String patientName = q.getPatientName(Integer.parseInt(selectedPatientId));
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
                    createAppointment(input,selectedPatientId,patientName,physicianName,t.getDate(),"Booked",t.getRoom(),t.getName());
                    
                }
            }
            catch(Exception e){
                System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 bookTreatmentByPhysician(id);
            }
        }
    }
    
    public static void createAppointment(String treatmentId,String patientId,String patientName,String physicianName,String date,String status,String room,String treatmentName){
        Appointment appointment = new Appointment(String.valueOf(q.getAppointmentSize()+1),patientId,patientName,physicianName,treatmentName,date,room,status);
        q.addAppointment(appointment);
        System.out.println("your "+ treatmentName+" appointment with "+physicianName+" has been successfully booked for "+ date );
        physicianEntryPoint();
    }

    private static void createPatient() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        scanner = new Scanner(System.in);
        System.out.println("Enter name to use: ");
        String name = scanner.nextLine();
        System.out.println("Enter phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter your address: ");
        String address = scanner.nextLine();
        int patientId = q.getPatientSize()+1;
        selectedPatientId = String.valueOf(patientId);
        Patient newp = new Patient(patientId,name,address,phoneNumber);
        q.addPatient(newp);
        System.out.println("Patient successfully created" );
        patientEntryPoint();
    }
    
    private static void viewAllAppointments(){
//        System.out.println("....All patients appointment.....");
        q.listAppointments();
        backToHome();
    }

    private static void attendAnAppointment() {
       q.listAppointments();
       System.out.println("00. Back to previous menu"+"\n0. Exit");
       System.out.println("Select an **APPOINTMENTID**  in order to attend");
       scanner = new Scanner(System.in);
       String input = scanner.next();
       int iput = Integer.parseInt(input);
       if(input.equals("0")){
           exitApp();
       }
       if(input.equals("00")){
           startConsoleApp(q);
       }
       if(iput<0||iput>q.getAppointmentSize()){
           System.err.println("Invalid input,kindly select a valid appointmentId from the above");
           attendAnAppointment();
       }
       else{
           try{
               Appointment selectedAppointment = q.getAppointmentById(iput);
               if(selectedAppointment.getStatus().equals("Cancelled")||selectedAppointment.getStatus().equals("Missed")){
                   System.err.println("Sorry you cannot attend an already cancelled or missed appointment");
                   attendAnAppointment();
               }
               selectedAppointment.setStatus("Attended");
               System.out.println("You have successfully attended the appointment,go back to previous menu to"
                       + " view all attended appointments or select another appointment to attend");
               attendAnAppointment();
           }
           catch(Exception e){
               System.err.println(e.getMessage());
               System.err.println("Make sure you input an integer");
           }
       }
    }
    
     private static void cancelAnAppointment() {
       q.listAppointments();
       System.out.println("00. Back to previous menu"+"\n0. Exit");
       System.out.println("Select an **APPOINTMENTID**  in order to cancel");
       scanner = new Scanner(System.in);
       String input = scanner.next();
       int iput = Integer.parseInt(input);
       if(input.equals("0")){
           exitApp();
       }
       if(input.equals("00")){
           startConsoleApp(q);
       }
       if(iput<0||iput>q.getAppointmentSize()){
           System.err.println("Invalid input,kindly select a valid appointmentId from the above");
           cancelAnAppointment();
       }
       else{
           try{
               Appointment selectedAppointment = q.getAppointmentById(iput);
               if(selectedAppointment.getStatus().equals("Attended")||selectedAppointment.getStatus().equals("Missed")){
                   System.err.println("Sorry you cannot cancel an already attended or missed appointment");
                   cancelAnAppointment();
               }
               selectedAppointment.setStatus("Cancelled");
               System.out.println("You have successfully cancelled the appointment,go back to previous menu to"
                       + " view all cancelled appointments or select another appointment to cancel");
               cancelAnAppointment();
           }
           catch(Exception e){
               System.err.println(e.getMessage());
               System.err.println("Make sure you input an integer");
           }
       }
    }
     private static void missAnAppointment() {
       q.listAppointments();
       System.out.println("00. Back to previous menu"+"\n0. Exit");
       System.out.println("Select an **APPOINTMENTID**  in order to miss");
       scanner = new Scanner(System.in);
       String input = scanner.next();
       int iput = Integer.parseInt(input);
       if(input.equals("0")){
           exitApp();
       }
       if(input.equals("00")){
           startConsoleApp(q);
       }
       if(iput<0||iput>q.getAppointmentSize()){
           System.err.println("Invalid input,kindly select a valid appointmentId from the above");
           missAnAppointment();
       }
       else{
           try{
               Appointment selectedAppointment = q.getAppointmentById(iput);
               if(selectedAppointment.getStatus().equals("Attended")||selectedAppointment.getStatus().equals("Cancelled")){
                   System.err.println("Sorry you cannot miss an already attended or cancelled appointment");
                   missAnAppointment();
               }
               selectedAppointment.setStatus("Missed");
               System.out.println("You have successfully cancelled the appointment,go back to previous menu to"
                       + " view all missed appointments or select another appointment to miss");
               missAnAppointment();
           }
           catch(Exception e){
               System.err.println(e.getMessage());
               System.err.println("Make sure you input an integer");
           }
       }
    }
     public static void viewAppointments(String status){
         switch(status){
             case "Attended":
                 q.viewAttendedAppointments();
                 break;
             case "Cancelled":
                 q.viewCancelledAppointments();
                 break;
             case "Missed":
                 q.viewMissedAppointments();
                 break;
             default:
                 startConsoleApp(q);
         }
       System.out.println("00. Back to previous menu"+"\n0. Exit");
       scanner = new Scanner(System.in);
       String input = scanner.next();
       
            if(input.equals("0")){
                exitApp();
           }
           if(input.equals("00")){
               startConsoleApp(q);
           }
           if(!(input.equals("0")||input.equals("00"))){
               System.err.println("Make sure you type either 0 or 00");
               viewAppointments(status);
           }
     }
}
