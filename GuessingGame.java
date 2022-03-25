package guessinggame;

//*********************************************
//GuessingGame.java
//
//Takes a range and tries to guess the number
//the user is thinking
//*********************************************
import java.util.Scanner;

public class GuessingGame {

  public static void main(String[] args) {
        
    //Declare some variables
    int lowBound, highBound, middle1, middle2;
    int counter = 0;
    String answer;
    Scanner scan = new Scanner(System.in);
        
        //Get the range
    System.out.println("Enter lower bound: ");
    lowBound = scan.nextInt();
    System.out.println("Enter upper bound: ");
    highBound = scan.nextInt();
    middle1 = highBound / 3;
    middle2 = (2 * (highBound) / 3);
    System.out.println("Think of a number!");
        
    //Guess the number
    while(lowBound < highBound){
      System.out.println("Enter A if between " + lowBound + " and " + middle1);
      System.out.println("Enter E1 if equals " + middle1);
      System.out.println("Enter B if between " + middle1 + " and " + middle2);
      System.out.println("Enter E2 if equals " + middle2);
      System.out.println("Enter C if between " + middle2 + " and " + highBound);
      answer = scan.next();
      if (answer.equals("A") || answer.equals("a")){
        middle1 = middle1 / 3;
        middle2 = (2 * middle1);
        highBound = highBound / 3;
        counter++;
      }
      else if (answer.equals("B") || answer.equals("b")){
        lowBound = middle1;
        middle1 = middle1 + ((middle2 - middle1)/3);
        middle2 = middle2 - ((middle2 - middle1)/3);
        highBound = middle2;
        counter++;
      }
      else if (answer.equals("C") || answer.equals("c")){
        lowBound = middle2;
        middle1 = middle2 + ((highBound - middle2) / 3);
        middle2 = highBound - ((highBound - middle2) / 3);
        counter++;
      }
      else if (answer.equals("E1") || answer.equals("E2") || answer.equals("e1") || answer.equals("e2")){
        System.out.println("I guessed your number in " + (counter +1) + " guesses!");
        lowBound = highBound + 1;
      }
    }    
  }    
}

