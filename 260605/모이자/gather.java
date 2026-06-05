import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) { // i: 모이는 장소
            int val = 0; // 이동 거리의 합

            for (int j = 0; j < N; j++) { // j: 탐색 노드
                if(i == j) continue;
                val += arr[j] * (Math.abs(i - j));
            }

            if (val < min) min = val;
        }

        System.out.println(min);
    }
}