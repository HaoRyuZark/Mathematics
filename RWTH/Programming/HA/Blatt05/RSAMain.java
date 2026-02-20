import java.math.BigInteger;

public class RSAMain {

  public static void main(String[] args) {
    long p = 53503;
    long q = 91957;

    RSA rsa = new RSA(p,q);
    PublicKey publicKey = rsa.publicKey();
    PrivateKey privateKey = rsa.privateKey();

    IO.println("PUBLIC KEY");
    IO.println("n: " + publicKey.n());
    IO.println("d: " + publicKey.d());
    IO.println();


    IO.println("PUBLIC PRIVATE");
    IO.println("n: " + privateKey.n());
    IO.println("e: " + privateKey.e());
    IO.println();

    IO.println("ENCRYPT");
    BigInteger m = BigInteger.valueOf(100000);
    BigInteger encrypted = publicKey.encrypt(m);
    IO.println(encrypted);
    IO.println();

    IO.println("DECRYPT");
    BigInteger decrypted = privateKey.decrypt(encrypted);
    IO.println(decrypted);
    IO.println();
  }
}
