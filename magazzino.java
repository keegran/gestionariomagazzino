public class Magazzino extends Pezzo{
    double guadagno;
    double spesa;
    int nPezzi=999999999;
    public Magazzino(float prezzomagazzino,float prezzoacquirente,int Codice,double guadagno, double spesa, int nPezzi) {
        super(prezzomagazzino,prezzoacquirente,Codice);
        this.guadagno = guadagno;
        this.spesa = spesa;
        this.nPezzi = nPezzi;
        if (nPezzi == 0) {
            try {
                throw new Exception("hai finito i pezzi non puoi più vendere");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
double Guadagnototale=prezzoacquirente-spesa;
double Spesatotale=prezzomagazzino*PezziComprati;
int nPezzirimanenti=nPezzi-PezziComprati;
}
