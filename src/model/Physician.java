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
