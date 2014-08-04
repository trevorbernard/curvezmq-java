package org.zeromq.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.zeromq.codec.Z85;

import djb.Curve25519;

public class Utils
{
    private Utils()
    {
    }

    public static byte[] random32Bytes() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        return randomNBytes(32);
    }

    public static byte[] randomNBytes(int n) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        sr.nextBytes(new byte[1]); // Ensure it's properly seeded
        byte[] bytes = new byte[n];
        sr.nextBytes(bytes);
        return bytes;
    }

    public static ZCurveKeyPair randomZCurveKeyPair()
    {
        try {
            byte[] pubKey = new byte[32];
            byte[] _ = new byte[32];
            byte[] random = random32Bytes();
            Curve25519.keygen(pubKey, _, random);
            return new ZCurveKeyPair(Z85.encoder(pubKey), Z85.encoder(random));
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(randomZCurveKeyPair());
    }
}
