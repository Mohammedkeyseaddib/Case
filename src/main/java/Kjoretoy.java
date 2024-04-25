
// Dataklassen (Modell)

public class Kjoretoy {
    private String registreringsnummer;
    private String eier;

    private String merke;

    private String modell;


    public Kjoretoy(String registreringsnummer, String eier, String merke, String modell) {
        this.registreringsnummer = registreringsnummer;
        this.eier = eier;
        this.merke = merke;
        this.modell = modell;
    }

    public String getregistreringsnummer() {
        return registreringsnummer;
    }

    public void setReisterering(String reistereringsnummer) {
        this.registreringsnummer = reistereringsnummer;
    }

    public String getEier() {
        return eier;
    }

    public void setEier(String eier) {
        this.eier = eier;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }


}
