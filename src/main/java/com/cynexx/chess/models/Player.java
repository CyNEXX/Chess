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
public interface Player {

    public long getPlayerElapsedTime();

    public void addPlayerElapsedTime(long longtime);

    public void resetTimer();

    public String getName();

    public void setName(String name);

    public Color getColor();

    public void setColor(Color color);

}
