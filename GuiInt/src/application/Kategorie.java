package application;

public class Kategorie {
    private final String name;
    private final double wert;

    private Kategorie(String name, double wert) {
        this.name = name;
        this.wert = wert;
    }

    public String getName() {
        return name;
    }

    public double getWert() {
        return wert;
    }

    // Hier kannst du statische Instanzen für verschiedene Kategorien erstellen
    public static final Kategorie PARKETT = new Kategorie("Parkett", 100.0);
    public static final Kategorie LOGE = new Kategorie("Loge", 150.0);
    public static final Kategorie LOGE_MIT_SERVICE = new Kategorie("Loge mit Service", 200.0);
}
