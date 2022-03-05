package array;

public class FindFirstnLastPosInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] searchRange(int[] nums, int target) {
		/*
		 * divide in two section, to find left and right & identify mid in each iteration
		 * compare target's position relative to mid and move the right/left w.r.t to mid accordingly
		 * logic will differ at the point when mid = target in finding left vs right 
		 */
		int[] retArr = new int[2];
		retArr[0] = 0;
		retArr[1] = 0;		
        if(nums.length == 0){
        	retArr[0] = -1;
        	retArr[1] = -1;
        	return retArr;
        }
        retArr[0] = findLeftMostIndex(nums, target);
        if(retArr[0] == -1){
        	retArr[1] = -1;
        	return retArr;
        }
        retArr[1] = findRightMostIndex(nums, target);
        return retArr;
    }
	
	public static int findLeftMostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftMostIndex = -1;
        while (left <= right) {
        	int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;    
            } else {
                leftMostIndex = mid;
                right = mid - 1;     
            }
        }
        return leftMostIndex;
    }
	
	public static int findRightMostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightMostIndex = -1;
        while (left <= right) {
        	int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;    
            } else {
            	rightMostIndex = mid;
                left = mid + 1;     
            }
        }
        return rightMostIndex;
    }
}
