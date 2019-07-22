
package assignment_1;

/**
 *
 * @author Muhammad Talha
 */


public class Assignment_1 {

    
    public static void main(String[] args) {
       
        encrypt secure = new encrypt(); // Making an object
        
        int num = secure.getter(); // Getting a number from the user to secure it or to encrypt it
     
        System.out.println("The number before encryption is : " + num );
        
        secure.encryption(); // encrypting the number entered by the user by using the method "encryption" of class "encrypt"
        
        secure.display(); // Printing the encrypted number by calling the display method
      
}

    


}
