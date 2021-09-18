/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dominio;

/**
 *
 * @author USUARIOTC
 */
public class ClassUsuario {

    @Override
    public String toString() {
        return "ClassUsuario{" + "id= " + id + ", username= " + username + ", password= " + password + '}';
    }


    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private int id;
    private String username;
    private String password;
    
    public ClassUsuario(){
        
    }
//    public ClassUsuario(){
//        
//    }
//    public ClassUsuario(){
//        
//    }
    
}
