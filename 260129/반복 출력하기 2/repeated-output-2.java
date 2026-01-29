import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        helloWorld(n);
    }

    private static void helloWorld(int n) {
        System.out.println("HelloWorld");
        if(n > 1) helloWorld(n-1);
        else return;
    }
}