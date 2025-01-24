import java.util.*;

public class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private int n, m;
    private boolean[][] visited;
    private int[][] land;

    public int solution(int[][] land) {
        this.n = land.length;
        this.m = land[0].length;
        this.land = land;
        this.visited = new boolean[n][m];

        // 각 열별로 포함된 석유량을 저장할 배열
        int[] oilInColumn = new int[m];

        // BFS를 사용하여 석유 덩어리 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, oilInColumn);
                }
            }
        }

        // 최대 석유량 계산
        int maxOil = 0;
        for (int oil : oilInColumn) {
            maxOil = Math.max(maxOil, oil);
        }

        return maxOil;
    }

    private void bfs(int x, int y, int[] oilInColumn) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> oilCells = new ArrayList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            oilCells.add(cell);

            for (int i = 0; i < 4; i++) {
                int nx = cell[0] + dx[i];
                int ny = cell[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 석유 덩어리의 크기
        int oilSize = oilCells.size();

        // 해당 석유 덩어리가 차지하는 열에 석유량 추가
        Set<Integer> uniqueColumns = new HashSet<>();
        for (int[] cell : oilCells) {
            uniqueColumns.add(cell[1]);
        }
        for (int col : uniqueColumns) {
            oilInColumn[col] += oilSize;
        }
    }
}
