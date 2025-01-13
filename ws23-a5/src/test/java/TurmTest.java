import de.hsd.medien.se.hsdchess.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurmTest {

    Position pPosition = new Position('h',1);

    Position f3 = new Position('h',8);
    Position b1 = new Position('a',8);

    @Test
    // Konstruktor testen
    public void testTurmAufGueltigeStartposition() throws Regelverstoss {
        Turm turm = new Turm(b1, Farbe.WEISS);
        assertEquals(b1, turm.getPosition());
        assertEquals(Farbe.WEISS, turm.getFarbe());
        assertTrue(turm.istImSpiel().getStatus());
    }

    @Test
    public void testRegelkonformerZugTurm() throws Regelverstoss {
        Turm zieheturm = new Turm(pPosition, Farbe.WEISS);
        zieheturm.zieheNach(f3);
        assertEquals(f3, zieheturm.getPosition());
    }

    @Test
    public void testUngueltigerZugAusserhalbSpielfeldTurm() throws Regelverstoss {
        Turm zieheFalschTurm = new Turm(pPosition, Farbe.WEISS);
        assertThrows(Regelverstoss.class, () -> zieheFalschTurm.zieheNach(new Position('g',4)));
    }

    @Test
    public void testTurmSchlaegtFigur() throws Regelverstoss {
        Turm turm = new Turm(b1, Farbe.WEISS);
        turm.schlagen();
        assertFalse(turm.istImSpiel().getStatus());
    }

    @Test
    public void testTurmMitUngueltigerFarbe() {
        assertThrows(Regelverstoss.class, () -> new Turm(new Position('g',8), Farbe.SCHWARZ));
    }
}
