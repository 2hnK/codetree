import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int count = 0;
        for(int i = a; i <= b; i++) {
            if(isPrime(i) && isEven(i))
                count++;
        }

        System.out.println(count);
    }

    public static boolean isPrime(int x) {
        if(x == 1) return false;

        for(int i = 2; i < x; i++) {
            if(x % i == 0)
                return false;
        }

        return true;
    }

    public static boolean isEven(int x) {
        int sum = 0; // 각 자리수의 합
        int num = x;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }

        if(sum % 2 != 0)
            return false;
        else
            return true;
    }
}