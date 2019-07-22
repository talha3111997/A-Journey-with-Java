
package assignment_1;

/**
 *
 * @author Muhammad Talha
 */
import java.util.Scanner ;
public class encrypt {
    
    /* Making the variables as fields of the class or declaring them globally  
    */
    private static int unit_place;
    private static int tens_place ; 
    private static int hundreds_place ;
    private static int thousands_place ;
    private static int user_value ;
     
    // Making the getter method to take input from the user for better programing practice
    int getter (){
     int count_mistakes = 0 ; // To take the input from the user until the user enters correct value
     String user_string ; // Taking the input from the user in the string form 
     do {
            if (count_mistakes > 0 ){
                // So that the loop runs only if the user enters a wrong input otherwise loop runs only once.
                count_mistakes--;
                
            }
                System.out.print("Enter the 4 digit number you want to encrypt : ");
                Scanner input = new Scanner(System.in);
         user_string = input.next(); // Taking input of a word from the user
       
        if (user_string.length()> 4){
            System.out.println("You have entered a wrong input. Please try again.");
             count_mistakes++ ;
             /* So that if the length of the string becomes greater than 4 digits then the loop
             runs again and ask the user to enter correct number of digits */
        }
        
        } while(count_mistakes != 0);
   
 user_value = Integer.parseInt(user_string); // Converting the string into the integer form to work or manipulate with integers
  digits();  // So that the 4 digit number can be splited into separate digits
 
 return user_value;
    }
    
   void setter (int to_set){
   user_value = to_set ;
   digits ();  // So that the 4 digit number can be splited into separate digits
   } 
    
   void digits (){
     // The method which is being used to separate the 4 digits number into different digits
    
     unit_place = user_value % 10 ;   // Fourth digit 
       
     tens_place = (user_value / 10) % 10 ;   // Third digit
     
     hundreds_place = ((user_value / 10 ) / 10 )% 10 ;// Second digit 
     
     thousands_place = ((user_value / 10 ) / 10 ) / 10 ;  // First digit
   
   }
   
   void encryption (){
    unit_place += 7 ;  // just adding 7 to each digit
    tens_place += 7;
    hundreds_place += 7 ;
    thousands_place += 7 ;
    
    unit_place %= 10 ;  // after adding 7 , taking the modulus of each digit with 10
    tens_place %= 10 ;
    hundreds_place %= 10 ;
    thousands_place %= 10 ;
    
    tens_place = swap (thousands_place , thousands_place = tens_place); // just swapping
    unit_place = swap (hundreds_place , hundreds_place = unit_place);
   
   }
   
   int swap ( int num1 , int num2 ){
  return num1 ;
   }
   
   // A simple method to get things on the screen or to print the result
   void display (){
   System.out.println("The entered number in the encrypted form is : " + thousands_place + 
           hundreds_place + tens_place + unit_place);
      
   System.out.println("Thanks");
   
   }
}
