/*
    Algoritmo semplificato della funzione di hash SHA-1 (Standard Hash Algorithm)
    hash=sminuzzare

    Semplificazione :
        - blocchi da 160 bit (diviso in 5 blocchi da 32 bit 5X32=160)
        - i blocchi sono chiamati A,B,C,D,E
        - inizializzazione del blocco di ingresso  come in SHA-1
            A = 67452301
            B = EFCDAB89
            C = 98BADCFE
            D = 10325476
            E = C3D2E1F0
        - funzione di left-shift di n bit (con n fisso mentre sha è variabile)
        - matrice di trasposizione fra il blocco di ingresso ed il primo blocco del documento
        - ripetizione del ciclo fra il blocco di uscita e un nuuovo blocco da 160 bit
          (la matrice di trasposizione resta la stessa)

NB : SCOPO GENERALE E' VERIFICARE POI IL GRADO DI "BONTA'" DI QUESTA FUNZIONE DI HASH
     CERCANDO DI CAPIRE LA PERCENTUALE DI "COLLISIONE"
     PER COLLISIONE DI UNA FUNZIONE DI HASH SI INTENDE LA GENERAZIONE DELLO STESSO DIGEST
     (DETTO IN ITALIANO "IMPRONTA DEL DOCUMENTO" ) CON DUE DOCUMENTI DIVERSI !!

     IN UNA BUONA FUNZIONE DI HASH NON DOVREBBE CAPITARE

 */

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        final int nLeftShift = 13;   // numero di shift a sinistra del blocco da 160 bit preso
        // dal documento
        final String path = "Mattarella.txt";
        final String path1 = "Mattarella1.txt";
        final String pathInit = "init.txt";

        // Press Alt+Invio with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("ALGORITMO SHA-1 SEMPLIFICATO\n");

        Blocco32 a32, b32, c32, d32, e32;
        // inizializzazione dei blocchi come in SHA-1
        System.out.println("Blocchi di partenza...");
        a32 = new Blocco32("67452301");
        b32 = new Blocco32("EFCDAB89");
        c32 = new Blocco32("98BADCFE");
        d32 = new Blocco32("10325476");
        e32 = new Blocco32("C3D2E1F0");

        System.out.println("A = " + a32.stampa());
        System.out.println("B = " + b32.stampa());
        System.out.println("C = " + c32.stampa());
        System.out.println("D = " + d32.stampa());
        System.out.println("E = " + e32.stampa());

        System.out.println("numero di left shift  = " + nLeftShift);

        Documento doc, docInit, doc1;
        doc = new Documento(path);
        docInit = new Documento(pathInit);
        doc1 = new Documento(path1);


        char[] bf1;  // relativo  a doc
        char[] bf2;  // relativo a docInit
        char[] bf3;  // relativo a doc1 (modificata solo una lettera dal doc originale)
        int[] v;
        v = new int[8];
        int[] vInit;
        vInit = new int[8];
        int[] v1;
        v1 = new int[8];

        int[][] m, mInit, mImpronta, m1, mImpronta1;
        m = new int[5][32];   //  5 righe 32 colonne 160 bit
        mInit = new int[5][32];
        mImpronta = new int[5][32];
        m1 = new int[5][32];
        mImpronta1 = new int[5][32];

        int c = 0;
        int r = 0;

        bf1 = doc.leggiBlocco();
        bf2 = docInit.leggiBlocco();
        bf3 = doc1.leggiBlocco();

        for (int i = 0; i < 20; i++) {
            System.out.println("\n carattere " + i + " del bf1 = " + (int) bf1[i]);
            v = Blocco32.toBinary(bf1[i]);

            for (int j = 0; j < 8; j++) {
                System.out.printf("\nbit n. %d= %d", j, v[j]);
                m[r][c] = v[j];
                c++;
                if (c == 32) { // se arriviamo in fondo alla colonna 32 ripartiamo con la nuova riga
                    c = 0;
                    r++;
                }
            }
        }
        c = r = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("\n carattere " + i + " del bf2 = " + (int) bf2[i]);
            vInit = Blocco32.toBinary(bf2[i]);

            for (int j = 0; j < 8; j++) {
                System.out.printf("\nbit n. %d= %d", j, vInit[j]);
                mInit[r][c] = vInit[j];
                c++;
                if (c == 32) {
                    c = 0;
                    r++;
                }
            }
        }
        c = r = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("\n carattere " + i + " del bf3 = " + (int) bf3[i]);
            v1 = Blocco32.toBinary(bf3[i]);

            for (int j = 0; j < 8; j++) {
                System.out.printf("\nbit n. %d= %d", j, v1[j]);
                m1[r][c] = v1[j];
                c++;
                if (c == 32) {
                    c = 0;
                    r++;
                }
            }
        }

        System.out.println("\nlunghezza dell'array letto : " + bf1.length);
        System.out.println("\nlunghezza dell'array letto : " + bf2.length);
        System.out.println("\nlunghezza dell'array letto : " + bf3.length);

        // CODICE STUDENTE

        Matrice532.Stampa(m, "Matrice originale");
        Matrice532.Stampa(mInit, "Matrice Init");
        Matrice532.Stampa(m1, "Matrice modificata");

        Matrice532.Xor(m, mInit, mImpronta);
        Matrice532.Xor(m1, mInit, mImpronta1);

        Matrice532.Stampa(mImpronta, "Impronta originale");
        Matrice532.Stampa(mImpronta1, "Impronta diversa");

        System.out.println("\nLe differenze tra le due impronte sono " + Matrice532.ContaDifferenze(mImpronta, mImpronta1));

        //

        System.out.println("\nFINE SHA-1 SEMPLIFICATO");
    }
}
