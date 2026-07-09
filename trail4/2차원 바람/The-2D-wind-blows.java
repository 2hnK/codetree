import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, Q;
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0, -1 };
    public static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        Q = Integer.parseInt(st.nextToken()); // 바람 수

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            rotate(r1, c1, r2, c2);
            setAvg(r1, c1, r2, c2);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static void rotate(int r1, int c1, int r2, int c2) {
        int temp = map[r1][c1];

        for (int i = r1; i < r2; i++) {
            map[i][c1] = map[i + 1][c1];
        }

        for (int i = c1; i < c2; i++) {
            map[r2][i] = map[r2][i + 1];
        }

        for (int i = r2; i > r1; i--) {
            map[i][c2] = map[i - 1][c2];
        }

        for (int i = c2; i > c1; i--) {
            map[r1][i] = map[r1][i - 1];
        }

        map[r1][c1 + 1] = temp;
    }

    public static void setAvg(int r1, int c1, int r2, int c2) {
        int[][] temp = new int[N][M];

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int val = map[i][j];
                int count = 1;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;

                    count++;
                    val += map[nr][nc];
                }

                val = val / count;
                temp[i][j] = val;
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }
}