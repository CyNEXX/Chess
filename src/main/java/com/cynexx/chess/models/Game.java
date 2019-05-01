/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.List;
import java.util.Map;

/**
 *
 * @author CyNEXX
 */
public interface Game {

    public void moveFromTo(Player player, Coordonate from, Coordonate to);

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
    
    public void setPlayerInventory();
    
    public void startGame();

}
