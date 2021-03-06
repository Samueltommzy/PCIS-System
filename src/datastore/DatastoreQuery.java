/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.Appointment;
import model.Expertise;
import model.Patient;
import model.Physician;
import model.Treatment;
import pcis.project.Main;

/**
 *
 * @author samuel
 */
public class DatastoreQuery {
   private ArrayList<Physician> physicians;
   private  ArrayList<Patient> patients;
   private ArrayList<Treatment> treatments;
   private ArrayList<Appointment> appointments;
   private ArrayList<Expertise> expertises;
    
    public DatastoreQuery(){
        this.appointments = new ArrayList<Appointment>();
        this.expertises = new ArrayList<Expertise>();
        this.patients = new ArrayList<Patient>();
        this.physicians = new ArrayList<Physician>();
        this.treatments = new ArrayList<Treatment>();
    }
    
    //Add physician
    public Physician addPhysician(Physician p){
        physicians.add(p);
        return p;
    }
    //Add patient
    public Patient addPatient(Patient p ){
        patients.add(p);
        return p;
    }
    //Add treatment
    public void addTreatment(Treatment t){
        treatments.add(t);
    }
     public void addExpertise(Expertise t){
        expertises.add(t);
    }
    public Appointment addAppointment(Appointment a){
        appointments.add(a);
        return a;
    }
    public ArrayList<Physician>  getAllPhysicians(){
        return physicians;
    }
    public ArrayList<Patient> getAllPatients(){
        return patients;
    }
    public ArrayList<Expertise> getAllExpertise(){
        return expertises;
    }
    //List physicians 
    public void listPhysicians(){
        System.out.println(".....................All physicians..............................\n");
        
        for(int i = 0;i <physicians.size();i++){
            System.out.println(physicians.get(i).getId()+"."+" "+physicians.get(i).getUserInfo()+"\n");
        }
    }
    //View physician Details
     public void viewPhysicianDetails(String name){
        int indexOfName = 0;
        while(true){
            if(physicians.get(indexOfName).getFullName().equals(name)){
                System.out.println("Physician full details\n");
                System.out.println(physicians.get(indexOfName).getUserInfo());
                break;
            }
            indexOfName++;
        }
    }
     
     public void listPatients(){
         System.out.println(".....................All patients..............................\n");
        
        for(int i = 0;i <patients.size();i++){
            System.out.println(patients.get(i).getId()+"."+" "+patients.get(i).getUserInfo()+"\n");
        }
     }
     
     public void listExpertise(){
         System.out.println(".....................All expertise..............................\n");
        
        for(int i = 0;i <expertises.size();i++){
            System.out.println(expertises.get(i).getId()+"."+" "+expertises.get(i).getName()+"\n");
        }
     }
     public void listAllAppointments(){
         System.out.println(".....................All Appointments..............................\n");
      
         System.out.println(":::::Patient Appointments:::::");
         for(int i = 0;i <appointments.size();i++){
          if(appointments.get(i).getAppointmentType().equals("Patient Booking")){
           System.out.println(appointments.get(i).appointmentInfo()+"\n");
          }
     
        }
         System.out.println(":::::Visitor Appointments:::::");
          for(int i = 0;i <appointments.size();i++){
           if(appointments.get(i).getAppointmentType().equals("visitor consultation")){
            System.out.println(appointments.get(i).visitorConsultationInfo()+"\n");
           }
        }
     }
     
     public void listPatientAppointments(){
      System.out.println(".....................All Patient Appointments..............................\n");
      for(int i = 0;i <appointments.size();i++){
          if(appointments.get(i).getAppointmentType().equals("Patient Booking")){
           System.out.println(appointments.get(i).appointmentInfo()+"\n");
       }
      }
     }
     //View treatments
     //Using hashset to improve performance giving constant -time number of operations 0(n) instead of looping o(n2)
     public void viewTreatmentByPhysician(int id){
         String physicianName = physicians.get(id-1).getFullName();
         Set<Integer> filterSet = treatmentFilter(id).stream().collect(Collectors.toSet());
        
          ArrayList<Treatment> availableTreatments  = (ArrayList<Treatment>) treatments.stream()
              .filter(treatment->filterSet.contains(treatment.getPhysicianId())).collect(Collectors.toList());
         
         System.out.println("-------All treatments available for  "+physicianName+"-------\n");
         for(int i =0;i<availableTreatments.size();i++){
//             System.out.println((i+1)+availableTreatments.get(i).getTreatmentInfo()+"\nPhysician name: "+physicianName);
             System.out.println(availableTreatments.get(i).getTreatmentInfo()+"\nPhysician name: "+physicianName+"\n");
         }
     }
   
     
        public void viewTreatmentByExpertise(int id){
         String expertiseName = expertises.get(id-1).getName();
         Set<String> filterSet = treatmentFilterExpertise(expertiseName).stream().collect(Collectors.toSet());
          ArrayList<Treatment> availableTreatments  = (ArrayList<Treatment>) treatments.stream().filter(treatment->filterSet.contains(treatment.getExpertiseName())).collect(Collectors.toList());
         
         System.out.println("-------All treatments available for "+expertiseName+"-------\n");
         for(int i =0;i<availableTreatments.size();i++){
             int physicianId = availableTreatments.get(i).getPhysicianId();
             String physicianName = physicians.get(physicianId-1).getFullName();
             System.out.println(availableTreatments.get(i).getTreatmentInfo()+"\nPhysician name: "+physicianName+"\n");
         }
     }
     
