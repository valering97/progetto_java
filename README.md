# progetto_java
# Team 3 - project




# Goals:
Scriviamo un programma che implementi un servizio per la gestione degli studenti di un corso. 
Al programma si richiedono le seguenti azioni:

    1. Aggiungere studenti, definiti per nome - età - corso di studi - matricola
    2. Visualizzare l'elenco completo degli studenti di una classe
    3. Cerca studenti nella lista in base al nome e alla matricola
    4. Modificare i dati degli studenti
    5. Uscire dal menu

## Step by Step

1. Abbiamo creato la classe "Studente", con i seguenti attributi e metodi:
nome, età, corso, matricola, getNome(), getEta(), getCorso(), getMatricola(), modificaNome(), modificaEta(), modificaCorso(), modificaMatricola(), stampaInfo().

2. Abbiamo creato una classe "Classe" con attributo ArrayList di tipo Studente. La classe implementa le funzioni richieste con i seguenti metodi: Aggiungi Studente, Cerca Studente, Modifica Studente, Visualizza la lista Studenti.

3. Abbiamo creato un file Main "MainStudente" in cui abbiamo implementato le richieste.

4. Abbiamo creato una lista di studenti con un ArrayList "elencoStudenti", per salvare gli studenti inseriti come input da tastiera.
5. Abbiamo creato una variabile booleana "flag" per controllare il ciclo while che permette di visualizzare le operazioni disponibili e con uno switch abbiamo gestito la scelta delle opzioni.
