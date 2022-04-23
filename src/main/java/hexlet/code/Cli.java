package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     *Метод просит пользователя ввести имя и возвращает его.
     *
     * @author Evgeny Aleksandrov
     *
     * @version 1.0
     * @return - name of player
     */
    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = SCANNER.next();
        System.out.println("Hello, " + playerName + "!");
    }
}
