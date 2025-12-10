public class Acquirente extends Pezzo {
    int identificativo;
    int sconto;
    int PezziComprati;
    Cittadino cittadino;

    public Acquirente(float prezzomagazzino, float prezzoacquirente, int Codice,
                      int identificativo, int sconto, int Pezzicomprati,
                      Cittadino cittadino) {
        super(prezzomagazzino, prezzoacquirente, Codice);
        this.identificativo = identificativo;
        this.sconto = sconto;
        this.PezziComprati = Pezzicomprati;
        this.cittadino = cittadino;

        if (sconto == 0 || sconto == 100) {
            try {
                throw new Exception("sconto invalido");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (PezziComprati == 0 || PezziComprati == 999999999) {
            try {
                throw new Exception("Numero pezzi invalido, prova di nuovo");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    float scontoeuro = (getPrezzoacquirente() * sconto) / 100;
    public float getPrezzoFinale() {
        float scontoeuro = (getPrezzoacquirente() * sconto) / 100;
        return getPrezzoacquirente() - scontoeuro;
    }

}
