
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 친구 이름을 인덱스로 매핑
        Map<String, Integer> friendIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendIndex.put(friends[i], i);
        }

        // 주고받은 선물을 기록할 2차원 배열
        int[][] giftMatrix = new int[n][n];

        // 선물 기록 업데이트
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = friendIndex.get(parts[0]);
            int receiver = friendIndex.get(parts[1]);
            giftMatrix[giver][receiver]++;
        }

        // 다음 달 받을 선물 수 계산
        int[] nextMonthGifts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    // 주고받은 횟수가 같다면 선물 지수를 비교
                    int giftIndexI = getGiftIndex(giftMatrix, i);
                    int giftIndexJ = getGiftIndex(giftMatrix, j);

                    if (giftIndexI > giftIndexJ) {
                        nextMonthGifts[i]++;
                    } else if (giftIndexI < giftIndexJ) {
                        nextMonthGifts[j]++;
                    }
                    // 선물 지수도 같으면 아무도 받지 않음
                }
            }
        }

        // 최대값 반환
        int maxGifts = 0;
        for (int giftsCount : nextMonthGifts) {
            maxGifts = Math.max(maxGifts, giftsCount);
        }

        return maxGifts;
    }

    // 선물 지수 계산 (준 선물 - 받은 선물)
    private int getGiftIndex(int[][] giftMatrix, int person) {
        int given = 0, received = 0;
        for (int i = 0; i < giftMatrix.length; i++) {
            given += giftMatrix[person][i];
            received += giftMatrix[i][person];
        }
        return given - received;
    }
}
