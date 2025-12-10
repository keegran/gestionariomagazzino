import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pezzo p1 = new Pezzo(20f, 40f, 1001);
        p1.setNome("Filtro olio");
        p1.setMarca("Yamaha");
        p1.setModello("MT-07");

        Pezzo p2 = new Pezzo(30f, 60f, 1002);
        p2.setNome("Pastiglie freno");
        p2.setMarca("Honda");
        p2.setModello("CB500");


        Pezzo[] pezzi = {p1, p2};


        Magazzino magazzino = new Magazzino(0f, 0f, 0, 0, 0, 20);

        System.out.println("Cerca pezzo per: 1) Codice  2) Marca+Modello");
        int scelta = in.nextInt();
        in.nextLine();

        Pezzo trovato = null;

        if (scelta == 1) {
            System.out.print("Inserisci codice: ");
            int codice = in.nextInt();
            for (Pezzo p : pezzi) {
                if (p.getCodice() == codice) {
                    trovato = p;
                    break;
                }
            }
        } else if (scelta == 2) {
            System.out.print("Inserisci marca: ");
            String marca = in.nextLine();
            System.out.print("Inserisci modello: ");
            String modello = in.nextLine();
            for (Pezzo p : pezzi) {
                if (marca.equalsIgnoreCase(p.getMarca())
                        && modello.equalsIgnoreCase(p.getModello())) {
                    trovato = p;
                    break;
                }
            }
        }
            if (trovato == null) {
            System.out.println("Pezzo non trovato");
            return;
        }

        System.out.println("Trovato: " + trovato.getNome() + " prezzo base: " + trovato.getPrezzoacquirente());

        System.out.print("Nome cliente: ");
        String nome = in.nextLine();
        System.out.print("Cognome cliente: ");
        String cognome = in.nextLine();
        Cittadino cittadino = new Cittadino(nome, cognome);

        System.out.print("Identificativo cliente: ");
        int id = in.nextInt();
        System.out.print("Sconto cliente (%): ");
        int sconto = in.nextInt();
        System.out.print("Quanti pezzi compra? ");
        int n = in.nextInt();

        Acquirente acq = new Acquirente(
                trovato.getPrezzomagazzino(),
                trovato.getPrezzoacquirente(),
                trovato.getCodice(),
                id,
                sconto,
                n,
                cittadino
        );

        float prezzoSingoloScontato = acq.getPrezzoFinale();
        float totale = prezzoSingoloScontato * n;

        System.out.println("Cliente: " + cittadino);
        System.out.println("Prezzo singolo scontato: " + prezzoSingoloScontato);
        System.out.println("Totale da pagare: " + totale);

        float magazzino1 = magazzino.getPrezzomagazzino();
        magazzino1 = trovato.getPrezzomagazzino();

        float acquirente1 = acq.getPrezzoacquirente();
        acquirente1 = trovato.getPrezzoacquirente();

        magazzino.aggiornaDopoVendita(n, prezzoSingoloScontato);

        System.out.println("Guadagno totale magazzino: " + magazzino.guadagno);
        System.out.println("Pezzi rimanenti in magazzino: " + magazzino.nPezzirimanenti);
    }
}
