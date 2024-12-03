package fotistsiou.java.last_pencil.step_3;

import java.util.Objects;
import java.util.Scanner;

/**
 * Working on the gameplay
 * -----------------------
 * Description
 * An interesting idea has come to your mind. Let's change the rules of game. Players take turns taking X pencils until
 * none of them remain.
 * -----------------------
 * Objectives
 * Expand your program by creating a loop. Each player takes turns removing pencils until 0 pencils remain on the table.
 * Each iteration prints 2 lines: lines with pencils (vertical bars) and whose turn is now by printing the *NameX*'s
 * turn string. If there are no pencils left after a player's move, the loop breaks and the game ends without any
 * additional output.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Who will be the first (P1, P2):");
        String player = scanner.nextLine();
        printTable(pencils);
        while (pencils > 0) {
            System.out.println(player + "'s turn:");
            int turn = scanner.nextInt();
            scanner.nextLine();
            if (turn <= pencils) {
                pencils -= turn;
                printTable(pencils);
                player = Objects.equals(player, "P1") ? "P2" : "P1";
            }
        }
        scanner.close();
    }

    static void printTable(int pencils) {
        for (int i = 0; i < pencils; i++) {
            System.out.print('|');
        }
        System.out.println();
    }
}
