package com.example.projeto2;

import com.example.projeto2.Tablero.BoardMaker;
import com.example.projeto2.Tablero.BoardSettings;
import com.example.projeto2.Tablero.SimulationBoard;
import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static javafx.application.Application.launch;

public class HelloApplication /*extends Application*/ {

    private final TableView table = new TableView();

    //@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // launch();

        Gson gson = new Gson();

        try {
            InputStream inputStream = HelloApplication.class.getResourceAsStream("src/main/resources/settings.json");
            if (inputStream == null) {
                System.out.println("El archivo settings.json no se encontró.");
                return;
            }

            InputStreamReader reader = new InputStreamReader(inputStream);
            BoardSettings boardSettings = gson.fromJson(reader, BoardSettings.class);

            if (boardSettings == null) {
                System.out.println("No se pudo deserializar el archivo settings.json en la clase BoardSettings.");
                return;
            }

            BoardMaker boardMaker = new BoardMaker(boardSettings);
            if (boardMaker == null) {
                System.out.println("No se pudo inicializar BoardMaker.");
                return;
            }

            SimulationBoard simulationBoard = boardMaker.createWorld();
            if (simulationBoard == null) {
                System.out.println("No se pudo crear el mundo de la simulación.");
                return;
            }

            SimulationBoardStatistics simulationBoardStatistics = new SimulationBoardStatistics(simulationBoard);
            if (simulationBoardStatistics == null) {
                System.out.println("No se pudo inicializar SimulationBoardStatistics.");
                return;
            }

            simulationBoard.start();
            simulationBoardStatistics.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se produjo un error: " + e.getMessage());
        }

    }
}