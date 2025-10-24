import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        // Please write your code here.
        int[] m31 = {1, 3, 5, 7, 8, 10, 12};
        int[] m30 = {4, 6, 9, 11};
        boolean leapYear = isLeapYear(y);

        // process month 2
        if(m == 2 && leapYear && validDay(d, 29)) printSeason(m);
        else if(m == 2 && !leapYear && validDay(d, 28)) printSeason(m);
        else if(m == 2) System.out.println("-1");

        // process month 1, 3, 5, 7, 8, 10, 12
        for(int x : m31) {
            if(x == m && validDay(d, 31))
                printSeason(m);
            else if(x == m)
                System.out.println("-1");
        }

        // process month 4, 6, 9, 11
        for(int x : m30) {
            if(x == m && validDay(d, 30))
                printSeason(m);
            else if(x == m)
                System.out.println("-1");
        }
    }

    public static boolean isLeapYear(int y) {
        if(y % 4 == 0) {
            if(y % 400 == 0) return true;
            else if(y % 100 == 0) return false;
            return true;
        }
        return false;
    }

    public static void printSeason(int m) {
        if(m >= 3 && m <= 5) {
            System.out.println("Spring");
        } else if(m >= 6 && m <= 8) {
            System.out.println("Summer");
        } else if(m >= 9 && m <= 11) {
            System.out.println("Fall");
        } else if(m == 12 || m >= 1 && m <= 2) {
            System.out.println("Winter");
        }
    }

    public static boolean validDay(int d, int e) {
        if(d >= 1 && d <= e) return true;
        else return false;
    }
}