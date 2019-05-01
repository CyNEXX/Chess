/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.controllers;

import com.cynexx.chess.models.*;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author CyNEXX
 */
public class ClassicGameController implements Initializable {

    private Player player_one, player_two;
    List<Player> playerList;
    private Table table;
    private Game game;
    private ObservableMap<Coordonate, TableSlot> tableCoordonatesSlots;

    @FXML
    public URL url;
    @FXML
    public ResourceBundle rb;

    @FXML
    public Label label;

    @FXML
    public GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        playerList = new ArrayList<>();
        player_one = new PlayerLocal("Ion", Color.WHITE);
        player_two = new PlayerLocal("Vasile", Color.BLACK);
        playerList.add(player_one);
        playerList.add(player_two);
        table = TableClassic.getTableInstance();
        table.initializeBlankTable();
        System.out.println("Resource: " + rb + ". Location: " + url);
        game = new GameClassic(table, playerList);
        game.startGame();

        gridPane = new GridPane();

        BiConsumer<Coordonate, TableSlot> buttonPlacer = (coord, slot) -> {

            Button tempButton = new Button("" + (1 + (table.getNrOfSlotsY() - coord.getY())) + coord.getX());
            String buttonId = "slotbutton_" + (1 + (table.getNrOfSlotsY() - coord.getY())) + coord.getX();
            tempButton.getStyleClass().add("slotbuttons");
            tempButton.setOnAction((e) -> slotButtonClicked(e));
            gridPane.add(tempButton, coord.getX(), coord.getY());
            System.out.println("Added from coord - X: " + coord.getX() + " Y: " + coord.getY() + " button text" + tempButton.getText());
        };

        table.getCoordonatesOfAllTableSlots().forEach(buttonPlacer);

        com.cynexx.chess.MainApp.getStage().setScene(new Scene(gridPane));

    }

    public void createTableLayout() {

    }

    private void slotButtonClicked(ActionEvent e) {
        Button button = (Button) e.getSource();

        System.out.println(button + ".Text: " + button.getText());

    }
}
