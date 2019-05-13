/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import javafx.scene.paint.Color;

/**
 *
 * @author CyNEXX
 */
public class TableClassic extends AbstractTable {

    private final static int NR_OF_ROWS = 8;
    private final static int NR_OF_COLUMNS = 8;
    private static List<String> mapView = new ArrayList<>();
    public static Table table;
    String tempString;

    private TableClassic() {
        super(NR_OF_ROWS, NR_OF_COLUMNS);
    }

    public static Table getTableInstance() {
        if (table == null) {
            table = new TableClassic();
        }
        return table;
    }

    @Override
    public Table getTable() {
        return getTableInstance();
    }

    @Override
    public void initializeBlankTable() {
      /*  System.out.println("Initializing a blank table with " + NR_OF_COLUMNS * NR_OF_ROWS + " coordonates...");
        boolean evenRow;
        for (int i = 1; i <= NR_OF_ROWS; i++) {
            Color slotColor = Color.BLACK;
            evenRow = i % 2 == 0;
            for (int k = 1; k <= NR_OF_COLUMNS; k++) {
                if (!evenRow && k % 2 != 0) {
                    slotColor = Color.BLACK;
                } else if (!evenRow && k % 2 == 0) {
                    slotColor = Color.WHITE;
                } else if (evenRow && k % 2 != 0) {
                    slotColor = Color.WHITE;
                } else if (evenRow && k % 2 == 0) {
                    slotColor = Color.BLACK;
                }
                Coordonate coordonate = new Coordonate(k, i);
                TableSlot tempSlot = new TableSlotClassic(slotColor);
                tempSlot.setChessPiece(new ChessPieceFake());
                this.putCoordonateAndTableSlot(coordonate, tempSlot);
            }
        }
        System.out.println("Done initializing table.");*/
    }

    @Override
    public void createPrintableTable() {
      /*  tempString = "";
        System.out.println("Creating table preivew...");
        getCoordonatesOfAllTableSlots().forEach(tableBuilder);
        System.out.println("Done creating printable preview.");
        quickPreview();*/
    }

    BiConsumer<Coordonate, TableSlot> tableBuilder = (c, t) -> {

        if (tempString.length() / 3 == NR_OF_COLUMNS - 1) {
            tempString = tempString.concat(t.getChessPiece().getMapView());
            mapView.add(tempString);
            tempString = "";
        } else {
            tempString = tempString.concat(t.getChessPiece().getMapView());
        }

    };

    @Override
    public void quickPreview() {
     /*   System.out.println("Printing table... " + mapView.size() + " rows.");
        for (int i = mapView.size() - 1; i >= 0; i--) {
            System.out.println(mapView.get(i));
        }*/
    }

}
