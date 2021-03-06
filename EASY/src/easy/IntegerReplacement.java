package easy;

import java.util.*;

public class IntegerReplacement {
    
    public static int integerReplacement(int n) {
        long min = Long.MAX_VALUE;
        Set<long[]> set = new HashSet(); 
        Queue<long[]> q = new LinkedList();
        long[] pair = new long[]{n, 0};
        q.offer(pair);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                long[] curr = q.poll();
                if(curr[0] == 1) set.add(curr);
                else {

                    if (curr[0] % 2 == 0) {
                        curr[0] /= 2;
                        curr[1]++;
                        q.offer(curr);
                    } else {
                        long[] minus = new long[2];
                        minus[0] = curr[0] - 1;
                        minus[1] = curr[1] + 1;
                        q.offer(minus);

                        long[] plus = new long[2];
                        plus[0] = curr[0] + 1;
                        plus[1] = curr[1] + 1;
                        q.offer(plus);
                    }
                }
            }
        }
        
        Iterator<long[]> it = set.iterator();
        while(it.hasNext()){
            min = Math.min(min, it.next()[1]);
        }
        return (int) min;
    }
    
    public static void main(String...strings){
        System.out.println(integerReplacement(2147483647));
        System.out.println(integerReplacement(65535));//should be 17
        System.out.println(integerReplacement(1234));//should be 14
//        System.out.println(integerReplacement(1));
//        System.out.println(integerReplacement(2));
//        System.out.println(integerReplacement(3));
        System.out.println(integerReplacement(5));//should be 3
//        System.out.println(integerReplacement(7));
    }
}
