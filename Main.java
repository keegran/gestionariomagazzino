import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Creazione pezzi con setter (come visto prima)
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

        boolean continua = true;
        while (continua) {
            System.out.println(Colors.CYAN + "==============================");
            System.out.println("      GESTIONE MAGAZZINO      ");
            System.out.println("==============================" + Colors.RESET);
            System.out.println("1) Cerca pezzo per codice");
            System.out.println("2) Cerca pezzo per marca e modello");
            System.out.println("0) Esci");
            System.out.print(Colors.YELLOW + "Scelta: " + Colors.RESET);

            int scelta;
            try {
                scelta = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(Colors.RED + "Inserisci un numero valido." + Colors.RESET);
                continue;
            }

            if (scelta == 0) {
                continua = false;
                System.out.println(Colors.GREEN + "Uscita dal programma. Ciao!" + Colors.RESET);
                break;
            }

            Pezzo trovato = null;

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci codice: ");
                    int codice = Integer.parseInt(in.nextLine());
                    for (Pezzo p : pezzi) {
                        if (p.getCodice() == codice) {
                            trovato = p;
                            break;
                        }
                    }
                }
                case 2 -> {
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
                default -> {
                    System.out.println(Colors.RED + "Scelta non valida." + Colors.RESET);
                    continue;
                }
            }

            if (trovato == null) {
                System.out.println(Colors.RED + "Pezzo non trovato." + Colors.RESET);
                continue;
            }

            System.out.println(Colors.GREEN + "\nTrovato: " + trovato.getNome()
                    + " | Marca: " + trovato.getMarca()
                    + " | Modello: " + trovato.getModello()
                    + " | Prezzo base: " + trovato.getPrezzoacquirente()
                    + Colors.RESET);

            System.out.println(Colors.BLUE + "=== DATI CLIENTE ===" + Colors.RESET);
            System.out.print("Nome: ");
            String nome = in.nextLine();
            System.out.print("Cognome: ");
            String cognome = in.nextLine();
            Cittadino cittadino = new Cittadino(nome, cognome);

            System.out.print("Identificativo cliente: ");
            int id = Integer.parseInt(in.nextLine());
            System.out.print("Sconto cliente (%): ");
            int sconto = Integer.parseInt(in.nextLine());
            System.out.print("Quanti pezzi compra? ");
            int n = Integer.parseInt(in.nextLine());

            Acquirente acq = new Acquirente(
                    trovato.getPrezzomagazzino(),
                    trovato.getPrezzoacquirente(),
                    trovato.getCodice(),
                    id,
                    sconto,
                    n,
                    cittadino
            );

            float prezzoSingoloScontato = acq.getPrezzoFinale(); // usa il getter che ti ho suggerito
            float totale = prezzoSingoloScontato * n;

            System.out.println(Colors.CYAN + "\n===== RIEPILOGO ACQUISTO =====" + Colors.RESET);
            System.out.println("Cliente: " + cittadino);
            System.out.println("Pezzo: " + trovato.getNome());
            System.out.println("Prezzo base: " + trovato.getPrezzoacquirente());
            System.out.println("Sconto: " + sconto + "%");
            System.out.println("Prezzo singolo scontato: " + prezzoSingoloScontato);
            System.out.println("Quantità: " + n);
            System.out.println("Totale da pagare: " + totale);

            magazzino.aggiornaDopoVendita(n, prezzoSingoloScontato);

            System.out.println(Colors.BLUE + "\n=== STATO MAGAZZINO ===" + Colors.RESET);
            System.out.println("Guadagno totale magazzino: " + magazzino.guadagno);
            System.out.println("Pezzi rimanenti in magazzino: " + magazzino.nPezzirimanenti);
            System.out.println();
        }
    }
}
