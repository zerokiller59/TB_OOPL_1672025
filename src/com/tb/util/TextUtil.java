package com.tb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author Velz
 */
public class TextUtil {

    public static boolean isEmptyField(TextInputControl... textFields) {
        for (TextInputControl tic : textFields) {
            if (tic.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static String SHAHash(String password) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).
                        substring(1));
            }

//        System.out.println("Hex format : " + sb.toString());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TextUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}
