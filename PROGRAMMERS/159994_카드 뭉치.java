import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> oneQue = new LinkedList<>();
        Queue<String> twoQue = new LinkedList<>();
        
        for(String card : cards1) {
            oneQue.add(card);
        }
        
        for(String card : cards2) {
            twoQue.add(card);
        }
        
        for(String str : goal) {
            String one = oneQue.peek();
            String two = twoQue.peek();
            
            if (!str.equals(one) && !str.equals(two)) {
                return "No";
            }
            
            if (str.equals(one)) {
                oneQue.remove();
            } else if (str.equals(two)) {
                twoQue.remove();
            }
        }
        
        return "Yes";
    }
}