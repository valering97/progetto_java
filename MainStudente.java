//Gestione lista degli studenti. Azioni:
//Aggiunge nuovo studente (nome, età e corso);
//Mostra elenco completo degli studenti nella lista;
//Cerca studente in base al nome;
//Modifica dati dello studente con come;
//Esci.

// importiamo le classi necessarie
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class MainStudente {
    public static void main(String[] args) {
        boolean flag = true; // Entra nel ciclo almeno una volta.
        Scanner scanner = new Scanner(System.in); // prendiamo input da tastiera
        ArrayList<Studente> elencoStudenti = new ArrayList<>(); // creiamo un arraylist di studenti

        while (flag) { // stampiamo a video un menu fin quando la variabile flag non diventa false
            System.out.println("\nMenu': ");
            System.out.println("1. Aggiungi nuovo studente.");
            System.out.println("2. Visualizza elenco studenti.");
            System.out.println("3. Cerca studente.");
            System.out.println("4. Modifica dati studente.");
            System.out.println("5. Esci dal menu'.");

            int scelta = scanner.nextInt();

            switch (scelta) { // usiamo switch per presentare le varie opzioni del menu
                case 1: // aggiungo nuovo studente nell'arraylist
                    String nuovoStudente;
                    scanner.nextLine();
                    // mettiamo un ciclo do-while per richiedere il nome nell'eventualità in cui il
                    // nome inserito
                    // sia già presente, utilizziamo la funzione studenteGiaPresente per
                    // verificarlo.
                    do {
                        System.out.println("Inserisci nome: ");
                        nuovoStudente = scanner.nextLine();
                    } while (studenteGiaPresente(elencoStudenti, nuovoStudente));

                    // inseriamo i vari datii dello studente
                    System.out.println("Inserisci eta': ");
                    int nuovaEta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Inserisci corso: ");
                    String nuovoCorso = scanner.nextLine();

                    // creiamo il nuovo studente e lo aggiungiamo alla lista
                    Studente studente1 = new Studente(nuovoStudente, nuovaEta, nuovoCorso);
                    elencoStudenti.add(studente1);

                    System.out.println("Studente aggiunto con successo!");
                    break;

                case 2: // stampa lista degli studenti
                    if (elencoStudenti.isEmpty()) { // verifichiamo se la lista è vuota
                        System.out.println("Non ci sono studenti inseriti nell'elenco.");
                    } else { // altrimenti stampiamo la lista, scorrendo attraverso un ciclo for gli elementi
                             // dell'array
                        System.out.println("Elenco degli studenti:");
                        System.out.println("Nome \tEta \tCorso");
                        for (int i = 0; i < elencoStudenti.size(); i++) {
                            elencoStudenti.get(i).stampaInfo();
                        }
                    }
                    break;

                case 3: // cerchiamo uno studente attraverso il nome
                    System.out.println("Inserisci il nome dello studente che vuoi cercare: ");
                    scanner.nextLine();
                    String cercaNome = scanner.nextLine();
                    boolean trovato = false;
                    // confrontiamo il nome inserito con i nomi della lista utilizzando
                    // Objects.equals(s1,s2)
                    // se il confronto ha esito positivo aggiorniamo la variabile booleana trovato =
                    // true.
                    for (int i = 0; i < elencoStudenti.size(); i++) {
                        if (Objects.equals(cercaNome, elencoStudenti.get(i).getNome())) {
                            elencoStudenti.get(i).stampaInfo();
                            trovato = true;
                        }
                    }
                    if (!trovato) {
                        System.out.println("Studente non trovato.");
                    }
                    break;

                case 4: // modifica uno studente
                    boolean flag1 = true; // inizalizziamo la variabile flag1 che ci servirà solo per questo caso
                    System.out.println("Inserisci il nome dello studente che vuoi modificare: ");
                    scanner.nextLine();
                    String modificaStudente = scanner.nextLine(); // prendiamo il nome dello studente da modificare
                    boolean newTrovato = false;
                    int indexNome = 0; // inizializziamo un indice che tiene conto della posizione dello studente nella
                                       // lista
                    // scorriamo la lista di studenti, quando troviamo lo studente con il nome
                    // modificaStudente stampiamo
                    // le sue info, salviamo la sua posizione in indexNome e aggiorniamo newTrovato
                    for (int i = 0; i < elencoStudenti.size(); i++) {
                        if (Objects.equals(modificaStudente, elencoStudenti.get(i).getNome())) {
                            elencoStudenti.get(i).stampaInfo();
                            indexNome = i;
                            newTrovato = true;
                        }
                    }
                    if (!newTrovato) {
                        System.out.println("Studente non trovato.");
                    }
                    // se il nome c'è nell'elenco e flag1==true stampiamo a video il secondo menu
                    // per modificare uno dei dati selezionato dall'utente
                    while (flag1 && newTrovato) {
                        System.out.println("\nQuale dato vuoi modificare?");
                        System.out.println("1. Modica nome.");
                        System.out.println("2. Modifica eta'.");
                        System.out.println("3. Modifica corso.");
                        System.out.println("4. Fine modifica");
                        int scelta1 = scanner.nextInt();

                        switch (scelta1) { // con switch implementiamo le varie opzioni
                            case 1:
                                System.out.println("Inserisci il nuovo nome: ");
                                scanner.nextLine();
                                String newName = scanner.nextLine();
                                elencoStudenti.get(indexNome).modificaNome(newName); // usiamo il metodo modificaNome
                                elencoStudenti.get(indexNome).stampaInfo();
                                break;

                            case 2:
                                System.out.println("Inserisci la nuova eta': ");
                                scanner.nextLine();
                                int newEta = scanner.nextInt();
                                elencoStudenti.get(indexNome).modificaEta(newEta);
                                elencoStudenti.get(indexNome).stampaInfo();
                                break;

                            case 3:
                                System.out.println("Inserisci il nuovo corso: ");
                                scanner.nextLine();
                                String newCorso = scanner.nextLine();
                                elencoStudenti.get(indexNome).modificaCorso(newCorso);
                                elencoStudenti.get(indexNome).stampaInfo();
                                break;

                            case 4: //per uscire dal menu di modifica mettiamo flag1=false
                                flag1 = false;
                                break;

                            default:
                                System.out.println("Modifica non disponibile.");
                                break;
                        }
                    }
                    break;

                case 5://per uscire dal menu iniziale mettiamo flag=false
                    System.out.println("Grazie per aver usato il nostro servizio, arrivederci!");
                    flag = false;
                    break;

                default:
                    System.out.println("Operazione non disponibile.");
                    break;
            }
        }

    }

    //funzione che serve a vedere se il nome dello studente inserito è già presente
    public static boolean studenteGiaPresente(ArrayList<Studente> studenti, String nome) {
        for (Studente studente : studenti) {
            if (studente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nome già presente. Riprova.");
                return true;
            }
        }
        return false;
    }
}