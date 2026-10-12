# Lerntracker 1. Semester

**Autor:** Max Wittich  
**Beschreibung:** Konsolenbasierter Java-Lerntracker zur strukturierten Erfassung, Verwaltung und Auswertung von täglichen Studienzeiten.

## Funktionsumfang
* **Zeiterfassung:** Eingabe von gelernten Stunden und Minuten pro Fach.
* **Aggregierte Speicherung:** Interne Zusammenfassung der Lernzeiten in Minuten zur fehlerfreien Aufaddierung über eine `HashMap`.
* **Übersichtliche Ausgabe:** Automatische Konvertierung der Gesamtminuten in ein lesbares Stunden-Minuten-Format mittels Division und Modulo.

## Technische Umsetzung
* Programmiersprache: Java
* Datenstruktur: `HashMap<String, Integer>` für den schnellen Zugriff.
* Steuerung: Interaktive Konsolen-Schleife mit einer stabilen `switch-case`-Struktur.

## Verwendung
1. Das Projekt in eine IDE (z. B. IntelliJ IDEA) klonen oder importieren.
2. Die Klasse `Lerntracker.java` ausführen.
3. Den Anweisungen im Konsolenmenü folgen.