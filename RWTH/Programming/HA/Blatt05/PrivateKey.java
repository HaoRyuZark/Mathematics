import java.math.BigInteger;

/**
 * Private Key von der RSA-Verschluesselung
 *
 * @param n der Modulus
 * @param e der private Exponent
 */
public record PrivateKey(BigInteger n, BigInteger e) {

    /**
     * Entschluesselt eine Nachricht mit dem privaten Exponenten
     *
     * @param cypher die zu entschluesselnde Nachricht
     * @return die entschluesselte Nachricht
     */
    public BigInteger decrypt(BigInteger cypher) {
        return cypher.modPow(e, n);
    }
}