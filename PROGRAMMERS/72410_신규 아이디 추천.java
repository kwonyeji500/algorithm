class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        
        //2단계
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        //3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        
        //4단계
        answer = answer.replaceAll("^\\.|\\.$","");
        
        //5단계
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        //6단계
        answer = answer.substring(0, Math.min(answer.length(), 15));
        answer = answer.replaceAll("\\.$", "");
        
        //7단계
        while(answer.length() < 3) {
            char lastChar = answer.charAt(answer.length() -1);
            answer += lastChar;
        }
        
        return answer;
    }
}