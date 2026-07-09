import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N개의 숫자
        int T = Integer.parseInt(st.nextToken()); // T초 후

        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        T %= 2 * N;

        for (int i = 0; i < T; i++) {
            int temp = arr1[N - 1];

            for (int j = N - 1; j >= 1; j--) {
                arr1[j] = arr1[j - 1];
            }

            arr1[0] = arr2[N - 1];

            for (int j = N - 1; j >= 1; j--) {
                arr2[j] = arr2[j - 1];
            }
            arr2[0] = temp;
        }

        // input
        StringBuilder sb = new StringBuilder();
        for (int x : arr1) {
            sb.append(x).append(" ");
        }
        sb.append("\n");
        for (int x : arr2) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
