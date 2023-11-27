package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Spinner;

public class Reihe {
    private Kategorie kategorie;
    private List<Sitzplatz> sitzplaetze;

    public Reihe(Kategorie kategorie) {
        this.kategorie = kategorie;
        this.sitzplaetze = new ArrayList<>();
    }

    public List<Sitzplatz> getSitzplaetze() {
        return this.sitzplaetze;
    }

    public Kategorie getKategorie() {
        return this.kategorie;
    }

    private transient Spinner<Integer> sitzplaetzeSpinner;

    // ... bestehende Konstruktoren und Methoden ...

    public void setSitzplaetzeSpinner(Spinner<Integer> spinner) {
        this.sitzplaetzeSpinner = spinner;
    }

    public Spinner<Integer> getSitzplaetzeSpinner() {
        return this.sitzplaetzeSpinner;
    }

    public void erstelleSitzplaetze() {
        int anzahlSitzplaetze = sitzplaetzeSpinner.getValue();
        for (int i = 0; i < anzahlSitzplaetze; i++) {
            sitzplaetze.add(new Sitzplatz(i + 1));
        }
    }
}
