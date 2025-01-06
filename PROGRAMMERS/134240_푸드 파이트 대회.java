class Solution {
    public String solution(int[] food) {
        String result = "0";
        
        for(int i=food.length-1; i>=1; i--) {
            int f = food[i]/2;
            String add = String.valueOf(i).repeat(f);
            result = add + result + add;
        }
        return result;
    }
}