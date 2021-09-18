/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Vista.Inicio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author USUARIOTC
 */
public class Menu_MysqlController implements Initializable {
    private static final Inicio MORE_WINDOW = new Inicio();

    @FXML
    private Button btn_insertar;
    @FXML
    private Button btn_consultar;
    @FXML
    private Button btn_actualizar;
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
    private void Click_insertar(ActionEvent event) throws IOException {
        MORE_WINDOW.ventanaInicial("/com.Vista/Insertar_datos.fxml","Insertar");
    }

    @FXML
    private void Click_Consultar(ActionEvent event) throws IOException {
        MORE_WINDOW.ventanaInicial("/com.Vista/Listar_Informacion.fxml","Consular");
    }

    @FXML
    private void Click_Actualizar(ActionEvent event) throws IOException {
        MORE_WINDOW.ventanaInicial("/com.Vista/Actualizar_datos.fxml","Actualizar");
    }

    @FXML
    private void Click_Eliminar(ActionEvent event) throws IOException {
        MORE_WINDOW.ventanaInicial("/com.Vista/Eliminar_datos.fxml","Eliminar");
    }
    
}
