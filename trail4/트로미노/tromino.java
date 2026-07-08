import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        // 2x2 사각형에서 3칸 선택
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int min = Math.min(Math.min(map[i][j], map[i + 1][j]), Math.min(map[i][j + 1], map[i + 1][j + 1]));
                int square = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1] - min;
                max = Math.max(max, square);
            }
        }

        // 세로 3칸
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M; j++) {
                int vertical = map[i][j] + map[i + 1][j] + map[i + 2][j];
                max = Math.max(max, vertical);
            }
        }

        // 가로 3칸
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 2; j++) {
                int hotizontal = map[i][j] + map[i][j + 1] + map[i][j + 2];
                max = Math.max(max, hotizontal);
            }
        }

        System.out.println(max);
    }
}