// Maximum profit of Bitcoin trading(up to 2 trades)

public static int solution(int[] price) {
        
    int profit = 0;
        
    List<Integer> potential = new ArrayList<>();
    
    int buying = 0;
    int sellingIndex = -1;
        
    for (int i = 0; i < price.length - 1; i++) {
        
        i = sellingIndex+1;
            
        buying = 0;
        sellingIndex = -1;
            
        if (price[i] < price[i + 1]) buying = price[i];
            
        for (int j = (i+1); j < price.length; j++) {
            if(j!=price.length-1) {
                if (price[j] > price[j + 1]) {
                    potential.add(price[j] - buying);
                    sellingIndex = j;
                    break;
                }
            } else {
                if(buying < price[j]) {
                    potential.add(price[j] - buying);
                    sellingIndex = j;
                    break;
                }
            }
        }
    }

    int max = 0;
    
    for(int i=0; i<2; i++) {
        
        max = Collections.max(potential);
        
        if(i==0) {
            for(int j=0; j<potential.size(); j++) {
                if(potential.get(j)==max) {
                    potential.remove(j);
                }
            }
        }
        
        profit += max;
        
    }
        
    return profit;
        
}
