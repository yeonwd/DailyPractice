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

/*
    일부 성공, 일부 시간 초과 실패한 코드

    class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        for(int i=0; i<callings.length; i++) {
            String name = callings[i];
            for(int j=0; j<players.length; j++) {
                if(players[j].equals(name)) {
                    String temp = players[j-1];
                    players[j-1] = players[j];
                    players[j] = temp;
                }
            }
        }
        return players;
    }
}
*/
    
}
