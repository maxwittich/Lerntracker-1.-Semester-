import java.util.Scanner;
import java.util.HashMap;

/**
 * Projekt: Lerntracker 1. Semester
 * Dateipfad: src/Lerntracker.java
 * Autor: Max Wittich
 * Beschreibung: Ein konsolenbasierter Java-Lerntracker zur strukturierten
 *               Erfassung, Verwaltung und Auswertung von täglichen Studienzeiten.
 */
public class Lerntracker {

    /**
     * Startpunkt der Anwendung. Verwaltet die Konsolenschleife und die Datenstruktur.
     *
     * @param args Kommandozeilenargumente (werden hier nicht verwendet)
     */
    public static void main(String[] args) {
        // Speichert das Fach als Schlüssel und die kumulierte Gesamtzeit in Minuten als Wert
        Scanner scanner = new Scanner(System.in);

        // HashMap speichert das Fach als Schlüssel und die kumulierte Gesamtzeit in Minuten als Wert
        HashMap<String, Integer> lerndaten = new HashMap<>();

        // Vordefinierte Fächer mit einer Startzeit von 0 Minuten anlegen
        lerndaten.put("PSE", 0);
        lerndaten.put("LDS", 0);
        lerndaten.put("Technische Grundlagen der Informatik", 0);
        lerndaten.put("Einfuehrung in die Informatik", 0);

        // Endlosschleife zur Steuerung des Hauptmenüs
        while (true) {
            System.out.println("\n--- Navigation ---");
            System.out.println("1: Lernzeit hinzufuegen");
            System.out.println("2: Stand anzeigen");
            System.out.println("3: Beenden");
            System.out.println("Auswahl: ");

            int auswahl = scanner.nextInt();
            scanner.nextLine(); // Restlichen Zeilenumbruch im Puffer abfangen

            // Option 1: Lernzeit für ein bestimmtes Fach erfassen
            if (auswahl == 1) {
                System.out.println("Fach eingeben: ");
                String fach = scanner.nextLine();

                // Prüfen, ob das angegebene Fach in der HashMap existiert
                if (lerndaten.containsKey(fach)) {
                    System.out.println("Gelernte Stunden: ");
                    int stunden = scanner.nextInt();
                    System.out.println("Gelernte Minuten: ");
                    int minuten = scanner.nextInt();

                    // Eingabe in Gesamtminuten umrechnen
                    int neueMinuten = (stunden * 60) + minuten;
                    // Bisherigen Wert auslesen und neue Minuten aufaddieren
                    int gesamtMinuten = lerndaten.get(fach) + neueMinuten;
                    // Aktualisierten Wert in der HashMap speichern
                    lerndaten.put(fach, gesamtMinuten);

                    System.out.println("Zeit erfolgreich hinzugefuegt.");
                } else {
                    System.out.println("Fach nicht gefunden.");
                }

                // Option 2: Lernstand für alle Fächer ausgeben
            } else if (auswahl == 2) {
                System.out.println("\n--- Lernstand ---");
                // Iteration über alle Schlüssel (Fächer) in der HashMap
                for (String fach : lerndaten.keySet()) {
                    int gesamt = lerndaten.get(fach);
                    // Rückrechnung der Gesamtminuten in Stunden und Restminuten
                    int stunden = gesamt / 60;
                    int minuten = gesamt % 60;
                    System.out.println(fach + ": " + stunden + " Std. " + minuten + " Min. " );
                }

                // Option 3: Programmausführung abbrechen
            } else if (auswahl == 3) {
                System.out.println("Programm wird beendet.");
                break;
            } else {
                System.out.println("Ungueltige Eingabe.");
            }
        }
        // Scanner schließen, um Ressourcenlecks zu vermeiden
        scanner.close();
    }
}
