package hexlet.code;

import java.util.Scanner;

public class Cli {

    private final Scanner scanner = new Scanner(System.in);

    /**
     *Метод просит пользователя ввести имя.
     *
     * @author Evgeny Aleksandrov
     *
     * @version 1.0
     */
    public void enterName() {
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }
}
