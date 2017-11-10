import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA12 {
    static BigInteger P,Q,N,Phi,E,D;
    static int bitlength = 1024;
    static Random R;

    public static byte[] encrypt(byte[] b){
        return (new BigInteger(b).modPow(D,N).toByteArray());
    }

    public static byte[] decrypt(byte[] b){
        return (new BigInteger(b).modPow(E,N).toByteArray());
    }

    public static void main(String[] args) {
        R=new Random();
        P=BigInteger.probablePrime(bitlength,R);
        Q=BigInteger.probablePrime(bitlength,R);
        E=BigInteger.probablePrime(bitlength/2,R);
        N=P.multiply(Q);
        Phi=P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));

        while(Phi.gcd(E).compareTo(BigInteger.ONE)>0&&E.compareTo(Phi)<0)
            E.add(BigInteger.ONE);
        D=E.modInverse(Phi);
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the String");
        String message=in.nextLine();
        System.out.println("Entered String is "+message);
        byte[] messagebytes=message.getBytes();

        System.out.println("The message in bytes is ");
        for(byte b:messagebytes)
            System.out.print(b+" ");
        byte[] encrypted=encrypt(messagebytes);

        String encryptedString=new String(encrypted);

        System.out.print("\nThe encrypted String is ");
        System.out.println(encryptedString);

        String decryptedString = new String(decrypt(encrypted));

        System.out.println("The decrypted string is "+decryptedString);
    }

}
