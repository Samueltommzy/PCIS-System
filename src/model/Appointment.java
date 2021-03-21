/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author samuel
 */
public class Appointment{
    private int patientId;
    private int physicianId;
    private String treatmentName;
    private String treatmentDate;
    private String room;
    private String status;
    
    public Appointment(int patientId,int physicianId,String treatmentName,String treatmentDate,String room,String status){
        this.patientId = patientId;
        this.physicianId = physicianId;
        this.room = room;
        this.status = status;
        this.treatmentDate = treatmentDate;
        this.treatmentName = treatmentName;
    }
    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the physicianId
     */
    public int getPhysicianId() {
        return physicianId;
    }

    /**
     * @param physicianId the physicianId to set
     */
    public void setPhysicianId(int physicianId) {
        this.physicianId = physicianId;
    }

    /**
     * @return the treatmentName
     */
    public String getTreatmentName() {
        return treatmentName;
    }

    /**
     * @param treatmentName the treatmentName to set
     */
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    /**
     * @return the treatmentDate
     */
    public String getTreatmentDate() {
        return treatmentDate;
    }

    /**
     * @param treatmentDate the treatmentDate to set
     */
    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
