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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samuel
 */
public class DatastoreQueryIT {
   static  Physician phy;
    static Patient p;
    static Treatment t;
    static Expertise e;
    static Appointment app;
    public DatastoreQueryIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String[] p4Expertise = { "Physiotherapy", "Oestopathy" };
        String[] p4ConsultationHours = { "Mondays 9-10am", "Wednesdays 3-4pm" };
        Patient pat = new Patient(20,"a","b","c");
        Physician phys = new Physician(10,"Test", "Tests", "Test", p4Expertise,p4ConsultationHours);
        Treatment treat = new Treatment(1,"1","2",3,"4","5","6");
        Expertise testExp = new Expertise("Test",1);
        Appointment ap = new Appointment("1","b","c","d","e","test","test","test","type");
       phy = phys;
       p = pat;
       t = treat;
       e = testExp;
       app = ap;
//        DatastoreQuery instance = new DatastoreQuery();
//        instance.addPatient(p);
//        instance.addPhysician(phys);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
   

    /**
     * Test of addPatient method, of class DatastoreQuery.
     */
    @Test
    public void testAddPatient() {
        Patient p = new Patient(20,"a","b","c");
        DatastoreQuery instance = null;
        assertNull(instance);
        instance = new DatastoreQuery();
        instance.addPatient(p);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance);
        assertTrue(p instanceof Patient);
    }

    /**
     * Test of addTreatment method, of class DatastoreQuery.
     */
    @Test
    public void testAddTreatment() {
        Treatment t = new Treatment(1,"1","2",3,"4","5","6");
       
        DatastoreQuery instance =null;
        assertNull(instance);
       instance = new DatastoreQuery();
       instance.addTreatment(t);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(t);
        assertTrue(t instanceof Treatment);
    }

    /**
     * Test of addAppointment method, of class DatastoreQuery.
     */
    @Test
    public void testAddAppointment() {
        Appointment a = new Appointment("a","s","d","f","p","q","g","booked","type");
       
        DatastoreQuery instance =null;
        assertNull(instance);
        instance = new DatastoreQuery();
        instance.addAppointment(a);
       
       assertNotNull(a);
      assertTrue(a instanceof Appointment);
    }

    /**
     * Test of getAllPhysicians method, of class DatastoreQuery.
     */
     @Test
    public void testGetAllPhysicians() {
        DatastoreQuery instance = null;
        assertNull(instance);
        instance = new DatastoreQuery();
        instance.addPhysician(phy);
       ArrayList<Physician> allPhysician =  instance.getAllPhysicians();
       assertNotNull(allPhysician);
       assertNotEquals(allPhysician.size(),0);
    }   

    /**
     * Test of getAllPatients method, of class DatastoreQuery.
     */
     @Test
    public void testGetAllPatients() {
        DatastoreQuery instance = null;
        assertNull(instance);
        instance = new DatastoreQuery();
        instance.addPatient(p);
        ArrayList<Patient> allpatients = instance.getAllPatients();
        assertNotNull(allpatients);
        assertNotEquals(allpatients.size(),0);
        
    }

    /**
     * Test of getAllExpertises method, of class DatastoreQuery.
     */
    @Test
    public void GetAllExpertise() {
       
        DatastoreQuery instance = null;
        assertNull(instance);
        instance = new DatastoreQuery();
       instance.addExpertise(e);
        ArrayList<Expertise> allExpertises = instance.getAllExpertise();
        assertNotNull(allExpertises);
        assertNotEquals(allExpertises.size(),0);
       
    }
    /**
     * Test of getPatientName method, of class DatastoreQuery.
     */
    @Test
    public void testGetPatientName() {
        int id = 1;
       DatastoreQuery instance = new DatastoreQuery();
       instance.addPatient(p);
       String nameOfPatient = instance.getPatientName(id);
       assertNotNull(nameOfPatient);
    }

    /**
     * Test of getPhysicianName method, of class DatastoreQuery.
     */
    @Test
    public void testGetPhysicianName() {
       int id = 1;
       DatastoreQuery instance = new DatastoreQuery();
       instance.addPhysician(phy);
       String nameOfPhysician = instance.getPhysicianName(id);
       assertNotNull(nameOfPhysician);
    }

    /**
     * Test of getTreatment method, of class DatastoreQuery.
     */
    @Test
    public void testGetTreatment() {
        int id = t.getTreatmentId();
        DatastoreQuery instance = new DatastoreQuery();
        instance.addTreatment(t);
        Treatment result = instance.getTreatment(id);
        assertNotNull(result);
        assertTrue(result instanceof Treatment);
    }

    /**
     * Test of setTreatmentStatus method, of class DatastoreQuery.
     */
    @Test
    public void testSetTreatmentStatus() {
       
        String status = "Booked";
        int id = t.getTreatmentId();
        DatastoreQuery instance = new DatastoreQuery();
        instance.addTreatment(t);
        instance.setTreatmentStatus(status, id);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(t.getStatus(),status);
    }

    /**
     * Test of getPatientSize method, of class DatastoreQuery.
     */
    @Test
    public void testGetPatientSize() {
       
        DatastoreQuery instance = new DatastoreQuery();
        instance.addPatient(p);
        int patientSize = instance.getPatientSize();
        assertNotEquals(patientSize,0);
    }

    /**
     * Test of getAppointmentSize method, of class DatastoreQuery.
     */
    @Test
    public void testGetAppointmentSize() {
        DatastoreQuery instance = new DatastoreQuery();
        int appointmentSize = instance.getAppointmentSize();
        assertEquals(appointmentSize,0);
    }

    /**
     * Test of getAppointmentById method, of class DatastoreQuery.
     */
    @Test
    public void testGetAppointmentById() {
        int id = 1;
        DatastoreQuery instance = new DatastoreQuery();
        instance.addAppointment(app);
        Appointment result = instance.getAppointmentById(id);
        assertNotNull(result);
    }

    /**
     * Test of viewAttendedAppointments method, of class DatastoreQuery.
     */
//    @Test
//    public void testViewAttendedAppointments() {
//        System.out.println("viewAttendedAppointments");
//        DatastoreQuery instance = new DatastoreQuery();
//        instance.viewAttendedAppointments();
//    }

    /**
     * Test of viewCancelledAppointments method, of class DatastoreQuery.
     */
//    @Test
//    public void testViewCancelledAppointments() {
//        System.out.println("viewCancelledAppointments");
//        DatastoreQuery instance = new DatastoreQuery();
//        instance.viewCancelledAppointments();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of viewMissedAppointments method, of class DatastoreQuery.
     */
//    @Test
//    public void testViewMissedAppointments() {
//        System.out.println("viewMissedAppointments");
//        DatastoreQuery instance = new DatastoreQuery();
//        instance.viewMissedAppointments();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
