package de.hsd.medien.se.hsdchess;

import com.github.lalyos.jfiglet.FigletFont;
import de.hsd.medien.se.hsdchess.domain.*;

public class HsdChess {
    public static void main(String[] args) {
        String willkommensText = "Welcome to HSD-Chess!";
        try {
            willkommensText = FigletFont.convertOneLine(willkommensText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(willkommensText);

        //Drei Figuren erzeugen

        Turm schwarzeTurm = new Turm(new Position('a', 8), Farbe.SCHWARZ);
        Turm weiseTurm = new Turm(new Position('h', 1), Farbe.WEISS);
        Pferd schwarzePferd = new Pferd(new Position('g', 8), Farbe.SCHWARZ);
        System.out.println("3 Figuren wurden instanziiert:");
        System.out.println("- " + schwarzeTurm);
        System.out.println("- " + weiseTurm);
        System.out.println("- " + schwarzePferd);


        schwarzePferd.zieheNach(new Position('h',6));
        weiseTurm.zieheNach(new Position('h',5));
        System.out.println("2 Figuren wurden an folgende Positionen bewegt:");
        System.out.println("Weisse Turm -> " + weiseTurm.getPosition());
        System.out.println("Schwarzer Pferd -> " + schwarzePferd.getPosition());


    }
}
