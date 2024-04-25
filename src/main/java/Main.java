import java.util.Scanner;

public class Main {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static KjoretoyService kjoretoyService = new KjoretoyService();
    private static Scanner scanner = new Scanner(System.in); // Definere en global scanner

    public static void main(String[] args) {
        if (authenticate()) {
            boolean running = true; // loop for interaksjon

            while (running) {
                printMenu();
                int valg = readUserChoice();

                switch (valg) {
                    case 1:
                        leggTilKjoretoy();
                        break;
                    case 2:
                        finnKjoretoy();
                        break;
                    case 3:
                        oppdaterKjoretoy();
                        break;
                    case 4:
                        slettKjoretoy();
                        break;
                    case 0:
                        running = false; // Sett running til false for å avslutte løkken
                        System.out.println("Takk for at du brukte kjøretøyadministrasjonssystemet!");
                        break;
                    default:
                        System.out.println("Ugyldig valg. Prøv igjen.");
                }
                if (running) {
                    pauseBeforeContinuing();
                }
            }
            scanner.close(); // Lukk scanneren når programmet avsluttes
        } else {
            System.out.println("Feil brukernavn eller passord. Tilgang nektet.");
        }
    }

    private static boolean authenticate() {
        System.out.println("Velkommen til kjøretøyadministrasjonssystemet!");
        System.out.print("Skriv inn brukernavn: ");
        String username = scanner.nextLine();
        System.out.print("Skriv inn passord: ");
        String password = scanner.nextLine();
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    private static void printMenu() {
        System.out.println("\n Velkommen! Velg en handling:");
        System.out.println("1. Legg til kjøretøy");
        System.out.println("2. Finn kjøretøy");
        System.out.println("3. Oppdater kjøretøy");
        System.out.println("4. Slett kjøretøy");
        System.out.println("0. Avslutt");
        System.out.println("`\n Skriv valg her: ");
    }

    private static int readUserChoice() {  //
        System.out.print("Valg: ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // kast ikke-int input
            System.out.println("Vennligst skriv inn et gyldig tall for valg.");
        }
        int valg = scanner.nextInt();
        scanner.nextLine(); // Håndterer newline etter tallinntasting
        return valg;
    }

    private static void pauseBeforeContinuing() {
        System.out.println("Trykk på 'Enter' for å fortsette...");
        scanner.nextLine();
    }

    private static void leggTilKjoretoy() {
        System.out.println("Legg til kjøretøy:");
        System.out.print("Registreringsnummer: ");
        String registreringsnummer = scanner.nextLine().trim();
        if (registreringsnummer.isEmpty()) {
            System.out.println("Registreringsnummer kan ikke være tomt.");
            return;
        }
        System.out.print("Merke: ");
        String merke = scanner.nextLine().trim();
        if (merke.isEmpty()) {
            System.out.println("Merke kan ikke være tomt.");
            return;
        }
        System.out.print("Modell: ");
        String modell = scanner.nextLine().trim();
        if (modell.isEmpty()) {
            System.out.println("Modell kan ikke være tom.");
            return;
        }
        System.out.print("Eier: ");
        String eier = scanner.nextLine().trim();
        if (eier.isEmpty()) {
            System.out.println("Eier kan ikke være tom.");
            return;
        }

        kjoretoyService.opprettKjoretoy(registreringsnummer, merke, modell, eier);
        System.out.println("Kjøretøy lagt til!");
    }

    private static void finnKjoretoy() {
        System.out.println("Finn kjøretøy:");
        System.out.print("Skriv inn registreringsnummer: ");
        String registreringsnummer = scanner.nextLine().trim();
        if (registreringsnummer.isEmpty()) {
            System.out.println("Registreringsnummer kan ikke være tomt.");
            return;
        }

        Kjoretoy funnetKjoretoy = kjoretoyService.finnKjoretoy(registreringsnummer);
        if (funnetKjoretoy != null) {
            System.out.println("Kjøretøy funnet:");
            System.out.println("Registreringsnummer: " + funnetKjoretoy.getregistreringsnummer());
            System.out.println("Merke: " + funnetKjoretoy.getMerke());
            System.out.println("Modell: " + funnetKjoretoy.getModell());
            System.out.println("Eier: " + funnetKjoretoy.getEier());
        } else {
            System.out.println("Ingen kjøretøy funnet med registreringsnummeret " + registreringsnummer);
        }
    }

    private static void oppdaterKjoretoy() {
        System.out.println("Oppdater kjøretøy:");
        System.out.print("Skriv inn registreringsnummer: ");
        String registreringsnummer = scanner.nextLine().trim();
        if (registreringsnummer.isEmpty()) {
            System.out.println("Registreringsnummer kan ikke være tomt.");
            return;
        }

        Kjoretoy eksisterendeKjoretoy = kjoretoyService.finnKjoretoy(registreringsnummer);
        if (eksisterendeKjoretoy != null) {
            System.out.println("Oppgi ny informasjon:");
            System.out.print("Eier: ");
            String nyEier = scanner.nextLine().trim();
            if (nyEier.isEmpty()) {
                System.out.println("Ny eier kan ikke være tom.");
                return;
            }
            kjoretoyService.oppdaterKjoretoy(registreringsnummer, nyEier);
            System.out.println("Kjøretøy oppdatert!");
        } else {
            System.out.println("Ingen kjøretøy funnet med registreringsnummeret " + registreringsnummer);
        }
    }

    private static void slettKjoretoy() {
        System.out.println("Slett kjøretøy:");
        System.out.print("Skriv inn registreringsnummer: ");
        String registreringsnummer = scanner.nextLine().trim();
        if (registreringsnummer.isEmpty()) {
            System.out.println("Registreringsnummer kan ikke være tomt.");
            return;
        }

        kjoretoyService.slettKjoretoy(registreringsnummer);
        System.out.println("Kjøretøy slettet!");
    }
}
