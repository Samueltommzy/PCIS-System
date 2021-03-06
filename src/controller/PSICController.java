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
public class PSICController {
    static Scanner scanner;
    public static String selectedPatientId = "1";
    public static DatastoreQuery q;
    
    public static void startConsoleApp(DatastoreQuery query){
        q = query;
        System.out.println("-------- Welcome to the Physiotherapy&Sports Injury Center --------\n"
                + "You will be provided with a couple of commands,"
                + "kindly type the command number to assess a particular functionality\n");
        
        System.out.println("Select an option below");
        System.out.println("1. View all available patients\n2. View all available physicians\n3. View all areas of Expertise "
                + "\n4. Create a patient\n5. Book Visitor consultation \n6. View all Appointments\n7. Attend patient appointment\n8. Cancel patient appointment"
                + "\n9. Miss patient appointment" +"\n10. View all attended appointments\n11. View all cancelled appointments"
                + "\n12. View all missed appointments\n13. Exit");
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
             bookVisitorAppointment();
    
                break;
            case "6":
             viewAllAppointments();
              
                break;
            case "7":
              attendAnAppointment();
                
                break;
            case "8":
             cancelAnAppointment();
                
                break;
            case  "9":
             missAnAppointment();
                
                break;
             case  "10":
              viewAppointments("Attended");
                
                break;
             case  "11":
              viewAppointments("Cancelled");
                
                break;
            case "12":
             viewAppointments("Missed");
                break;
            case "13":
                exitApp();
                break;
            default:
                System.out.println("Invalid option selected,restarting ....\n");
                backToHome();
        }
    }
    
    public static void backToHome(){
        startConsoleApp(q);
    }
    
    public static void exitApp(){
        System.out.println("\nThanks for coming!!! Bye Bye ...");
        System.exit(0);
    }
    
    private static void  patientEntryPoint(){
         q.listPatients();
         System.out.println("0. Exit App  \n\n00. Back to previous menu\n");
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
                    System.out.println("\nYou have chosen to use "+q.getPatientName(iput).toUpperCase());
                    System.out.println("\nYou will be taken back to home page to view physicians or expertises in order to book a treatment\n");
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
        System.out.println("0. Exit App  \n\n00. Back to previous menu\n");
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
        System.out.println("0. Exit App  \n\n00. Back to previous menu\n");
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
        System.out.println("\n0. Exit App \n\n00. Back to physicians menu\n");
        System.out.println("Select a ***treatmentId*** to book");
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
                    System.err.println("This treatment has already been booked,select another treatment!!!");
                    bookTreatmentByPhysician(id);
                }
                else{
                    q.setTreatmentStatus("Booked", iput);
                    createAppointment(selectedPatientId,patientName,physicianName,t.getDate(),"Booked",t.getRoom(),t.getName(),"Physician",id);
                    
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
        System.out.println("\n0. Exit App \n\n00. Back to expertise menu\n");
        System.out.println("Select a ***TREATMENTID*** to book");
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.equals("0")){
            exitApp();
        }
        else if(input.equals("00")){
            expertiseEntryPoint();
        }
        else{
            try{
                int iput = Integer.parseInt(input);
                Treatment t = q.getTreatment(iput);
                if(t.getStatus().equals("Booked")){
                    System.err.println("This treatment has already been booked,select another option!!!");
                    bookTreatmentByExpertise(id);
                }
                else{
                    q.setTreatmentStatus("Booked", iput);
                    createAppointment(selectedPatientId,patientName,physicianName,t.getDate(),"Booked",t.getRoom(),t.getName(),"Expertise",id);
                    
                }
            }
            catch(Exception e){
                System.out.println("You have to input a valid number");
                 System.err.println(e.getMessage());
                 bookTreatmentByExpertise(id);
            }
        }
    }
    
    public static void createAppointment(String patientId,String patientName,String physicianName,String date,String status,String room,String treatmentName,String entry,int entryId){
        Appointment appointment = new Appointment(String.valueOf(q.getAppointmentSize()+1),patientId,patientName,physicianName,treatmentName,date,room,status,"Patient Booking");
        q.addAppointment(appointment);
        System.out.println("your "+ treatmentName+" appointment with "+physicianName+" has been successfully booked for "+ date+ " Thank you!!!" );
        if(entry.equals("Physician")){
            bookTreatmentByPhysician(entryId);
        }
        else{
            bookTreatmentByExpertise(entryId);
        }
       
    }

    private static void createPatient() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        scanner = new Scanner(System.in);
        System.out.println("Enter name to use: ");
        String name = scanner.nextLine();
        while(name.isEmpty()){
         System.err.println("Make sure you input a name");
         System.out.println("Enter name to use: ");
         name = scanner.nextLine();
        }
        System.out.println("Enter phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        while(phoneNumber.isEmpty()){
         System.err.println("Make sure you input a phonenumber");
         System.out.println("Enter phoneNumber: ");
         phoneNumber = scanner.nextLine();
        }
        System.out.println("Enter your address: ");
        String address = scanner.nextLine();
         while(address.isEmpty()){
         System.err.println("Make sure you input an address");
         System.out.println("Enter your address: ");
         address = scanner.nextLine();
        }
        int patientId = q.getPatientSize()+1;
        selectedPatientId = String.valueOf(patientId);
        Patient newp = new Patient(patientId,name,address,phoneNumber);
        q.addPatient(newp);
        System.out.println("\nPatient successfully created!!!" );
        patientEntryPoint();
    }
    
    private static void viewAllAppointments(){
//        System.out.println("....All patients appointment.....");
        if(q.getAppointmentSize()>0){
           
             q.listAllAppointments();
             backToHome();
        }
        else{
            System.out.println("sorry,you do not have any appointments at this time/n");
            System.out.println("Would you like to view available treatments by a physician or area expertise???");
            System.out.println("1. Select a physician\n\n2. Select area of expertise\n\n00. Back to previous menu\n\n0. Exit App");
            scanner = new Scanner(System.in);
            String input = scanner.next();
            switch (input) {
                case "0":
                    exitApp();
                    break;
                case "00":
                    backToHome();
                    break;
                case "1":
                    physicianEntryPoint();
                    break;
                case "2":
                   expertiseEntryPoint();
                   break;
                default:
                  System.err.println("Invalid option selected,try again!!!");
                  viewAllAppointments();
                  break;
            }
        }
    }

    private static void attendAnAppointment() {
        if(q.getAppointmentSize() == 0){
            System.out.println("Sorry you do not have any appointmens yet !!!\nView physicians or expertise to see treatments and book appointment");
            backToHome();
        }
        else{
            q.listPatientAppointments();
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
               System.out.println("You have successfully attended the appointment!!!\nGo back to previous menu to"
                       + " view all attended appointments or select another appointment to attend");
               attendAnAppointment();
           }
           catch(Exception e){
               System.err.println(e.getMessage());
               System.err.println("Make sure you input an integer");
           }
           }
        }
    }
    
     private static void cancelAnAppointment() {
       q.listPatientAppointments();
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
       q.listPatientAppointments();
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
               System.out.println("You have missed the appointment,go back to previous menu to"
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
               System.err.println("Make sure you type either 0 to Exit App or 00 to go back to previous menu");
               viewAppointments(status);
           }
     }
     
     public static void bookVisitorAppointment(){
         System.out.println("***\nWelcome to consultation bookings***\nKindly select a physician to schedule a consultation below");
         q.listPhysicians();
         System.out.println("0 Exit App\n00 Back to previous menu");
         System.out.println("\nSelect physician to book consultation");
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
            if(iput>0&&iput<=5){
             bookConsultationByPhysician(iput);
            }
           }
           catch(Exception e){
            System.err.println("Invalid input");
           }
          }       
     }
     
     public static void bookConsultationByPhysician(int id){
      String physicianName = q.getPhysicianName(id);
      String physicianConsultations = q.getPhysicianConsultation(id);
      System.out.println("Please provide your name ");
      String visitorName = scanner.nextLine();
        while(visitorName.isEmpty()){
         System.err.println("Make sure you input your name");
         System.out.println("Please provide your name: ");
         visitorName = scanner.nextLine();
        }
      Appointment consultationAppointment = new Appointment(String.valueOf(q.getAppointmentSize()+1),visitorName,physicianName,physicianConsultations,
                                                            "Room X","Booked","visitor consultation");
      q.addAppointment(consultationAppointment);
      System.out.println("\nCongratulations, "+visitorName+ "!!! "+ "Your consultation apointment with "+ physicianName+" has been reserved for "+ physicianConsultations.split(",")[0]);
      System.out.println("\n\n0 Exit App\n00 Back to previous menu");
        scanner = new Scanner(System.in);
         String input = scanner.next();
         
          if(input.equals("0")){
           exitApp();
          }
          else if(input.equals("00")){
           backToHome();
          }
     }
}
