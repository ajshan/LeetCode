package ArrayStrings;

import java.util.Arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        /*
        Example 1:
        Input: flowerbed = [1,0,0,0,1], n = 1
        Output: true
        Example 2:
        Input: flowerbed = [1,0,0,0,1], n = 2
        [0,0,1,0,1]
        [1,0,0,0,1]
        Output: false
        */
        int[] vFlowerBedArr = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println("Array: " + Arrays.toString(vFlowerBedArr));
        boolean isResult = canBePlaced(vFlowerBedArr, n);
        System.out.println("Result: " + isResult);
    }

    public static boolean canBePlaced(int[] vFlowerBedArr, int n) {
        if (n == 0) {
            return true;
        }
        int vArrLen = vFlowerBedArr.length;
        int vCount = 0;
        int vLeft, vRight, vCenter;
        for (int i = 0; i < vArrLen; ++i) {
            //Get Left Value
            if (i == 0) {
                vLeft = 0;
            } else {
                vLeft = vFlowerBedArr[i - 1];
            }
            //Get Right Value
            if (i == vArrLen - 1) {
                vRight = 0;
            } else {
                vRight = vFlowerBedArr[i + 1];
            }
            //Get Center Value
            vCenter = vFlowerBedArr[i];
            if (vLeft + vCenter + vRight == 0) {
                vFlowerBedArr[i] = 1;
                vCount++;
                if (vCount == n) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canBePlaced2(int[] vFlowerBedArr, int n) {
        if (n == 0) {
            return true;
        }
        int[] vNewArr = new int[vFlowerBedArr.length + 2];
        for (int i = 0; i < vFlowerBedArr.length; i++) {
            vNewArr[i + 1] = vFlowerBedArr[i];
        }
        System.out.println("New Array: " + Arrays.toString(vNewArr));
        int vCount = 0;
        for (int i = 0; i < vFlowerBedArr.length; i++) {
            if ((vNewArr[i] | vNewArr[i + 1] | vNewArr[i + 2]) == 0) {
                vNewArr[i + 1] = 1;
                vCount++;
                if (vCount == n) {
                    System.out.println("New Filled Array: " + Arrays.toString(vNewArr));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canBePlaced1(int[] vFlowerBedArr, int n) {
        boolean isResult = false;

        int vArrLen = vFlowerBedArr.length;
        int vCount = 0;
        for (int i = 0; i < vArrLen - 1; i++) {
            if (vFlowerBedArr[i] == 0 && vFlowerBedArr[i + 1] == 0) {
                vFlowerBedArr[i] = 1;
                i = i + 1;
                vCount++;
                System.out.println("Count: " + vCount);
                System.out.println("New Array: " + Arrays.toString(vFlowerBedArr));
            } else {
                i = i + 1;
            }
            if (vCount >= n) {
                isResult = true;
            }
        }
        return isResult;
    }
}
