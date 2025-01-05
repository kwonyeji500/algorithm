import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=number; i++) {
            list.add(getMeasure(i));
        }
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) > limit) {
                list.set(i, power);
            }
        }
        
        for(int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }
        
        return answer;
    }
    
    private int getMeasure(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                count++;
                if (i != number / i) {
                    count++;
                }
            }
        }
        return count;
    }
}