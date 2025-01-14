class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += (long) price * i;
        }

        long rack = totalPrice - money;

        return rack < 0 ? 0 : rack;
    }
}
