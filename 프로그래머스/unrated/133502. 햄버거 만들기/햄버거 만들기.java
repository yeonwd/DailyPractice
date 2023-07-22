/*
class Solution {
    public int solution(int[] ingredient) {
      
        int answer = burger(ingredient, 0);

        return answer;
    }
    
    public int burger(int[] ingredient, int quantity) {
        
        for (int i = 0; i <= ingredient.length - 4; i++) {
            if (ingredient[i] == 1 && ingredient[i + 1] == 2 && ingredient[i + 2] == 3 && ingredient[i + 3] == 1) {
                quantity++;
                if (ingredient.length > 4) {
                    ingredient = removeUsed(ingredient, i);
                    quantity = burger(ingredient, quantity);
                }
            }
        }
        
        return quantity;
        
    }
    
    public int[] removeUsed(int[] original, int index) {
        int[] adjusted = new int[original.length-4];
        int newIndex = 0;
        for(int i=0; i<original.length; i++) {
            if(i==index) {
                i = i+3;
            }
            else {
                adjusted[newIndex] = original[i];
                newIndex++;
            }
        }
        return adjusted;
    }

}
*/

/*
시간/메모리 초과 - GPT 최적화 코드
import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int quantity = 0;

        int i = 0;
        while (i <= ingredient.length - 4) {
            if (ingredient[i] == 1 && ingredient[i + 1] == 2 && ingredient[i + 2] == 3 && ingredient[i + 3] == 1) {
                quantity++;
                for (int j = i + 4; j < ingredient.length; j++) {
                    ingredient[j - 4] = ingredient[j];
                }
                ingredient = Arrays.copyOf(ingredient, ingredient.length - 4);
                i = 0; // Start over from the beginning after removing elements
            } else {
                i++;
            }
        }

        return quantity;
    }
}
*/

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int patternCount = 0;

        for (int num : ingredient) {
            stack.push(num);

            // Check if the stack contains the pattern "1, 2, 3, 1"
            if (stack.size() >= 4 &&
                stack.get(stack.size() - 4) == 1 &&
                stack.get(stack.size() - 3) == 2 &&
                stack.get(stack.size() - 2) == 3 &&
                stack.get(stack.size() - 1) == 1) {

                // Pop the elements from the stack for the pattern "1, 2, 3, 1"
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();

                // Increment the pattern count
                patternCount++;
            }
        }

        return patternCount;
    }
}
