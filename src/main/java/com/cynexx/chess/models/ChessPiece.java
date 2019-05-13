/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CyNEXX
 */
public interface ChessPiece {

    public String getPattern();

    public String getSymbol();

    public String getID();

    public void setID(String id);

    public String getPieceType();

    public String getMapView();

    public int getValue();

    public List<Coordonate> getAllMoves(Coordonate currentCoordonates, Table table);

    public void kill();

    public void promote(ChessPiece chessPiece);

    public boolean canJump();

    public boolean isAlive();

    public boolean isInCheck();

    public void setInCheck(boolean inCheck);

    public boolean isInCheckMate();

    public void setInCheckMate(boolean inCheckMate);

    public void resurrect();

    public int getTimesCreated();

    public boolean hasMoved();

    public int getTimesMoved();

    public List<List<Integer[]>> getAllMovingPositions(int currentColumn, int currentRow, int totalColumns, int totalRows);

    public List<List<Integer[]>> getAllAttackingPositions(int currentColumn, int currentRow, int totalColumns, int totalRows);

    public List<Comparator<Integer[]>> getComparatorRules();

    public Map<List<Integer[]>, Comparator<Integer[]>> getDirectionComparatorMap();

}
