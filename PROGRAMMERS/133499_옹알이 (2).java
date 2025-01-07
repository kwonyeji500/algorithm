class Solution {
    public int solution(String[] babbling) {
        String[] valid = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for(String b : babbling) {
            String prev = "";
            boolean isValid = true;
            
            while(!b.isEmpty()) {
                boolean found = false;
                
                for (String v : valid) {
                    if(b.startsWith(v) && !prev.equals(v)) {
                        b = b.substring(v.length());
                        prev = v;
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) {
                count++;
            }
        }
        
        return count;
    }
}