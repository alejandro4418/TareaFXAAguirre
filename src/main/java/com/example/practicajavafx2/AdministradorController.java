package com.example.practicajavafx2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorController{

    //Labels
    @FXML
    private Label lblTituloAdmin;
    @FXML
    private Label lblProducto;
    @FXML
    private Label lblCategoria;
    @FXML
    private Label lblPrecio;
    @FXML
    private Label lblStock;

    //TextFields
    @FXML
    private TextField txtProducto;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtStock;



}