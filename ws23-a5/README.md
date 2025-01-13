## Projekt-Team
- Mein Name ist Hanen Husen, ich studiere Medieninformatik an der Hochschule Düsseldorf. Der Studiengang ist sehr vielseitig, sodass es die Möglichkeit gibt in verschiedenen Branchen zu arbeiten und in vielen Bereichen das erlente einzusetzen. [Hier ist ein Link zu meinem Studiengang.](https://medien.hs-duesseldorf.de/studium/studiengaenge/bmi/Seiten/uebersicht.aspx)Meine Hobbies sind Lesen, Kochen und baken.
![ALT](Bild) *Mein Lieblingssüßigkeit*

Name: Sawsan Alghabra

Motivation für das Studium BMI: Gutes Arbeit,interesante Studiengang

Hobbies: schwimmen,lesen

## Name ** Salah Aldin Alhaji** 
** Motivation Große Interesse an Medien**
 

## Software Engineering
1. warum Software Engineering nicht gleich Programmierung ist: Software Engineering ist das Prozess eine Software zu entwicklen, Programmierung ist ein Teil dieses Prozesses.
2. wieso Software Engineering wichtig ist: Es ist wichtig für die Qualität einer Software, was die Anforderungen entspricht, also sorgt für eine erfolgreiche Software.
3. worum es beim Software Engineering geht, d.h. was die Disziplin Software Engineering umfasst: Anforderungsanalyse, Kostenkontrolle, Dokumentation, Implementierung ,Testen.
4. wieso die Produktionskosten (nicht die Entwicklungskosten) für Software vergleichsweise gering sind
Dies liegt daran, dass es keine Materialkosten gibt und die Kosten für die Vervielfältigung und Verteilung von Software sehr gering sind.

5. und wieso Software vergleichsweise schwer modellierbar ist
Software ist vergleichsweise schwer modellierbar, weil sie sehr komplex sein kann. Es gibt viele verschiedene Arten von Software und jede hat ihre eigenen Anforderungen und Einschränkungen. Es kann schwierig sein, alle diese Faktoren in einem Modell zu berücksichtigen.

## 01 - Anforderungserfassung 
1. Anforderungen in Gitlab als Issues erfassen: 
Für jede Anforderung ist eine eigenes Issue mit eindeutiger Beschreibung zu erstellen. Ein Repository für die isssues templates erzeugen indem eine .md datei für die Beschreibung der issues.
2. Anforderungen von anderen Issues schnell unterscheiden und filtern:
Durch Labels werden die unterschiedlichen Arten von Issues gekennzeichnet und mit der Spezifizierung von meilestones.
3. Anforderungen nach einem einheitlichen Schema erfasst werden: 
eindeutiges Titel,klare Beschreibung, Labels, meilensteine.
4. verschiedene Arten von Anforderungen schnell unterscheiden und filtern:
Mit der Verwendung von Label-Kategorien, z.B: Feature, bug, verbessung. oder auch durch Priorität und Status der Anforderung. Durch diese Kriterien sind die Issues beim Suchen auch schnell zu finden.

# 03- Erfassung von Anforderungen als User Stories
## 5 Funktionale Anforderungen

1-Der Spieler kann auswählen das spiel entweder mit den Computer oder einen anderen Person zu starten.

2-Das Spieler hat die möglichkeit den Spiel mit oder ohne Timer zu spielen und den Timer benutzer defniert setzen zu können z.B der Spieler hat 30sec zu spielen.

3-Spiel zu pauseren und nächstes mal vorzusetzen.

4-Gültige Züge anzeigen: Als Spieler möchte ich die gültigen Züge für eine ausgewählte Schachfigur in einer bestimmten Position sehen, um meine Spielstrategie zu planen.

5-Spielende erkennen : Als Spieler möchte ich, dass die Anwendung das Spielende erkennt und das Spiel gemäß den Schachregeln beendet.

## 5 NFRs

1-Hsd-Schach sollte sicher sein und die Daten von Benutzer schützen zu können.

2-Auf unterschidliche Geräte nutzen zu können (Tablet,laptop,Handy)

3-Unterstüzt Zwei Sprachen Deutch English damit der Benutzer alle informationen von spiel versteht.

4-Reaktionszeit : Als Spieler möchte ich, dass die Anwendung innerhalb von 1 Sekunde auf meine Zugauswahl reagiert, um das Spiel flüssig spielen zu können.

5-Kompaktheit: Als Spieler möchte ich, dass die Installationsgröße der Anwendung unter 50 MB liegt, um den Speicherplatzbedarf zu minimieren.

## Unit-Tests
- TestHelloWorld.java mit dem Befehl javac kompilieren: javac TestHelloWorld.java
- Tests mit dem Console-Launcher ausführen: java -jar junit-platform-console-standalone-1.10.0.jar --class-path . --scan-classpath
- Warum junit-platform-console-standalone-1.10.0.jar nicht ins Git-Repository aufnehmen? 
Durch Hinzufügen in das Repository würde die Größe des Repositories unnötig erhöht, und es ist besser, diese Abhängigkeiten lokal zu verwalten.
junit-platform-console-standalone-1.10.0.jar in .gitignore-Datei hinzufügen, um sicherzustellen, dass es nicht versehentlich ins Repository gelangt.

| Testfallname                              | Geprüfte(r) Methode/Konstruktor | Parameterwerte                   | Beschreibung des zu prüfenden Verhaltens                | Erwartetes Verhalten oder erwarteter Rückgabewert oder erwartetes Ereignis                         | Begründung für den konkreten Testfall                                                                   |
| ----------------------------------------- | --------------------------------- | --------------------------------- | ------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `testSetzePferdAufGueltigeStartposition`  | Konstruktor                      | Farbe: "Weiß", Startposition: "B1" | Überprüfen, ob das Pferd auf der angegebenen Startposition erstellt wird. | Pferd wird erstellt, und Position und Farbe stimmen mit den übergebenen Werten überein.          | Grundlegender Test, um sicherzustellen, dass das Pferd ordnungsgemäß erstellt wird.                        |
| `testRegelkonformerZugPferd`              | zieheNach                        | Zielposition: "C3"                | Überprüfen, ob das Pferd gemäß den Schachregeln regelkonform gezogen werden kann. | Pferd wird auf die neue Position verschoben, und der Status des Pferds wird aktualisiert.               | Sicherstellen, dass das Pferd sich ordnungsgemäß bewegen kann.                                               |
| `testUngueltigerZugAusserhalbSpielfeldPferd`   | zieheNach                        | Zielposition: "I9"                | Überprüfen, ob ein Zug außerhalb des Spielfelds abgelehnt wird. | Eine Ausnahme oder ein Fehler wird ausgelöst.                                                     | Sicherstellen, dass das Pferd nicht über die Grenzen des Schachbretts hinausgeht.                           |
| `testPferdSchlaegtFigur`                 | schlagen                         | Figur auf Zielposition                   | Überprüfen, ob das Pferd eine Figur auf der Zielposition schlagen kann. | Die Figur auf der Zielposition wird als geschlagen markiert.                                      | Überprüfen, ob das Pferd ordnungsgemäß auf Schlageaktionen reagieren kann.                                   |
| `testPferdNichtGleicheFarbe`             | Konstruktor                      | Farbe: "Weiß", Startposition: "G1" | Überprüfen, ob das Pferd mit einer Position der falschen Farbe nicht erstellt wird. | Eine Ausnahme oder ein Fehler wird ausgelöst.                                                     | Sicherstellen, dass das Pferd nicht mit einer Position der falschen Farbe erstellt wird.                 |


