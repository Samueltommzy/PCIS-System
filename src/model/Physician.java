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
public class Physician extends User {
    private String[] areasOfExpertise;

    private String[] consultHours;
    private int id;

    private String fullName;

    private String address;

    private String phoneNumber;
       public Physician(){
    
    }
    
    public Physician(int id, String fullName, String address, String phoneNumber, String[] expertise, String[] consultHours) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        areasOfExpertise = expertise;
        this.consultHours = consultHours;
    }
    @Override
    public int getId() {
       return id;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getAddress() {
       return address;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
     public String getAreasOfExpertise() {
        String result = "";
        for (String s : areasOfExpertise) {
            result += s + ",";
        }
        return result;
    }

    public String getConsultationHours() {
        String result = "";
        for (String s : consultHours) {
            result += s + ",";
        }
        return result;
    }

    @Override
    public String getUserInfo() {
        return  "Id: " + getId() + "\nName: " + getFullName() + "\nAddress: " + getAddress() + "\nphoneNumber: " + 
                getPhoneNumber()+ "\nAreas of Expertise: " + "[" + getAreasOfExpertise() + "]" + "\nConsultation Hours: " + "[" + getConsultationHours() + "]";
    }
    
}
