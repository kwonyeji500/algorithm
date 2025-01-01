import java.util.*;

class Solution {
    public int[] solution(String s) {
       Map<Character, Integer> lastSeen = new HashMap<>();
        int[] result = new int[s.length()];
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen.containsKey(c)) {
                result[i] = i - lastSeen.get(c);
            } else {
                result[i] = -1;
            }
            lastSeen.put(c, i);
        }
        return result;
}
}