import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Classe {
    // classe che contiene una lista di studenti
    private ArrayList<Studente> classe = new ArrayList<>();

    // costruttore
    public Classe() {
        classe = new ArrayList<>();
    }

    // super si usa per utilizzare il costruttore della classe Studente se Classe è
    // figlia di Studente
    // public Classe(String nome, int eta, String corso, int matricola,
    // ArrayList<Studente> classe){
    // super(nome, eta, corso, matricola);
    // this.classe=classe;
    // }

    // get
    public ArrayList<Studente> getClasse() {
        return classe;
    }

    // set, metto la lista di studenti che passo in input nella lista di studenti
    // della class Classe
    public void setClasse(ArrayList<Studente> classe) {
        this.classe = classe;
    }

    // metodo aggiungi uno studente alla lista classe
    public void aggiungiStudente() {
        Scanner scanner = new Scanner(System.in);
        String nuovoStudente;
        int nuovaMatricola;
        // scanner.nextLine();
        System.out.println("Inserisci nome: ");
        nuovoStudente = scanner.nextLine();
        // mettiamo un ciclo do-while per richiedere il nome nell'eventualità in cui il
        // nome inserito
        // sia già presente, utilizziamo la funzione studenteGiaPresente per
        // verificarlo.
        do {
            System.out.println("Inserisci matricola: ");
            nuovaMatricola = scanner.nextInt();
        } while (matricolaGiaPresente(classe, nuovaMatricola));

        // inseriamo i vari dati dello studente
        System.out.println("Inserisci eta': ");
        int nuovaEta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci corso: ");
        String nuovoCorso = scanner.nextLine();

        // creiamo il nuovo studente e lo aggiungiamo alla lista
        Studente studente1 = new Studente(nuovoStudente, nuovaEta, nuovoCorso, nuovaMatricola);
        classe.add(studente1);

        System.out.println("Studente aggiunto con successo!");
    }

    // funzione per confrontare due matricole
    private boolean matricolaGiaPresente(ArrayList<Studente> studenti, int matricola) {
        for (Studente studente : studenti) {
            if (studente.getMatricola() == matricola) {
                System.out.println("Matricola già presente. Riprova.");
                return true;
            }
        }
        return false;
    }

    // stampa lista degli studenti
    public void stampa() {
        if (classe.isEmpty()) { // verifichiamo se la lista è vuota
            System.out.println("Non ci sono studenti inseriti nell'elenco.");
        } else { // altrimenti stampiamo la lista, scorrendo attraverso un ciclo for gli elementi
                 // dell'array
            System.out.println("Elenco degli studenti:");
            System.out.println("Nome \tEta \tCorso \t Matricola");
            for (int i = 0; i < classe.size(); i++) {
                classe.get(i).stampaInfo();
            }
        }
    }

    public void cercaStudente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome dello studente che vuoi cercare: ");
        // scanner.nextLine();
        String cercaNome = scanner.nextLine();
        boolean trovato = false;
        int count = 0;
        ArrayList<Integer> indici = new ArrayList<>();
        // confrontiamo il nome inserito con i nomi della lista utilizzando
        // Objects.equals(s1,s2)
        // se il confronto ha esito positivo aggiorniamo la variabile booleana trovato =
        // true.
        for (int i = 0; i < classe.size(); i++) {
            if (Objects.equals(cercaNome, classe.get(i).getNome())) {
                classe.get(i).stampaInfo();
                trovato = true;
                count++;
                // indici.add(i);
            }
        }

        if (!trovato) {
            System.out.println("Studente non trovato.");
        }

        if (count >= 2) {
            System.out.println("Inserisci la matricola dello studente che stai cercando");
            int newMatricola = scanner.nextInt();
            int i = 0;
            while (newMatricola != classe.get(i).getMatricola()) {
                i++;
            }
            classe.get(i).stampaInfo();
        }
    }

    public void modificaStudente() {
        Scanner scanner = new Scanner(System.in);
        boolean flag1 = true; // inizalizziamo la variabile flag1 che ci servirà solo per questo caso
        System.out.println("Inserisci il nome dello studente che vuoi modificare: ");
        // scanner.nextLine();
        String modificaStudente = scanner.nextLine(); // prendiamo il nome dello studente da modificare
        boolean newTrovato = false;
        int indexNome = 0; // inizializziamo un indice che tiene conto della posizione dello studente nella lista
        int count = 0;    //usiamo il count per tenere traccia di più studenti con lo stesso nome
        // scorriamo la lista di studenti, quando troviamo lo studente con il nome
        // modificaStudente stampiamo
        // le sue info, salviamo la sua posizione in indexNome e aggiorniamo newTrovato
        for (int i = 0; i < classe.size(); i++) {
            if (Objects.equals(modificaStudente, classe.get(i).getNome())) {
                classe.get(i).stampaInfo();
                indexNome = i;
                newTrovato = true;
                count++;
            }
        }
        if (!newTrovato) {
            System.out.println("Studente non trovato.");
        }

        if (count >= 2) {
            System.out.println("Inserisci la matricola dello studente che vuoi modificare");
            int newMatricola = scanner.nextInt();
            int i = 0;
            while (newMatricola != classe.get(i).getMatricola()) {
                i++;
            }
            classe.get(i).stampaInfo();
        }
        // se il nome c'è nell'elenco e flag1==true stampiamo a video il secondo menu
        // per modificare uno dei dati selezionato dall'utente
        while (flag1 && newTrovato) {
            System.out.println("\nQuale dato vuoi modificare?");
            System.out.println("1. Modica nome.");
            System.out.println("2. Modifica eta'.");
            System.out.println("3. Modifica corso.");
            System.out.println("4. Modifica matricola. ");
            System.out.println("5. Fine modifica");
            int scelta1 = scanner.nextInt();

            switch (scelta1) { // con switch implementiamo le varie opzioni
                case 1:
                    System.out.println("Inserisci il nuovo nome: ");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    classe.get(indexNome).modificaNome(newName); // usiamo il metodo modificaNome
                    classe.get(indexNome).stampaInfo();
                    break;

                case 2:
                    System.out.println("Inserisci la nuova eta': ");
                    scanner.nextLine();
                    int newEta = scanner.nextInt();
                    classe.get(indexNome).modificaEta(newEta);
                    classe.get(indexNome).stampaInfo();
                    break;

                case 3:
                    System.out.println("Inserisci il nuovo corso: ");
                    scanner.nextLine();
                    String newCorso = scanner.nextLine();
                    classe.get(indexNome).modificaCorso(newCorso);
                    classe.get(indexNome).stampaInfo();
                    break;

                case 4:
                    System.out.println("Inserisci la nuova matricola: ");
                    scanner.nextLine();
                    int newMatricola = scanner.nextInt();
                    classe.get(indexNome).modificaMatricola(newMatricola);
                    classe.get(indexNome).stampaInfo();
                    break;
                case 5: // per uscire dal menu di modifica mettiamo flag1=false
                    flag1 = false;
                    break;

                default:
                    System.out.println("Modifica non disponibile.");
                    break;
            }
        }
    }
}
