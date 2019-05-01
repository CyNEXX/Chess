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
public class ChessPiecePawn extends AbstractChessPiece {

    private final String pieceType = "Pawn";
    private final int value = 1;
    private String symbol;

    private final String pattern = "p";
    private final String mapView = "[p]";

    private final String whiteSymbol = "[" + "\u2659" + "]";
    private final String blackSymbol = "[" + "\u265F" + "]";

    public ChessPiecePawn(AbstractChessPiece.ChessColor chessPieceColor) {
        if (chessPieceColor == AbstractChessPiece.ChessColor.BLACK) {
            symbol = blackSymbol;
        }
        if (chessPieceColor == AbstractChessPiece.ChessColor.WHITE) {
            symbol = whiteSymbol;
        }
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

}
