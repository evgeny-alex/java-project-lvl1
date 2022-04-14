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
    public static String enterAndGetName() {
        return SCANNER.next();
    }
}
