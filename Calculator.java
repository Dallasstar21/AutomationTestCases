/**
 * Created by Anton on 17.12.16.
 */
import java.util.*;
import java.math.*;

public class Calculator {

    public static void entry () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int a = in.nextInt();
        System.out.print("Введите операцию (+, -, *, /, sqrt, ^2): ");
        String s = in.next();

        if (s.equals("sqrt") || s.equals("^2")) {
            calculation(a, 0, s);
        }
        else {
            System.out.print("Введите еще одно целое число: ");
            int b = in.nextInt();
            calculation(a, b, s);
        }
    }

    public static void calculation (int n1, int n2, String symb) {
        double res = 0;
        switch (symb) {
            case "+": res = n1 + n2; break;
            case "-": res = n1 - n2; break;
            case "*": res = n1 * n2; break;
            case "/": res = (double) n1 / n2; break;
            case "sqrt": res = Math.sqrt(n1); break;
            case "^2": res = Math.pow(n1, 2); break;
            default: System.out.println("Вы ввели не верную операцию"); break;
        }
        System.out.println("Ответ: " + res);
    }

    public static void main(String[] args) {
        entry();
    }
}
