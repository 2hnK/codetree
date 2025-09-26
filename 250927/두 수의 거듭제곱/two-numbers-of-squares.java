import java.util.Scanner;

public class Main {

    public static int power(int a, int b) {
        return (int)Math.pow(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        System.out.println(power(a, b));
    }
}