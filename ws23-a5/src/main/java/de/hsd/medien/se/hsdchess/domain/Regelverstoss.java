package de.hsd.medien.se.hsdchess.domain;

public class Regelverstoss extends RuntimeException {
    public Regelverstoss(String message) {
        super(message);
    }
}
