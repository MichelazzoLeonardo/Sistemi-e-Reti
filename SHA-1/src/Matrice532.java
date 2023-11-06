public class Matrice532 {
    public static void Stampa(int[][] maux, String commento) {
        System.out.println("\n" + commento);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 32; j++)
                System.out.print(maux[i][j] + " ");
            System.out.println();
        }
    }

    public static void Xor(int[][] maux1, int[][] maux2, int[][] mImpronta) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 32; j++)
                mImpronta[i][j] = maux1[i][j] ^ maux2[i][j];
    }

    public static int ContaDifferenze(int[][] maux1, int[][] maux2) {
        int counter = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 32; j++)
                if (maux1[i][j] != maux2[i][j])
                    counter++;
        return counter;
    }
}
