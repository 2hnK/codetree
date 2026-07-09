import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N개의 숫자
        int T = Integer.parseInt(st.nextToken()); // T초 후

        int[] list = new int[3 * N];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        T %= 3 * N; // 한 바퀴 도는 경우 처리

        idx = 3 * N - T;
        int[][] arr = new int[3][N];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = list[idx];
                idx++;
                idx %= 3 * N;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
