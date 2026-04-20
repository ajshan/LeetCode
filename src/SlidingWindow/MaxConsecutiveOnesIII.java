package SlidingWindow;

import java.util.Arrays;

public class MaxConsecutiveOnesIII {
    //Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2                  //Output: 6
    //Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3  //Output: 10
    public static void main(String[] args) {
        int[] vInputArr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Input Array: " + Arrays.toString(vInputArr));
        int vResult = longestOnes2(vInputArr, k);
        System.out.println("Result: " + vResult);
    }

    public static int longestOnes2(int[] vInputArr, int k)
    {
        int vLeft = 0;
        int vRight = 0;
        while(vRight < vInputArr.length)
        {
            if (vInputArr[vRight] == 0)
            {
               k--;
            }
            if (k<0)
            {
                if (vInputArr[vLeft]==0)
                {
                    k++;
                }
                vLeft++;
            }
            vRight++;
        }
        return vRight - vLeft;
    }

    //Copied method
    public int longestOnes1(int[] nums, int k) {
        int left = 0, maxLength = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            int vWindowLength = right - left + 1;
            maxLength = Math.max(maxLength, vWindowLength);
        }
        return maxLength;
    }

    public static int maxConsecutiveOnes1(int[] vInputArr, int k)
    {
        int vCountOnes = 0;
        int vCountZeros = 0;
        int vMaxValue = 0;
        for (int i=1; i<vInputArr.length; i++)
        {
            if (vCountZeros==k)
            {
                vCountOnes = vCountOnes + vCountZeros;
                vMaxValue = Math.max(vMaxValue, vCountOnes);
                System.out.println("---------Count Ones: "+ vCountOnes);
                System.out.println("Count Zeros: "+ vCountZeros);
                System.out.println("Max Value: "+ vMaxValue);
                vCountOnes=0;
                vCountZeros=0;
            }
            if (vInputArr[i] == vInputArr[i-1])
            {
                vCountOnes++;
                System.out.println("Ones: "+vCountOnes);
            }
            else {
                vCountZeros++;
                System.out.println("......Zeros: "+vCountZeros);
            }
        }
        return vMaxValue;
    }

    public static int maxConsecutiveOnes2(int[] vInputArr, int k)
    {
        int vCountZeros = 0;
        int vMaxValue = 0;
        int i = 0;//Left Index
        int j = 0;//Right Index
        System.out.println("Zero: " + vCountZeros);
        while(j<vInputArr.length)
        {
            if (vInputArr[j] == 0)
            {
                vCountZeros++;
                System.out.println("Zero: " + vCountZeros);
            }

            if (vCountZeros > k)
            {
                int vWindowLen = j-i+1;//get window length
                System.out.println("Result: " + vWindowLen);
                vMaxValue = Math.max(vMaxValue, vWindowLen);
                i++;//increment left index
                vCountZeros--;
            }
        }
        return vMaxValue;
    }

}
