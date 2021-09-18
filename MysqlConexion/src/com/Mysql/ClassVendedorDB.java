/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Mysql;

import com.Dominio.ClassUsuario;
import com.Dominio.ClassVendedor;
import com.mysql.cj.protocol.Resultset;
import com.sun.media.sound.ModelOscillator;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import sun.security.rsa.RSACore;


/**
 *
 * @author USUARIOTC
 */
public class ClassVendedorDB {
    private static final String SQL_VEFICAR="SELECT  username, password from usuario where username=? and password=?;";
    private static final String SQL_SELECT="SELECT *FROM tb_vendedor";
    private static final String SQL_UPDATE ="UPDATE tb_vendedor set nombre=? where  id_vendedor=?";
    private static final String SQL_INSERTE="INSERT INTO tb_vendedor (nombre,apellido,enero,febrero,marzo,promedio,gran_total) value (?,?,?,?,?,?,?);";
    private static final String SQL_DELETE="DELETE FROM tb_vendedor where id_vendedor=?";
    
    public List<ClassVendedor> seleccion (){
        Connection cn=null;
        PreparedStatement stmt=null;
        ClassVendedor vendedor=null;
        ResultSet rs=null;
        List<ClassVendedor> array_alumno= new ArrayList<ClassVendedor>();
        
        try {
            cn = ClassConexion.conexion();
            if (cn!=null){
            stmt = cn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id=rs.getString("id_vendedor");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                double enero=rs.getDouble("enero");
                double febrero=rs.getDouble("febrero");
                double marzo=rs.getDouble("marzo");
                double promedio=rs.getDouble("promedio");
                double gran_total=rs.getDouble("gran_total");

    
                vendedor=new ClassVendedor();
                vendedor.setId(id);
                vendedor.setNombre(nombre);
                vendedor.setApellido(apellido);
                vendedor.setEnero(enero);
                vendedor.setFebrero(febrero);
                vendedor.setMarzo(marzo);
                vendedor.setPromedio(promedio);
                vendedor.setGran_Total(gran_total);

                 
                array_alumno.add(vendedor);
            }    
        } 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClassConexion.close(cn);
            ClassConexion.close(stmt);
            ClassConexion.close(rs);
        }
        return array_alumno;
    }
    //https://www.cablenaranja.com/como-insertar-datos-desde-una-aplicacion-java-hacia-mysql/
    public void insertar_informacion (String nom, String apelli, double ene, double feb, double mar){
        
        PreparedStatement sentencia = null;
        Connection cn = null;
        ClassVendedor vendedor= null;
//        ResultSet result=null;
        
        try {
            vendedor = new ClassVendedor();
            cn=ClassConexion.conexion();
            if (cn!=null){
            vendedor.setNombre(nom);
            vendedor.setApellido(apelli);
            vendedor.setEnero(ene);
            vendedor.setFebrero(feb);
            vendedor.setMarzo(mar);
            vendedor.setPromedio(ene, feb, mar);
            vendedor.setGran_Total(ene, feb, mar);
            sentencia=cn.prepareStatement(SQL_INSERTE);
          
            sentencia.setString(1, vendedor.getNombre());
            sentencia.setString(2, vendedor.getApellido());
            sentencia.setDouble(3, vendedor.getEnero());
            sentencia.setDouble(4, vendedor.getFebrero());
            sentencia.setDouble(5, vendedor.getMarzo());
            sentencia.setDouble(6, vendedor.getPromedio());
            sentencia.setDouble(7, vendedor.getGran_Total());
            sentencia.executeUpdate();
            System.out.println("Se han insertado datos ");                
            }
            else {
                System.out.println("Error al conectar a base de datos");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClassConexion.close(cn);
            ClassConexion.close(sentencia);
//            ClassConexion.close(result);
        }
        
    }
    
    public void actulaizar_informacion(int id, String nombre){
        PreparedStatement sentencia = null;
        Connection conect=null;
//        ClassVendedor vendedor = null;
        
        
        try {
            conect=ClassConexion.conexion();
            sentencia=conect.prepareStatement(SQL_UPDATE);
            sentencia.setString(1, nombre);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("Informacion actualzada");
            
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClassConexion.close(conect);
            ClassConexion.close(sentencia);
        }
        
    }
    
    public void eliminar_informacion(int id){
        PreparedStatement sentencia = null;
        Connection conection = null;
        try {
            conection=ClassConexion.conexion();
            sentencia=conection.prepareStatement(SQL_DELETE);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            System.out.println("Eliminacion realizada");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClassConexion.close(conection);
            ClassConexion.close(sentencia);
        }
    }
    public boolean buscar_Usuario(String nombre, String contrasena){
        PreparedStatement setencia= null;
        Connection conexion=null;
        ResultSet rs = null;
        boolean acceso=false;
        try {
            conexion=ClassConexion.conexion();
            setencia=conexion.prepareStatement(SQL_VEFICAR);
            setencia.setString(1, nombre);
            setencia.setString(2, contrasena);
            
            rs=setencia.executeQuery();
            
            while(rs.next()){
                acceso=true;
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClassConexion.close(conexion);
            ClassConexion.close(setencia);
            ClassConexion.close(rs);
        }
        return acceso;
        
    }
    

}
