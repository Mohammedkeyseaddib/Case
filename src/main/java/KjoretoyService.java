public class KjoretoyService {
    private KjoretoyRepository kjoretoyRepository;    // Henter repository

    public KjoretoyService() {
        this.kjoretoyRepository = new KjoretoyRepository(); //  konstruktør for å gjøre handlinger fra repositoriet
    }

    public void opprettKjoretoy(String registreringsnummer, String merke, String modell, String eier) {
        Kjoretoy nyttKjoretoy = new Kjoretoy(registreringsnummer, merke, modell, eier);   // opprettte ny kjørtøy som vi kaller NyttKjøretøy
        kjoretoyRepository.lagreKjoretoy(nyttKjoretoy);
    }

    public Kjoretoy finnKjoretoy(String registreringsnummer) {
        return kjoretoyRepository.hentKjoretoy(registreringsnummer);
    }

    public void oppdaterKjoretoy(String registreringsnummer, String nyEier) {
        Kjoretoy kjoretoy = kjoretoyRepository.hentKjoretoy(registreringsnummer);
        if (kjoretoy != null) {
            kjoretoy.setEier(nyEier);
            kjoretoyRepository.oppdaterKjoretoy(kjoretoy);
        } else {
            System.out.println("Kjøretøy ikke funnet.");
        }
    }

    public void slettKjoretoy(String registreringsnummer) {
        kjoretoyRepository.slettKjoretoy(registreringsnummer);
    }
}


    /*
    public List<Kjoretoy> alleKjøretøy() {
        return (List<Kjoretoy>) kjoretoyRepository.alleKjoretoy();
    }


     */
