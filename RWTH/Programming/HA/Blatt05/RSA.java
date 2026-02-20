import java.math.BigInteger;
import java.util.Random;

/**
 * RSA Klasse zur Erzeugung von Public- und Private-Keys
 * @author Miguel Mendez
 */
public class RSA {

    /** 
    * Private Attribute der RSA Klasse   
    */
    private BigInteger d;

    private BigInteger e;

    private BigInteger n;

    /**
     * Konstruktor der RSA Klasse  
     * @param p
     * @param q
     */
    public RSA(BigInteger p, BigInteger q) {
        this.n = p.multiply(q);
        this.e = RSA.generateCoprime(RSA.eulerPhi(p, q));
        this.d = this.e.modInverse(RSA.eulerPhi(p, q));
    }

    /**
     * Konstruktor der RSA Klasse  
     * @param p
     * @param q
     */
    public RSA(long p, long q){

        BigInteger a = new BigInteger(Long.toString(p));
        BigInteger b = new BigInteger(Long.toString(q));
        
        this.n = a.multiply(b);
        this.e = RSA.generateCoprime(RSA.eulerPhi(a, b));
        this.d = this.e.modInverse(RSA.eulerPhi(a, b));
 
    }

    /**
     * Methode zur Erzeugung eines PublicKeys
     * @return PublicKey
     */
    public PublicKey publicKey() {
        return new PublicKey(this.n, this.d);
    }

    /**
     * Methode zur Erzeugung eines PrivateKeys
     * @return PrivateKey
     */
    public PrivateKey privateKey() {
        return new PrivateKey(this.n, this.e);
    }

    /**
     * Methode zur Berechnung der Eulerschen Phi Funktion
     * @param p
     * @param d
     * @return Eulersche Phi Funktion
     */
    public static BigInteger eulerPhi(BigInteger p, BigInteger d) {
        
        BigInteger f = p.subtract(BigInteger.ONE);
        BigInteger g = d.subtract(BigInteger.ONE);

        return new BigInteger("1").multiply(f).multiply(g);
    }

    /**
     * Methode zum Vergleichen zweier BigInteger
     * @param a
     * @param b
     * @return true wenn a < b, sonst false
     */
    public static boolean lessThan(BigInteger a, BigInteger b) {
        return a.compareTo(b) < -1 ? true : false;
    }

    /**
     * Methode zur Generierung einer Zahl die teilerfremd zu x ist
     * @param x
     * @return Zahl e, die teilerfremd zu x ist
     */
    public static BigInteger generateCoprime(BigInteger x) {

        if (lessThan(x, BigInteger.ONE) || x.equals(BigInteger.ONE)) {
            return new BigInteger("69");
        }
       
        BigInteger e = new BigInteger(x.bitLength(), new Random()); 
        
        while (e.gcd(x).equals(BigInteger.ONE)? false : true) {
            e = new BigInteger(x.bitLength(), new Random()); 
        }

        return e;
    }

}