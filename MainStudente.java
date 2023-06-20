import java.util.ArrayList;
import java.util.Scanner;

public class MainStudente {
     public static void main(String[] args) {
        boolean flag = true; // Entra nel ciclo almeno una volta.
        Scanner scanner = new Scanner(System.in); // prendiamo input da tastiera
        //ArrayList<Studente> elencoStudenti = new ArrayList<>(); // creiamo un arraylist di studenti
        Classe classe = new Classe(); 

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
                    classe.aggiungiStudente();
                    break;
                case 2: // stampa lista degli studenti
                    classe.stampa();
                    break;

                case 3: // cerchiamo uno studente attraverso il nome
                    classe.cercaStudente();
                    break;

                case 4: // modifica uno studente
                    classe.modificaStudente();
                    break;

                case 5:// per uscire dal menu iniziale mettiamo flag=false
                    System.out.println("Grazie per aver usato il nostro servizio, arrivederci!");
                    flag = false;
                    break;

                default:
                    System.out.println("Operazione non disponibile.");
                    break;
            }
        }

    }

    // funzione che serve a vedere se il nome dello studente inserito è già presente
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
