class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;
        while (n >= a) {
            int bottle = n/a;
            int remain = n%a;
            
            count += bottle*b;
            n = remain + (bottle * b);
        }
        
        return count;
    }
}