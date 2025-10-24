import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        // Please write your code here.
        boolean leapYear = isLeapYear(y);

        if(!validMonth(m)) {
            System.out.println("-1");
            return;
        }

        int maxDay = getMaxDay(y, m);

        if(d >= 1 && d <= maxDay)
            printSeason(m);
        else
            System.out.println("-1");
    }

    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    public static void printSeason(int m) {
        if(m >= 3 && m <= 5) {
            System.out.println("Spring");
        } else if(m >= 6 && m <= 8) {
            System.out.println("Summer");
        } else if(m >= 9 && m <= 11) {
            System.out.println("Fall");
        } else
            System.out.println("Winter");
    }

    public static boolean validMonth(int m) {
        return m >= 1 && m <= 12;
    }

    public static int getMaxDay(int y, int m) {
        if (m == 2)
            return isLeapYear(y) ? 29 : 28;
        else if (m == 4 || m == 6 || m == 9 || m == 11)
            return 30;
        else
            return 31;
    }
}