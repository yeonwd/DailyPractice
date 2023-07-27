import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        List <Integer> list = new ArrayList<>();
        
        for(int i=1; i<food.length; i++) {
            int piece = food[i]/2;
            for(int j=0; j<piece; j++) {
                list.add(i);
            }
        }
        
        for(int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }
        
        answer += "0";
        
        for(int i=list.size()-1; i>=0; i--) {
            answer += list.get(i);
        }
        return answer;
    }
}