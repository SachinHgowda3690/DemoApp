import java.util.Scanner;

class Guesser1 {
    int guessNum(int min, int max) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guesser kindly guess the number between " + min + " and " + max);
        int guessNum = scan.nextInt();
        return guessNum;
    }
}

class Players {
    String name;

    Players() {
        name = "";
    }

    void setName(String playerName) {
        name = playerName;
    }

    int guessNum(int min, int max) {
        Scanner scan = new Scanner(System.in);
        System.out.println(name + ", kindly guess the number between " + min + " and " + max);
        int guessNum = scan.nextInt();
        return guessNum;
    }
}

class Umpires {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void collectNumFromGuesser(int min, int max) {
        Guesser1 g = new Guesser1();
        numFromGuesser = g.guessNum(min, max);
    }

    void collectNumFromPlayers(int min, int max, Players[] playersArray) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println("Enter the name for Player " + (i + 1) + ":");
            String playerName = scan.nextLine();
            playersArray[i] = new Players();
            playersArray[i].setName(playerName);
        }

        numFromPlayer1 = playersArray[0].guessNum(min, max);
        numFromPlayer2 = playersArray[1].guessNum(min, max);
        numFromPlayer3 = playersArray[2].guessNum(min, max);
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
        }}
    void showSummary(int round, int[] playerScores, Players[] playersArray) {
        System.out.println("Round " + round + " Summary:");
        for (int i = 0; i < playerScores.length; i++) {
            System.out.println(playersArray[i].name + ": " + playerScores[i] + " points");
        }
    }
}

public class Game {
    public static void main(String[] args) {
        Umpires u = new Umpires();
        int minRange = 1;
        int maxRange = 100;  
        int numPlayers = 3;
        int[] playerScores = new int[numPlayers];
        Players[] playersArray = new Players[numPlayers];

        boolean playAgain = true;
        int round = 1;

        while (playAgain) {
            u.collectNumFromGuesser(minRange, maxRange);
            u.collectNumFromPlayers(minRange, maxRange, playersArray);
            u.compare();

            
            for (int i = 0; i < numPlayers; i++) {
                if ((u.numFromGuesser == u.numFromPlayer1 && u.numFromPlayer1 == playersArray[i].guessNum(minRange, maxRange))
                        || (u.numFromGuesser == u.numFromPlayer2 && u.numFromPlayer2 == playersArray[i].guessNum(minRange, maxRange))
                        || (u.numFromGuesser == u.numFromPlayer3 && u.numFromPlayer3 == playersArray[i].guessNum(minRange, maxRange))) {
                    playerScores[i]++;
                }
            }

            u.showSummary(round, playerScores, playersArray);
            round++;

            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = scan.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
    }
}
