/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import javafx.scene.paint.Color;

/**
 *
 * @author CyNEXX
 */
public interface TableSlot {

    public Color getColor();

    public ChessPiece getChessPiece();

    public void setChessPiece(ChessPiece chessPiece);

    public boolean isFree();
    
    public void clearSlot();

}
