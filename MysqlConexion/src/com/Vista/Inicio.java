/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Vista;

import com.Controlador.Controlador_Ventanas;
import com.Controlador.InicioController;
import java.awt.Desktop.Action;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.awt.AppContext;


/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author USUARIOTC
 */
public class Inicio extends Application {
    private Controlador_Ventanas controlador = new Controlador_Ventanas();
    private Stage stagePrincipal;
    private Parent rootPane;
    
    private void ventanaPrincipal() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.Vista/Inicio.fxml"));
        rootPane=(Parent) loader.load();
        Scene scene = new Scene(rootPane);
        
        stagePrincipal.setScene(scene);
        stagePrincipal.setTitle("Inicio secion");
        stagePrincipal.show();
        
    }
        public void ventanaInicial( String nombre_archivo, String titulo) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(nombre_archivo));
        Pane mutlti_ventana=(Pane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle(titulo);
        ventana.initOwner(stagePrincipal);
        Scene scene = new Scene(mutlti_ventana);
        ventana.setScene(scene);
        ventana.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stagePrincipal=primaryStage;
        ventanaPrincipal();      
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
