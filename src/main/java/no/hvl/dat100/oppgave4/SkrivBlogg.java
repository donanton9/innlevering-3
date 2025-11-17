package no.hvl.dat100.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        boolean ok = false;

        File fil;
        if (mappe == null || mappe.equals("")) {
            fil = new File(filnavn);
        } else {
            fil = new File(mappe + "/" + filnavn);
        }

        try {
            PrintWriter pw = new PrintWriter(fil);
            pw.print(samling.toString());
            pw.close();
            ok = true;

        } catch (FileNotFoundException e) {
            ok = false;
        }

        return ok;
    }
}
