package phoenix;
import java.util.*;

public class TwoSum {
    
    public static int[] nums = {2, 7, 11, 15};
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(complementMap.containsKey(complement)){
                return new int[]{i, complementMap.get(complement)};
            }else {
                complementMap.put(nums[i], i);
            }
            
        }
        return null;
    }
    
    public static void main(String... argvs) {
        System.out.println("TwoSum solution: " + twoSum(nums, 13));
    }
}
