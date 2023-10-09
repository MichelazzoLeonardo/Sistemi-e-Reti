package RSA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Factor {
    private long numero;
    private List<Long> fattori;

    public Factor(long numero) {
        this.numero = numero;
        fattori=new ArrayList<Long>();
    }

    public void Fattorizza(){
        if (numero == 1)
            fattori.add(1L);
        else
            Fattorizza(numero);

        if(!CheckFactors()){
            fattori.clear();
            fattori.add(-1L);
        }
    }
    private void Fattorizza(long n){
        for (long i = 2; i <= n; i++)
            if (n % i == 0) {
                fattori.add(i);
                Fattorizza(n / i);
                break;
            }
    }
    private boolean CheckFactors(){
        long result=1;
        for (long value:this.fattori)
            result*=value;

        return result==numero;
    }

    @Override
    public String toString() {
        return "Numero da Fattorizzare: "+numero+"\nFattori: "+fattori.toString();
    }
}
