/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.List;

/**
 *
 * @author CyNEXX
 */
public abstract class AbstractChessPiece implements ChessPiece {

    public enum ChessColor {
        BLACK, WHITE
    }

    private boolean alive = true;
    private boolean jump;
    private String pieceType;
    private String symbol;
    private String pattern;
    private int value;
    private String ID;

    private boolean inCheck;
    private boolean inCheckMate;

    public AbstractChessPiece() {
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String getPieceType() {
        return this.pieceType;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public boolean canJump() {
        return this.jump;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void kill() {
        this.alive = false;
    }

    @Override
    public void resurrect() {
        this.alive = true;
    }

    @Override
    public void promote(ChessPiece chessPiece) {
    }

    @Override
    public String toString() {
        return "Name: " + getPieceType() + ". canJump? " + this.canJump() + ". isAlive? " + this.isAlive() + ". score: " + this.getValue();
    }

    @Override
    public boolean isInCheck() {
        return false;
    }

    @Override
    public void setInCheck(boolean inCheck) {

    }

    @Override
    public boolean isInCheckMate() {
        return false;
    }

    @Override
    public void setInCheckMate(boolean inCheckMate) {

    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public void setID(String id) {
        this.ID = id;
    }

    @Override
    public boolean equals(Object comparingChessPiece) {
        if (comparingChessPiece == null || !(comparingChessPiece instanceof ChessPiece)) {
            return false;
        }
        if (comparingChessPiece == this) {
            return true;
        }

        return (((ChessPiece) comparingChessPiece).getID().equals(this.getID()));

    }

    @Override
    public int hashCode() {
        return this.getID().hashCode();
    }

}
