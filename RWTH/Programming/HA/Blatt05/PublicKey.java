import java.math.BigInteger;

/**
 * Public der RSA verschlüsselung.
 * 
 * @param n Modulus
 * @param d Exponent
 */
public record PublicKey(BigInteger n, BigInteger d) {

    /**
     * Verschlüsselt eine Nachricht mit dem öffentlichen Schlüssel.
     * 
     * @param message Die zu verschlüsselnde Nachricht als BigInteger
     * @return Die verschlüsselte Nachricht als BigInteger
     */
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(d, n);
    }
}