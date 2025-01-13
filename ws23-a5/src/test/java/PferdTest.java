import de.hsd.medien.se.hsdchess.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PferdTest {

    Position pPosition = new Position('g',1);
    Position f3 = new Position('f',3);
    Position b1 = new Position('b',1);
    Position g8 = new Position('g',8);


    @Test
    // Konstruktor testen
    public void testPferdAufGueltigeStartposition() throws Regelverstoss {
        Pferd pferd = new Pferd(b1, Farbe.WEISS);
        assertEquals(b1, pferd.getPosition());
        assertEquals(Farbe.WEISS, pferd.getFarbe());
        assertTrue(pferd.istImSpiel().getStatus());
    }

    @Test
    public void testRegelkonformerZugPferd() throws Regelverstoss {
        Pferd ziehePferd = new Pferd(pPosition, Farbe.WEISS);
        ziehePferd.zieheNach(f3);
        assertEquals(f3, ziehePferd.getPosition());
    }

    @Test
    public void testUngueltigerZugAusserhalbSpielfeldPferd() throws Regelverstoss {
        Pferd zieheFalschPferd = new Pferd(pPosition, Farbe.WEISS);
        assertThrows(Regelverstoss.class, () -> zieheFalschPferd.zieheNach(new Position('h',4)));
    }

    @Test
    public void testPferdSchlaegtFigur() throws Regelverstoss {
        Pferd pferd = new Pferd(b1, Farbe.WEISS);
        pferd.schlagen();
        assertFalse(pferd.istImSpiel().getStatus());
    }

    @Test
    public void testPferdMitUngueltigerFarbe() {
        assertThrows(Regelverstoss.class, () -> new Pferd(new Position('g',8), Farbe.WEISS));
    }

    @Test
    public void testeStertPosition(){
        Pferd pferd = new Pferd(g8, Farbe.SCHWARZ);
        assertEquals(g8, pferd.getPosition());
        assertEquals(Farbe.SCHWARZ, pferd.getFarbe());
        assertTrue(pferd.istImSpiel().getStatus());
    }
}


