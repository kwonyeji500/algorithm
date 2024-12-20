import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        // 지갑 크기
        int walletWidth = Math.max(wallet[0], wallet[1]);
        int walletHeight = Math.min(wallet[0], wallet[1]);

        // 지폐 크기
        int billWidth = Math.max(bill[0], bill[1]);
        int billHeight = Math.min(bill[0], bill[1]);

        // 지폐가 지갑에 들어갈 수 있을 때까지 반복
        while ((billWidth > walletWidth || billHeight > walletHeight) &&
               (billWidth > walletHeight || billHeight > walletWidth)) {
            // 긴 쪽을 반으로 접음
            if (billWidth >= billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }

            // 접는 횟수 증가
            answer++;
        }

        return answer;
    }
}