Agenzia di produzione cinematografica

Creazione di un sito con Spring Boot per un’agenzia di cinema per poter gestire i casting delle proprie produzioni.
Il sito dispone di una Home Page con divisione dei film per genere e degli ultimi attori iscritti al sito. Ogni film ha la sua scheda di dettaglio, dove vengono visualizzate tutte le informazioni di quel film, ovvero, la locandina, il trailer, la trama, la data di uscita, il titolo, il genere ed il cast. Se clicchiamo poi sul singolo attore possiamo visualizzare la pagina dettaglio attore, dove troviamo tutti i film da lui recitati, i suoi dati anagrafici e le sue foto. 
Nella Home Page ogni attore può registrarsi sul sito e fare il login per poi accedere alla sua area riservata, dove potrà visualizzare i suoi dati anagrafici, poter modificare le sue foto o poter eliminare il suo profilo. 


Il database utilizzato dall’applicazione è MySQL. Ecco le istruzioni per configurare il database sul tuo sistema: 

1- Assicurati di avere MySQL installato sul tuo sistema. Se non lo hai già puoi installarlo sul sito ufficiale di MySQL (https://dev.mysql.com/downloads/. 

2- Crea un nuovo database chiamato “casting” utilizzando il seguente comando SQL:  "CREATE DATABASE casting;"
Nella cartella "sql" in src/main/resources troverai due file, nel file schema.sql ci sono tutte le informazioni per creare le tabelle necessarie e nel file data.sql trovarai i dati di esempio per poterle popolare.  

3-Clona il repository che trovi in questo link: https://github.com/B-Xhovana/casting

4-Importa il progetto su Spring Boot e assicurati che la connessione nel file application.properties sia corretto. 

5-Esegui il progetto e accedi all’applicazione tramite il Browser all’indirizzo http://localhost:8080/landing


Linguaggio di programmazione: JAVA
Framework: SPRING BOOT
FrontEnd: HTML, CSS, JAVASCRIPT
Database: MySQL




Copyright (2024) (Agnese Burla, Viviana Mancini, Veronica Zaccardi, Xhovana Barjamaj,Deborah Del Gaudio, Hajar Errafi,Stefania Pinna)
Quest’opera è concessa in licenza con una Licenza Creative Commons Attribuzione - Non commerciale.


Agnese Burla
Viviana Mancini
Veronica Zaccardi
Xhovana Barjamaj
Deborah Del Gaudio
Hajar Errafi
Stefania Pinna

[^1]

[^1]: Queste persone hanno contribuito al progetto con il loro lavoro e impegno.


