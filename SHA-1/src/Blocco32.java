import java.nio.charset.StandardCharsets;

/*
Classe per la gestione del Blocco da 32 bit
 */
public class Blocco32 {
    private String s;   // la stringa è fatta da 4 caratteri letti dal file


    public Blocco32(String s1) {
        this.s=s1;
    }
    public String stampa() {
        return s;
    }

    static public int[] toBinary(char ch) {
        // metodo per prendere un carattere e convertirlo in un array da 8 bit
        // che rappresenta il suo valore binario
        int[] v;
        v=new int[8];
        String s1;

        System.out.println("Valore binario del "+ch +"=" +Integer.toBinaryString((int)ch));
        s1 = Integer.toBinaryString((int)ch);
        System.out.println("Lugghezza stemp = "+s1.length());
        if (s1.length()<8) {
            int l=8-s1.length();
            int k;
            for ( k = 1; k <= l ; k++)
                s1 = "0" + s1;
        }
        System.out.println("Lunghezza stemp = "+s1.length());

        for (int i=0;i<8;i++) {
            v[i] = s1.charAt(i);

        }

        for(int i=0;i<8;i++){
            v[i] = ((v[i]==49)?1:0);
        }

        return v;
    }
}
