package application;

import java.util.ArrayList;
import java.util.List;

public class Kinosaal {
    private String name;
    private List<Reihe> sitzreihen;
    private boolean istFreigegeben;

    public Kinosaal(String name, boolean istFreigegeben) {
        this.name = name;
        this.sitzreihen = new ArrayList<>();
        this.istFreigegeben = istFreigegeben;
    }

    public void addReihe(Reihe reihe) {
        sitzreihen.add(reihe);
    }
    public String getName() {
        return this.name;
    }
    public List<Reihe> getSitzreihen() {
        return this.sitzreihen;
    }
    public String toString() {
        return this.name; // Der Name des Kinosaals wird angezeigt
    }
    public int getMaxSitzeProReihe() {
        int maxSitze = 0;
        for (Reihe reihe : sitzreihen) {
            if (reihe.getSitzplaetze().size() > maxSitze) {
                maxSitze = reihe.getSitzplaetze().size();
            }
        }
        return maxSitze;
    }


    // Additional methods like getters, setters, and other functionality
}
