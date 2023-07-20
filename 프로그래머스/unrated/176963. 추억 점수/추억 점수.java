import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        Map <String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++) {
            int score = 0;
            for(int j=0; j<photo[i].length; j++) {
                String nameOfPic = photo[i][j];
                score += map.getOrDefault(nameOfPic, 0); //그리움 점수가 없을 때 핸들링
            }
            answer[i] = score;
        }
        
        return answer;
    }
}