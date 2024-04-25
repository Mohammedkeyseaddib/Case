import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KjoretoyServiceTest {
    private KjoretoyService kjoretoyService;

    @BeforeEach
    public void setUp() {
        kjoretoyService = new KjoretoyService();
    }

    @Test
    public void lagreOgHenteKjoretoy() {
        // Arrange
        String registreringsnummer = "ABC123";
        String merke = "Toyota";
        String modell = "Nissan";
        String eier = "John Doe";

        // Act
        kjoretoyService.opprettKjoretoy(registreringsnummer, merke, modell, eier);  // Opprett kjøretøy
        Kjoretoy hentetKjoretoy = kjoretoyService.finnKjoretoy(registreringsnummer); // Hent kjøretøy

        // Assert
        assertNotNull(hentetKjoretoy);
        assertEquals(registreringsnummer, hentetKjoretoy.getregistreringsnummer());
        assertEquals(merke, hentetKjoretoy.getMerke());
        assertEquals(modell, hentetKjoretoy.getModell());
        assertEquals(eier, hentetKjoretoy.getEier());
    }


    @Test
    public void oppdatereKjoretoy() {
        // Arrange
        String registreringsnummer = "ABC123";
        String merke = "Toyota";
        String modell = "Corolla";
        String eier = "John Doe";
        kjoretoyService.opprettKjoretoy(registreringsnummer, merke, modell, eier);

        // Act
        String nyEier = "Jane Doe";
        kjoretoyService.oppdaterKjoretoy(registreringsnummer, nyEier);
        Kjoretoy oppdatertKjoretoy = kjoretoyService.finnKjoretoy(registreringsnummer);

        // Assert
        assertNotNull(oppdatertKjoretoy);
        assertEquals(nyEier, oppdatertKjoretoy.getEier());
    }

    @Test
    public void slettEksisterendeKjoretoy() {
        // Arrange
        String registreringsnummer = "ABC123";
        String merke = "Toyota";
        String modell = "Corolla";
        String eier = "John Doe";
        kjoretoyService.opprettKjoretoy(registreringsnummer, merke, modell, eier);

        // Act
        kjoretoyService.slettKjoretoy(registreringsnummer);
        Kjoretoy slettetKjoretoy = kjoretoyService.finnKjoretoy(registreringsnummer);

        // Assert
        assertNull(slettetKjoretoy);
    }

    @Test
    public void slettIkkeEksisterendeKjoretoy() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> kjoretoyService.slettKjoretoy("XYZ789"));
    }



    // Teste for å se noe bare
}

