public class Studente {
    //Attributi.
    protected String nome;
    protected int eta;
    protected String corso;
    protected int matricola;


    //Costruttore.
    public Studente(String nome, int eta, String corso, int matricola){
        this.nome = nome;
        this.eta = eta;
        this.corso = corso;
        this.matricola = matricola;
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

    public int getMatricola(){
        return matricola;
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

    public void modificaMatricola(int matricola){
        this.matricola=matricola;
    }


    public void stampaInfo(){
        System.out.print(nome + "\t");
        System.out.print(eta + "\t");
        System.out.print(corso + "\t");
        System.out.print(matricola + "\n");
    }
}
