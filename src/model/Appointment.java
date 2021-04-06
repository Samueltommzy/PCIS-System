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
    private String appointmentId;
    private String patientId;
    private String patientName;
    private String physicianName;
    private String treatmentName;
    private String treatmentDate;
    private String room;
    private String status;
    
    public Appointment(String appointmentId,String patientId,String patientName,String physicianName,String treatmentName,String treatmentDate,String room,String status){
        this.patientId = patientId;
        this.physicianName = physicianName;
        this.room = room;
        this.status = status;
        this.treatmentDate = treatmentDate;
        this.treatmentName = treatmentName;
        this.appointmentId = appointmentId;
        this.patientName = patientName;
    }
    /**
     * @return the patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the physicianId
     */
    public String getPhysicianName() {
        return physicianName;
    }

    /**
     * @param physicianId the physicianId to set
     */
    public void setPhysicianId(String physicianName) {
        this.physicianName = physicianName;
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
    
    public String appointmentInfo(){
        return "\nappointmentId:"+appointmentId+" \ntreatment: "+treatmentName+"\npatientName: "+patientName+"\nphysicianName: "+physicianName+"\nstatus: "+status+"\ndate: "+treatmentDate+"\nroom: "+room;
    }
}
