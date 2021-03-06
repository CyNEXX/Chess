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
public class ChessPieceQueen extends AbstractChessPiece {

    private final String pieceType = "Queen";
    private final int value = 20;
    private String symbol;
    private final String pattern = "q";
    private final String mapView = "[q]";

    private final String whiteSymbol = "\u2655";
    private final String blackSymbol = "\u265B";
    private static int timesCreated = 0;

    public ChessPieceQueen(AbstractChessPiece.ChessColor chessPieceColor) {
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
    public int getTimesCreated() {
        return timesCreated;
    }

    @Override
    public List<List<Integer[]>> getAllMovingPositions(int currentRow, int currentColumn, int totalRows, int totalColumns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<Integer[]>> getAllAttackingPositions(int currentRow, int currentColumn, int totalRows, int totalColumns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
