/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Vista.Inicio;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author USUARIOTC
 */
public class Controlador_Ventanas {
    public boolean verificar_String(String cadena){
        boolean access;
        if(cadena!=null){
            access=true;    
        }
        else {
            access=false;
        }
        return access;
    }
    public boolean verifiar_int(String cadena){
        boolean access;
        if (cadena.matches("-?\\d+")&& cadena!=null){
            access=true;
    }
        else{
            access=false;
        }
        return access;
    }
    public boolean veririfar_double(String cadena){
        boolean access=false;
        try {
            if (cadena!=null){
                Double.parseDouble(cadena);
                access=true;  
            }

        } catch (Exception e) {
            access=false;
        }
        return access;
    }
    
    public void alert_informacion(String titulo, String mensaje){
        Alert inf = new Alert(Alert.AlertType.INFORMATION);
        inf.setHeaderText(null);
        inf.setTitle(titulo);
        inf.setContentText(mensaje);
        inf.showAndWait();
    }
    public void alert_error(String titulo, String mensaje){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle(titulo);
            error.setContentText(mensaje);
            error.showAndWait();
    }
    public void alert_warring(String titulo, String mensaje){
        Alert waring = new Alert(Alert.AlertType.WARNING);
        waring.setHeaderText(null);
        waring.setTitle(titulo);
        waring.setContentText(mensaje);
        waring.showAndWait();
    }
 // private void cerrarVentana(ActionEvent event) {
// 
//     Stage stage = (Stage) this.btnCierrame.getScene().getWindow();
//     stage.close();
// }
    public void closeVentana(Button boton, ActionEvent event){
        Stage stage = (Stage) boton.getScene().getWindow();
        stage.close();
        
    }
    
}
