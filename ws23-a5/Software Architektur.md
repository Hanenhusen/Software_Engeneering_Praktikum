# Softwarearchitektur

## Kontextabgrenzung

Die Softwarearchitektur von HSD-Chess umfasst mehrere Bausteine und Schnittstellen, um das Schachspiel zu realisieren. Hier ist eine Kontextabgrenzung, die die externen Interaktionen des Systems darstellt:


*Legende:*

Als HSD-Chess-Spieler:in ...
... kann ich HSD-Chess so konfigurieren, dass meine Züge und Spielergebnisse und die meiner Freunde automatisch über einen Dischord- Kanal übermittelt werden, um dort mit meinen Freunden immer aktuell über die Spiele diskutieren können.
... kann ich HSD-Chess so konfigurieren, dass meine Spielergebnisse automatisch über meinen Twitter-Account gepostet werden, immer direkt nach Beendigung eines Spiels, um meine Follower auf meine Aktivitäten hinzuweisen.
... kann ich mich bei HSD-Chess ohne Registrierung mit meinem HSD-Account anmelden, um einfach und ohne weitere Kontoverwaltungsaufwände HSD- Chess spielen zu können.

Als HSD-Chess-Administrator ...
... kann ich einfach und bequem (ohne Upload-Prozesse, ohne komplizierte Konfigurationsdateien) Turniere anlegen, Spieler:innen verwalten, Einladungen senden, um auch kurzfristig und ohne großen Aufwand HSD-Chess-Events einstellen zu können.

Als HSD-Chess-Marketer ...
... kann ich einfach und bequem über das Reporting-Tool TBQ sekundenaktuelle Auswertungen zu HSD-Spiel-Aktivitäten analysieren und Berichte erstellen um effizient und wie gewohnt Marketing-Kampagnen, Absprung-Raten und Nutzergewinne zu berichten. Dazu kann ich über TBQ relevante Daten aus HSD-Chess anfragen.

![Grafische Darstellung](/Bilder/kontext_Abgrenzug.png)



## Baustein: HSD-Chess
| **Schnittstelle**           | **Eingehende Daten**                                           | **Ausgehende Daten**                                          | **Konsumenten/Empfänger**                                     | **Leistungsanforderungen**                                    |
|-----------------------------|------------------------------------------------------------------|----------------------------------------------------------------|---------------------------------------------------------------|----------------------------------------------------------------|
| Discord-Integration         | Spielerzüge, Spielerergebnisse, Spielinformationen               | Spielupdates, Spielergebnisse                                  | HSD-Chess-Spieler:innen, Freunde                              | Echtzeitübertragung, Moderates Lastverhalten für Updates       |
| Twitter-Integration         | Spielergebnisse                                                 | Tweets mit Spielinformationen                                  | HSD-Chess-Spieler:innen, Twitter-Follower                     | Schnelle Postings nach Spielende, Moderates Lastverhalten      |
| HSD-Account-Anmeldung        | Anmeldedaten (Benutzername, Passwort)                           | Bestätigung der Anmeldung                                      | HSD-Chess-Spieler:innen ohne Registrierung                     | Schnelle, zuverlässige Anmeldungen, geringe Latenz bei Bestätigung |
| Administrator-Oberfläche     | Turnierkonfiguration, Spielerdaten, Einladungen                 | Turnierinformationen, Bestätigungen, Einladungen                | HSD-Chess-Administrator                                       | 15 Anfragen pro Stunde  |
| TBQ Reporting-Tool          | Spielaktivitätsdaten, Marketingkampagnendaten                   | Sekundenaktuelle Auswertungen, Berichte                        | HSD-Chess-Marketer                                            | Schnelle Datenabfragen, Skalierbarkeit für umfangreiche Analysen |
| HSDCHESS SPieler			 |GUI , Spielergebnisse 											 | Anmeldedaten , züge 											 | HSDChess Spieler 											| 100 Anfragen pro Minute , 10tel Sekunde reaktionzeit											 |



