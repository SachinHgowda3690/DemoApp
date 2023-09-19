import java.util.Scanner;

class Guesser {
    int guessNum(int min, int max) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guesser kindly guess the number between " + min + " and " + max);
        int guessNum = scan.nextInt();
        return guessNum;
    }
}

class Player {
    String name;

    Player(String playerName) {
        name = playerName;
    }

    int guessNum(int min, int max) {
        Scanner scan = new Scanner(System.in);
        System.out.println(name + ", kindly guess the number between " + min + " and " + max);
        int guessNum = scan.nextInt();
        return guessNum;
    }
}

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void collectNumFromGuesser(int min, int max) {
        Guesser g = new Guesser();
        numFromGuesser = g.guessNum(min, max);
    }

    void collectNumFromPlayers(int min, int max) {
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");

        numFromPlayer1 = p1.guessNum(min, max);
        numFromPlayer2 = p2.guessNum(min, max);
        numFromPlayer3 = p3.guessNum(min, max);
    }

    void compare() {
        if (numFromGuesser == numFromPlayer1 || numFromGuesser == numFromPlayer2 || numFromGuesser == numFromPlayer3) {
            System.out.print("The guesser's number was " + numFromGuesser + ". ");
            if (numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("All players won the game");
            } else if (numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer2) {
                System.out.println("Player 1 & Player 2 won");
            } else if (numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer3) {
                System.out.println("Player 1 & Player 3 won");
            } else if (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("Player 2 & Player 3 won");
            } else if (numFromGuesser == numFromPlayer1) {
                System.out.println("Player 1 won the game");
            } else if (numFromGuesser == numFromPlayer2) {
                System.out.println("Player 2 won the game");
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 3 won the game");
            }
        } else {
            System.out.println("Game lost. Try Again!");
        }
    }
}

public class LaunchGame {
    public static void main(String[] args) {
        Umpire u = new Umpire();
        int minRange = 1;
        int maxRange = 100;  

        boolean playAgain = true;

        while (playAgain) {
            u.collectNumFromGuesser(minRange, maxRange);
            u.collectNumFromPlayers(minRange, maxRange);
            u.compare();

            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = scan.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
    }
}
