/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.controllers;

import com.cynexx.chess.models.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.util.stream.Stream;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CyNEXX
 */
public class ClassicGameController extends AbstractGame implements Initializable {
    
    private Player player_one, player_two;
    private static List<Player> playerList = new ArrayList<>();
    private final static int NR_OF_COLUMNS = 8;
    private final static int NR_OF_ROWS = 8;
    private static Table mainTable = TableClassic.getTableInstance();
    private Game game;
    
    private ObjectProperty<Player> currentPlayer = new SimpleObjectProperty<>();
    private final String ORIGINAL_PATTERN = "1ra8-1nb8-1bc8-1qd8-1ke8-1bf8-1ng8-1rh8-1pa7-1pb7-1pc7-1pd7-1pe7-1pf7-1pg7-1ph7-0pa2-0pb2-0pc2-0pd2-0pe2-0pf2-0pg2-0ph2-0ra1-0nb1-0bc1-0qd1-0ke1-0bf1-0ng1-0rh1";
    
    private final ObservableMap<Player, List<ChessPiece>> playerInventory = new SimpleMapProperty<>();
    
    private final Map<Player, List<ChessPiece>> inventory = new LinkedHashMap<>();
    private static final Map<Integer, Integer> adaptedToViewRowTable = new LinkedHashMap<>();
    private static final Map<String, Integer> adaptedToViewColumnTable = new LinkedHashMap<>();
    private static final Map<Integer, Integer> viewToClassicRowTable = new LinkedHashMap<>();
    private static final Map<Integer, String> viewToClassicColumnTable = new LinkedHashMap<>();
    private static final Map<String, ChessPiece> nameToChessPieceTable = new HashMap<>();
    
    private final StringProperty slotStyleProperty = new SimpleStringProperty();
    private static ObjectProperty<ChessPiece> currentChessPiece;
    
    private final static StringProperty currentChessPieceText = new SimpleStringProperty();
    
    public ClassicGameController() {
        
        super(mainTable, playerList);
        
        adaptedToViewRowTable.put(1, 7);
        adaptedToViewRowTable.put(2, 6);
        adaptedToViewRowTable.put(3, 5);
        adaptedToViewRowTable.put(4, 4);
        adaptedToViewRowTable.put(5, 3);
        adaptedToViewRowTable.put(6, 2);
        adaptedToViewRowTable.put(7, 1);
        adaptedToViewRowTable.put(8, 0);
        
        adaptedToViewColumnTable.put("a", 0);
        adaptedToViewColumnTable.put("b", 1);
        adaptedToViewColumnTable.put("c", 2);
        adaptedToViewColumnTable.put("d", 3);
        adaptedToViewColumnTable.put("e", 4);
        adaptedToViewColumnTable.put("f", 5);
        adaptedToViewColumnTable.put("g", 6);
        adaptedToViewColumnTable.put("h", 7);
        
        BiConsumer<Integer, Integer> viewToClassicRowTableConsumer = (classicValue, viewValue) -> {
            viewToClassicRowTable.put(viewValue, classicValue);
        };
        
        BiConsumer<String, Integer> viewToClassicColumnTableConsumer = (classicValue, viewValue) -> {
            viewToClassicColumnTable.put(viewValue, classicValue);
        };
        
        adaptedToViewRowTable.forEach(viewToClassicRowTableConsumer);
        adaptedToViewColumnTable.forEach(viewToClassicColumnTableConsumer);
        
        player_one = new PlayerLocal("Ion", Color.WHITE);
        player_two = new PlayerLocal("Vasile", Color.BLACK);
        player_one.setPlayerName("Ion");
        player_two.setPlayerName("Vasile");
        playerList.add(player_one);
        playerList.add(player_two);
        
        mainTable.initializeBlankTable();
        
    }
    
    public Map<Player, List<ChessPiece>> getInventory() {
        return this.inventory;
    }
    
    @FXML
    public URL url;
    
    @FXML
    public ResourceBundle rb;
    
    @FXML
    private ToggleGroup toggleGroup;
    
    @FXML
    public ToggleButton selectedButton;
    
    @FXML
    public Label playerLabel;
    
    @FXML
    public VBox mainVBox;
    
    @FXML
    public VBox tablePane;
    
    @FXML
    public VBox playerPane;
    
    @FXML
    public GridPane tableGrid;
    
    @FXML
    public Button currentButton;
    
    @FXML
    public HBox selectPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedButton = new ToggleButton();
        
