/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 *
 * @author CyNEXX
 */
public class PlayerLocal extends AbstractPlayer {

    private final StringProperty playerName = new SimpleStringProperty();
    private Color color;

    public PlayerLocal(String name, Color color) {
        super(name, color);
    }

    @Override
    public String getPlayerName() {
        return this.playerName.get();
    }

    @Override
    public void setPlayerName(String inName) {
        super.setPlayerName(inName);
        this.playerName.set(inName);
    }

    @Override
    public StringProperty nameProperty() {
        return playerName;
    }

}
