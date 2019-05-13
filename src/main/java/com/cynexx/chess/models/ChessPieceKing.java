/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CyNEXX
 */
public class ChessPieceKing extends AbstractChessPiece {

    private final String pieceType = "KING";
    private final int value = 1000;
    private String symbol;
    private final String pattern = "k";
    private boolean inCheck;
    private boolean inCheckMate;
    private final String mapView = "[K]";
    List<Coordonate> allMoves = new ArrayList<>();
    List<TableSlot> allDestinationSlots = new ArrayList<>();
    private static int timesCreated = 0;

    private final String whiteSymbol = "\u2654";
    private final String blackSymbol = "\u265A";

    public ChessPieceKing(AbstractChessPiece.ChessColor chessPieceColor) {
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
    public boolean isInCheck() {
        return inCheck;
    }

    @Override
    public void setInCheck(boolean inCheck) {
        this.inCheck = inCheck;
    }

    @Override
    public boolean isInCheckMate() {
        return inCheckMate;
    }

    @Override
    public void setInCheckMate(boolean inCheckMate) {
        this.inCheckMate = inCheckMate;
    }

    @Override
    public void promote(ChessPiece chessPiece) {
    }

    @Override
    public List<Coordonate> getAllMoves(Coordonate currentCoordonates, Table table) {
        allMoves = new ArrayList<>();

        //can moveToSlot right (OX+)
        if (currentCoordonates.getX() >= 1 && currentCoordonates.getX() < table.getNrOfSlotsX() - 1) {
            allMoves.add(new Coordonate(currentCoordonates.getX() + 1, currentCoordonates.getY()));
        }

        //can moveToSlot left (OX-)
        if (currentCoordonates.getX() > 1 && currentCoordonates.getX() <= table.getNrOfSlotsX()) {
            allMoves.add(new Coordonate(currentCoordonates.getX() - 1, currentCoordonates.getY()));
        }

        //can moveToSlot up (OY+)
        if (currentCoordonates.getY() >= 1 && currentCoordonates.getY() < table.getNrOfSlotsY() - 1) {
            allMoves.add(new Coordonate(currentCoordonates.getX(), currentCoordonates.getY() + 1));
        }

        //can moveToSlot down (OY-)
        if (currentCoordonates.getY() > 1 && currentCoordonates.getY() <= table.getNrOfSlotsY()) {
            allMoves.add(new Coordonate(currentCoordonates.getX(), currentCoordonates.getY() - 1));
        }

        //diagonally NE (right & up)
        if ((currentCoordonates.getX() >= 1 && currentCoordonates.getX() < table.getNrOfSlotsX() - 1)
                && (currentCoordonates.getY() >= 1 && currentCoordonates.getY() < table.getNrOfSlotsY() - 1)) {
            allMoves.add(new Coordonate(currentCoordonates.getX() + 1, currentCoordonates.getY() + 1));
        }

        //diagonally SE (right & down)
        if ((currentCoordonates.getX() >= 1 && currentCoordonates.getX() < table.getNrOfSlotsX() - 1)
                && (currentCoordonates.getY() > 1 && currentCoordonates.getY() <= table.getNrOfSlotsY())) {
            allMoves.add(new Coordonate(currentCoordonates.getX() + 1, currentCoordonates.getY() - 1));
        }

        //diagonally NW (left & up)
        if ((currentCoordonates.getX() > 1 && currentCoordonates.getX() <= table.getNrOfSlotsX())
                && (currentCoordonates.getY() >= 1 && currentCoordonates.getY() < table.getNrOfSlotsY() - 1)) {
            allMoves.add(new Coordonate(currentCoordonates.getX() + 1, currentCoordonates.getY() + 1));
        }

        //diagonally SW (left & down)
        if ((currentCoordonates.getX() > 1 && currentCoordonates.getX() <= table.getNrOfSlotsX())
                && (currentCoordonates.getY() > 1 && currentCoordonates.getY() <= table.getNrOfSlotsY())) {
            allMoves.add(new Coordonate(currentCoordonates.getX() + 1, currentCoordonates.getY() + 1));
        }

        return allMoves;
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