     private List<Integer> treatmentFilter(int id){
         return Arrays.asList(id);
     }
     private List<String> treatmentFilterExpertise(String name){
         return Arrays.asList(name);
     }
     private List<String> appointmentFilter(String type){
      return Arrays.asList(type);
     }
        public  void readFileData(String fileName,String className) throws EOFException, FileNotFoundException, IOException, ClassNotFoundException, URISyntaxException{
             InputStream fi = Main.class.getClassLoader().getResourceAsStream(fileName);
            ObjectInputStream oi = new ObjectInputStream(fi);
            try(oi){
                while(true){
                    Object fileData = oi.readObject();
                    if(fileData == null){
                        break;
                    }
                    switch (className){
                        case "Physician":
                            Physician p = (Physician) fileData;
                            physicians.add(p);
                            break;
                        case "Expertise":
                            Expertise e = (Expertise) fileData;
                            expertises.add(e);
                            break;
                        case "Patient":
                            Patient pa = (Patient) fileData;
                            patients.add(pa);
                            break;
                        case "Treatment":
                            Treatment t = (Treatment) fileData;
                            treatments.add(t);
                            break;
                        default:
                            System.err.println("Invalid class name provided");
                            break;
                    }  
                }
            }
            
            catch(EOFException e){
//                e.printStackTrace();
                oi.close();
            }       
    }
    
        public String getPatientName(int id){
            return patients.get(id-1).getFullName();
        }
        public String getPhysicianName(int id){
            return physicians.get(id-1).getFullName();
        }
        public Treatment getTreatment(int id){
            return treatments.get(id-1);
        }
        public String getPhysicianConsultation(int id){
         return physicians.get(id-1).getConsultationHours();
        }
       public void setTreatmentStatus(String status,int id){
           Treatment t = treatments.get(id-1);
           
           t.setStatus(status);
       }
       public int getPatientSize(){
           return patients.size();
       }
       public int getAppointmentSize(){
           return appointments.size();
       }
       
       public Appointment getAppointmentById(int id){
           return appointments.get(id-1);
       }
       public void viewAttendedAppointments(){
          String status = "Attended";
          Set<String> filterSet = appointmentFilterByStatus(status).stream().collect(Collectors.toSet());
          ArrayList<Appointment> attendedAppointments  = (ArrayList<Appointment>) appointments.stream().filter(appointment->filterSet.contains(appointment.getStatus())).collect(Collectors.toList());
          System.out.println("-------All attended appointments-------\n");
          for(int i =0;i<attendedAppointments.size();i++){
             System.out.println(attendedAppointments.get(i).appointmentInfo()+"\n");
          }
       }
        public void viewCancelledAppointments(){
          String status = "Cancelled";
          Set<String> filterSet = appointmentFilterByStatus(status).stream().collect(Collectors.toSet());
          ArrayList<Appointment> cancelledAppointments  = (ArrayList<Appointment>) appointments.stream().filter(appointment->filterSet.contains(appointment.getStatus())).collect(Collectors.toList());
          System.out.println("-------All cancelled appointments-------\n");
          for(int i =0;i<cancelledAppointments.size();i++){
             System.out.println(cancelledAppointments.get(i).appointmentInfo()+"\n");
          }
       }
        
           public void viewMissedAppointments(){
          String status = "Missed";
          Set<String> filterSet = appointmentFilterByStatus(status).stream().collect(Collectors.toSet());
          ArrayList<Appointment> missedAppointments  = (ArrayList<Appointment>) appointments.stream().filter(appointment->filterSet.contains(appointment.getStatus())).collect(Collectors.toList());
          System.out.println("-------All missed appointments-------\n");
          for(int i =0;i<missedAppointments.size();i++){
             System.out.println(missedAppointments.get(i).appointmentInfo()+"\n");
          }
       }
        private List<String> appointmentFilterByStatus(String status){
         return Arrays.asList(status);
     }
}

