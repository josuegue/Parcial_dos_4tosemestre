/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Dominio.ClassUsuario;
import com.Mysql.ClassVendedorDB;
import com.Vista.Inicio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USUARIOTC
 */
public class InicioController implements Initializable {

    @FXML
    private TextField txtfl_username;
    @FXML
    private Button btn_IniciosSecion;
    @FXML
    private PasswordField txt_pass;
    
    private int permiso=0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
//ventana_Principal("/com.Vista/Menu_Mysql.fxml","Menu principal ");
    @FXML
    private void Click_InicioSecion(ActionEvent event) throws IOException {
        permiso++;
        ClassVendedorDB vendedor = new ClassVendedorDB();
        Controlador_Ventanas controlador = new Controlador_Ventanas();
        if(permiso<3){
                      

            if(vendedor.buscar_Usuario(txtfl_username.getText(), txt_pass.getText())){
                Inicio invocar = new Inicio();
                invocar.ventanaInicial("/com.Vista/Menu_Mysql.fxml","Menu mysql");
                controlador.closeVentana(btn_IniciosSecion, event);
                limpiar();
        }
            else {

                controlador.alert_error("Error", "No se encuentra ese usuario con esas especificaciones");
            }

        }
        else{
            controlador.alert_error("Error", "Has intentado ingresar erroneamente 3 veces.");
            controlador.closeVentana(btn_IniciosSecion, event);
        }

        
        //mando la informacion a pantalla
        

        
    }
    private void limpiar(){
        txtfl_username.setText("");
        txt_pass.setText("");
    }
 
}
