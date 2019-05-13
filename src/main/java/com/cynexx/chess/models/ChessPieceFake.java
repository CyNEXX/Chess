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
public class ChessPieceFake extends AbstractChessPiece {

    private final String pieceType = "fake";
    private final int value = 0;
    private final String symbol = " ";
    private final String pattern = "o";
    private final String mapView = " ";
    private static int timesCreated = 0;
    //private final String whiteSymbol = "[" + "\u2657" + "]";
    // private final String blackSymbol = "[" + "\u265D" + "]";

    public ChessPieceFake() {
        timesCreated++;
    }

    @Override
    public String getMapView() {
        return this.mapView;
    }

    @Override
    public List<Coordonate> getAllMoves(Coordonate currentCoordonates, Table table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
