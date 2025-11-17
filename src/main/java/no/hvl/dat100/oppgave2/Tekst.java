package no.hvl.dat100.oppgave2;

import no.hvl.dat100.oppgave1.Innlegg;

public class Tekst extends Innlegg {

    private String tekst;

    public Tekst(int id, String bruker, String dato, String tekst) {
        super(id, bruker, dato);
        this.tekst = tekst;
    }

    public Tekst(int id, String bruker, String dato, int likes, String tekst) {
        super(id, bruker, dato, likes);
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String toString() {
        return "TEKST\n" +
                getId() + "\n" +
                getBruker() + "\n" +
                getDato() + "\n" +
                getLikes() + "\n" +
                tekst + "\n";
    }
}
