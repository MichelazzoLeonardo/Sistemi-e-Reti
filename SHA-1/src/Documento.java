// classe per la gestione del documento di cui ricavare il digest (impronta)
import java.io.*;

public class Documento {
    final int MAX=20;
    private String nomeDocumento;
    private File f;

    public Documento(String nome) {
        nomeDocumento=nome;
        f = new File(nomeDocumento);

    }



    public char[] leggiBlocco() throws IOException {
        // metodo che legge 160 bit = 20 caratteri da 8 bit restituiti come array di char
        char[] buffer;
        FileReader fr;
        BufferedReader br;
        int size;

        fr = new FileReader(f);
        buffer = new char[MAX];  // per leggere 160 bit devo leggere 160/8=20 caratteri
        buffer[0]='\0';
        br=new BufferedReader(fr);
        size = br.read(buffer);
        if (size!=160)
            System.out.println("ERRORE NELLA DIMENSIONE DEL BUFFER LETTO!!");
        else
            System.out.println("dimension del buffer : "+size);

        return buffer ;
    }
}
