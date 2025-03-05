package ArrayStrings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]

    //Input: nums = [-1,1,0,-3,3]
    //Output: [0,0,9,0,0]

    public static void main(String[] args) {
        int[] vNumArr = {1,2,3,4};
        //int[] vNumArr = {-1,1,0,-3,3};
        int[] vResultArr = productOfArray2(vNumArr);
        System.out.println("Input Array: " + Arrays.toString(vNumArr));
        System.out.println("Output Array: " + Arrays.toString(vResultArr));
    }
    //Method2: Optimized: Using Prefix & Suffix
    public static int[] productOfArray2(int[] vNumArr)
    {
        int vArrLen = vNumArr.length;
        int[] vResultArr = new int[vArrLen];
        int[] vLeftArr = new int[vArrLen];
        int[] vRightArr = new int[vArrLen];

        //[,a,a*b,a*b*c] {1,2,3,4} --> {,1x1,1x2,1x2x3}
        vLeftArr[0] = 1;
        for (int i=1; i<vArrLen; i++)
        {
            vLeftArr[i] = vLeftArr[i-1] * vNumArr[i-1];
        }
        System.out.println("Left Array: " + Arrays.toString(vLeftArr));
        //[B*C*D,C*D,D,] {1,2,3,4} --> {4x3x2,4x3x1,4x1,}
        vRightArr[vArrLen-1] = 1;
        for (int i=vArrLen-2; i>=0; i--)
        {
            vRightArr[i] = vRightArr[i+1] * vNumArr[i+1];
        }
        System.out.println("Right Array: " + Arrays.toString(vRightArr));
        for (int i=0; i<vArrLen; i++)
        {
            vResultArr[i] = vLeftArr[i] * vRightArr[i];
        }
        System.out.println("Result: " + Arrays.toString(vResultArr));
        System.out.println(".".repeat(20));
        //[a*A,b*B,c*C,d*D]
        return vResultArr;
    }

    public static int[] productOfArray1(int[] vNumArr)
    {
        int vArrLen = vNumArr.length;
        int[] vResultArr = new int[vArrLen];
        int vProduct = 1;
        for (int vNum: vNumArr)
        {
            vProduct = vProduct * vNum;
        }
        System.out.println("Product: " + vProduct);

        for (int i=0; i<vArrLen; i++)
        {
            vResultArr[i] = vProduct/vNumArr[i];
        }
        return vResultArr;
    }
}
