/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import java.util.List;
import java.util.Map;

/**
 *
 * @author CyNEXX
 */
public interface Table {

    public int getNrOfSlotsX();

    public int getNrOfSlotsY();

    public Table getTable();

    public Map<TableSlot, Coordonate> getAllTableSlotCoordonates();

    public Map<Coordonate, TableSlot> getCoordonatesOfAllTableSlots();

    public void putCoordonateAndTableSlot(Coordonate coordonate, TableSlot tableslot);
    
    public void initializeBlankTable();
    
    public void createPrintableTable();
    
    public void quickPreview();
}
