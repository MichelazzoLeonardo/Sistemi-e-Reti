package Cifrario;

public class CifrarioDiCesare {
    protected String messaggio;
    protected int chiave;

    public CifrarioDiCesare() {
    }

    public CifrarioDiCesare(String message, int key) {
        this.messaggio = message;
        this.chiave = key;
    }

    public String CriptaMessaggio() {
        String risultato = "";
        for (char c : messaggio.toCharArray())
            risultato += CriptaCarattere(c, chiave);
        return risultato;
    }

    public String DecriptaMessaggio() {
        String risultato = "";
        for (char c : messaggio.toCharArray())
            risultato += DecriptaCarattere(c, chiave);
        return risultato;
    }

    protected static char CriptaCarattere(char c, int key) {
        char risultato;
        int ascii;

        ascii = c;
        ascii = ascii + key;

        while (ascii > 122)
            ascii = ascii - 91;

        risultato = (char) ascii;
        return risultato;
    }

    protected static char DecriptaCarattere(char c, int key) {
        char risultato;
        int ascii;

        ascii = c;
        ascii = ascii - key;

        while (ascii < 32)
            ascii = ascii + 91;

        risultato = (char) ascii;
        return risultato;
    }

    @Override
    public String toString() {
        return "message: " + messaggio + "\n" +
                "key = " + chiave + "\n";
    }
}
