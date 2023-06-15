public class Studente{
    //Attributi.
    private String nome;
    private int eta;
    private String corso;


    //Costruttore.
    public Studente(String nome, int eta, String corso){
        this.nome = nome;
        this.eta = eta;
        this.corso = corso;
    }


    //Metodi.

    public String getNome(){
        return nome;
    }


    public int getEta(){
        return eta;
    }


    public String getCorso(){
        return corso;
    }


    public void modificaNome(String nomeModificato){
        this.nome = nomeModificato;
    }


    public void modificaEta(int etaModificata){
        this.eta = etaModificata;
    }


    public void modificaCorso(String corsoModificato){
        this.corso = corsoModificato;
    }


    public void stampaInfo(){
        System.out.print(nome + "\t");
        System.out.print(eta + "\t");
        System.out.print(corso + "\n");
    }
}
