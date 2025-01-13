package de.hsd.medien.se.hsdchess.domain;

import java.util.Arrays;

public class Turm extends Figur {

    public Turm(Position position, Farbe farbe) {
        super(position, farbe);
    }

    @Override
    public void zieheNach(Position neuePosition) {
        if (isValidMove(neuePosition)) {
            position = neuePosition;
        } else {
            throw new Regelverstoss("Ungültiger Zug");
        }
    }

    @Override
    protected void validateStartPos() {
        if (!isValidStartPos()) {
            throw new Regelverstoss("Ungültige Startposition");
        }
    }

    @Override
    protected boolean isValidStartPos() {
        char spalte = position.getSpalte();
        int zeile = position.getZeile();

        if (farbe == Farbe.WEISS) {
            return Arrays.asList('a', 'h').contains(spalte) && Arrays.asList(1, 8).contains(zeile);
        } else if (farbe == Farbe.SCHWARZ) {
            return Arrays.asList('a', 'h').contains(spalte) && Arrays.asList(1, 8).contains(zeile);
        } else {
            throw new Regelverstoss("Ungültige Farbe");
        }
    }

    @Override
    protected boolean isValidMove(Position neuePosition) {
        char startSpalte = position.getSpalte();
        int startZeile = position.getZeile();
        char zielSpalte = neuePosition.getSpalte();
        int zielZeile = neuePosition.getZeile();

        return startSpalte == zielSpalte || startZeile == zielZeile;
    }
}
