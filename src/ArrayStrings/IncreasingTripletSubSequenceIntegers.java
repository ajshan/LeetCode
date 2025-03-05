package ArrayStrings;

import java.util.Arrays;

public class IncreasingTripletSubSequenceIntegers {
    /*
    Input: nums = [1,2,3,4,5]
    Output: true
    Input: nums = [5,4,3,2,1]
    Output: false
    Input: nums = [2,1,5,0,4,6]
    Output: true
    */
    public static void main(String[] args) {
        //int[] vInputArr = {1,2,3,4,5};
        //int[] vInputArr = {5,4,3,2,1};
        //int[] vInputArr = {2,1,5,0,4,6};
        //[20,100,10,12,5,13]
        int[] vInputArr = {20, 100, 10, 12, 5, 13};
        boolean vResult = isTripletSubsequence3(vInputArr);
        System.out.println("Input Array: "+Arrays.toString(vInputArr));
        System.out.println("Output (Is Triplet Subsequence): " + vResult);
    }
    // Method#3: Swap Method; Time Complexity: O(n); Space Complexity: O(1)
    public static boolean isTripletSubsequence3(int[] vInputArr)
    {
        if (vInputArr.length<3)
        {return false;}
        
        int vFirst = Integer.MAX_VALUE;
        int vSecond = Integer.MAX_VALUE;
        System.out.println("Input Array: "+Arrays.toString(vInputArr));
        for (int vElement: vInputArr)
        {
            if (vElement<=vFirst && vElement < vSecond) {
                vFirst = vElement;
                System.out.println("1st: "+vFirst);
            }
            else if (vElement<=vSecond && vElement > vFirst)
            {
                vSecond = vElement;
                System.out.println("   2nd: "+vSecond);
            }
            else
            {
                //First<Second<Third
                System.out.println("First<Second<Third: [" + vFirst+", "+ vSecond + ", " + vElement + "]");
                return true;
            }
        }
        return false;
    }
    // Method#2: create 2 extra array; Time Complexity: O(n); Space Complexity: O(n)
    public static boolean isTripletSubsequence2(int[] vInputArr) {
        int vArrLen = vInputArr.length;
        int[] vLeftMinArr = new int[vArrLen];
        int[] vRightMaxArr = new int[vArrLen];
        vLeftMinArr[0] = vInputArr[0];
        vRightMaxArr[vArrLen-1] = vInputArr[vArrLen-1];
        for (int i=1; i<vArrLen; i++)
        {
            vLeftMinArr[i] = Math.min(vLeftMinArr[i-1], vInputArr[i]);
        }
        System.out.println("Left Array: " + Arrays.toString(vLeftMinArr));
        for (int i=vArrLen-2; i>=0; i--)
        {
            vRightMaxArr[i] = Math.max(vRightMaxArr[i+1], vInputArr[i]);
        }
        System.out.println("Input Array: " + Arrays.toString(vInputArr));
        System.out.println("Right Array: " + Arrays.toString(vRightMaxArr));
        for (int i=0; i<vArrLen;i++)
        {
            if (vLeftMinArr[i]<vInputArr[i] && vInputArr[i]<vRightMaxArr[i])
            {
                System.out.println("Left<Input<Right: [" + vLeftMinArr[i] +", "+ vInputArr[i] + ", " + vRightMaxArr[i] + "]");
                return true;
            }
        }
         return false;
        }
    public static boolean isTripletSubsequence1(int[] vInputArr) {
        int vArrLen = vInputArr.length;

        for (int i = 0; i < vArrLen - 2; i++) {
            if ((vInputArr[i] < vInputArr[i + 1]) && (vInputArr[i + 1] < vInputArr[i + 2])) {
                System.out.println("True");
                return true;
            }
        }
        return false;
    }

}
