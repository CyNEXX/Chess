/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cynexx.chess.models;

/**
 *
 * @author CyNEXX
 */
public class Coordonate {

    private final int x;
    private final int y;

    public Coordonate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object newCoordonate) {
        if (newCoordonate == null || !(newCoordonate instanceof Coordonate)) {
            return false;
        }
        if (newCoordonate == this) {
            return true;
        }

        return ((this.x == ((Coordonate) newCoordonate).getX()) && (this.y == ((Coordonate) newCoordonate).getY()));

    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf("" + (31 * this.getX()) + (31 * this.getY()));
    }
}
