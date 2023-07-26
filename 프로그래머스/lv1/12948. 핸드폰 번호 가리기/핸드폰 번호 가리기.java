class Solution {
    public String solution(String phone_number) {
        char[] phoneArray = phone_number.toCharArray();
        
        for (int i = 0; i < phoneArray.length - 4; i++) {
            phoneArray[i] = '*';
        }
        
        return new String(phoneArray);
    }
}
