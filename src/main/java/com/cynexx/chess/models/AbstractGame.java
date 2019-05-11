/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CyNEXX
 */
public abstract class AbstractGame implements Game {

    private List<Player> playerList;
   // private Player currentPlayer;
    public Table table;
    private Map<Player, List<ChessPiece>> playerInventory;

    public AbstractGame(Table table, List<Player> playerList) {
        this.table = table.getTable();
        this.playerList = playerList;
        playerInventory = new LinkedHashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            playerInventory.put(playerList.get(i), new ArrayList<>());
        }
    }

    /* @Override
    public void moveFromTo(Player player, Coordonate from, Coordonate to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @Override
    public void saveTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Table loadTable(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void addToCalsualties(Player player, ChessPiece chessPiece) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFromCalsualties(Player player, ChessPiece chessPiece) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Player, List<ChessPiece>> getCasualties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChessPiece> getPlayerCasualties(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public Player nextPlayer() {
        int currentIndex = playerList.indexOf(currentPlayer);
        if (currentIndex < playerList.size() - 1) {
            return currentPlayer = playerList.get(currentIndex + 1);
        }
        return playerList.get(0);
    }*/

    /*@Override
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }*/

    @Override
    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    @Override
    public Map<Player, List<ChessPiece>> getPlayerInventory() {
        return this.playerInventory;
    }

    @Override
    public void addToPlayerInventory(Player player, ChessPiece chesspiece) {

    }

    @Override
    public List<Player> getPlayerList() {
        return this.playerList;
    }

}
