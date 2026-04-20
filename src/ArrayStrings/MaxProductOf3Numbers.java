package ArrayStrings;

import java.util.Arrays;

public class MaxProductOf3Numbers {
    public static void main(String[] args) {
        int[] vNumArr = {-100,-98,-1,2,3,4};

        int vCount = 3;
        System.out.println("Range: " + vNumArr.length);

        Arrays.sort(vNumArr);
        System.out.println("Print Array: " + Arrays.toString(vNumArr));
        System.out.println("Print value at last place: "+ vNumArr[vNumArr.length-1]);
        int vResult = maxProduct(vNumArr, vCount);
        System.out.println("Result: " + vResult);
    }

    public static int maxProduct(int[] vNumArr, int vCount) {
        int vResult = 0;
        int MaxPositive=0;
        int MaxNegativeAndPositive=0;
        int vArrLen = vNumArr.length;
        if (vNumArr.length < vCount) {
            System.out.println("Invalid range: " + vNumArr.length);
        } else {
            // Option 1: Product of the three largest numbers
            MaxPositive = vNumArr[vArrLen - 1] * vNumArr[vArrLen - 2] * vNumArr[vArrLen - 3];
            // Option 2: Product of the two smallest (most negative) and the largest
            MaxNegativeAndPositive = vNumArr[0] * vNumArr[1] * vNumArr[vArrLen - 1];
            System.out.println(vResult);
        }
        System.gc();
        return vResult = Math.max(MaxPositive, MaxNegativeAndPositive);
    }
}
