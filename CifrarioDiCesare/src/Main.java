import Cifrario.CifrarioDiCesare;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CIFRARIO DI CESARE:");
        System.out.print("Inserisci il messaggio: ");
        String messaggio = scanner.nextLine();
        System.out.print("Inserisci la chiave: ");
        int chiave = scanner.nextInt();

        CifrarioDiCesare cifrario = new CifrarioDiCesare(messaggio, chiave);
        String messaggioCriptato = cifrario.CriptaMessaggio();
        System.out.println("messaggio criptato: " + messaggioCriptato);

        cifrario = new CifrarioDiCesare(messaggioCriptato, chiave);
        String messaggioDecriptato = cifrario.DecriptaMessaggio();
        System.out.println("messaggio decriptato: " + messaggioDecriptato);
    }
}
