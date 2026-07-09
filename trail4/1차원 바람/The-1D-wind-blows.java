import java.util.*;
import java.io.*;

public class Main {

    public static int N, M, Q;
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
            int row = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);

            shiftRow(row, dir);
            propagateUp(row, dir);
            propagateDown(row, dir);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 행 shift 함수
    public static void shiftRow(int row, char dir) {
        if (dir == 'L') {
            int temp = map[row][M - 1];
            for (int i = M - 1; i > 0; i--) {
                map[row][i] = map[row][i - 1];
            }
            map[row][0] = temp;
        } else if (dir == 'R') {
            int temp = map[row][0];
            for (int i = 0; i < M - 1; i++) {
                map[row][i] = map[row][i + 1];
            }
            map[row][M - 1] = temp;
        }
    }

    // 인접한 열 확인 함
    public static boolean sameCheck(int row1, int row2) {
        for (int i = 0; i < M; i++) {
            if (map[row1][i] == map[row2][i]) {
                return true;
            }
        }

        return false;
    }

    public static void propagateUp(int curRow, char curDir) {
        int nextRow = curRow - 1;
        if (nextRow < 0)
            return;
        if (sameCheck(curRow, nextRow)) {
            char nextDir = (curDir == 'L') ? 'R' : 'L';
            shiftRow(nextRow, nextDir);
            propagateUp(nextRow, nextDir);
        }
    }

    public static void propagateDown(int curRow, char curDir) {
        int nextRow = curRow + 1;
        if (nextRow >= N)
            return;
        if (sameCheck(curRow, nextRow)) {
            char nextDir = (curDir == 'L') ? 'R' : 'L';
            shiftRow(nextRow, nextDir);
            propagateDown(nextRow, nextDir);
        }
    }
}