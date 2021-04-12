/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author samuel
 */
public class Treatment implements Serializable {
//    private static final long serialVersionUID = 1L;
    private String name;
    private String date;
    private int physicianId;
    private String room;
    private String status;
    private String expertiseName;
    private int treatmentId;
    
    public Treatment(int treatmentId,String name,String date,int physicianId,String room,String status,String expertiseName){
        this.date = date;
        this.expertiseName = expertiseName;
        this.name = name;
        this.physicianId  = physicianId;
        this.room = room;
        this.status = status;
        this.treatmentId = treatmentId;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the physicianId
     */
    public int getPhysicianId() {
        return physicianId;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }
    public void setStatus(String status){
        this.status = status;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the expertise
     */
    public String getExpertiseName() {
        return expertiseName;
    }
    public int getTreatmentId(){
        return this.treatmentId;
    }
    public String getTreatmentInfo(){
        return "\nTreatmentId: " + getTreatmentId()+"\nTreatment: "+getName()+"\nRoom: "+getRoom()+"\nDate Available: "+getDate()+"\nStatus: "+getStatus();
    }
    
}
