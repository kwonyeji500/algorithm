class Solution {
    public int solution(int[] players, int m, int k) {
        int totalCount = 0;
        int currentServer = 0;
        int[] increaseServer = new int[24];
        
        for (int i=0; i<24; i++) {
            int requiredServer = players[i] / m;
            
            if (i >= k) {
                currentServer -= increaseServer[i - k];
            }
            
            if (currentServer < requiredServer) {
                int increase = requiredServer - currentServer;
                increaseServer[i] = increase;
                currentServer = requiredServer;
                totalCount += increase;
            }
        }
        
        return totalCount;
    }
}