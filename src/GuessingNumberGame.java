import java.util.Scanner;
import java.util.Random;

public class GuessingNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get usernames from terminal
        System.out.print("Enter username for player 1: ");
        String user1 = scanner.nextLine();

        System.out.print("Enter username for player 2: ");
        String user2 = scanner.nextLine();

        int score1 = 0;
        int score2 = 0;

        while (score1 < 5 && score2 < 5) {
            // Player 1's turn
            int num1 = random.nextInt(100); // Generate random number between 0 and 99
            int num2 = random.nextInt(100); // Generate random number between 0 and 99
            System.out.println(user1 + ", which number is bigger? " + num1 + " or " + num2 + " ?");
            int answer1 = scanner.nextInt();
            if ((num1 > num2 && answer1 == num1) || (num2 > num1 && answer1 == num2)) {
                score1++;
                System.out.println(user1 + " is correct! Score: " + score1);
            } else {
                System.out.println(user1 + " is incorrect! Score: " + score1);
            }



            // Player 2's turn
            num1 = random.nextInt(100); // Generate random number between 0 and 99
            num2 = random.nextInt(100); // Generate random number between 0 and 99
            System.out.println(user2 + ", which number is bigger? " + num1 + " or " + num2 + " ?");
            int answer2 = scanner.nextInt();
            if ((num1 > num2 && answer2 == num1) || (num2 > num1 && answer2 == num2)) {
                score2++;
                System.out.println(user2 + " is correct! Score: " + score2);
            } else {
                System.out.println(user2 + " is incorrect! Score: " + score2);
            }
            // Check if user1 has won
            if (score1 == 5) {
                break;
            }
            // Check if user2 has won
            if (score2 == 5) {
                break;
            }
        }

        // Determine the winner
        if(score1 == 5 && score2 == 5){
            System.out.println("DRAW");
        }
        else if (score1 == 5) {
            System.out.println(user1 + " is the winner!");
        } else if (score2 == 5) {
            System.out.println(user2 + " is the winner!");
        }

        // Close the scanner
        scanner.close();
    }
}
