# progetto_java
# Team 3 - project




# Goals:
Scriviamo un programma che implementi un servizio per la gestione degli studenti di un corso. 
Al programma si richiedono le seguenti azioni:

    1. Aggiungere studenti, definiti per nome - età - corso di studi
    2. Visualizzare l'elenco completo degli studenti
    3. Cerca studenti nella lista in base al nome
    4. Modificare i dati degli studenti
    5. Uscire dal menu

## Step by Step

1. Abbiamo creato la classe "Studente", con i seguenti attributi e metodi:
nome, età, corso, getNome(), getEta(), getCorso(), modificaNome(), modificaEta(), modificaCorso(), stampaInfo().

2. Abbiamo creato un file Main "MainStudente" in cui abbiamo implementato le richieste.

3. Abbiamo creato una lista di studenti con un ArrayList "elencoStudenti", per salvare gli studenti inseriti come input da tastiera.
4. Abbiamo creato una variabile booleana "flag" per controllare il ciclo while che permette di visualizzare le operazioni disponibili e con uno switch abbiamo gestito la scelta delle opzioni.
