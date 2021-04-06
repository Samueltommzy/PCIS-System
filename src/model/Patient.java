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
public class Patient extends User implements Serializable{
//     private static final long serialVersionUID = 1L;1
     private int id;

    private String fullName;

    private String address;

    private String phoneNumber;
    
    public Patient(int id,String fullName,String address,String phoneNumber){
         this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    @Override
    public String getUserInfo() {
        return "Id: " + getId() + "\nName: " + getFullName() + "\nAddress: " + getAddress() + "\nphoneNumber: " +getPhoneNumber();
    }  
}
