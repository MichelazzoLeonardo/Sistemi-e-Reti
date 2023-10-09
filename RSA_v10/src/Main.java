/*
programma per verificare il funzionamento dell'algoritimo RSA
Versione 1.0 : semplice calcolo numerico con numeri piccoli
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.printf("PROGRAMMA PER DESCRIVERE IL FUNZIONAMENTO DELL'RSA");

        Scanner input;
        long   p,q;
        long  N,V,Npri,Npub=-1;
        long   m; // messaggio da trasmettere (numero)
        long   c; // messaggio criptato (numero)
        long m1 ; // messaggio decriptato (numero)

        input = new Scanner(System.in);

        System.out.println("Inserire il valore di p (deve essere numero primo) : ");
        p= input.nextInt();

        System.out.println("Inserire il valore di q (deve essere numero primo) : ");
        q= input.nextInt();

        N=p*q;

        V=(p-1)*(q-1);

        System.out.println("Valore di N  : "+N);
        System.out.println("Valore di V  : "+V);

        System.out.println("Inserire il valore di Npri (non deve avere fattori comuni con V) : ");
        // per decidere calcoliamo i fattori di V cioè cerchiamo i divisori interi di V
        // quindi scansioniamo tutti gli interi fino a V/2 e vediamo se danno modulo 0
        System.out.print("fattori di V = ");
        for(int k=1 ; k<=(V/2) ; k++)
            if (V%k==0)
                    System.out.print(k+"\t");

        Npri= input.nextInt();

        // ricerca dell'Npub tale per cui (Npub*Npri)%V=1
        for(int i=1;i<=V;i++)
            if(((i*Npri)%V)==1)
                Npub=i;
        if (Npub==-1)
            System.out.println(("PROBLEMA!! non trovo una Npub"));
        else
            System.out.println("TROVATA!! Npub = "+ Npub);

        System.out.println("Kpub  = ("+N+","+Npri+")");
        System.out.println("Kpri (destinatario) = ("+N+","+Npub+")");

        System.out.println(("Inserire il messaggio da trasmettere (numero) : "));
        m=input.nextInt();

        c=((long)Math.pow(m,Npri))%N;   // N ed Npub costituiscono la chiave pubblica

        System.out.println("Messaggio (numero) criptato : "+c);

        m1=((long)Math.pow(c,Npub))%N;

        System.out.println("Messaggio (numero) decriptato : "+m1);

        System.out.println("FINE PROGRAMMA RSA" );
        }
    }