### Verfeinerungsebene 1 - Whitebox-Sicht


### Erläuterung der Bausteine

UI:
 • Interaktionslogik
• Präsentation von Informationen
• Keine Geschäftslogik, sondern Verwendung der dafür

Persistenz :
 • Sicherstellung der konsistenten, dauerhaften Speicherung 
benötigter Daten und der performanten Abfrage und 
Durchsuchung persistierter Daten (insbesondere für den Baustein 
Geschäftslogik)
• Transaktionssicherheit für parallele Schreibzugriffe
• Keine Geschäftslogik, keine Präsentation

Geschäftslogik schicht :Komponenten, die Fachlichkeit, 
Verhalten, fachliche Funktion implementieren. Keine technischen Aspekte siehe unten.
![Grafische Darstellung](/Bilder/withe_box.png)

[Grafische Darstellung](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1#R5VxdW6s4EP41vawP39BLra56jmfXta5H92YfLIFmpaQbUkv76zeU0AJJsSoQ3O2FbYbwkXfemQyTiQN9PE8usbuY%2FUAeCAea4iUD%2FXyg0Y%2Bl0q9Uss4ktulkggBDLxOpe8EEbgATKky6hB6ISx0JQiGBi7JwiqIITElJ5mKMVuVuPgrLd124AeAEk6kb8tKf0COzTOpo9l5%2BBWAwy%2B%2BsWqPsyNzNO7ORxDPXQ6uCSL8Y6GOMEMl%2BzZMxCFPwclyy8345cHT3YBhE5JgTfqy%2B%2FzXRDOvmdX3n%2BxFZWw%2F2UGeXick6HzHwKACsiTCZoQBFbnixl55htIw8kF5Woa19nxuEFlSoUuHfgJA106a7JIiKZmQesqP0ifH6kZ2%2FbTyljRMzb54nxYPna9bih5w%2FPlriKagZp6Yz7rg4AKSmo8oUm6JQuAWD9BKgOaBPRDtgELoEvpZp4jK2Bbt%2Be4XQH0wn79BP%2Ftyvbrhkt%2BIUtldHiu1qBgmYLNwtHCtqlGXoD0L4CjABSe2Q2VGdETq3aJu1V3v70EZMNivaRt7xMyi9eOPrIbnx5skF3kzC%2Bytt%2FDBUdSksTiB5LPx%2ByjlLf%2B8JnDbWRTY%2Flqn%2BVLSJz%2FBejAxPe2G%2FkSzWO0Zyf7cxX842i9%2BSb4t5sv55OTR6o84TzWxRoxW4G1OxEFS9I43WPWSdG3vDcbnxIpvffZikam7Ck2lO2ZXt2gVXpjsCV7YTNg6UxgF1NaF%2FlfHVxWTCYUbHScowxQSjFzBGIcJUEqEotQ0fhmFF5IYwiGhzStEDVH6WogZp3HPKDsyh520NS6SXsrE1MaccoQl1ZPGaMNtShC1grBWmaPuIDrOoBuufJcoPDOOtfzmlHVRrkWzRyY%2FTX0H6PVlAEFLQ2fXo42WXzI6%2B1zCaQF8ro6%2BK0NcEdmC1hf6IQ3%2BCptBNz%2FsBPOjS71vqt4iP8BxEEiAznL5BpvIutcNZk81%2FbN7Mj7w5aSqKVX4FUFLQa6fObesWYEhhSz3XJyMk%2B8gISZUVIYnf2zj7%2BOOaU39Zue3bxC7qZzah67xNCGdTtQGbEMJkcDBdgng6G4z1wanhkzhEAXyRjps%2BMt%2FETTU7Bc7kgKMWF8OYgGiTz1vPOL3HoVmraxBNu2%2FkU%2F97uRWhZxSkVr4%2FBv65D07XRvRwdZMMr7%2FdGT3zoHKny%2FJL5rHvmH3TqNYvjVr%2FW3sT9jNkaafuqYtTcQ9CFl0pzxqGws8almDWaO21k49YfgVkswJYfphiaNpJJVAxeLTyWKZptMQmb8o1%2Ba7SuOaRJm%2F1yuT5IPLcpQHksxvJJ7Np2xUym5rJm76AzIbZElwWBxdtsVwR1Wch6s5C7ucIxjHoIZJCJ2q04xbqIs1i9iiFEYMAhMMxokaJwm0CTrpHfRs40UpaEzkksT%2Ftz0KazKC4Lth90websnxw3VMXTOHPZTB8ANjFzwCSZRTEwwnAr3Aq35NUzUHkkTs1B5FHrppH5J2mZSaD3cpKAZMygAco%2B1HCNva%2BXUBXlGTKZUfzld3hFsHtOkmu3ErVQFVpmf2xk%2FZ6466jV5KMRnUWyXDhLrQlwG7UH%2BeEaF2oaU58OJD8Ypyorjt9WVI47ZBC7cZRHJvG6YYUOxI0TQpT6ZYU%2FBpm86Roz1P0ixRmW56ia1Lkqw3vY4XnxrNdhV%2BBIqn81iUE4Ggr0RR9kNeA5OWqGkelg6SQrezPKtepliZWL9SycvPbS0pHlaeLFqtpVcGieW35al9WCPjgzYcwWNZlArqpqTXVahJFWFZr7jKwjRfWigHjA5sFiiGBiK%2B56Ryysq07Fo9XawU4YrD4CT8mLlnGfYPK7rJWSewX%2BLTEXZqco0OKCYrlI6ZWyrscTTpk%2FMrQrQ%2Bwx0EloY62Gp2pypHLaO2hJXthSNXsUpx%2BomxDs3YK22oJ8%2BW2vPBZt%2FslnveB51b%2FeG5L5rmp6VWeOx3z3PqiPOdjq5Ptpw9Mt9XeMX0kmemO7VSYrnXt0Z3eM12480iQ4ZBXl6Ud91r83q1ZwoEfu%2FtOqnZEW7Ma2uhy6s1h1Og2F86DCRRz2KlV9hgJ3rBbi%2BkPb8kTbPaCHh0R9OGLK3zTbh8pa9Q3qL5gbWcjLuTYyi%2BpLoQv9GrMhdyf%2FT5IidZTH6K3mHWizf1%2Fh8hS1Pv%2FsaFf%2FAs%3D)


| Name des Bausteins | Beschreibung des Bausteins                                                                                           | Beschreibung der Abhängigkeit zu anderen Bausteinen                                                                                                                |
|--------------------|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Figur`            | Die abstrakte Klasse `Figur` bildet die Grundlage für alle Schachfiguren. Sie hält Informationen über Position, Farbe und Status der Figur.                          | - `Turm`, `Pferd`, und andere konkrete Figuren erben von `Figur`. - Sie wird von spezifischen Figurenklassen für die Validierung von Startpositionen und Zügen verwendet. |
| `Turm`             | Die Klasse `Turm` repräsentiert den Turm im Schachspiel. Sie erbt von `Figur` und implementiert spezifische Regeln für den Turm.                                              | - Nutzt die abstrakte Klasse `Figur` für gemeinsame Eigenschaften. - Wird von der Spiellogik verwendet, um Turm-spezifische Aktionen durchzuführen.                     |
| `Position`         | Die Klasse `Position` repräsentiert eine Schachbrett-Position durch Spalte und Zeile.                           | - Wird von verschiedenen Figuren verwendet, um ihre aktuelle Position zu halten. - Von `Turm`, `Pferd`, etc. genutzt, um Startpositionen und Züge zu validieren.       |
| `Regelverstoss`    | Die Klasse `Regelverstoss` ist eine benutzerdefinierte Ausnahme für Regelverletzungen im Schachspiel.           | - Wird von den Figurenklassen (`Turm`, `Pferd`, etc.) geworfen, um auf Regelverstöße hinzuweisen. - Von der Spiellogik genutzt, um Spielregelverletzungen zu behandeln.  |
| `Status`           | Die Klasse `Status` repräsentiert den Status einer Figur im Spiel (am Leben oder geschlagen).                   | - Wird von den Figurenklassen (`Turm`, `Pferd`, etc.) genutzt, um den Status der Figur zu verfolgen.                                                              |
| `Pferd`            | Die Klasse `Pferd` repräsentiert die Schachfigur Pferd. Sie erbt von `Figur` und implementiert spezifische Regeln für das Pferd.                                            | - Nutzt die abstrakte Klasse `Figur` für gemeinsame Eigenschaften. - Wird von der Spiellogik verwendet, um Pferd-spezifische Aktionen durchzuführen.                 |


![Grafische Darstellung](/Bilder/laufzeit.png)


![Laufzeitsicht für die Ausführung eines Spielzuges](https://viewer.diagrams.net/index.html?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Unbenanntes%20Diagramm.drawio#R7Vxbc5s6EP41fnQGkK%2BPiZ1e5rQzbdPLtC8dDLKtCSAqhO3k158ViLsIxDF2Lu5DCoskhPbb%2FXZXSnpo5u7eM9Nff6Y2dnqGZu96aN4zjIk%2BhZ9CcBcLBgjFghUjdizSM8ENucdSqElpSGwcFBpySh1O%2FKLQop6HLV6QmYzRbbHZkjrFt%2FrmClcEN5bpVKW%2FiM3X8rOGWib%2FgMlqnbxZ1%2BQT10waS0GwNm26zYnQdQ%2FNGKU8vnJ3M%2ByItUvWJe73ruZpOjGGPd6mw6%2FL7fdg9Of35M%2Fvn%2FaMf9V%2F%2F3T7xiQeZmM6ofxiOVt%2BlyzBBjNOYEU%2BmQvsfKEB4YR68GhBOaduD10lDS4dshIPOPVBuuauAzc6XMKn%2B2Iwd7cSILlYmAGxLlikr6slcZwZdSiDFZl71MOiA2f0Nl3waIgYGfCN6Ip4dvzNQ7iR84cp4F3tyujpegNOMXUxZ3fQRHYYSQ1JiKKpvN9mCh9OpGydV3aiWlOCbJUOnekBLqQqHqOW4enUYlHmYfaX0dCz%2F0odReY8govtmnB845uW6LeFXp1owEBtNTA8gAbMz1N2t0G7zdjw%2F9Hd1%2Fm3D9d9vaoAdHkZ8jV8EVmSeyI%2Bl0GLG59gR1yV1JMsbug6n8gSOyQCto8ZgQlCezR3pPhLJlOub05j4OW4CV1Ed2EJNqP%2Bd5OtMJcCizqO6QdkEU1DSECDIQvIBn%2FD0oaElIZcvHqWek0h9CnjIAHjg3cIITYDvsWBQICHt9c2eMbkA8eg9tG%2FUDivK5w%2BSEWwWLnnzoLmemeNjFmpUc0ACZJrusIHbrBd6KsVGkRYrrQYzzO%2FMtBSIFdQq8B2LZAHRSAPqjhOCSKP48GkKxwbzY4khy%2BfguKjKQyvesN5CbAAjzVdUc908pBVQolHoLwRNhBUjeAN4qyKrQfdTnvADQuAG6sAV8XbqCu4oQrcAoACfwhzZZpK%2BSvqeSliOIE9GFJoz7MTycKh1m3STAaOkwJKAFhFRCTaR%2FNU06lWpbeUGozvHqc0njjiBlsUE3xQtQw7JgePXQxmFaqSXb8Iq80g0dfVmEhGCGjILCw7lfSdzmJ%2FCChCF3T5%2FsfH%2Fn%2FU9SG88ziYplZBxJkvX6gfe7TLSjOiZ0OSozNJPlNwPehh9iXJSTuS7I4lxwq8jRyxFn4BdckKCUj0k6mBKjRdzDfOfrUl%2BLh%2B7KrEo4m%2Fi%2BSZckYr8b9%2BAQ%2B%2F4RV2bqm3pMwVOUv80gVLGkXJzH24EixFvBVeYK%2FaKJHAp%2FuZbA%2BCV5B5p%2BQtPVXMf8083cjno%2BPwuT4twldH7Qgd1ta8yzWTfqv%2BPZOiX9aLBSW4iEfcN1pQVzpU0UIEQyaw2gcXyBmQ9DnDftlO%2FUnlITQuWsBRIwY1bM959QtCV73naRsy6IqasCpmmHYFOKQoSJ4B93oBh4btAKfrXSFu0GGQqms1UeqLii1Lgd8Rgs3Dx5ZaKeZrWSx6fGw5VL5HGVtWeqclrLpZxqt3iJKW0hRUu3ExTgWuldbQMiszRFb2J0q4TEi1tPc%2FPori2Az1rmYLzFzCOXZEDma6IlD1FoGfsxJlThZPqcZ0MhjrzbHwASI3vbQhoitCN9XGXjnFOZhXU5R6IuJ4lDZ1vUadoMn%2BT8xMtsCEh94q6N9gtiEWbqufc07zeoKAhy1jeMoqqNI0ps0RZo5VLccMAmIVkbYvS%2BbZ7zGxU%2F58gGKtEtkTSdIopZ%2FgnS60%2FL9RK86sjJvGeOVjD0eitSR0fEjjiUMCu799SNeJJiYX2nRooEn6c%2B9oaU8cpEbzRKUPjJqA%2FLFaLg90dC2rMsfDRC8oi142CeuJirFmw9Ksa8rL1brevsEMOF9exKQp0wBL7DIyRX7gEtuO4n0meM3MCK%2BaMJshp5L7osNS0ZG06KBaLz2nlp5dy0QHoAajXPBVFR9UyeCgK2rQW5S7jsEN9dtBp%2BKGQYnGjTI9t3UTxqRhoK7dRH2%2B%2F1Q3McglObf32OcEs8hNACCaU5v8nhXhIjW6HIjp%2BCxOk5bZHtXZYch7VTB5XIeh2uJ8LsFkTSnlSA4DFe0clQ8Rt44rpiWHceSiiK46On4YhzHMHAakvgEJUo%2BRBBYNPqMuD3%2FrjmIwqCGZ0zmKFlnneV%2FjhZQ0RqWUyVCgq6PTqOpssUWC2xULNRb%2BT8pC5WgTlXXQPrttGKhjFjKent3WbkaNBA3FFXnzlodAAUHCQyISVeWtBV6ysQtNPRxGXWI%2Be%2FMMVBf%2B5H0EOiYDGdUtgSRX4TJZqZ5ff63qqatINlWlO9uvMaqJRKSdcgSoecRa87eqtRLvqupFKpvqTmsn20t4LnWgQdlfta4DjRsG6phQkSpmOmAdKCrnANoDTkX9ZvoumlD2W5WqE8dRnUi73lnCsKkg0y1my4azyW%2BSXo1J%2BaTkqekVGc2u4JzgvYwEzygneC1PRXZ3SA1Vf%2BHwlRNNeTN6qB0oc6sM1DXRdLfhENUP3%2BG1g5mLHTv04vNV96CNM2moSKMUciRmnjdr4zDxI9xmf%2FIkhlL2d2PQ9f8%3D)


[link zu einem Bild](https://drive.google.com/file/d/1yc2jmCjc9axOzl-WBU2RSXP8LwUXxiSM/view)
