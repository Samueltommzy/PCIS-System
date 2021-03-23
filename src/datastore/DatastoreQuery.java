/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;

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

/**
 *
 * @author samuel
 */
public class DatastoreQuery {
    ArrayList<Physician> physicians;
    ArrayList<Patient> patients;
    ArrayList<Treatment> treatments;
    ArrayList<Appointment> appointments;
    ArrayList<Expertise> expertises;
    
    public DatastoreQuery(){
        this.appointments = new ArrayList<Appointment>();
        this.expertises = new ArrayList<Expertise>();
        this.patients = new ArrayList<Patient>();
        this.physicians = new ArrayList<Physician>();
        this.treatments = new ArrayList<Treatment>();
    }
    
    //Add physician
    public void addPhysician(Physician p){
        physicians.add(p);
    }
    //Add patient
    public void addPatient(Patient p ){
        patients.add(p);
    }
    //Add treatment
    public void addTreatment(Treatment t){
        treatments.add(t);
    }
    public void addAppointment(Appointment a){
        appointments.add(a);
    }
    //List physicians by name
    public void listPhysicians(){
        System.out.println(".....................All physicians..............................\n");
        
        for(int i = 0;i <physicians.size();i++){
            System.out.println(physicians.get(i).getId()+"."+" "+physicians.get(i).getFullName());
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
     //View physician treatments
     //Using hashset to improve performance giving constant -time number of operations 0(n) instead of looping o(n2)
     public void viewPhysicianTreatments(int id){
         ArrayList<Treatment> physTreatments;
         String physicianName = physicians.get(id-1).getFullName();
         Set<Integer> filterSet = treatmentFilter(id).stream().collect(Collectors.toSet());
         physTreatments = (ArrayList<Treatment>) treatments.stream().filter(treatment->filterSet.contains(treatment.getPhysicianId())).collect(Collectors.toList());
         System.out.println("-------All treatments available for this physician-------\n");
         for(int i =0;i<physTreatments.size();i++){
             System.out.println("....................."+(i+1)+ ".............................\n"+physTreatments.get(i).getTreatmentInfo()+"\nPhysician name: "+physicianName);
         }
     }
     
     private List<Integer> treatmentFilter(int id){
         return Arrays.asList(id);
     }
}
