/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcis.project;

import controller.PCISControllers;
import datastore.Data;
import datastore.DatastoreQuery;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author samuel
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, EOFException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
//        Data.createPhysicians();
//        Data.createExpertise();
//        Data.createTreatments();
//        Data.createPatients();
        
        DatastoreQuery q = new DatastoreQuery();
        q.readFileData("physicians.txt","Physician");
        q.readFileData("expertises.txt", "Expertise");
        q.readFileData("treatments.txt", "Treatment");
        q.readFileData("patients.txt", "Patient");
        
        PCISControllers.startConsoleApp(q);
//        System.exit(0);
    }
    
}
