import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> positionCount = new HashMap<>();
        
        for (int[] route : routes) {
            int time = 0; // 로봇마다 time 초기화
            int[] currentPosition = Arrays.copyOf(points[route[0] - 1], 2);
            
            // 출발지 기록
            String key = currentPosition[0] + "," + currentPosition[1] + "," + time;
            positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
            
            for (int i = 1; i < route.length; i++) {
                int[] nextPosition = Arrays.copyOf(points[route[i] - 1], 2);
                
                // r 좌표 이동
                while (currentPosition[0] != nextPosition[0]) {
                    if (currentPosition[0] < nextPosition[0]) {
                        currentPosition[0]++;
                    } else {
                        currentPosition[0]--;
                    }
                    time++;
                    key = currentPosition[0] + "," + currentPosition[1] + "," + time;
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
                
                // c 좌표 이동
                while (currentPosition[1] != nextPosition[1]) {
                    if (currentPosition[1] < nextPosition[1]) {
                        currentPosition[1]++;
                    } else {
                        currentPosition[1]--;
                    }
                    time++;
                    key = currentPosition[0] + "," + currentPosition[1] + "," + time;
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
            }
        }
        
        int dangerCount = 0;
        for (int count : positionCount.values()) {
            if (count > 1) dangerCount++;
        }
        
        return dangerCount;
    }
}