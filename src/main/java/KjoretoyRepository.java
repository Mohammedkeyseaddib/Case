import java.util.HashMap;
import java.util.Map;

public class KjoretoyRepository {   // Datalaget her som utfører crud operasjoner som service klassen trenger senere for å implementere logikken
    private Map< String, Kjoretoy> database = new HashMap<>();  // Lager en hashmap som en database for å lagre all kjøretøyene


    // Create - Legge til et nytt kjoretoy i databasen
    public void lagreKjoretoy(Kjoretoy kjoretoy) {
        database.put(kjoretoy.getregistreringsnummer(), kjoretoy);
    }



    // Read - Hent et kjøretøy med registeringsnummer
    public Kjoretoy hentKjoretoy(String registeringsnummer){ // metode for å hente regstereringsnummer;
        return database.get(registeringsnummer);
    }



    // Update - Oppdatere informajsonen til et eksisterende kjøretøy

    public void oppdaterKjoretoy(Kjoretoy kjoretoy){
        if (database.containsKey(kjoretoy.getregistreringsnummer())){
            database.put(kjoretoy.getregistreringsnummer(), kjoretoy);
        } else {
            throw new IllegalArgumentException("Kjoretoy med registeringsnummer" + kjoretoy.getregistreringsnummer() + " Finnes ikke");
        }
    }



    // Delete - Slette et kjøretøy fra databasen
    public void slettKjoretoy(String registereringsnummer) {
        if (database.containsKey(registereringsnummer)){
            database.remove(registereringsnummer);
        } else {
            throw new IllegalArgumentException("Kjoretoy med ");
        }
    }



    // Vise alle kjørtøy i databasen   (Valgfritt for å vise til at alle datene som er registert i hashmapen, men er ikke så lurt for å gi tilgang til de andre klassene vi de kan manioulere datene direkte )

    public Map<String, Kjoretoy> alleKjoretoy() {
        return new HashMap<>(database);
    }

}
