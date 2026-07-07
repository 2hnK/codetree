import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = check();
        System.out.println(result);
    }

    public static int check() {
        int res = 0;

        for (int i = 0; i < N; i++) {
            int prev = map[i][0];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == prev) {
                    cnt++;
                    if (cnt == M) {
                        // System.out.println("i: " + i + ", j: " + j);
                        res++;
                        break;
                    }
                } else {
                    prev = map[i][j];
                    cnt = 1;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            int prev = map[0][j];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == prev) {
                    cnt++;
                    if (cnt == M) {
                        // System.out.println("i: " + i + ", j: " + j);
                        res++;
                        break;
                    }
                } else {
                    prev = map[i][j];
                    cnt = 1;
                }
            }
        }

        return res;
    }
}