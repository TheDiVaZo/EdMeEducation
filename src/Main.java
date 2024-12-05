import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Pattern PATTERN = Pattern.compile("^([1-9]|10)\\s*([+\\-*/])\\s*([1-9]|10)$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String calc) {
        Matcher matcher = PATTERN.matcher(calc);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format. Please use the format 'number number operator'.");
        }
        int num1 = Integer.parseInt(matcher.group(1));
        char operator = matcher.group(2).charAt(0);
        int num2 = Integer.parseInt(matcher.group(3));

        switch (operator) {
            case '+':
                return String.valueOf(num1 + num2);
            case '-':
                return String.valueOf(num1 - num2);
            case '*':
                return String.valueOf(num1 * num2);
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return String.valueOf(num1 / num2);
            default:
                throw new IllegalArgumentException("Invalid operator. Please use one of '+', '-', '*', or '/'.");
        }
    }
}