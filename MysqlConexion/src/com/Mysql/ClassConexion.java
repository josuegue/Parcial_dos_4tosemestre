/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIOTC
 */
public class ClassConexion {
    private final static String URL_MYSQL= "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String USER_MYSQL="root";
    private final static String PASSWORD_MYSQL="12345678";
    
    public static Connection conexion () throws SQLException{
        return DriverManager.getConnection(URL_MYSQL,USER_MYSQL,PASSWORD_MYSQL);
    }
    
    public static void close (ResultSet resul){
        try {
            resul.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void close (PreparedStatement st){
        try {
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void close (Connection cn){
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
//    public void conectar(){
//        try {
//            Connection conexion = DriverManager.getConnection(URL_MYSQL,USER_MYSQL,PASSWORD_MYSQL);
//            if (conexion!=null){
//            java.sql.Statement st = conexion.createStatement();
//            String query ="SELECT *FROM dt_vendedores;";
//            ResultSet resultado = st.executeQuery(query);
//            while (resultado.next()){
//                System.out.println("Id = "+resultado.getInt("id_vendedor")
//                + "  Nombres : "+resultado.getString("nombres_vendedor")
//                + "  Apellidos : "+resultado.getString("apellidos_vendedor"));
//            }
//                
//            }
//
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
}
