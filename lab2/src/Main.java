import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение корректно: ");
        String str = in.nextLine();
        Calculations calc = new Calculations();
        String ans = calc.calculationsWithChecking(str, 0, str.length() - 1);
        System.out.println(str + ": "  + ans);
        System.out.print("Unit-тесты: \n");
        UnitTest test = new UnitTest();
        test.calculations();
    }
}