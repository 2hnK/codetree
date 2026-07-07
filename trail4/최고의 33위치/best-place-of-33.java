import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println(Arrays.deepToString(map));

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.println("i: " + i + ", j: " + j);

                int temp = check(i, j);
                result = Math.max(result, temp);
            }
        }

        System.out.println(result);
    }

    // 3*3 격자 범위 탐색
    public static int check(int row, int col) {
        int res = 0;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                // System.out.println("r: " + r + ", c: " + c);

                if (r >= n || c >= n)
                    continue;

                if (map[r][c] == 1)
                    res++;
            }
        }

        return res;
    }
}