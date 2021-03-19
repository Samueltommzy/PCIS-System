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
abstract class User {
     public abstract int getId();
     public abstract String getFullName();
     public abstract String getAddress();
     public abstract String getPhoneNumber();
     public abstract String getUserInfo();
}
