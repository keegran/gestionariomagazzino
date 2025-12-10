public class Pezzo {
    private float prezzomagazzino;
    private float prezzoacquirente;
    private int Codice;
    private String nome;
    String modello;
    String marca;

    public Pezzo(float prezzomagazzino, float prezzoacquirente, int Codice) {
        this.prezzomagazzino = prezzomagazzino;
        this.prezzoacquirente = prezzoacquirente;
        this.Codice = Codice;

        if (prezzoacquirente < 0) {
            try {
                throw new Exception("il prezzo è invalido ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (prezzomagazzino < 0) {
            try {
                throw new Exception("il prezzo per il magazzino è invalido ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public float getPrezzomagazzino(){
        return prezzomagazzino;
    }
    public float getPrezzoacquirente(){
        return prezzoacquirente;
    }
    public String getNome(){
        return nome;
    }
    public String getModello(){
        return modello;
    }
    public String getMarca(){
        return marca;
    }
    public int getCodice(){
        return Codice;
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModello(String modello) { this.modello = modello; }


    public boolean equals(Object obj) {
        return (this == obj);
    }
}
