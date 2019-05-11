package com.cynexx.chess.controllers;

import com.cynexx.chess.MainApp;
import com.cynexx.chess.models.*;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.util.stream.Stream;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

    private Player player_one, player_two;
    List<Player> playerList;
    private Table table;
    private Game game;
    private ObservableMap<Coordonate, TableSlot> tableCoordonatesSlots;
    Parent root;

    @FXML
    private URL url;
    @FXML
    private ResourceBundle rb;

    @FXML
    private VBox vMainbox;

    @FXML
    private Label label;

    @FXML
    private GridPane gpane;

    @FXML
    private void handleStartNewGameClassic(ActionEvent event) throws IOException {

        //    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClassicGame.fxml"));
        Parent classicGame = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ClassicGame.fxml"));
        //     Scene scene = new Scene(classicGame);
        com.cynexx.chess.MainApp.getStage().setScene(new Scene(classicGame, 800, 700));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    public void createTableLayout() {

        /*   BiConsumer<Coordonate, TableSlot> buttonPlacer = (coord, slot) -> {
            Button tempButton = new Button("" + (table.getNrOfSlotsY() - coord.getY()) + coord.getX());
            String buttonId = "slotbutton" + (table.getNrOfSlotsY() - coord.getY()) + coord.getX();
            tempButton.getStyleClass().add("slotbuttons");
            gpane.add(tempButton, coord.getX(), table.getNrOfSlotsY() - coord.getY());
        };
        
        gpane = new GridPane();
        table.getCoordonatesOfAllTableSlots().forEach(buttonPlacer);
         */
    }

}
