import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minKeyPresses = new HashMap<>();
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                minKeyPresses.put(c, Math.min(
                    minKeyPresses.getOrDefault(c, Integer.MAX_VALUE), i+1));
            }
        }
        
        int[] result = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            String target = targets[i];
            int totalKeyPresses = 0;
            for(char c : target.toCharArray()) {
                if(!minKeyPresses.containsKey(c)) {
                    totalKeyPresses = -1;
                    break;
                }
                totalKeyPresses += minKeyPresses.get(c);
            }
            result[i] = totalKeyPresses;
        }
        return result;
    }
}