        tableGrid = new GridPane();
        currentChessPiece = new SimpleObjectProperty<>();
        boolean evenRow;
        toggleGroup = new ToggleGroup();
        String slotclasscolor;
        for (int i = 0; i < NR_OF_ROWS; i++) {
            Color slotColor = Color.BLACK;
            slotclasscolor = "slotblack";
            evenRow = i % 2 == 0;
            for (int k = 0; k < NR_OF_COLUMNS; k++) {
                if (!evenRow && k % 2 != 0) {
                    slotColor = Color.BLACK;
                    slotclasscolor = "slotblack";
                } else if (!evenRow && k % 2 == 0) {
                    slotColor = Color.WHITE;
                    slotclasscolor = "slotwhite";
                } else if (evenRow && k % 2 != 0) {
                    slotColor = Color.WHITE;
                    slotclasscolor = "slotwhite";
                } else if (evenRow && k % 2 == 0) {
                    slotColor = Color.BLACK;
                    slotclasscolor = "slotblack";
                }
                HBox tempHBox = new HBox();
                tempHBox.setId("slot_" + getClassicColumnValue(i) + getClassicRowValue(k));
                tempHBox.getStyleClass().add(slotclasscolor);
                tempHBox.getStyleClass().add("tableslot");
                tableGrid.add(tempHBox, k, i);
            }
            currentButton.textProperty().bind(currentChessPieceText);
        }
        
        setCurrentPlayer(playerList.get(0));
        
        startGame();
        
        playerLabel.textProperty().bind(getCurrentPlayer().nameProperty());
        
