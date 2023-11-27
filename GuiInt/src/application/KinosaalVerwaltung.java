package application;

import java.util.ArrayList;
import java.util.List;

public class KinosaalVerwaltung {
    private static List<Kinosaal> kinosaalListe = new ArrayList<>();

    public static void addKinosaal(Kinosaal kinosaal) {
        kinosaalListe.add(kinosaal);
    }

    public static Kinosaal getKinosaalByName(String name) {
        for (Kinosaal kinosaal : kinosaalListe) {
            if (kinosaal.getName().equals(name)) {
                return kinosaal;
            }
        }
        return null; // Kein Kinosaal mit diesem Namen gefunden
    }
    public static void updateOrAddKinosaal(Kinosaal kinosaal) {
        for (int i = 0; i < kinosaalListe.size(); i++) {
            if (kinosaalListe.get(i).getName().equals(kinosaal.getName())) {
                kinosaalListe.set(i, kinosaal);
                return;
            }
        }
        kinosaalListe.add(kinosaal);
    }
    public static List<Kinosaal> getKinosaalListe() {
        return kinosaalListe;
    }
    // Weitere Methoden nach Bedarf
}