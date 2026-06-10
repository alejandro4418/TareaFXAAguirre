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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private final String usuarioAdmin = "admin";
    private final String claveAdmin = "1234";

    private final String usuarioCajero = "cajero";
    private final String claveCajero = "1234";


    // Labels
    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblContrasena;

    @FXML
    private Label lblValidacion;

    // TextFields
    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContrasena;

    //Combo Box

    @FXML
    private ComboBox<String> cbxRol;

    //Llenar el ComboBox
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cbxRol.getItems().add("Administrador");
        cbxRol.getItems().add("Cajero");
    }


    @FXML
    public void validarCredenciales() {

        String usuarioIngresado = txtUsuario.getText().trim();
        String claveIngresada = txtContrasena.getText().trim();
        String rolIngresado = cbxRol.getValue();

        if(usuarioIngresado.isEmpty() || claveIngresada.isEmpty() || rolIngresado == null){
            lblValidacion.setText("No debes dejar campos vacios");
            return;
        }

        if (usuarioIngresado.equals(usuarioAdmin)
                && claveIngresada.equals(claveAdmin) && rolIngresado.equals("Administrador")) {

            lblValidacion.setText("ACCESO CONCEDIDO COMO ADMINISTRADOR");
            try {
                cambiarVentana("administrador.fxml", "Administrador");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (usuarioIngresado.equals(usuarioCajero)
                && claveIngresada.equals(claveCajero) && rolIngresado.equals("Cajero")) {

            lblValidacion.setText("ACCESO CORRECTO COMO CAJERO!");
            try {
                cambiarVentana("cajero.fxml", "Cajero");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            lblValidacion.setText("ACCESO INVALIDO!");
            mostrarAlertaError();
        }
    }

    @FXML
    private void cambiarVentana(String archivoFXML, String titulo) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(archivoFXML));
            Parent root = loader.load();

            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void mostrarAlertaError() {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Error de Acceso");
        alerta.setHeaderText("ACCESO INVALIDO");
        alerta.setContentText("Usuario o Contraseña inválidos\nIntente nuevamente");
        alerta.showAndWait();
    }

    @FXML
    public void salirDelPrograma(){
        System.exit(0);
    }
}