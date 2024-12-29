class Solution {
    public String solution(String s, String skip, int index) {
        String result = "";
        for (char ch : s.toCharArray()) {
            int idx = index;
            while (idx > 0) {
                ch = (++ch > 'z') ? 'a' : ch;
                
                if(!skip.contains((String.valueOf(ch)))) {
                    idx--;
                }
            }
            result += ch;
        }
        return result;
    }
}