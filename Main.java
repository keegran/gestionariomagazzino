import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Creiamo qualche pezzo di esempio
        Pezzo p1 = new Pezzo(50f, 100f, 1111);
        p1.nome = "Filtro olio";
        p1.marca = "Yamaha";
        p1.modello = "MT-07";

        Pezzo p2 = new Pezzo(80f, 150f, 2222);
        p2.nome = "Pastiglie freno";
        p2.marca = "Honda";
        p2.modello = "CB500";

        Pezzo[] magazzino = { p1, p2 };

        // Info sul magazzino (guadagno, spesa, n pezzi)
        Magazzino infoMagazzino = new Magazzino(
                p1.prezzomagazzino, p1.prezzoacquirente, p1.Codice,
                0,                            // guadagno iniziale
                0,                            // spesa iniziale
                10                            // pezzi disponibili totali
        );

        System.out.println("Vuoi cercare per: 1) codice  2) marca+modello?");
        int scelta = in.nextInt();
        in.nextLine(); // consuma newline

        Pezzo trovato = null;

        if (scelta == 1) {
            System.out.print("Inserisci codice pezzo: ");
            int codice = in.nextInt();
            for (Pezzo p : magazzino) {
                if (p.Codice == codice) {
                    trovato = p;
                    break;
                }
            }
        } else if (scelta == 2) {
            System.out.print("Inserisci marca: ");
            String marca = in.nextLine();
            System.out.print("Inserisci modello: ");
            String modello = in.nextLine();
            for (Pezzo p : magazzino) {
                if (p.marca.equalsIgnoreCase(marca)
                        && p.modello.equalsIgnoreCase(modello)) {
                    trovato = p;
                    break;
                }
            }
        }

        if (trovato == null) {
            System.out.println("Pezzo non trovato.");
            return;
        }

        System.out.println("Pezzo trovato: " + trovato.nome + " prezzo base: " + trovato.prezzoacquirente);

        // Cliente
        System.out.print("Inserisci identificativo cliente: ");
        int id = in.nextInt();
        System.out.print("Inserisci sconto (percentuale): ");
        int sconto = in.nextInt();
        System.out.print("Quanti pezzi compra? ");
        int n = in.nextInt();

        // Creiamo l'Acquirente usando la tua classe
        Acquirente cliente = new Acquirente(
                trovato.prezzomagazzino,
                trovato.prezzoacquirente,
                trovato.Codice,
                id,
                sconto,
                n
        );

        // Calcolo del prezzo finale con sconto (usando i campi già presenti)
        float scontoeuro = (cliente.prezzoacquirente * cliente.sconto) / 100;
        float prezzofinale = cliente.prezzoacquirente - scontoeuro;

        System.out.println("Prezzo singolo scontato: " + prezzofinale);
        float totaleCliente = prezzofinale * n;
        System.out.println("Totale da pagare: " + totaleCliente);

        // Aggiornamento semplice del magazzino e del guadagno
        infoMagazzino.guadagno += (prezzofinale - cliente.prezzomagazzino) * n;
        infoMagazzino.spesa += cliente.prezzomagazzino * n;
        infoMagazzino.nPezzi -= n;

        System.out.println("Guadagno totale negozio: " + infoMagazzino.guadagno);
        System.out.println("Pezzi rimanenti in magazzino: " + infoMagazzino.nPezzi);
    }
}
