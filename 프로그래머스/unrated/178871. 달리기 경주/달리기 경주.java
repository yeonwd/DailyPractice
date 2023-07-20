import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        String[] answer = {};
        
        Map <String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String calling : callings) {
            
            int rank = map.get(calling); //불린 선수(추월한 선수)의 등수
            String forwardRunner = players[rank-1]; //추월 당한 선수의 이름
            
            players[rank-1] = calling;
            players[rank] = forwardRunner;
            
            map.put(calling, rank-1);
            map.put(forwardRunner, rank);
            
        }
        
        return players;
    }
}