import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map <String, Integer> tMap = new HashMap<>();
        tMap = getTermMap(tMap, terms);
        
        int todays = calToday(today);
        
        ArrayList<Integer> result = new ArrayList<>();
        
                
        for(int i=0; i<privacies.length; i++) {
            
            String[] temp = privacies[i].split(" ");
            
            String[] datetemp = temp[0].split("\\.");
            int year = Integer.parseInt(datetemp[0]);
            int month = Integer.parseInt(datetemp[1]);
            int day = Integer.parseInt(datetemp[2]);

            int registered = (year - 2000) * 12 * 28 + month * 28 + day;

            int expired = tMap.get(temp[1]);
                        
            if(todays-registered>=expired) result.add(i+1);
            
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public Map<String, Integer> getTermMap(Map <String, Integer> tMap, String[] terms) {
        
        for(int i=0; i<terms.length; i++) {
            String[] temp = terms[i].split(" ");
            tMap.put(temp[0], Integer.parseInt(temp[1])*28);
        }
        
        return tMap;
    }
    
    
    public int calToday(String today) {
        
        String[] temp = today.split("\\.");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);

        int totalDays = (year - 2000) * 12 * 28 + month * 28 + day;

        return totalDays;
    }

}