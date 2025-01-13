package de.hsd.medien.se.hsdchess.domain;

public class Position {
    private char spalte;
    private int zeile;

    public Position(char spalte, int zeile) {
        this.spalte = spalte;
        this.zeile = zeile;
    }

    public char getSpalte() {
        return spalte;
    }

    public int getZeile() {
        return zeile;
    }

    @Override
    public String toString() {
        return "" + spalte + zeile;
    }
}
