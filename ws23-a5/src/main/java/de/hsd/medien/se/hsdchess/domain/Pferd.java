package de.hsd.medien.se.hsdchess.domain;

import java.util.Arrays;

public class Pferd extends Figur {

    public Pferd(Position position, Farbe farbe) throws Regelverstoss {
        super(position, farbe);
        validateStartPos();
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
            String[] gueltigeStartpositionenWeiss = {"g1", "b1"};
            return Arrays.asList(gueltigeStartpositionenWeiss).contains(position.toString());
        } else if (farbe == Farbe.SCHWARZ) {
            String[] gueltigeStartpositionenSchwarz = {"g8", "b8"};
            return Arrays.asList(gueltigeStartpositionenSchwarz).contains(position.toString());
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

        int spaltenDiff = Math.abs(startSpalte - zielSpalte);
        int zeilenDiff = Math.abs(startZeile - zielZeile);
        // Ein Pferd kann sich in L-Form bewegen: zwei Schritte in einer
        // Richtung und ein Schritt in der anderen Richtung.
        boolean vertikaleMove = (spaltenDiff == 1 && zeilenDiff == 2);
        boolean horizontaleMove = (spaltenDiff == 2 && zeilenDiff == 1);
        return vertikaleMove || horizontaleMove;

        //zwei methoden und dann hier zusammen fügen , besser zu verstehen und ist nicht komplexer
    }
}
