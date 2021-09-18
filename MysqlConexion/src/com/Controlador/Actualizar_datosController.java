/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Dominio.ClassVendedor;
import com.Mysql.ClassVendedorDB;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USUARIOTC
 */
public class Actualizar_datosController implements Initializable {

    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_nombre;
    @FXML
    private Button btn_actualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Click_Actualizar(ActionEvent event) {
        Controlador_Ventanas controlador = new Controlador_Ventanas();
        ClassVendedorDB vendedor = new ClassVendedorDB();
        if (txt_id.getText().matches("-?\\d+")&&txt_nombre.getText()!=null){
           
        int id=Integer.parseInt(txt_id.getText());
        
        vendedor.actulaizar_informacion(id, txt_nombre.getText());
        cadena_vacia();

        controlador.alert_informacion("Actualizacion", "Se ha realizado la actualizacion de datos");
        controlador.closeVentana(btn_actualizar, event);
        
        }
        else{
            controlador.alert_error("Error", "Ingreso de paramentros erroneo, ¡Verifiquelos!");

        }

    }
    private void cadena_vacia(){
        txt_id.setText("");
        txt_nombre.setText("");
    }
    
}
