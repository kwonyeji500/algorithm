class Solution {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i=0; i<10; i++) {
            if (s.contains(arr[i])) {
                s = s.replaceAll(arr[i], i + "");
            }
        }
        
        return Integer.valueOf(s);
    }
}