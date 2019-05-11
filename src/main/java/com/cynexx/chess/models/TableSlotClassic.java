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
public class TableSlotClassic extends AbstractTableSlot {

    public TableSlotClassic(Color color) {
        super(color);
        super.setChessPiece(new ChessPieceFake());
    }

    @Override
    public boolean hasFake() {
        return getChessPiece() instanceof ChessPieceFake;
    }
;

}
