package fotistsiou.java.last_pencil.step_2;

import java.util.Scanner;

/**
 * New rules
 * ---------
 * Description
 * Your friend's suggestion surprised you a little bit. After a couple of "No, you" retaliations, you decided that it
 * would be more convenient to input the initial conditions to determine who goes first, and how many pencils there
 * are on the table.
 * ---------
 * Objectives
 * Write a program that will satisfy the conditions below:
 * 1. Ask users to input the number of pencils with the How many pencils string. Read the number;
 * 2. Ask users to input who goes first from the two possible players. To do so, output the Who will be the first
 *    (*Name1*, *Name2*) string. You can ask a user to choose from any two names that consist of the letters of the English alphabet and numbers (for example, John and Jack). Read the name;
 * 3. Print two lines: one with vertical bar symbols representing the input number of pencils, the other with the
 *    *NameX* is going first string.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        String pencils = scanner.nextLine();
        System.out.println("Who will be the first (Player 1, Player 2):");
        String firstPlayer = scanner.nextLine();
        for (int i = 1; i <= Integer.parseInt(pencils); i++) {
            System.out.print('|');
        }
        System.out.println();
        System.out.println(firstPlayer + " is going first!");
    }
}
