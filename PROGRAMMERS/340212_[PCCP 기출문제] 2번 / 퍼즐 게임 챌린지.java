class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canSolveWithinLimit(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean canSolveWithinLimit(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        
        for (int i=0; i<diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = i > 0 ? times[i-1] : 0;
            
            if (diff <= level) {
                totalTime += time_cur;
            } else {
                int mistakes = diff - level;
                totalTime += (long) mistakes * (time_cur + time_prev) + time_cur;
            }
            
            if (totalTime > limit) {
                return false;
            }
        }
        return totalTime <= limit;
    }
}