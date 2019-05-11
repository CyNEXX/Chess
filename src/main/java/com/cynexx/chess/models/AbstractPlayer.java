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
public abstract class AbstractPlayer implements Player {

    private long elapsedTime = 0;
    private StringProperty name = new SimpleStringProperty();
    private Color color;

    public AbstractPlayer(String name, Color color) {
        this.name.set(name);
        this.color = color;
    }

    @Override
    public void addPlayerElapsedTime(long longtime) {
        elapsedTime += longtime;
    }

    @Override
    public String getPlayerName() {
        return this.name.get();
    }

    @Override
    public void setPlayerName(String name) {
        this.name.set(name);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public long getPlayerElapsedTime() {
        return this.elapsedTime;
    }

    @Override
    public void resetTimer() {
        this.elapsedTime = 0;
    }

    @Override
    public String toString() {
        return "Player name: " + this.name.get() + ". Player color: " + this.color;
    }

}
