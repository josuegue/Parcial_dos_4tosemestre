/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Mysql.ClassVendedorDB;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USUARIOTC
 */
public class Insertar_datosController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellido;
    @FXML
    private TextField txt_enero;
    @FXML
    private TextField txt_febrero;
    @FXML
    private TextField txt_marzo;
    @FXML
    private Button btn_insetar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Click_Insertar(ActionEvent event) {
        Controlador_Ventanas controlador = new Controlador_Ventanas();
        ClassVendedorDB vendedor = new ClassVendedorDB();
        if(controlador.verificar_String(txt_marzo.getText())&&
                controlador.verificar_String(txt_apellido.getText()) &&
                controlador.veririfar_double(txt_enero.getText())&& 
                controlador.veririfar_double(txt_febrero.getText())&&
                controlador.veririfar_double(txt_marzo.getText())){
            
            double enero=Double.parseDouble(txt_enero.getText());
            double febrero=Double.parseDouble(txt_febrero.getText());
            double marzo=Double.parseDouble(txt_marzo.getText());
            vendedor.insertar_informacion(txt_nombre.getText(), txt_apellido.getText(), enero, febrero, marzo);
            limpiar();
            controlador.alert_informacion("Informacion de datos", "Se han insertado datos, en base de tados");
            controlador.closeVentana(btn_insetar, event);
            
        }
        else{
            controlador.alert_error("Error", "Verificar si los parametros estan bien escritos."
                    + "\nNombre y apellido tienen que ir de tipo cadena de texto."
                    + "\nLos meses, deben de ser enteros o double");
        }
        

    }
    private void limpiar(){
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_febrero.setText("");
        txt_enero.setText("");
        txt_marzo.setText("");
    }
    
}
