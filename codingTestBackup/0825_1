// Sum of elements in the original array except the i-th element

public static int[] solution(int[] input) {
        
    int[] sum = new int[input.length];
        
    for(int i=0; i<input.length; i++) {

        int temp = 0;

        for(int j=0; j<input.length; j++) {
            if(j!=i) temp += input[j];
        }

        sum[i] = temp;
    }
        
    return sum;
        
}
