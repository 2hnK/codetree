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

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (isHappyLine(i, true))
                result++;
            if (isHappyLine(i, false))
                result++;
        }
        System.out.println(result);
    }

    public static boolean isHappyLine(int index, boolean isRow) {
        if (M == 1)
            return true;

        int count = 1;

        for (int i = 1; i < N; i++) {
            int current = isRow ? map[index][i] : map[i][index];
            int previous = isRow ? map[index][i - 1] : map[i - 1][index];

            if (current == previous)
                count++;
            else
                count = 1;

            if (count >= M)
                return true;
        }

        return false;
    }
}