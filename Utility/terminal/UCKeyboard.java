package DoubleNumericIntegrate.Utility.terminal;
import java.util.Scanner;

public class UCKeyboard {
    private static final Scanner scanner = new Scanner(System.in);
    public static String nextLine(){
        return scanner.nextLine();
    }
    public static int nextInt(){
        int result = Integer.parseInt(nextLine());
        return result;
    }
    public static void pressEnterToContinue(){
        String tmp = nextLine();
    }
}
