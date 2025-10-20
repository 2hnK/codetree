import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        char o = sc.next().charAt(0);
        int y = sc.nextInt();
        
        // Please write your code here.
        int res = 0;
        switch (o) {
            case '+':
                res = addition(x, y);
                System.out.println(x + " " + o + " " + y + " = " + res);
                break;
            case '-':
                res = subtraction(x, y);
                System.out.println(x + " " + o + " " + y + " = " + res);
                break;
            case '*':
                res = multiplication(x, y);
                System.out.println(x + " " + o + " " + y + " = " + res);
                break;
            case '/':
                res = division(x, y);
                System.out.println(x + " " + o + " " + y + " = " + res);
            default:
                res = -1;
                System.out.println("False");
                break;
        }
    }

    public static int multiplication(int x, int y) {
        return x * y;
    }

    public static int addition(int x, int y) {
        return x + y;
    }

    public static int subtraction(int x, int y) {
        return x - y;
    }

    public static int division(int x, int y) {
        return x / y;
    }
}