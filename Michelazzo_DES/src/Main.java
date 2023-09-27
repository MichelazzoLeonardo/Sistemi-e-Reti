// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import Matrice.Matrice;
import java.util.random.*;

public class Main {
    public static void main(String[] args) {
        Matrice dati = new Matrice();
        Matrice permutazione = new Matrice();
        Matrice cripted = new Matrice();

        dati.CaricaDati();
        permutazione.Carica();
        cripted = Matrice.Permuta(permutazione, dati);

        dati.Stampa();
        permutazione.Stampa();
        cripted.Stampa();
    }
}
