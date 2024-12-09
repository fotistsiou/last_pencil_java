package fotistsiou.java.last_pencil.step_5;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * The right strategy
 * ------------------
 * Description
 * You've played a couple of games with your friend. After a while, you both found out that if there are 2, 3, or 4
 * pencils left on the table, you automatically win. It happens because a player can take 1, 2, or 3 pencils and
 * leave the other player with only one. The other player has nothing left but to take the last pencil and lose the game.
 * On the other hand, if you have 5 pencils on the table, you lose. You can take 1, 2, or 3 pencils, your friend will
 * then take 1, 2, or 3 pencils as well leaving you with the last pencil. So, it will again lead to the situation
 * described above but vice-versa.
 * The same thing happens when there are 6, 7, or 8 pencils left on the table. It will eventually repeat all over again.
 * It's easier to get a grasp of it with a line of 10 slash-bar symbol pencils. In this example, we can be sure that if both
 * players know the winning strategy, the first one will be the winner. Here is a game process:
 * /|||/|||/|
 * The first player has an advantage and takes 1 pencil:
 * /|||/|||/
 * The second player has a disadvantage, so if the second player takes any number of pencils from 1 to 3, the first player
 * is left with a winning strategy:
 * 1: /|||/|||
 * 2: /|||/||
 * 3: /|||/|
 * The first player stands in a winning position and takes that number. It will lead to a losing position for the second player:
 * /|||/
 * The second player stands in a losing position — if the second player takes any number of pencils from 1 to 3, the
 * first player will be left in a winning position:
 * 1: /|||
 * 2: /||
 * 3: /|
 * The first player stands in a winning position and takes the right number of pencils. It leaves the second player
 * with one pencil:
 * /
 * Your friend came up with the idea of creating a bot to make the game a bit more replayable. Instead of taking input
 * from two players, you need to program a bot that follows a winning strategy. If the bot's position isn't the winning
 * one, you can program it to take any number of pencils (1, 2, or 3) at random. You can also come up with any pattern
 * of your own for the losing position.
 * To make it easier to understand, the logic of the bot could look like this:
 * If the bot is in a losing position, the outcome of the game does not depend on his action, so if the number of
 * pencils on the table in his turn is:
 * - 5,9,13,17... - bot takes a random number of pencils from 1 to 3
 * - 1 - bot takes the last pencil and loses
 * If the bot is in a winning position, his goal is to take as many pencils to put his opponent in a losing position,
 * so if the number of pencils on the table in his turn:
 * - 4,8,12,16... - bot takes 3 pencils
 * - 3,7,11,15... - bot takes 2 pencils
 * - 2,6,10,14... - bot takes 1 pencil
 * ------------------
 * Objectives
 * Implement the bot for the second of the two possible players. For example, in Who will be the first (John, Jack)
 * John is the user and Jack is the bot (and will always be the bot).
 * So, if the player chooses Jack as the first player, after that input, the bot's move should be printed.
 * Your final objective is to expand your program. Write a solution, that can be executed for any initial number of pencils.
 * Check each iteration whose turn is now. If it is the bot, instead of requiring input from the second player, output
 * one line that contains the bot's move (1, 2 or 3) that follows the winning strategy. If the bot is not in the winning
 * position, make it follow any pattern of your liking, as the tests check only the bot's winning position.
 * ------------------
 * Hint
 * Jack is ALWAYS the bot, no matter if he is the first or second player.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define Initial Number of Pencils
        int pencils = defineInitialNumberPencils(scanner);

        // Define First Player
        String player = defineFirstPlayer(scanner);

        // Print Initial Table
        printTable(pencils);

        // Running the game
        while (pencils > 0) {
            // Player Movement
            int turn = takePencils(scanner, pencils, player);

            // Player Movement execution
            pencils -= turn;
            player = Objects.equals(player, "P1") ? "P2" : "P1";
            printTable(pencils);

            // Game Over
            if (pencils == 0) {
                System.out.println(player + " won!");
                break;
            }
        }

        scanner.close();
    }

    static void printTable(int pencils) {
        if (pencils > 0) {
            System.out.println("|".repeat(pencils));
        }
    }

    static int defineInitialNumberPencils(Scanner scanner) {
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String pencilStr = scanner.nextLine();
            if (pencilStr.matches("\\d+")) {
                int pencils = Integer.parseInt(pencilStr);
                if (pencils == 0) {
                    System.out.println("The number of pencils should be positive");
                    continue;
                }
                return pencils;
            } else {
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    static String defineFirstPlayer(Scanner scanner) {
        System.out.println("Who will be the first (P1, P2):");
        while (true) {
            String player = scanner.nextLine();
            if (Objects.equals(player, "P1") || Objects.equals(player, "P2")) {
                return player;
            } else {
                System.out.println("Choose between 'P1' and 'P2'");
            }
        }
    }

    static int takePencils(Scanner scanner, int pencils, String player) {
        System.out.println(player + "'s turn:");
        if (Objects.equals(player, "P1")) {
            while (true) {
                String movementStr = scanner.nextLine();
                if (movementStr.matches("[123]")) {
                    int movement = Integer.parseInt(movementStr);
                    if (movement > pencils) {
                        System.out.println("Too many pencils were taken");
                        continue;
                    }
                    return movement;
                } else {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            }
        }
        return botMovement(pencils);
    }

    static int botMovement(int pencils) {
        // The bot is in a winning position OR takes the last pencil
        if (pencils == 1 || pencils == 2 || ((pencils - 2) % 4) == 0) {
            System.out.println(1);
            return 1;
        }
        if (pencils == 3 || ((pencils - 3) % 4) == 0) {
            System.out.println(2);
            return 2;
        }
        if (pencils == 4 || ((pencils - 4) % 4) == 0) {
            System.out.println(3);
            return 3;
        }

        // The bot is in a losing position
        Random random = new Random();
        int botMovement = random.nextInt(3) + 1;
        System.out.println(botMovement);
        return botMovement;
    }
}
