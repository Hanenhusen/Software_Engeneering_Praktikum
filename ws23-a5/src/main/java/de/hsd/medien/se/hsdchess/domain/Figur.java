package de.hsd.medien.se.hsdchess.domain;

public abstract class Figur {
    protected Position position;
    protected Farbe farbe;
    protected Status status;

    public Figur(Position position, Farbe farbe) {
        this.position = position;
        this.farbe = farbe;
        this.status = new Status();
        validateStartPos();
    }

    public Position aktuellePosition() {
        return position;
    }

    public abstract void zieheNach(Position neuePosition);

    public Status istImSpiel() {
        return status;
    }

    public void schlagen() {
        status.schlagen();
    }

    protected abstract void validateStartPos();

    protected abstract boolean isValidStartPos();

    protected abstract boolean isValidMove(Position neuePosition);

    public Farbe getFarbe() {
        return this.farbe;
    }

    public Position getPosition() {
        return this.position;
    }
}
