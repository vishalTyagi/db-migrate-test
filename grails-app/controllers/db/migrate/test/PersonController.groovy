package db.migrate.test

import org.apache.commons.codec.binary.Base64

import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import java.security.InvalidKeyException
import java.security.Key

//import org.bouncycastle.util.encoders.Base64Encoder
class PersonController {
    Cipher cipher
    String algorithm = "AES"//"DESede";
    String KEY = "Bar12345Bar12345"; // 128 bit key

    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

    SecretKey secretKey = keyGenerator.generateKey();

    def index() {
        String text = params.text//"Hello World this is the plain text";
        String key = "Bar12345Bar12345"; // 128 bit key
        // Create key and cipher
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        // encrypt the text
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        println "--------->>> ${new String(encrypted)}";
        // decrypt the text
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(encrypted));
        println "--------------------->>>${decrypted}"
        render(view: "my")
    }

    def two() {
        cipher = Cipher.getInstance("AES");
        keyGenerator.init(128);
        render(view: "two")
    }

    def test() {
        String text = params.text
        String encryptedText = ""
        if (text) {
            Key key = new SecretKeySpec(KEY.getBytes(), algorithm);
            cipher = Cipher.getInstance(algorithm);
            println "----------------------->>> ${text}"
            encryptedText = myEncrypt(text, key);
            println "------>>> encrypted text -->> ${encryptedText}"
        }
        render(view: 'my', model: [encryptedText: encryptedText])
    }

    def test2() {
        String encryptedText = params.encryptedText
        String normalText = ""
        if (encryptedText) {
            Key key = new SecretKeySpec(KEY.getBytes(), algorithm);
            cipher = Cipher.getInstance(algorithm);
            println "----------------------->>> ${encryptedText}"
            normalText = myDecrypt(encryptedText, key);
            println "------>>> decryptrd text -->> ${normalText}"
        }
        render(view: "two", model: [normalText: normalText])
    }

    public String myEncrypt(String plainText, Key key) {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        byte[] byteArray = Base64.encodeBase64(encryptedByte);
        String encryptedText = new String(byteArray)
        return encryptedText;
    }

    public String myDecrypt(String encryptedText, Key key) {
        byte[] decodeBytes = Base64.decodeBase64(encryptedText)
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByte = cipher.doFinal(decodeBytes);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}

