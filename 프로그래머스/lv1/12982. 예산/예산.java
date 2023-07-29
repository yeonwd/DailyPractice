import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        int answer = 0;
        int accepted = 0;
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++) {
            
            int temp = d[i];
            int potentially = accepted + temp;
            
            if(potentially<=budget) {
                accepted = potentially;
                answer++;
            } else break;
            
        }
        
        return answer;
    }
}