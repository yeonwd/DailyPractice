// Maximum profit on Bitcoin trading

public static int solution(int[] price) {
        
    int profit = 0;
    int partialProfit = 0;
    
    for(int i=0; i<price.length; i++) {
            
            if(i!=price.length-1 && price[i]<price[i+1]) {
                
                for(int j=i+1; j<price.length; j++) {
        
                    if(j!=price.length-1) {
                        
                        if(price[j]>price[j+1]) {
                            partialProfit = price[j] - price[i];
                            i=j;
                            break;
                        }
                        
                    } else {
                        
                        if(partialProfit==0) {
                            partialProfit = price[j] - price[i];
                            i=j;
                            break;
                        }
                        
                    }
                }
                
            profit += partialProfit;
            partialProfit = 0;
                
            }
    }
        
    return profit;
        
}
