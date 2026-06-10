package com.example.practicajavafx2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ResourceBundle;

public class EncuestaController implements Initializable {

    @FXML
    private ComboBox<String> cbxPRegunta1;

    @FXML
    private ComboBox<String> cbxPRegunta2;

    @FXML
    private ComboBox<String> cbxPRegunta3;

    @FXML
    private ComboBox<String> cbxPRegunta4;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnRegistrarRespuestas;

    // Variables para almacenar las respuestas correctas
    private final String RESPUESTA_CORRECTA_1 = "Raditz";
    private final String RESPUESTA_CORRECTA_2 = "Teletransportación Instantánea (Shunkan Idō)";
    private final String RESPUESTA_CORRECTA_3 = "7";
    private final String RESPUESTA_CORRECTA_4 = "Super Saiyajin (normal)";

    // Variables para el puntaje
    private int puntajeTotal = 0;
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;
    private final int VALOR_POR_RESPUESTA = 5;
    private final int TOTAL_PREGUNTAS = 4;
    private final int PUNTAJE_MAXIMO = TOTAL_PREGUNTAS * VALOR_POR_RESPUESTA; // 20 puntos

    private boolean encuestaRespondida = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Llenar las opciones para cada pregunta

        // Pregunta 1: Hermano de Goku
        cbxPRegunta1.getItems().addAll(
                "-- Selecciona una opcion --",
                "Vegeta",
                "Raditz",
                "Nappa",
                "Bardock"
        );
        cbxPRegunta1.getSelectionModel().selectFirst(); // Seleccionar el prompt por defecto

        // Pregunta 2: Técnica de teletransportación
        cbxPRegunta2.getItems().addAll(
                "-- Selecciona una opcion --",
                "Kamehameha",
                "Genkidama",
                "Teletransportación Instantánea (Shunkan Idō)",
                "Kaioken"
        );
        cbxPRegunta2.getSelectionModel().selectFirst();

        // Pregunta 3: Número de Esferas del Dragón
        cbxPRegunta3.getItems().addAll(
                "-- Selecciona una opcion --",
                "4",
                "5",
                "6",
                "7"
        );
        cbxPRegunta3.getSelectionModel().selectFirst();

        // Pregunta 4: Primera transformación Super Saiyajin
        cbxPRegunta4.getItems().addAll(
                "-- Selecciona una opcion --",
                "Super Saiyajin Dios",
                "Super Saiyajin 3",
                "Super Saiyajin (normal)",
                "Super Saiyajin 4"
        );
        cbxPRegunta4.getSelectionModel().selectFirst();
    }

    @FXML
    private void RegistrarRespuestas() {
        if (encuestaRespondida) {
            return;
        }
        // Reiniciar contadores
        puntajeTotal = 0;
        respuestasCorrectas = 0;
        respuestasIncorrectas = 0;

        // Validar que todas las preguntas estén respondidas
        if (hayPreguntasSinResponder()) {
            lblResultado.setText("Error. Por favor responde todas las preguntas antes de registrar.");
            return;
        }

        // Evaluar cada pregunta
        evaluarPregunta1();
        evaluarPregunta2();
        evaluarPregunta3();
        evaluarPregunta4();

        // Calcular puntaje total (ya se va sumando en cada evaluación)
        // Mostrar resultados
        mostrarResultados();
        //Bloquea la encuesta
        bloquearEncuesta();
    }

    private void bloquearEncuesta() {
        encuestaRespondida = true;

        cbxPRegunta1.setDisable(true);
        cbxPRegunta2.setDisable(true);
        cbxPRegunta3.setDisable(true);
        cbxPRegunta4.setDisable(true);

        btnRegistrarRespuestas.setDisable(true);
        btnRegistrarRespuestas.setText("Encuesta Completada");
    }

    private void evaluarPregunta1() {
        String respuesta = cbxPRegunta1.getValue();
        if (respuesta.equals(RESPUESTA_CORRECTA_1)) {
            respuestasCorrectas++;
            puntajeTotal += VALOR_POR_RESPUESTA;
        } else if (!respuesta.equals("-- Selecciona una opcion --")) {
            respuestasIncorrectas++;
        }
    }

    private void evaluarPregunta2() {
        String respuesta = cbxPRegunta2.getValue();
        if (respuesta.equals(RESPUESTA_CORRECTA_2)) {
            respuestasCorrectas++;
            puntajeTotal += VALOR_POR_RESPUESTA;
        } else if (!respuesta.equals("-- Selecciona una opcion --")) {
            respuestasIncorrectas++;
        }
    }

    private void evaluarPregunta3() {
        String respuesta = cbxPRegunta3.getValue();
        if (respuesta.equals(RESPUESTA_CORRECTA_3)) {
            respuestasCorrectas++;
            puntajeTotal += VALOR_POR_RESPUESTA;
        } else if (!respuesta.equals("-- Selecciona una opcion --")) {
            respuestasIncorrectas++;
        }
    }

    private void evaluarPregunta4() {
        String respuesta = cbxPRegunta4.getValue();
        if (respuesta.equals(RESPUESTA_CORRECTA_4)) {
            respuestasCorrectas++;
            puntajeTotal += VALOR_POR_RESPUESTA;
        } else if (!respuesta.equals("-- Selecciona una opcion --")) {
            respuestasIncorrectas++;
        }
    }

    private boolean hayPreguntasSinResponder() {
        String respuesta1 = cbxPRegunta1.getValue();
        String respuesta2 = cbxPRegunta2.getValue();
        String respuesta3 = cbxPRegunta3.getValue();
        String respuesta4 = cbxPRegunta4.getValue();

        return respuesta1 == null || respuesta1.equals("-- Selecciona una opcion --") ||
                respuesta2 == null || respuesta2.equals("-- Selecciona una opcion --") ||
                respuesta3 == null || respuesta3.equals("-- Selecciona una opcion --") ||
                respuesta4 == null || respuesta4.equals("-- Selecciona una opcion --");
    }

    private void mostrarResultados() {
        String mensaje = String.format("Nota %d/%d  |  Correctas %d  |  Incorrectas %d",
                puntajeTotal, PUNTAJE_MAXIMO, respuestasCorrectas, respuestasIncorrectas);

        lblResultado.setText(mensaje);
    }
}