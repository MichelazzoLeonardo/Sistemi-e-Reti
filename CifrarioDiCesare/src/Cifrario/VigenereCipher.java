package Cifrario;

import java.util.Arrays;

public class VigenereCipher extends CaesarCipher {
    String alphabeticKey;
    int[] numericKey;

    public VigenereCipher(String message, String key) {
        this.message = message;
        this.alphabeticKey = key;
        this.numericKey=TranslateKey();
    }

    public String getAlphabeticKey() {
        return alphabeticKey;
    }

    public int[] getNumericKey() {
        return numericKey;
    }

    public String CryptMessage() {
        String result = "";
        for (int i = 0; i < message.length(); i++)
            result += CryptChar(message.charAt(i), numericKey[i%numericKey.length]);
        return result;
    }

    public String DecryptMessage() {
        String result = "";
        for (int i = 0; i < message.length(); i++)
            result += DecryptChar(message.charAt(i), numericKey[i%numericKey.length]);
        return result;
    }

    private int[] TranslateKey() {
        int[] result = new int[alphabeticKey.length()];
        for (int i = 0; i < result.length; i++)
            result[i] = (int) (Character.toUpperCase(alphabeticKey.charAt(i))) - 64;
        return result;
    }

    @Override
    public String toString() {
        return "message: " + message + "\n" +
                "alphabetic key=" + alphabeticKey + "\n" +
                "numeric key=" + Arrays.toString(numericKey) + "\n";
    }
}
