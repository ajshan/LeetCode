package SlidingWindow;

import java.util.Arrays;

public class MaximumAverageSubarrayI {
    //Input: nums = [1,12,-5,-6,50,3], k = 4    //Output: 12.75000
    //Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    //Input: nums = [5], k = 1    //Output: 5.00000
    public static void main(String[] args) {
        int[] vInputArr = {1,12,-5,-6,50,3};
        //int[] vInputArr = {0,1,1,3,3};
        int k = 4;
        System.out.println("Input Array: "+Arrays.toString(vInputArr));
        double vResult = maxAverageSubArrK(vInputArr, k);
        System.out.println("Result: " + vResult);
    }
    public static double maxAverageSubArrK(int[] vInputArr, int k)
    {
        double vSum = 0;
        for (int i=0; i<k; i++)
        {
            vSum += vInputArr[i];
            System.out.println("Sum: "+vSum);
        }
        System.out.println(".".repeat(20));
        int vLen = vInputArr.length;
        //Set i=5th element or kth element which is 4th index
        int i = k;
        double vMaxValue = vSum;
        while(i<vLen)
        {
            int j = i-k;
            //Sum of next 4 elements = Sum+5th Element - 1st Element
            vSum = vSum + vInputArr[i] - vInputArr[j];
            System.out.println("Sum: "+vSum);
            vMaxValue = Math.max(vMaxValue,vSum);
            System.out.println("Max Value: " + vMaxValue);
            i++;
        }
        double vResult = vMaxValue/k;
        System.out.println("Result: " + vResult);
        System.gc();
        return vResult;
    }

}
