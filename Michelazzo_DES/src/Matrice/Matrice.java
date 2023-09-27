package Matrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrice {
    private int[][] matrice;
    private Random rn = new Random();

    public Matrice() {
        matrice = new int[8][8];
    }

    public void Stampa() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print(matrice[i][j] + "\t");
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void Carica() {
        int[] numbers = new int[64];
        for (int i = 0; i < 64; i++)
            numbers[i] = i + 1;

        int n;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                do {
                    n = rn.nextInt(64);
                    if (numbers[n] != 0) {
                        matrice[i][j] = numbers[n];
                        numbers[n] = 0;
                    }
                } while (matrice[i][j] == 0);
            }
        }
    }

    public void CaricaDati() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                matrice[i][j] = rn.nextInt(2);
    }

    public static Matrice Permuta(Matrice permutazione, Matrice dati) {
        Matrice result = new Matrice();

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                result.matrice[i][j] = dati.matrice[Math.floorDiv(permutazione.matrice[i][j]-1, 8)][(permutazione.matrice[i][j] - 1) % 8];
        return result;
    }
}
