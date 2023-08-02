import java.util.*;

// 시간복잡도 

// class Solution {
//     public int[] solution(int[] numbers) {
        
//         List<Integer> list = new ArrayList<>();
        
//         for(int i=0; i<numbers.length; i++) {
//             int result = 0;
//             for(int j=i+1; j<numbers.length; j++) {
//                 if(numbers[i] < numbers[j]) {
//                     result = numbers[j];
//                     break;
//                 }
//             }
//                if(result!=0) list.add(result);
//                 else list.add(-1);
//         }
        
//         /*
//             list.stream List를 stream으로 변환
//             mapToInt(Integer::intValue) Integer.intValue() 메소드로 stream 요소를 int로 매핑해 stream에 저장
//             toArray() stream의 요소를 int[] 배열로 변환
//         */
            
//         int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
//         return answer;

//     }
// }


import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        // Traverse the input array
        for (int i = 0; i < numbers.length; i++) {
            // While the stack is not empty and the current number is greater than the number at the top of the stack
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                // Pop the index at the top of the stack
                int index = stack.pop();
                // Set the answer for the number at the popped index to the current number
                answer[index] = numbers[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // After traversing the array, there may be elements left in the stack without a next greater element
        // Set their answer to -1
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = -1;
        }

        // Return the answer array with the next greater elements for each number in the input array
        return answer;
    }
}
