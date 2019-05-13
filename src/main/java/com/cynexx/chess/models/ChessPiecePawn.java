/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CyNEXX
 */
public class ChessPiecePawn extends AbstractChessPiece {

    private final String pieceType = "Pawn";
    private final int value = 1;
    private String symbol;
    private AbstractChessPiece.ChessColor chessPieceColor;

    private final String pattern = "p";
    private final String mapView = "[p]";

    private final String whiteSymbol = "\u2659";
    private final String blackSymbol = "\u265F";
    private static int timesCreated = 0;
    private List<List<Integer[]>> allMovingPositions;
    private List<List<Integer[]>> allAttackingPositions;
    private List<Comparator<Integer[]>> comparatorRules = new ArrayList<>();
    private Map<List<Integer[]>, Comparator<Integer[]>> directionComparatorMap = new LinkedHashMap<>();

    private Comparator<Integer[]> positiveComparator = (array_one, array_two) -> {
        System.out.println("array_two[1]-Row: " + array_two[1] + " array_one[1]-Row: " + array_one[1]);
        return (array_two[1] - array_one[1]);
    };

    private Comparator<Integer[]> negativeComparator = (array_one, array_two) -> {
        return (-1) * (array_two[1] - array_one[1]);
    };

    public ChessPiecePawn(AbstractChessPiece.ChessColor chessPieceColor) {
        if (chessPieceColor == AbstractChessPiece.ChessColor.BLACK) {
            this.chessPieceColor = AbstractChessPiece.ChessColor.BLACK;
            symbol = blackSymbol;
            comparatorRules.add(negativeComparator);
        }
        if (chessPieceColor == AbstractChessPiece.ChessColor.WHITE) {
            symbol = whiteSymbol;
            this.chessPieceColor = AbstractChessPiece.ChessColor.WHITE;
            comparatorRules.add(positiveComparator);
        }
        timesCreated++;
    }

    @Override
    public Map<List<Integer[]>, Comparator<Integer[]>> getDirectionComparatorMap() {
        return this.directionComparatorMap;
    }

    @Override
    public List<Comparator<Integer[]>> getComparatorRules() {
        return this.comparatorRules;
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
    public List<List<Integer[]>> getAllMovingPositions(int currentColumn, int currentRow, int totalColumns, int totalRows) {
        allMovingPositions = new ArrayList<>();

        System.out.printf("Received table of %d columns, %d rows. Current coordonates are: columnIndex %d and rowIndex %d%n", totalColumns, totalRows, currentColumn, currentRow);
        if (chessPieceColor == AbstractChessPiece.ChessColor.BLACK) {
            List<Integer[]> direction_verticalNegative = new ArrayList<>();
            System.out.println("Black Chess Piece");
            if (currentRow < totalRows - 2) {
                direction_verticalNegative.add(new Integer[]{currentColumn, currentRow - 1});
            }
            if (currentRow < totalRows - 3) {
                if (!this.hasMoved()) {
                    System.out.println("Hasn't moved, so adding a slot");
                    direction_verticalNegative.add(new Integer[]{currentColumn, currentRow - 2});
                }
            }

            direction_verticalNegative.sort(negativeComparator);
            directionComparatorMap.put(direction_verticalNegative, negativeComparator);
            allMovingPositions.add(direction_verticalNegative);
        }
        if (chessPieceColor == AbstractChessPiece.ChessColor.WHITE) {
            List<Integer[]> direction_verticalPositive = new ArrayList<>();
            System.out.println("White Chess Piece");
            if (currentRow < totalRows - 2) {
                direction_verticalPositive.add(new Integer[]{currentColumn, currentRow + 1});
            }
            if (currentRow < totalRows - 3) {
                if (!this.hasMoved()) {
                    System.out.println("Hasn't moved, so adding a slot");
                    direction_verticalPositive.add(new Integer[]{currentColumn, currentRow + 2});
                }
            }
            direction_verticalPositive.sort(positiveComparator);
            directionComparatorMap.put(direction_verticalPositive, positiveComparator);
            allMovingPositions.add(direction_verticalPositive);
        }
        System.out.println("Calculated moving coordonates: ");

        return allMovingPositions;
    }

    @Override
    public List<List<Integer[]>> getAllAttackingPositions(int currentColumn, int currentRow, int totalColumns, int totalRows) {
        allAttackingPositions = new ArrayList<>();

        if (chessPieceColor == AbstractChessPiece.ChessColor.BLACK) {
            List<Integer[]> attackingCoordonates = new ArrayList<>();
            if (currentRow < totalRows - 2) {

                if ((currentColumn >= 0) && (currentColumn < totalColumns - 2)) {
                    attackingCoordonates.add(new Integer[]{currentColumn + 1, currentRow - 1});
                }
                if ((currentColumn > 0) && (currentColumn < totalColumns - 1)) {
                    attackingCoordonates.add(new Integer[]{currentColumn - 1, currentRow - 1});
                }
            }
            allAttackingPositions.add(attackingCoordonates);

        }

        if (chessPieceColor == AbstractChessPiece.ChessColor.WHITE) {
            List<Integer[]> attackingCoordonates = new ArrayList<>();
            if (currentRow < totalRows - 2) {

                if ((currentColumn >= 0) && (currentColumn < totalColumns - 2)) {
                    attackingCoordonates.add(new Integer[]{currentColumn + 1, currentRow + 1});
                }
                if ((currentColumn > 0) && (currentColumn < totalColumns - 1)) {
                    attackingCoordonates.add(new Integer[]{currentColumn - 1, currentRow + 1});
                }
            }
            allAttackingPositions.add(attackingCoordonates);

        }
        System.out.println("Calculated attacking coordonates: ");
        System.out.println(allAttackingPositions);
        return allAttackingPositions;
    }

}
