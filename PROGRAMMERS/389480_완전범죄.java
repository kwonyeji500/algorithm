import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int INF = 99999; // 충분히 큰 값으로 초기화

        // DP 배열 선언 (크기를 n+1, m+1로 설정)
        int[][][] dp = new int[itemCount + 1][n + 1][m + 1];

        // DP 배열을 큰 값으로 초기화
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, INF);
            }
        }

        // 초기 상태 (아무 물건도 훔치지 않은 상태에서 A 흔적 0)
        dp[0][0][0] = 0;

        // DP 테이블 채우기
        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0]; // A 도둑이 남기는 흔적
            int bTrace = info[i][1]; // B 도둑이 남기는 흔적

            for (int a = 0; a <= n; a++) {
                for (int b = 0; b <= m; b++) {
                    if (dp[i][a][b] == INF) continue; // 기존 경로가 없으면 건너뛰기

                    // A 도둑이 훔치는 경우
                    int newA = Math.min(a + aTrace, n);
                    int newB = b;
                    dp[i + 1][newA][newB] = Math.min(dp[i + 1][newA][newB], dp[i][a][b] + aTrace);

                    // B 도둑이 훔치는 경우
                    newA = a;
                    newB = Math.min(b + bTrace, m);
                    dp[i + 1][newA][newB] = Math.min(dp[i + 1][newA][newB], dp[i][a][b]);
                }
            }
        }

        // 정답 찾기 (A가 남긴 최소 흔적)
        int answer = INF;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[itemCount][a][b] != INF) {
                    answer = Math.min(answer, dp[itemCount][a][b]);
                }
            }
        }

        return (answer == INF) ? -1 : answer;
    }
}