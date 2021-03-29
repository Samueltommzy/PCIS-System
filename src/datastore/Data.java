/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import model.Expertise;
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
        
        String[] p6Expertise = { "Physiotherapy","Oestopathy", "Rehabilitation" };
        String[] p6ConsultationHours = { "Fridays 12-1pm", "Wednesdays 1-2pm" };
        
        Physician p1 = new Physician(1,"Edmond Samson", "London,UK", "08123492788", p1Expertise, p1ConsultationHours);
        Physician p2 = new Physician(2, "Ademola Emmanuel", "Ashford,UK", "08123056789", p2Expertise, p2ConsultationHours);
        Physician p3 = new Physician(3, "Emilly Simpson", "Manchester,UK", "08124456788", p3Expertise, p3ConsultationHours);
        Physician p4 = new Physician(4, "Adam Smith", "Porthsmouth,UK", "08124456188", p4Expertise, p4ConsultationHours);
        Physician p5 = new Physician(5, "Benjamin Taylor", "London,UK", "08124456798", p5Expertise, p5ConsultationHours);
        Physician p6 = new Physician(6, "Omolola Rachael", "Ashford,UK", "08124451788", p6Expertise, p6ConsultationHours);
        
        
        outputStream.writeObject(p1);
        outputStream.writeObject(p2);
        outputStream.writeObject(p3);
        outputStream.writeObject(p4);
        outputStream.writeObject(p5);
        outputStream.writeObject(p6);
        
        outputStream.close();
    }
   
   static void createExpertise() throws IOException{
       ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("expertise.txt"));
       Expertise e1 = new Expertise("Oesteopathy",1);
       Expertise e2 = new Expertise("Physiotherapy",2);
       Expertise e3 = new Expertise("Rehabilitation",3);
       
       outputStream.writeObject(e1);
       outputStream.writeObject(e2);
       outputStream.writeObject(e3);
       
       outputStream.close();
   }
   
   static void createTreatments() throws  IOException{
       ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("treatments.txt"));
        outputStream.writeObject( new Treatment("Acupuncture","04/05/2021,1:00-2:00pm",1,"suit A","Available","Physiotherapy"));
        outputStream.writeObject( new Treatment("Acupuncture","04/05/2021,4:00-5:00pm",1,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Massage","07/05/2021,8:00-9:00am",1,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Mental Rehab","11/05/2021,10:00-11:00am",1,"suit C","Available","Rehabilitation"));
        outputStream.writeObject( new Treatment("Massage","13/05/2021,2:00-3:00pm",1,"spa","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Pool Rehab","14/05/2021,8:00-9:00am",1,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Acupuncture","18/05/2021,4:00-5:00pm",1,"suit A","Available","Physiotherapy"));
        outputStream.writeObject(new Treatment("Mental Rehab","21/05/2021,8:00-9:00am",1,"suit  C","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Pool Rehab","03/05/2021,8:00-9:00am",2,"pool","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Neural Mobilisation","05/05/2021,11:00-12:00pm",2,"suit D","Available","Oestopathy"));
        outputStream.writeObject(new Treatment("Mental Rehab","10/05/2021,1:00-2:00pm",2,"suit C","Available","Rehabilitation"));
        outputStream.writeObject(new Treatment("Pool Rehab","15/05/2021,10:00-11:00am",2,"pool","Available","Rehabilitation"));
        
        outputStream.close();
   }
   

}
