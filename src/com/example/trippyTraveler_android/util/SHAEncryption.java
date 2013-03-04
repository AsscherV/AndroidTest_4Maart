package com.example.trippyTraveler_android.util;


import com.sun.jersey.core.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: glenn
 * Date: 26/02/13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public final class SHAEncryption {
    public static String encrypt(String password) {


        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes("UTF-8"));
            byte byteData[] = md.digest();
            return new String(new Base64().encode(byteData), "UTF8");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            //logger.error(e.getMessage());
            throw new RuntimeException("Algorithm not found", e);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            //logger.error(e.getMessage());
            throw new RuntimeException("Encoding not supported", e);
        }
    }
}
