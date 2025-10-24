import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        if(validDate(m, d))
            System.out.println("Yes");
        else
            System.out.println("No");
    }


    public static boolean validDate(int m, int d) {
        int[] m31 = {1, 3, 5, 7, 8, 10, 12};
        int[] m30 = {4, 6, 9, 11};

        if(m == 2) return d >= 1 && d <= 28;
        for(int x : m31) if(x == m) return d >= 1 && d <= 31;
        for(int x : m30) if(x == m) return d >= 1 && d <= 30;

        return false;
    }
}