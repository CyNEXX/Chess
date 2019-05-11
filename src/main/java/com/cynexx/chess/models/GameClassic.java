/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 *
 * @author CyNEXX
 */
public class GameClassic {

    /*private Table table;
    private final ObjectProperty<Player> currentPlayer = new SimpleObjectProperty<>();
    //private static List<Player> playerList = new ArrayList<>();
    //private static final String LOADING_PATTERN = "R:11-N:12-B:13-Q:14-K:15-B:16-N:17-R:18-P:11-P:12-P:13-P:14-P:15-P:16-P:17-P:18";
    private static final String ORIGINAL_PATTERN = "0r11-0n12-0b13-0q14-0k15-0b16-0n17-0r18-0p21-0p22-0p23-0p24-0p25-0p26-0p27-0p28-1p71-1p72-1p73-1p74-1p75-1p76-1p77-1p78-1r81-1n82-1b83-1q84-1k85-1b86-1n87-1r88";

    public GameClassic(Table table, List<Player> playerList) {
        super(table, playerList);
        this.table = table;
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer.get();
    }

    @Override
    public void setCurrentPlayer(Player player) {
        currentPlayer.set(player);
    }

    @Override
    public ObjectProperty<Player> currentPlayerProperty() {
        return currentPlayer;
    }

    public Table getTable() {
        return table;
    }

    public static void initializeFields() {

    }

    public static void startClassicLocal() {

    }

    @Override
    public void initializePlayersInventory() {

    }

    @Override
    public void startGame() {
        initializePlayersInventory();
        populateTable();
        table.createPrintableTable();
        setCurrentPlayer(getPlayerList().get(0));
    }

    @Override
    public void populateTable() {

        Pattern.compile("-").splitAsStream(ORIGINAL_PATTERN).peek(System.out::println).forEach((string) -> {
            ChessPiece cp = null;
            AbstractChessPiece.ChessColor pieceColorSymbol;

            int ownerIndex = Integer.valueOf(string.substring(0, 1));
            String piecePattern = string.substring(1, 2);
            Coordonate coordonate = new Coordonate(Integer.valueOf(string.substring(2, 3)), Integer.valueOf(string.substring(3, 4)));

            TableSlot ts = table.getCoordonatesOfAllTableSlots().get(coordonate);
            System.out.println("Before adding to slot, tableSlot: " + ts + " @coord " + coordonate);
            if (ownerIndex == 0) {
                pieceColorSymbol = AbstractChessPiece.ChessColor.WHITE;
            } else {
                pieceColorSymbol = AbstractChessPiece.ChessColor.BLACK;
            }

            switch (piecePattern) {
                case "r": {

                    cp = new ChessPieceRook(pieceColorSymbol);
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                case "q": {
                    cp = new ChessPieceQueen(pieceColorSymbol);
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                case "b": {
                    cp = new ChessPieceBishop(pieceColorSymbol);
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                case "n": {
                    cp = new ChessPieceKnight(pieceColorSymbol);
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                case "k": {
                    cp = new ChessPieceKing(pieceColorSymbol);
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                case "p": {
                    cp = new ChessPiecePawn(pieceColorSymbol);
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                case "o": {
                    cp = new ChessPieceFake();
                    ts.setChessPiece(cp);
                    System.out.println("Placed " + cp + "@ts " + ts + " @coord " + coordonate);
                    break;
                }
                default: {
                    System.out.println("Nothing");
                    break;
                }
            }
            getPlayerInventory().get(getPlayerList().get(ownerIndex)).add(cp);
        });
    }

    @Override
    public void movePiece(Player player, Coordonate fromCoordonate, Coordonate toCoordonate) {
        if (player.getName().equals(getCurrentPlayer().getName())) {
            ChessPiece selectedChessPiece = table.getCoordonatesOfAllTableSlots().get(fromCoordonate).getChessPiece();
            TableSlot selectedTableSlot = table.getCoordonatesOfAllTableSlots().get(fromCoordonate);
            TableSlot targetTableSlot = table.getCoordonatesOfAllTableSlots().get(toCoordonate);
            if (getPlayerInventory().get(player).contains(selectedChessPiece)) {
                List<Coordonate> possibleCoordonates = selectedChessPiece.getAllMoves(fromCoordonate, table);
                if (possibleCoordonates.contains(toCoordonate)) {
                    if (targetTableSlot.isFree() || targetTableSlot.hasFake()) {
                        targetTableSlot.setChessPiece(selectedChessPiece);
                        selectedTableSlot.clearSlot();
                        selectedTableSlot.setChessPiece(new ChessPieceFake());
                    }
                }
            }
        }
    }*/
}
