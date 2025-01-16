class Solution {
    public int solution(int n) {
        String ternary = "";
        int result = 0;
        
        while (n > 0) {
            ternary = ternary + (n % 3);
            n /= 3;
        }
        
        int power = 0;

        for (int i = ternary.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(ternary.charAt(i));
            result += digit * Math.pow(3, power);
            power++;
        }

        return result;
    }
}