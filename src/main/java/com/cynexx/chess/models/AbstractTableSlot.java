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
public abstract class AbstractTableSlot implements TableSlot {

    private final Color color;
    private ChessPiece chessPiece;

    public AbstractTableSlot(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public ChessPiece getChessPiece() {
        return this.chessPiece;
    }

    @Override
    public void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    @Override
    public boolean isFree() {
        return this.chessPiece == null;
    }

    @Override
    public void clearSlot() {
        this.chessPiece = null;
    }

    @Override
    public String toString() {
     /*   String status = "";
        if (this.isFree()) {
            status = "nothing";
        }*/
        return "SlotColor: " + this.getColor() + ". Contains: " + chessPiece.getPattern();
    }

}
