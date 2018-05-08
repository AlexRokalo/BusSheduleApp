package Validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCheck {
    private Pattern patternWay = Pattern.compile("([1-2])");
    private Pattern patternSkin = Pattern.compile("([0-3])");

    public int wayValidater() {
        Scanner scanner = new Scanner(System.in);
        int integerChoice = 0;
        do {
            String choice = scanner.next();
            Matcher matcher = patternWay.matcher(choice);
            if (matcher.find()) {
                integerChoice = Integer.parseInt(choice);
            } else {
                System.out.println("Повторите ввод! " + "\n Необходимо ввести цифру от 1 до 2");
            }
        } while (integerChoice != 1 && integerChoice != 2);

        return integerChoice;
    }

    public int skinValidater() {
        Scanner scanner = new Scanner(System.in);
        int integerChoice = -1;
        do {
            String choice = scanner.next();
            Matcher matcher = patternSkin.matcher(choice);
            if (matcher.find()) {
                integerChoice = Integer.parseInt(choice);
            } else {
                System.out.println("Повторите ввод!" + "\n Необходимо ввести цифру от 0 до 3");
            }
        } while (integerChoice != 0 && integerChoice != 1 && integerChoice != 2 && integerChoice != 3);

        return integerChoice;
    }

}
