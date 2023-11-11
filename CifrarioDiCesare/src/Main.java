import Cifrario.CaesarCipher;
import Cifrario.VigenereCipher;

public class Main {
    public static void main(String[] args) {
        CaesarCipher cipher=new CaesarCipher("AAAAAAAAAA",6);
        System.out.println("CAESAR CIPHER\n" + cipher.toString() +
                "crypted message: " + cipher.CryptMessage() + "\n");

        VigenereCipher vigenereCipher=new VigenereCipher("AAAAAAAAAA", "hjdtchnwlp");
        System.out.println("VIGENERE CIPHER\n" + vigenereCipher.toString() +
                "crypted message: " + vigenereCipher.CryptMessage() + "\n");
    }
}