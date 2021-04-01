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
public class Expertise implements Serializable{
     private String name;
     private int id;
     
     public Expertise(){
         
     };
    public Expertise(String name,int id) {
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
}
