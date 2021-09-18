/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controlador;

import com.Dominio.ClassVendedor;
import com.Mysql.ClassVendedorDB;
import java.net.IDN;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USUARIOTC
 */
public class Listar_informacionController implements Initializable {

    @FXML
    private TableView<ClassVendedor> tb_datos;
    @FXML
    private TableColumn <ClassVendedor, String> col_id;
    @FXML
    private TableColumn <ClassVendedor, String> col_nombre;
    @FXML
    private TableColumn <ClassVendedor, String> col_apellido;
    @FXML
    private TableColumn <ClassVendedor, String> col_enero;
    @FXML
    private TableColumn <ClassVendedor, String> col_febrero;
    @FXML
    private TableColumn <ClassVendedor, String> col_marzo;
    @FXML
    private TableColumn <ClassVendedor, String> col_promedio;
    @FXML
    private TableColumn <ClassVendedor, String> col_total;
    
    private ObservableList <ClassVendedor> vendedor;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar();
        
        // TODO
    }    
    public void listar(){
                ClassVendedorDB vendedorDB = new ClassVendedorDB();
                List <ClassVendedor> vendedores = vendedorDB.seleccion();
                tabla();             
                for (ClassVendedor vnd: vendedores){
                    tb_datos.getItems().addAll(vnd);
                }
        
    }
    private TableView tabla(){
       col_id.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("id"));
       col_nombre.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("nombre"));
       col_apellido.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("apellido"));
       col_enero.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("enero"));
       col_febrero.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("febrero"));
       col_marzo.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("marzo"));
       col_promedio.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("promedio"));
       col_total.setCellValueFactory(new PropertyValueFactory<ClassVendedor, String>("gran_Total")); 
//       tb_datos.getColumns().addAll(col_id,col_nombre,col_apellido,col_enero,col_febrero,col_marzo,col_promedio,col_total);
       return tb_datos;
    }
    
}
