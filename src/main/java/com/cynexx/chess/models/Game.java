/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.List;
import java.util.Map;
import javafx.beans.property.Property;

/**
 *
 * @author CyNEXX
 */
public interface Game {

    // public void moveFromTo(Player player, Coordonate from, Coordonate to);
    public void populateTable();

    public void saveTable();

    public Table loadTable(String path);

    public Player getCurrentPlayer();

    public void setCurrentPlayer(Player player);

    public void addToCalsualties(Player player, ChessPiece chessPiece);

    public void removeFromCalsualties(Player player, ChessPiece chessPiece);

    public Map<Player, List<ChessPiece>> getCasualties();

    public List<ChessPiece> getPlayerCasualties(Player player);

    public Player nextPlayer();

    public void addPlayer(Player player);

    public Map<Player, List<ChessPiece>> getPlayerInventory();

    public void initializePlayersInventory();

    public void addToPlayerInventory(Player player, ChessPiece chesspiece);

    public void startGame();

    public void movePiece(Player player, Coordonate fromCoordonate, Coordonate toCoordonate);
    
    public List<Player> getPlayerList();
    
    public Property<Player> currentPlayerProperty();

}
