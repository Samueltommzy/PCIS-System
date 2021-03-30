/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import model.Expertise;
import model.Patient;
import model.Physician;
import model.Treatment;

/**
 *
 * @author samuel
 */
public class Data {
    
   public static void createPhysicians() throws IOException{
         ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("physicians.txt"));
         String[] p1Expertise = { "Physiotherapy", "Rehabilitation" };
        String[] p1ConsultationHours = { "Modays 12-1pm", "Wednesdays 1-2pm" };
        
        String[] p2Expertise = { "Oestopathy", "Rehabilitation" };
        String[] p2ConsultationHours = { "Tuesdays 8-9am", "Thursday 3-4pm" };
        
        String[] p3Expertise = { "Physiotherapy","Oestopathy", "Rehabilitation" };
        String[] p3ConsultationHours = { "Tuesdays 12-1pm", "Wednesdays 1-2pm" };
        
        String[] p4Expertise = { "Physiotherapy", "Oestopathy" };
        String[] p4ConsultationHours = { "Mondays 9-10am", "Wednesdays 3-4pm" };
        
        String[] p5Expertise = { "Physiotherapy","Oestopathy", "Rehabilitation" };
        String[] p5ConsultationHours = { "Thursdays 10-11am", "Fridays 1-2pm" };
        
        Physician p1 = new Physician(1,"Edmond Samson", "London,UK", "08123492788", p1Expertise, p1ConsultationHours);
        Physician p2 = new Physician(2, "Ademola Emmanuel", "Ashford,UK", "08123056789", p2Expertise, p2ConsultationHours);
        Physician p3 = new Physician(3, "Emilly Simpson", "Manchester,UK", "08124456788", p3Expertise, p3ConsultationHours);
        Physician p4 = new Physician(4, "Adam Smith", "Porthsmouth,UK", "08124456188", p4Expertise, p4ConsultationHours);
        Physician p5 = new Physician(5, "Benjamin Taylor", "London,UK", "08124456798", p5Expertise, p5ConsultationHours);
        
        outputStream.writeObject(p1);
        outputStream.writeObject(p2);
        outputStream.writeObject(p3);
        outputStream.writeObject(p4);
        outputStream.writeObject(p5);
        
        outputStream.close();
    }
   
   public static void createExpertise() throws IOException{
       ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("expertises.txt"));
       Expertise e1 = new Expertise("Oestopathy",1);
       Expertise e2 = new Expertise("Physiotherapy",2);
       Expertise e3 = new Expertise("Rehabilitation",3);
       
       outputStream.writeObject(e1);
       outputStream.writeObject(e2);
       outputStream.writeObject(e3);
       
       outputStream.close();
   }
   
  public static void createTreatments() throws  IOException{
       ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("treatments.txt"));
        outputStream.writeObject( new Treatment("Acupuncture","04/05/2021,1:00-2:00pm",1,"suit A","Available","Physiotherapy"));
        outputStream.writeObject( new Treatment("Acupuncture","06/05/2021,4:00-5:00pm",1,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Massage","07/05/2021,8:00-9:00am",1,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Mental Rehab","11/05/2021,10:00-11:00am",1,"suit C","Available","Rehabilitation"));
        outputStream.writeObject( new Treatment("Massage","13/05/2021,2:00-3:00pm",1,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Pool Rehab","14/05/2021,8:00-9:00am",1,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Acupuncture","18/05/2021,4:00-5:00pm",1,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Mental Rehab","21/05/2021,8:00-9:00am",1,"suit  C","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Pool Rehab","03/05/2021,8:00-9:00am",2,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Neural Mobilisation","05/05/2021,11:00-12:00pm",2,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Mental Rehab","10/05/2021,1:00-2:00pm",2,"suit C","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Pool Rehab","14/05/2021,10:00-11:00am",2,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Bone and Marrow Check","18/05/2021,12:00-1:00pm",2,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Neural Mobilisation","19/05/2021,12:00-1:00pm",2,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Mental Rehab","24/05/2021,3:00-4:00pm",2,"suit B","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Bone and Marrow Check","18/05/2021,12:00-1:00pm",3,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Neural Mobilisation","03/05/2021,11:00-12:00pm",3,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Massage","06/05/2021,8:00-9:00am",3,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Acupuncture","07/05/2021,4:00-5:00pm",3,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Pool Rehab","13/05/2021,8:00-9:00am",3,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Mental Rehab","17/05/2021,10:00-11:00am",3,"suit  C","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Bone and Marrow Check","20/05/2021,12:00-1:00pm",3,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Massage","04/05/2021,8:00-9:00am",4,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Acupuncture","07/05/2021,4:00-5:00pm",4,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Pool Rehab","13/05/2021,8:00-9:00am",4,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Massage","18/05/2021,8:00-9:00am",4,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Acupuncture","20/05/2021,4:00-5:00pm",4,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Massage","28/05/2021,4:00-5:00pm",4,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Neural Mobilisation","04/05/2021,11:00-12:00pm",5,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Mental Rehab","05/05/2021,10:00-11:00am",5,"suit  C","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Bone and Marrow Check","10/05/2021,12:00-1:00pm",5,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Pool Rehab","17/05/2021,8:00-9:00am",5,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Acupuncture","25/05/2021,4:00-5:00pm",5,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Mental Rehab","26/05/2021,10:00-11:00am",5,"suit  C","Available","Rehabilitation"));
        
        outputStream.close();
   }
   
  public static void createPatients() throws FileNotFoundException, IOException{
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("patients.txt"));
      outputStream.writeObject(new Patient(1,"Edmond Sam", "London,UK", "08123492788"));
      outputStream.writeObject(new Patient(2,"Daniel Opeyemi", "Ashford,UK", "08123493188"));
      outputStream.writeObject(new Patient(3,"Oladele Helen", "Manchester,UK", "08162892789"));
      outputStream.writeObject(new Patient(4,"Drasner Paul", "London,UK", "08123036788"));
      outputStream.writeObject(new Patient(5,"Alexandro Cortez", "Sussex,UK", "05187937982"));
      outputStream.writeObject(new Patient(6,"Xi Chan", "Ashford,UK", "08126290712"));
      outputStream.writeObject(new Patient(7,"Rajek Khan", "London,UK", "09155492722"));
      outputStream.writeObject(new Patient(8,"Luke Cage", "Hatfield,UK", "08121792753"));
      outputStream.writeObject(new Patient(9,"Ellean Shapiro", "London,UK", "08111192788"));
      outputStream.writeObject(new Patient(10,"Smart Diddy", "Southanmpton,UK", "08198792788"));
      outputStream.writeObject(new Patient(11,"Random name", "Nowhere,UK", "08XXXXXXXXX"));
      outputStream.writeObject(new Patient(12,"Thomas Edison", "London,UK", "08128935782"));
      outputStream.writeObject(new Patient(13,"Michael Franklin", "Oxford,UK", "08135672788"));
      outputStream.writeObject(new Patient(14,"Adeyemi Gabriella", "Ashford,UK", "07423492788"));
      outputStream.writeObject(new Patient(15,"Celina Diaz", "London,UK", "07523497215"));
      
      outputStream.close();
  }

}
