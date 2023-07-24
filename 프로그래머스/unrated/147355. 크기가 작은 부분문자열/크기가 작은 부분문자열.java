import java.util.*;

/*

class Solution {
    public int solution(String t, String p) {
        
        int answer = 0;
        
        // int pvalue = Integer.parseInt(p);
        // int: 최대 10자리
        long pvalue = Long.parseLong(p);
        
        int pindex = p.length();
        
        int[] tArray = new int[t.length()];
        
        // int t > int 배열
        for (int i = 0; i < t.length(); i++) {
            tArray[i] = Character.getNumericValue(t.charAt(i));
        }
        
        // p가 한 자리 숫자일 때
        if(pindex==1) {
            for(int i=0; i<tArray.length; i++) {
                if(tArray[i]<=pvalue) answer++;
            }
            
        // p가 10 이상일 때
        } else {

            for(int i=0; i<tArray.length-(pindex-1); i++) {
                
                // p의 자릿수와 같은 자릿수의 부분문자열
                int num = getSubArray(i, tArray, pindex);
                if(num<=pvalue) answer++;  

            }
        }
        
        return answer;
    }
    
    public int getSubArray(int index, int[] tArray, int pindex) {
        
        int[] subArray = new int[pindex];
        
        for(int i=0; i<pindex; i++) {
            subArray[i] = tArray[index+i];
        }
        
        String temp = "";
        for(int i=0; i<subArray.length; i++) {
            temp += subArray[i];
        }
        
        return Integer.parseInt(temp);
    }
}

*/


// 런타임 에러로 풀이 참고 후 다시 풀이

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pnum = Long.parseLong(p);
        
        for(int i=0; i<t.length(); i++) {
            if(i<=t.length()-p.length()) {
               String temp = t.substring(i, i + p.length());
                if(Long.parseLong(temp) <= pnum) answer++;
            }
        }
        
        return answer;
    }
}