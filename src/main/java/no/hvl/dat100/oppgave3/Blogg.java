package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

    private Innlegg[] innleggtabell;
    private int neste;

    public Blogg() {
        innleggtabell = new Innlegg[20];
        neste = 0;
    }

    public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
        neste = 0;
    }

    public int getAntall() {
        return neste;
    }

    public Innlegg[] getSamling() {
        return innleggtabell;
    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < neste; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
    }

    public boolean ledigPlass() {
        return neste < innleggtabell.length;
    }

    public boolean leggTil(Innlegg innlegg) {
        if (!finnes(innlegg) && ledigPlass()) {
            innleggtabell[neste] = innlegg;
            neste++;
            return true;
        }
        return false;
    }

    public String toString() {
        String s = neste + "\n";
        for (int i = 0; i < neste; i++) {
            s += innleggtabell[i].toString();
        }
        return s;
    }

    public void utvid() {
        Innlegg[] ny = new Innlegg[innleggtabell.length * 2];
        for (int i = 0; i < neste; i++) {
            ny[i] = innleggtabell[i];
        }
        innleggtabell = ny;
    }

    public boolean leggTilUtvid(Innlegg innlegg) {
        if (!finnes(innlegg)) {
            if (!ledigPlass()) {
                utvid();
            }
            innleggtabell[neste] = innlegg;
            neste++;
            return true;
        }
        return false;
    }

    public boolean slett(Innlegg innlegg) {
        int pos = finnInnlegg(innlegg);
        if (pos == -1) {
            return false;
        }

        for (int i = pos; i < neste - 1; i++) {
            innleggtabell[i] = innleggtabell[i + 1];
        }

        innleggtabell[neste - 1] = null;
        neste--;
        return true;
    }

    public int[] search(String keyword) {
        int teller = 0;

        for (int i = 0; i < neste; i++) {
            if (innleggtabell[i].toString().toLowerCase().contains(keyword.toLowerCase())) {
                teller++;
            }
        }

        int[] ids = new int[teller];
        int j = 0;

        for (int i = 0; i < neste; i++) {
            if (innleggtabell[i].toString().toLowerCase().contains(keyword.toLowerCase())) {
                ids[j] = innleggtabell[i].getId();
                j++;
            }
        }

        return ids;
    }
}
