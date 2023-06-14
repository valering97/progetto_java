//Gestione lista degli studenti. Azioni:
//Aggiunge nuovo studente (nome, età e corso);
//Mostra elenco completo degli studenti nella lista;
//Cerca studente in base al nome;
//Modifica dati dello studente con come;
//Esci.
import java.util.Scanner;
import java.util.ArrayList;

public class MainStudente {
    public static void main(String[] args){
        boolean flag = true; //Entra nel ciclo almeno una volta.
        Scanner scanner = new Scanner(System.in);
        ArrayList<Studente> elencoStudenti = new ArrayList<>();
        while(flag){
            System.out.println("\nMenu': ");
            System.out.println("1. Aggiungi nuovo studente.");
            System.out.println("2. Visualizza elenco studenti.");
            System.out.println("3. Cerca studente.");
            System.out.println("4. Modifica dati studente.");
            System.out.println("5. Esci dal menu'.");
            int scelta = scanner.nextInt();
            switch(scelta){
                case 1:
                    System.out.println("Inserisci nome: ");
                    scanner.nextLine();
                    String nuovoStudente = scanner.nextLine();
                    System.err.println("Inserisci eta': ");
                    //scanner.nextLine();
                    int nuovaEta = scanner.nextInt(); 
                    System.out.println("Inserisci corso: ");
                    scanner.nextLine();
                    String nuovoCorso = scanner.nextLine();
                    Studente studente1 = new Studente(nuovoStudente, nuovaEta, nuovoCorso); 
                    elencoStudenti.add(studente1);
                    break;   
                case 2:
                    if(elencoStudenti.size() == 0){
                        System.out.println("Non ci sono studenti inseriti nell'elenco.");
                    } else {
                        System.out.println("Elenco degli studenti.");
                        System.out.println("Nome: Eta: Corso: ");
                        for(int i = 0; i < elencoStudenti.size(); i++){
                            elencoStudenti.get(i).stampaInfo();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il nome dello studente che vuoi cercare: ");
                    scanner.nextLine();
                    String cercaNome = scanner.nextLine();
                    boolean trovato = false;
                    for(int i = 0; i < elencoStudenti.size(); i++){
                        if(cercaNome == elencoStudenti.get(i).getNome()){
                            elencoStudenti.get(i).stampaInfo();
                            trovato = true;
                        }
                    }
                    if(trovato){
                        System.out.println("Studente non trovato.");
                    }
                    break;
                case 4:
                    boolean flag1 = true; //Non all'inizio altrimenti dopo una iterazione del while diventa false.
                    System.out.println("Inserisci il nome dello studente che vuoi modificare: ");
                    scanner.nextLine();
                    String modificaStudente = scanner.nextLine();
                    boolean newTrovato = false;
                    int indexNome = 0;
                    for(int i = 0; i < elencoStudenti.size(); i++){
                        if(modificaStudente == elencoStudenti.get(i).getNome()){
                        elencoStudenti.get(i).stampaInfo();
                        indexNome = i;
                        newTrovato = true;
                        }
                    }
                    if(newTrovato){ 
                        System.out.println("Studente non trovato.");
                    }
                    while(flag1){
                        System.out.println("\nQuale dato vuoi modificare?");
                        System.out.println("1. Modica nome.");
                        System.out.println("2. Modifica eta'.");
                        System.out.println("3. Modifica corso.");
                        int scelta1 = scanner.nextInt();
                        switch(scelta1){
                            case 1:
                                System.out.println("Inserisci il nuovo nome: ");
                                scanner.nextLine();
                                String newName = scanner.nextLine();
                                elencoStudenti.get(indexNome).modificaNome(newName);
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
                            default:
                                System.out.println("Modifica non disponibile.");
                                flag1 = false; 
                                break;
                        }
                    }
                case 5:
                    System.out.println("Grazie per aver usato il nostro servizio, arrivederci!");
                    flag = false;
                    break;
                default:
                    System.out.println("Operazione non disponibile.");
                    break;
            }
        }
    }
}
