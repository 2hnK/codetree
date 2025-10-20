import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        int x = sc.nextInt();
        int y = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        
        perfectNumber(x, y, set);

        System.out.println(set.size());
        // for(int num : set) {
        //     System.out.print(num + " ");
        // }
    }
    
    public static void perfectNumber(int x, int y, Set set) {
        for(int i = x; i <= y; i++) {
            if ((i % 2 == 0) || (i % 10 == 5) || (i % 3 == 0 && i % 9 != 0)) {
                // System.out.println("continue" + i);
                continue;
            } else {
                set.add(i);
                // System.out.println("add" + i);
            }
        }
    }
}