        tableGrid.setId("maingrid");
        tableGrid.getStyleClass().add("maingridclass");
        tablePane.getChildren().add(tableGrid);
    }
    
    private Integer getClassicRowValue(Integer viewRowValue) {
        return viewToClassicRowTable.get(viewRowValue);
    }
    
    private String getClassicColumnValue(Integer viewColumnValue) {
        return viewToClassicColumnTable.get(viewColumnValue);
    }
    
    public void createTableLayout() {
        
    }
    
    @FXML
    public String getSlotStyle() {
        return slotStyleProperty.get();
    }
    
    @FXML
    public void setSlotStyle(String slotStyle) {
        slotStyleProperty.set(slotStyle);
    }
    
    @FXML
    public StringProperty slotStyleProperty() {
        return slotStyleProperty;
    }
    
    @FXML
    public String getCurrentChessPieceText() {
        return currentChessPieceText.get();
    }
    
    @FXML
    public StringProperty currentChessPieceTextProperty() {
        return currentChessPieceText;
    }
    
    public void setCurrentChessPieceText(String selectedChessPieceText) {
        currentChessPieceText.set(selectedChessPieceText);
    }
    
    @FXML
    public ObjectProperty<ChessPiece> currentChessPieceProperty() {
        return currentChessPiece;
    }
    
    @FXML
    public ChessPiece currentChessPiece() {
        return currentChessPiece.get();
    }
    
    public void setCurrentChessPiece(ChessPiece selectedChessPiece) {
        currentChessPiece.set(selectedChessPiece);
    }
    
    public Table getTable() {
        return mainTable;
    }
    
    @Override
    public void initializePlayersInventory() {
        getPlayerList().forEach((Player p) -> {
            inventory.put(p, new ArrayList<>());
        });
    }
    
    @Override
    public void startGame() {
        initializePlayersInventory();
        populateTable();
        mainTable.createPrintableTable();
        
    }
    
    @Override
    public void populateTable() {
        
        Pattern.compile("-").splitAsStream(ORIGINAL_PATTERN).forEach((string) -> {
            ChessPiece cp = null;
            AbstractChessPiece.ChessColor pieceColorSymbol;
            int ownerIndex = Integer.valueOf(string.substring(0, 1));
            String piecePattern = string.substring(1, 2);
            int columnFromPattern = adaptedToViewColumnTable.get(string.substring(2, 3));
            int rowFromPattern = adaptedToViewRowTable.get(Integer.valueOf(string.substring(3, 4)));
            
            if (ownerIndex == 0) {
                pieceColorSymbol = AbstractChessPiece.ChessColor.WHITE;
            } else {
                pieceColorSymbol = AbstractChessPiece.ChessColor.BLACK;
            }
            
            switch (piecePattern) {
                case "r": {
                    cp = new ChessPieceRook(pieceColorSymbol);
                    System.out.println("Created " + cp);
                    break;
                }
                case "q": {
                    cp = new ChessPieceQueen(pieceColorSymbol);
                    System.out.println("Created " + cp);
                    break;
                }
                case "b": {
                    cp = new ChessPieceBishop(pieceColorSymbol);
                    System.out.println("Created " + cp);
                    break;
                }
                case "n": {
                    cp = new ChessPieceKnight(pieceColorSymbol);
                    System.out.println("Created " + cp);
                    break;
                }
                case "k": {
                    cp = new ChessPieceKing(pieceColorSymbol);
                    System.out.println("Created " + cp);
                    break;
                }
                case "p": {
                    cp = new ChessPiecePawn(pieceColorSymbol);
                    System.out.println("Created " + cp);
                    break;
                }
                default: {
                    cp = new ChessPieceFake();
                    System.out.println("Created Nothing");
                    break;
                }
            }
            
            ToggleButton tempButton = new ToggleButton(cp.getSymbol());
            System.out.println("Got string from cp: " + toHex(cp.getSymbol()));
            String tempChessPieceID = ownerIndex + piecePattern + "_" + cp.getTimesCreated();
            cp.setID(tempChessPieceID);
            tempButton.setId(tempChessPieceID);
            tempButton.getStyleClass().add("slotbuttons");
            tempButton.getStyleClass().add("owner_" + ownerIndex);
            toggleGroup.getToggles().add(tempButton);
            
            nameToChessPieceTable.put(tempChessPieceID, cp);
            if (!(cp instanceof ChessPieceFake)) {
                (getInventory().get(getPlayerList().get(ownerIndex))).add(cp);
            }
            
            ((HBox) getNodeFromGridPane(tableGrid, columnFromPattern, rowFromPattern)).getChildren().add(tempButton);
        });
        
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                if ((oldValue != null) && (newValue == null)) {
                    System.out.println("No chess piece selected");
                    currentChessPiece.setValue(null);
                    currentChessPieceText.set(null);
                    tableGrid.getChildren().forEach((node) -> {
                        ((HBox) node).getStyleClass().remove("hoverableslot");
                    });
                    
                }
                if (newValue != null) {
                    if (oldValue == null) {
                        tableGrid.getChildren().forEach((node) -> {
                            ((HBox) node).getStyleClass().add("hoverableslot");
                        });
                    }
                    ToggleButton selectedToggleButton = (ToggleButton) newValue;
                    ToggleButton previousToggleButton = (ToggleButton) oldValue;
                    currentChessPiece.setValue(nameToChessPieceTable.get(selectedToggleButton.getId()));
                    System.out.println("Button selected: " + selectedToggleButton.getId() + ". CP: " + nameToChessPieceTable.get(selectedToggleButton.getId()));
                    System.out.println("Style classes before removing: " + selectPane.getStyleClass().size());
                    
                    selectPane.getStyleClass().clear();
                    System.out.println("No of style classes after removal " + selectPane.getStyleClass().size());
                    System.out.println("Style classes after removal " + selectPane.getStyleClass());
                    
                    System.out.println("selectedToggleButton style: " + selectedToggleButton.getParent().getStyleClass());
                    
                    selectPane.getStyleClass().addAll(selectedToggleButton.getParent().getStyleClass());
                    System.out.println("Adding class...: " + selectedToggleButton.getParent().getStyleClass()
                            + ". Actual class is: " + selectPane.getStyleClass());
                    
                    currentChessPieceText.set(selectedToggleButton.getText());
                    
                    System.out.println("display slot class: " + selectPane.getStyleClass());
                    System.out.println("currentChessPiece text: " + currentChessPiece.getValue());
                    
                    
                }
                
            }
        });
    }
    
    public String toHex(String arg) {
        String response = "";
        try {
            return String.format("%x", new BigInteger(1, arg.getBytes("UTF-16")));
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            return response;
        }
    }
    
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    
    @Override
    public void movePiece(Player player, Coordonate fromCoordonate, Coordonate toCoordonate) {
        if (player.getPlayerName().equals(getCurrentPlayer().getPlayerName())) {
            ChessPiece selectedChessPiece = mainTable.getCoordonatesOfAllTableSlots().get(fromCoordonate).getChessPiece();
            TableSlot selectedTableSlot = mainTable.getCoordonatesOfAllTableSlots().get(fromCoordonate);
            TableSlot targetTableSlot = mainTable.getCoordonatesOfAllTableSlots().get(toCoordonate);
            if (getPlayerInventory().get(player).contains(selectedChessPiece)) {
                List<Coordonate> possibleCoordonates = selectedChessPiece.getAllMoves(fromCoordonate, mainTable);
                if (possibleCoordonates.contains(toCoordonate)) {
                    if (targetTableSlot.isFree() || targetTableSlot.hasFake()) {
                        targetTableSlot.setChessPiece(selectedChessPiece);
                        selectedTableSlot.clearSlot();
                        selectedTableSlot.setChessPiece(new ChessPieceFake());
                    }
                }
            }
        }
    }
    
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer.getValue();
    }
    
    @Override
    public void setCurrentPlayer(Player player) {
        currentPlayer.setValue(player);
    }
    
    @Override
    public ObjectProperty<Player> currentPlayerProperty() {
        return currentPlayer;
    }
    
    @Override
    public Player nextPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
