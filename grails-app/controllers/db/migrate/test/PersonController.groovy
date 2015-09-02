package db.migrate.test

import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.spec.SecretKeySpec
import java.security.InvalidKeyException
import java.security.Key

//import org.bouncycastle.util.encoders.Base64Encoder
class PersonController {
    Cipher cipher
    String algorithm = "AES"//"DESede";
    String KEY = "Bar12345Bar12345"; // 128 bit key
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
        render(view: "two")
    }

    def test() {
        String text = params.text
        String encryptedText = ""
        if (text) {
            /*KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();*/
            //cipher = Cipher.getInstance("AES");
            /* Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
             Cipher cipher = Cipher.getInstance("AES");
             cipher.init(Cipher.ENCRYPT_MODE, aesKey)
             println "--plain text----->> ${text}"
             encryptedText = new String(cipher.doFinal(text.getBytes()))
 //            encryptedText = encrypt(text, secretKey);
             println "Encrypted Text After Encryption: " + encryptedText
             cipher.init(Cipher.DECRYPT_MODE, aesKey)
             println "-----encrypted text ---->> ${encryptedText}"
             String normalText = new String(cipher.doFinal(encryptedText.bytes))
             println "Decrypted Text After Decryption: " + normalText*/
            Key key = new SecretKeySpec(KEY.getBytes(), algorithm);
            cipher = Cipher.getInstance(algorithm);
            println "----------------------->>> ${text}"
            encryptedText = encrypt1(text, key);
            println "------>>> encrypted text -->> ${encryptedText}"
        }
        render(view: 'my', model: [encryptedText: encryptedText])
    }

    def test2() {
        String encryptedText = params.encryptedText
        String normalText = ""
        if (encryptedText) {
            /*   KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
               keyGenerator.init(128);
               SecretKey secretKey = keyGenerator.generateKey();*//*
            Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey)
            println "-----encrypted text ---->> ${encryptedText}"
            normalText = new String(cipher.doFinal(encryptedText.bytes))
            println "Decrypted Text After Decryption: " + normalText*/
            Key key = new SecretKeySpec(KEY.getBytes(), algorithm);
            cipher = Cipher.getInstance(algorithm);
            println "----------------------->>> ${encryptedText}"
            normalText = decrypt1(encryptedText, key);
            println "------>>> decryptrd text -->> ${normalText}"
        }
        render(view: "two", model: [normalText: normalText])
    }

    /*String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        String encryptedText = new String(encryptedByte)
        *//*Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);*//*
        return encryptedText;
    }

    String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        *//*Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);*//*
        byte[] encryptedTextByte = encryptedText.bytes
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
*/

    private String encrypt1(String input, Key key) throws InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        String encrypt = new String(cipher.doFinal(inputBytes))
        String encodeStr = encrypt.encodeAsBase64()
        return encodeStr;
    }

    private String decrypt1(String encryptionBytes, Key key) throws InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
//        BASE64Decoder base64decoder = new BASE64Decoder();
//        System.out.println(myEncryptionKey);
        byte[] encryptedText = encryptionBytes.decodeBase64()
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(encryptedText);
        String recovered = new String(recoveredBytes);
        return recovered;
    }
}
