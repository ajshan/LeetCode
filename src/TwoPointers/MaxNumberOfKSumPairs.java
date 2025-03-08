package TwoPointers;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    //Input: nums = [1,2,3,4], k = 5 //Output: 2
    //Input: nums = [3,1,3,4,3], k = 6 //Output: 1
    public static void main(String[] args) {
        //int[] vInputArr = {5};
        //int[] vInputArr = {1,2,3,4};
        int[] vInputArr = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
        int k = 2;
        System.out.println(Arrays.toString(vInputArr));
        int vResult = maxOperationOfSums(vInputArr, k);
        System.out.println("Result (Max # of operations): " + vResult);
    }
    public static int maxOperationOfSums(int[] vInputArr, int k) {
        for (int i = 0; i < vInputArr.length; i++) {
            if (vInputArr[i] >= k) {
                vInputArr[i] = 0;
            }
        }
        Arrays.sort(vInputArr);
        System.out.println(Arrays.toString(vInputArr));
        int vCount = 0;
        int i = 0;
        int j = vInputArr.length - 1;
        while (i < j) {
            int vSum = vInputArr[i] + vInputArr[j];
            if (vSum == k) {
                vCount++;
                i++;
                j--;
            } else if (vSum < k) {
                i++;
            } else {
                j--;
            }
        }
        System.gc();
        return vCount;
    }
}
