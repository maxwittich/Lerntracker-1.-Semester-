import java.util.Scanner;
import java.util.HashMap;

public class Lerntracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> lerndaten = new HashMap<>();
        lerndaten.put("PSE", 0);
        lerndaten.put("LDS", 0);
        lerndaten.put("Technische Grundlagen der Informatik", 0);
        lerndaten.put("Einfuehrung in die Informatik", 0);

        while (true) {
            System.out.println("\n--- Navigation ---");
            System.out.println("1: Lernzeit hinzufuegen");
            System.out.println("2: Stand anzeigen");
            System.out.println("3: Beenden");
            System.out.println("Auswahl: ");

            int auswahl = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch anfragen

            if (auswahl == 1) {
                System.out.println("Fach eingeben: ");
                String fach = scanner.nextLine();

                if (lerndaten.containsKey(fach)) {
                    System.out.println("Stunden: ");
                    int stunden = scanner.nextInt();
                    System.out.println("Minuten: ");
                    int minuten = scanner.nextInt();

                    int neueMinuten = (stunden * 60) + minuten;
                    int gesamtMinuten = lerndaten.get(fach) + neueMinuten;
                    lerndaten.put(fach, gesamtMinuten);

                    System.out.println("Zeit erfolgreich hinzugefuegt.");
                } else {
                    System.out.println("Fach nicht gefunden.");
                }

            } else if (auswahl == 2) {
                System.out.println("\n--- Lernstand ---");
                for (String fach : lerndaten.keySet()) {
                    int gesamt = lerndaten.get(fach);
                    int stunden = gesamt / 60;
                    int minuten = gesamt % 60;
                    System.out.println(fach + ": " + stunden + " Std. " + minuten + " Min. " );
                }

            } else if (auswahl == 3) {
                System.out.println("Programm wird beendet.");
                break;
            } else {
                System.out.println("Ungueltige Eingabe.");
            }
        }
        scanner.close();
    }
}
