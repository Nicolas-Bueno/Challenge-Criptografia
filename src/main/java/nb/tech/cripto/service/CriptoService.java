package nb.tech.cripto.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CriptoService {

    private static final StrongTextEncryptor encryptor;

    static{
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("APP_KEY"));
    }

    public static String encrypt(String rawText) {
        return encryptor.encrypt(rawText);
    }

    public static String dencrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }
}
