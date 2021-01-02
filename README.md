# MTTPP

LV2
U ovoj vježbi radi se automatizirano testiranje Web aplikacija. Zadatak sadrži tri testne klase: provjeru iz Google tražilice te provjere na stranicama NBA lige i FERIT-a. 
U Maven projektu dodane su Selenium i TestNG ovisnosti.
Prvi test koji se izvodi u Google tražilici ponekad zna pasti i javiti grešku da je nemoguće locirati željeni element za koji je predan XPath (prvi link na stranici rezultata).
Unatoč povećanom vremenu unutar Thread.sleep() funkcije, i dalje zna doći do navedenog problema (uglavnom se riješi ponovnim pokretanjem toga testa ili zatvaranjem i ponovnim otvaranjem projekta).
Ostali testovi trebali bi raditi bez problema.

LV3
U ovoj vježbi pomoću REST Assureda testiramo GET, POST, PUT i DELETE zahtjeve na JSON datoteci. Imamo datoteku db.json s uzorkom podataka u kojoj se nalaze studenti. Svaki student ima ime, prezime, smjer te jedinstveni id. 
Također, imamo datoteku s uzorkom prilagođenih putanja koje ćemo koristiti za izvođenje zahtjeva. JSON poslužitelja pokrećemo na portu 7000 i predajemo mu datoteke s rutama i studentima.
Unutar Maven projekta dodajemo Rest Assured i TestNG ovisnost. Nakon toga pišemo testove za ranije navedene zahtjeve na JSON datoteku. 
Unutar svake metode nalaze se zakomentirani odgovori na zahtjeve za koje testovi neće proći.

LV5
Za testiranje otpornosti na opterećenje odabrana je stranica www.amazon.com .
Odabrano je da se spaja 500 korisnika, s vremenom pokretanja svih niti od 5 sekundi te da je broj ponavljanja ovog testa 5 puta. Za krajnju točku odabrana je stranica "music".
U elementu View Results Tree možemo vidjeti da su svi zahtjevi prošli te dodatne informacije o svakom od njih (vrijeme učitavanja, kašnjenje, povratni kod i povratnu poruku, ...).
U elementu Graph Results možemo vidjeti rezultate ispitivanja na grafu. Najvažniji parametri su propusnost i devijacija. Propusnost predstavlja sposobnost poslužitelja da obrađuje teška opterećenja.
Velika propusnost znači da poslužitelj može obraditi velik broj zahtjeva u minuti. U provedenom testu propusnost iznosi 5,788.824 zahtjeva u minuti (vrijednost ovisi o više čimbenika tako da rezultati mogu varirati). 
Ova vrijednost je visoka što znači da Amazon poslužitelj ima dobre rezultate.
Devijacija označava odstupanje od prosjeka. Cilj je da bude što manja. Devijacija u ovom testiranju iznosi 1486, što je puno veća vrijednost od vrijednosti dobivenih na vježbama gdje smo testirali Google poslužitelj (ova vrijednost također ovisi o više čimbenika tako da rezultati mogu varirati).

