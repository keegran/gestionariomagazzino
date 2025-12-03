public class Pezzo{
    float prezzomagazzino;
    float prezzoacquirente;
    String nome;
    int	Codice;
    String modello;
    String marca;
    public Pezzo (float prezzomagazzino,float prezzoacquirente,int Codice){
        this.prezzomagazzino=prezzomagazzino;
        this.prezzoacquirente=prezzoacquirente;
        this.Codice=Codice;
        if(prezzoacquirente<0){
            try {
                throw new Exception("il prezzo è invalido ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(prezzomagazzino<0){
            try {
                throw new Exception("il prezzo per il magazzino è invalido ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
        public boolean equals(Object obj) {
            return (this == obj);
        }
    }
