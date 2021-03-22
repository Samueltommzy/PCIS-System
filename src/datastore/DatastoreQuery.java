/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;

import java.util.ArrayList;
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
}
