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
public class ChessPieceKnight extends AbstractChessPiece {

    private final String pieceType = "Knight";
    private final int value = 2;
    private String symbol;
    private final String pattern = "n";
    private final boolean jump = true;
    private final String mapView = "[n]";

    private final String whiteSymbol = "\u2658";
    private final String blackSymbol = "\u265E";
    private static int timesCreated = 0;

    public ChessPieceKnight(AbstractChessPiece.ChessColor chessPieceColor) {
        if (chessPieceColor == AbstractChessPiece.ChessColor.BLACK) {
            symbol = blackSymbol;
        }
        if (chessPieceColor == AbstractChessPiece.ChessColor.WHITE) {
            symbol = whiteSymbol;
        }
        timesCreated++;
    }

    @Override
    public String getMapView() {
        return this.mapView;
    }

    @Override
    public void resurrect() {
        super.resurrect();
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getPieceType() {
        return this.pieceType;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public List<Coordonate> getAllMoves(Coordonate currentCoordonates, Table table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canJump() {
        return this.jump;
    }

    @Override
    public int getTimesCreated() {
        return timesCreated;
    }

}
