import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for (int i=left; i<=right; i++) {
            List<Integer> divisor = divisors(i);
            if (divisor.size()%2==0) {
                result += i;
            } else {
                result -= i;
            }
        }
    
        return result;
    }
    
    private List<Integer> divisors(int n) {
        List<Integer> divisorList = new ArrayList<>();
        for (int i=1; i*i<=n; i++) {
            if (n%i==0) {
                divisorList.add(i);
                if(i!=n/i) {
                    divisorList.add(n/i);
                }
            }
        }
        return divisorList;
    }
}