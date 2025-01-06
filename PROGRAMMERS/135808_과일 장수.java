import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        // 점수를 내림차순으로 정렬
        Arrays.sort(score);
        
        int totalProfit = 0;
        int n = score.length;
        
        // 상자에 m개씩 담기
        for (int i = n - m; i >= 0; i -= m) {
            // 가장 낮은 점수 (최소값)으로 상자 가격 결정
            int boxPrice = score[i] * m;
            totalProfit += boxPrice;
        }
        
        return totalProfit;
    }
}
