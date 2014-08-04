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

    public byte[] getPublicBytes()
    {
        return Z85.decoder(publicKey);
    }

    public byte[] getPrivateBytes()
    {
        return Z85.decoder(privateKey);
    }
    
    @Override
    public String toString()
    {
        return String.format("PublicKey: %s, PrivateKey: %s", publicKey, privateKey);
    }
}
