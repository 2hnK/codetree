import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        // Please write your code here.
        if(isPartial(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean isPartial(int[] a, int[] b) {
        for(int i = 0; i < a.length - b.length; i++) {
            for(int j = 0; j < b.length; j++) {
                if(a[i+j] != b[j])
                    break;
                else if(j == b.length-1)
                    return true;
            }
        }

        return false;
    }
}