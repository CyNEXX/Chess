/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author CyNEXX
 */
public abstract class AbstractTable implements Table {

    private final int nrOfRows;
    private final int nrOfColumns;
    public Map<TableSlot, Coordonate> allTableSlotCoordonates = new LinkedHashMap<>();

    public Map<Coordonate, TableSlot> coordonatesOfAllTableSlots;

    public AbstractTable(int nrOfRows, int nrOfColumns) {
        this.nrOfRows = nrOfRows;
        this.nrOfColumns = nrOfColumns;
        coordonatesOfAllTableSlots = new LinkedHashMap<>();
    }

    @Override
    public int getNrOfSlotsX() {
        return this.nrOfColumns;
    }

    @Override
    public int getNrOfSlotsY() {
        return this.nrOfRows;
    }

    @Override
    public Map<TableSlot, Coordonate> getAllTableSlotCoordonates() {
        return (LinkedHashMap<TableSlot, Coordonate>) this.allTableSlotCoordonates;
    }

    @Override
    public Map<Coordonate, TableSlot> getCoordonatesOfAllTableSlots() {
        return this.coordonatesOfAllTableSlots;
    }

    @Override
    public void putCoordonateAndTableSlot(Coordonate coordonate, TableSlot tableslot) {
        System.out.println("Added @" + coordonate + ". tableSlot: " + tableslot);
        coordonatesOfAllTableSlots.put(coordonate, tableslot);
    }
;

}
