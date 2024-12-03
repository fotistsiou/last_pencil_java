package fotistsiou.java.last_pencil.step_4;

import java.util.Objects;
import java.util.Scanner;

/**
 * Fair play
 * ---------
 * Description
 * The game was interesting, but it went sour. No one was playing a fair game! You've taken 10 pencils, your friend
 * decided that it is unfair and somehow took a negative number! Moreover, you both can't decide which of you won.
 * Maybe, it's time to add new rules to the game.
 * ---------
 * Objectives
 * In this stage, your task is to add a new level of control over the game. Check the input. If it's incorrect, print
 * the reason why. Also, limit the possible amount of pencils taken. Let's say that players can remove not more than
 * 3 pencils at a time.
 * Here are possible errors and their feedback:
 * 1. The initial number of pencils is not a numeric string, so it can't be converted to an integer — The number of pencils should be numeric;
 * 2. The initial number of pencils is equal to 0 — The number of pencils should be positive;
 * 3. If the input is a negative amount, apply condition (1), as the minus sign is not a numeric;
 * 4. If the chosen first player is not *Name1* or *Name2* — Choose between *Name1* and *Name2*;
 * 5. One of the players has taken the number of pencils that differs from 1, 2, or 3 — Possible values: '1', '2' or '3';
 * 6. One of the players has taken more pencils than there are on the table — Too many pencils were taken.
 * If one of the errors occurs, ask for input once again. Please note that when an error occurs, you don't need to
 * print whose turn it is. Just output the error feedback (see the examples below).
 * Don't forget to help determine the winner of the game. The player who takes the last pencil loses the game.
 * Print out the result at the end of the game with the line *Winner-name* won!
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pencils = definePencils(scanner);
        scanner.nextLine();
        System.out.println("Who will be the first (P1, P2):");
        String player = scanner.nextLine();
        printTable(pencils);
        while (pencils > 0) {
            System.out.println(player + "'s turn:");
            int turn = scanner.nextInt();
            pencils -= turn;
            printTable(pencils);
            player = Objects.equals(player, "P1") ? "P2" : "P1";
        }
        scanner.close();
    }

    static void printTable(int pencils) {
        for (int i = 0; i < pencils; i++) {
            System.out.print('|');
        }
        System.out.println();
    }

    static int definePencils(Scanner scanner) {
        System.out.println("Enter the number of pencils: ");
        while (true) {
            try {
                int pencils = scanner.nextInt();
                if (pencils <= 0) {
                    System.out.println("The number of pencils should be positive");
                    scanner.nextLine();
                    continue;
                }
                return pencils;
            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
                scanner.nextLine();
            }
        }
    }
}
