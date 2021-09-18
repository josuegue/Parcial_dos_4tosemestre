/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Mysql.ClassVendedorDB;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USUARIOTC
 */
public class Eliminar_datosController implements Initializable {

    @FXML
    private TextField txt_id;
    @FXML
    private Button btn_eliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Click_Eliminar(ActionEvent event) {
        Controlador_Ventanas controlador = new Controlador_Ventanas();
        if(txt_id.getText().matches("-?\\d+")){
            
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Confirmacion");
            confirmacion.setContentText("¿Deseas eliminar al vendedor?");
            Optional<ButtonType> opcion= confirmacion.showAndWait();
            if(opcion.get()==ButtonType.OK){

                ClassVendedorDB vendedor = new ClassVendedorDB();
                int id = Integer.parseInt(txt_id.getText());
                vendedor.eliminar_informacion(id);
                txt_id.setText("");
                controlador.alert_informacion("Informacion", "¡Se ha eliminado el vendedor!");
                controlador.closeVentana(btn_eliminar, event);
            }
            
            else{
                controlador.alert_informacion("Informacion", "Has cancelado la eliminacion");
                controlador.closeVentana(btn_eliminar, event);
                txt_id.setText("");
            }   

        }
        else {
            controlador.alert_error("Error", "Parametro en id, no es un entero");

        }

    }
    
}
