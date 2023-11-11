package Cifrario;

public class CaesarCipher {
    String message;
    int key;

    public CaesarCipher() {
    }

    public CaesarCipher(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public int getKey() {
        return key;
    }

    public String CryptMessage() {
        String result = "";
        for (char c : message.toCharArray())
            result += CryptChar(c, key);
        return result;
    }

    public String DecryptMessage() {
        String result = "";
        for (char c : message.toCharArray())
            result += DecryptChar(c, key);
        return result;
    }

    protected static char CryptChar(char c, int key) {
        return (char) (((((int) c) - 32 + key) % 90) + 32);
    }

    protected static char DecryptChar(char c, int key) {
        return (char) (((((int) c) - 32 - key) % 90) + 32);
    }

    @Override
    public String toString() {
        return "message: " + message + "\n" +
                "key = " + key + "\n";
    }
}
