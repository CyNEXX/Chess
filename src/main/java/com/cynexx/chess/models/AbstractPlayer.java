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
public abstract class AbstractPlayer implements Player {

    private long elapsedTime = 0;
    private String name;
    private Color color;

    public AbstractPlayer(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public void addPlayerElapsedTime(long longtime) {
        elapsedTime += longtime;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
        return "Player name: " + this.name + ". Player color: " + this.color;
    }

}
