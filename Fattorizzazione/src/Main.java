import java.util.Scanner;
import RSA.Factor;
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.println("Inserisci il numero da fattorizzare");
        long num=scan.nextLong();

        Factor factor=new Factor(num);
        factor.Fattorizza();

        System.out.print(factor.toString());
    }
}
