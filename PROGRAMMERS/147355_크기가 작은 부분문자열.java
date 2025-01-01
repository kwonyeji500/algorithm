class Solution {
    public int solution(String t, String p) {
        int length = p.length();
        long num = Long.parseLong(p);
        int result = 0;
        
        for (int i=0; i<t.length() - length + 1; i++) {
            long diff = Long.parseLong(t.substring(i, i + length));
            if (diff <= num) result++;
        }
        return result;
    }
}