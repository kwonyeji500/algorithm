import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> resultSet = new TreeSet<>();
        
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            answer[index++] = num;
        }
        
        return answer;
    }
}