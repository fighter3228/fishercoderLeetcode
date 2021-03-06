package medium;

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {
    
    //then I turned to Discuss and found this post: https://discuss.leetcode.com/topic/55870/share-my-solutions-for-contest-2
    //instead of literally removing half of the elements in each scan, this solution is just moving the pointer to point to next start position
    //So brilliant!
    public int lastRemaining(int n) {
        int remaining = n;
        int start = 1;
        int step = 2;
        boolean forward = true;
        while(remaining > 1){
            remaining /= 2;
            if(forward) start = start + step*remaining - step/2;
            else start = start - step*remaining + step/2;
            step *= 2;
            forward = !forward;
        }
        return start;
    }

    //I tried brute force, all producing the correct output, but got TLE by OJ.
    public static int lastRemaining_brute_force_TLE(int n) {
        List<Integer> list  = new ArrayList();
        for(int i = 0; i < n; i++){
            list.add(i+1);
        }
        boolean forward = true;
        while(list.size() > 1){
            int size = list.size()/2;
            if(list.size() == 1) return list.get(0);
            if(forward){
                if(list.size() == 1) return list.get(0);
                for(int i = 0; i <= size && i < list.size(); i++){
                    list.remove(i);
                }
                forward = false;
            } else {
                if(list.size() == 1) return list.get(0);
                for(int i = list.size()-1, count = 0; i >= 0 && count <= size; count++){
                    list.remove(i);
                    i -= 2;
                }
                forward = true;
            }
        }
        return list.get(0);
    }
    
    public static void main(String...strings){
        System.out.println(lastRemaining_brute_force_TLE(5204));
        System.out.println(lastRemaining_brute_force_TLE(5058));
//        System.out.println(lastRemaining(10));
//        System.out.println(lastRemaining(9));
//        System.out.println(lastRemaining(3));
    }

}
