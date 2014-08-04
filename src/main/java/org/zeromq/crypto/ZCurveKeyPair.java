package org.zeromq.crypto;

import org.zeromq.codec.Z85;

public class ZCurveKeyPair
{
    private String publicKey;
    private String privateKey;

    public ZCurveKeyPair(String publicKey, String privateKey)
    {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public byte[] getPublicKeyBytes()
    {
        return Z85.decoder(publicKey);
    }

    public String getPublicKey()
    {
        return publicKey;
    }

    public byte[] getPrivateKeyBytes()
    {
        return Z85.decoder(privateKey);
    }

    public String getPrivateKey()
    {
        return privateKey;
    }

    @Override
    public String toString()
    {
        return String.format("PublicKey: %s, PrivateKey: %s", publicKey, privateKey);
    }
}
