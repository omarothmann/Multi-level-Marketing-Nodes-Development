package OtherTests;

import Main.EncryptDecrypt;
import java.util.Scanner;

public class testing_omar {

   public static void main(String[] args) {
        
       EncryptDecrypt omar = new EncryptDecrypt();
       Scanner s = new Scanner(System.in);
       
       System.out.print("Enter your name: ");
       String name = s.nextLine();
       System.out.println("Name before encryption: " + name);
       
       System.out.print("Name after encryption: ");
       System.out.println(omar.Encrypt(name));
       
       System.out.print("Name after decryption: ");
       System.out.println(omar.Decrypte(omar.Encrypt(name),1234));  //1234 is the password, only company know the password
       
    }
    
}
