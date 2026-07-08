import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int totalgold = 0;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) totalgold++;
            }
        }

        int max = 0;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int n = 0; n <= 2 * (N - 1); n++) {
                    if(max == totalgold) break outer;

                    int gold = search(i, j, n);
                    int penalty = (int) (Math.pow(n, 2) + Math.pow(n + 1, 2));

                    if (gold * M - penalty >= 0)
                        max = Math.max(max, gold);
                }
            }
        }

        System.out.println(max);
    }

    public static int search(int r, int c, int size) {
        int gold = 0;

        for (int i = -size; i <= size; i++) {
            int d = size - Math.abs(i);
            for (int j = -d; j <= d; j++) {
                int nr = r + i;
                int nc = c + j;

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    gold++;
                }
            }
        }

        return gold;
    }
}