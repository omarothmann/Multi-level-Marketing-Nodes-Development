package Main;

import java.util.Scanner;

public class TestOmar {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        EncryptDecrypt test = new EncryptDecrypt();
        
        String name;
        int key;
        
        System.out.print("Enter your name: ");
        name = s.nextLine();
        
        System.out.println("Name after encryption: " + test.Encrypt(name) );
        
        System.out.print("Enter key to decrypt: ");
        key = s.nextInt();
        test.Decrypte(test.Encrypt(name), key);
        
        System.out.println("Name after decryption: " + name);
        
        
        
        
        
    }
    
}
