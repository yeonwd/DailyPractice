// Rank calculation of the card game

public static int solution(int[] cards) {

    Arrays.sort(cards);
    
    int aceIndex = hasAce(cards);
    int rank = -1;
    
    if(aceIndex!=-1) {
        if(!qualifiedAce(cards)) {
            rank = 9;
        } else rank = getRank(cards, aceIndex);
    } else rank = getRank(cards, aceIndex);
    
    return rank;
}

public static int getRank(int[] cards, int aceIndex) {
    
    int rank = -1;
    
    if(rank1(cards)) rank=1;
    else if(rank2(cards)) rank=2;
    else if(rank3(cards)) rank=3;
    else if(rank4(cards)) rank=4;
    else if(rank5(cards, aceIndex)) rank=5;
    else if(rank6(cards)) rank=6;
    else if(rank7(cards)) rank=7;
    else if(rank8(cards)) rank=8;
    else rank=9;
    
    return rank;
}

public static boolean rank1(int[] cards) {

    boolean flag = false;

    if(isSameSuit(cards)) {
        for(int i=0; i<cards.length-1; i++) {
            if(cards[i]+1 == cards[i+1]) flag=true;
        }
    }
    
    return flag;
}

public static boolean rank2(int[] cards) {

    boolean flag = false;
    
    Set <Integer> set1 = new HashSet<>();
    Set <Integer> set2 = new HashSet<>();
    
    set1.add(cards[0]);
    
    int[] set = new int[4];
    for(int i=1; i<cards.length; i++) {
        
        int[] temp = {cards[0], cards[i]};
        
        if(isSameSuit(temp)) set1.add(cards[i]);
        else set2.add(cards[i]);
        
    }
    
    int index = 0;
    
    if(set1.size()==4) {
        for(int i : set1) {
            set[index] = i;
            index++;
        }
    } else if(set2.size()==4) {
        for(int i : set2) {
            set[index] = i;
            index++;
        }
    }
    
    if(isSet(set)) flag = true;
    
    return flag;
}

public static boolean rank3(int[] cards) {
    
    boolean flag = false;
    
    Set <Integer> set1 = new HashSet<>();
    Set <Integer> set2 = new HashSet<>();
    
    set1.add(cards[0]);
    
    for(int i=1; i<cards.length; i++) {
        int[] temp = {cards[0], cards[i]};
        if(isSet(temp)) {
            set1.add(cards[i]);
        } else {
            set2.add(cards[i]);
        }
    }
    
    int index = 0;
    
    int[] temp1 = new int [set1.size()];
    int[] temp2 = new int [set2.size()];
    
    for(int i : set1) {
        temp1[index] = i;
        index++;
    }
    
    index = 0;
    
    for(int i : set2) {
        temp2[index] = i;
        index++;
    }
    
    if(isSet(temp1) && isSet(temp2)) {
        flag = true;
    }
    return flag;
}

public static boolean rank4(int[] cards) {
    
    if(isSameSuit(cards)) return true;
    else return false;
    
}

public static boolean rank5(int[] cards, int aceIndex) {
    
    boolean flag = false;
    int increment = 13;
    
    if(aceIndex!=-1) {
        if(qualifiedAce(cards)) {
            
            int[] sorted = new int [4];
            int index = 0;
            
            for(int i=0; i<cards.length; i++) {
                if(i!=aceIndex) {
                    sorted[index] = cards[i];
                    index ++;
                }
            }
            
            for(int i=0; i<sorted.length-1; i++) {
                if(sorted[i] + increment == sorted[i+1]) {
                    flag = true;
                    increment ++;
                } else {
                    flag = false;
                    break;
                }
            }               
        }
    }
    
    return flag;
    
}

public static boolean rank6(int[] cards) {
    
    boolean flag = false;
    
    Set <Integer> set1 = new HashSet<>();
    Set <Integer> set2 = new HashSet<>();
    
    int card = cards[0];
    set1.add(card);
    
    for(int i=1; i<cards.length; i++) {
        int[] temp = {card, cards[i]};
        if(isSet(temp)) set1.add(cards[i]);
        else set2.add(cards[i]);
    }
    
    int[] temp1 = new int[set1.size()];
    int[] temp2 = new int[set2.size()];
    
    int index = 0;
    
    if(set1.size()==3) {
        
        for(int i : set1) {
            temp1[index] = i;
            index++;
        }
        
        if(isSet(temp1)) flag = true;
        
    } else if(set2.size()==3) {
        
        for(int i: set2) {
            temp2[index] = i;   
            index++;
        }
        
        if(isSet(temp2)) flag = true;
        
    }
    
    return flag;
    
}

public static boolean rank7(int[] cards) {
    
    boolean flag = false;
    
    int count = 0;
    
    for(int i=0; i<cards.length; i++) {
        for(int j=0; j<cards.length; j++) {
            if(j!=i) {
                int[] temp = {cards[i], cards[j]};
                if(isSet(temp)) count++;
            }
        }
    }
    
    count = count/2;
    if(count==2) flag = true;
    
    return flag;
    
}

public static boolean rank8(int[] cards) {
    
    boolean flag = false;
    
    int count = 0;
    
    for(int i=0; i<cards.length; i++) {
        for(int j=0; j<cards.length; j++) {
            if(j!=i) {
                int[] temp = {cards[i], cards[j]};
                if(isSet(temp)) count++;
            }
        }
    }
    
    count = count/2;
    if(count==1) flag = true;
    
    return flag;
    
}

public static boolean isSameSuit(int[] cards) {
    
    int lastIndex = cards.length-1;
    
    if(cards[0]>=0 && cards[lastIndex]<=12) return true;
    else if(cards[0]>=13 && cards[lastIndex]<=25) return true;
    else if(cards[0]>=26 && cards[lastIndex]<=38) return true;
    else if(cards[0]>=39 && cards[lastIndex]<=51) return true;
    
    return false;
}

public static boolean isSet(int[] cards) {
    
    boolean flag = false;
    
    Arrays.sort(cards);
    
    int card = cards[0];
    
    for(int i=1; i<cards.length; i++) {
        if(card==cards[i]-13 || card==cards[i]-26 || card==cards[i]-39) { flag = true;
        } else {
            flag = false;
            break;
        }
    }
    
    return flag;   
 
}

public static int hasAce(int[] cards) {
    
    int aceIndex = -1;
    
    for(int i=0; i<cards.length; i++) {
        if(cards[i]==0 || cards[i]==13 || cards[i]==26 || cards[i]==39) {
            aceIndex = i;
            break;
        }
    }
    
    return aceIndex;   
}

public static boolean qualifiedAce(int[] cards) {

    boolean isQualified = false;
    
    for(int i=0; i<cards.length; i++) {
        if(cards[i]==1 || cards[i]==14 || cards[i]==27 || cards[i] == 40 || cards[i]==12 || cards[i]==25 || cards[i]==38 || cards[i]==51) {
                isQualified = true;
                break;
            }
    }
    
    return isQualified;
}
