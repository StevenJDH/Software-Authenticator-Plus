/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Steven Jenkins De Haro
 */

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder; //BASE64Decoder is internal proprietary API and may be removed in a future release. Cane be replaced with Apache commons.
import sun.misc.BASE64Encoder; //BASE64Encoder is internal proprietary API and may be removed in a future release. Cane be replaced with Apache commons.


public class AES {
    
     private static final String ALGO = "AES";
     private static final byte[] keyValue = new byte[] { 'h', 'X', '6', 'g', 'g', 's', 'Y', '5', 'j', '8', 'a','8', 'P', 'Z', 'd', 'A' };
    
public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher chiper = Cipher.getInstance(ALGO);
        chiper.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = chiper.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher chiper = Cipher.getInstance(ALGO);
        chiper.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = chiper.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}
