package Main;

import java.util.Base64;

public class EncryptDecrypt {
    
   public String Encrypt(String plain) {
   String encoded = Base64.getEncoder().encodeToString(plain.getBytes());

   // Reverse the string
   String reverse = new StringBuffer(encoded).reverse().toString();

   StringBuilder tmp = new StringBuilder();
   final int OFFSET = 4;
   for (int i = 0; i < reverse.length(); i++) {
      tmp.append((char)(reverse.charAt(i) + OFFSET));
   }
   return tmp.toString();
}
    
   public String Decrypte(String secret ,int password) {
       
   if (password == 1234){
    StringBuilder tmp = new StringBuilder();
    final int OFFSET = 4;
    for (int i = 0; i < secret.length(); i++) {
      tmp.append((char)(secret.charAt(i) - OFFSET));
   }

   String reversed = new StringBuffer(tmp.toString()).reverse().toString();
   return new String(Base64.getDecoder().decode(reversed));
   }
   else
       return "The Key is Incorrect!";
   
}
    
}
