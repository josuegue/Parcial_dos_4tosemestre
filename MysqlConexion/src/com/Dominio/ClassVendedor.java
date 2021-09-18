/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dominio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.temporal.TemporalQueries;

/**
 *
 * @author USUARIOTC
 */
public class ClassVendedor {
    private String id;
    private String nombre;
    private String apellido;
    private double enero;
    private double febrero;
    private double marzo;
    private double promedio;
    private double gran_Total;
    
    
    public ClassVendedor(){

    }

    @Override
    public String toString() {
        return "Id = "+id+" Nombre = " + nombre + ", apellido = " + apellido + ", enero = " + enero + ", febrero = " + febrero + ", marzo = " + marzo + ", promedio = " + promedio + ", gran_Total = " + gran_Total;
    }
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the enero
     */
    public double getEnero() {
        return enero;
    }

    /**
     * @param enero the enero to set
     */
    public void setEnero(double enero) {
        this.enero = enero;
    }

    /**
     * @return the febrero
     */
    public double getFebrero() {
        return febrero;
    }

    /**
     * @param febrero the febrero to set
     */
    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    /**
     * @return the marzo
     */
    public double getMarzo() {
        return marzo;
    }

    /**
     * @param marzo the marzo to set
     */
    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }

    /**
     * @return the promedio
     */
    public double getPromedio() {
        return promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(double enero, double febrero, double marzo) {
        this.promedio = Math.round(((enero+febrero+marzo)/3)*100.0)/100.0;
    }
        public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    /**
     * @return the gran_Total
     */
    public double getGran_Total() {
        return gran_Total;
    }

    /**
     * @param gran_Total the gran_Total to set
     */
    public void setGran_Total(double enero, double febrero, double marzo) {
        this.gran_Total = Math.round(((enero+febrero+marzo)*100.00)/100.0);
    }
        public void setGran_Total(double gran_total) {
        this.gran_Total = gran_total;
    }

    /**
     * @return the id
     */
    public String  getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
}
