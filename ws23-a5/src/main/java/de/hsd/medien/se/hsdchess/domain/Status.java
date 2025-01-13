package de.hsd.medien.se.hsdchess.domain;

public class Status {
    
    boolean nochAmLeben;

    public Status() {
        this.nochAmLeben = true;
    }

    public boolean getStatus() {
        return this.nochAmLeben;
    }

    public void schlagen() {
        this.nochAmLeben = false;
    }


}