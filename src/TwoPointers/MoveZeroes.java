package TwoPointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] vIntArr = {0, 1, 0, 3, 12};//Output [1,3,12,0,0]
        //int[] vIntArr = {0};//Output [0]
        System.out.println(Arrays.toString(vIntArr));
        int[] vResultArr = moveZeroArray3(vIntArr);
        System.out.println(Arrays.toString(vResultArr));
    }
    //Method#3:  2 Pointers & Swap Method
    public static int[] moveZeroArray3(int[] vIntArr) {
        if (vIntArr.length == 1) {
            System.out.println(Arrays.toString(vIntArr));
            return vIntArr;
        }
        int vIndex = 0;
        for (int i = 0; i < vIntArr.length; i++) {
            if (vIntArr[i] != 0) {
                //Swap Method
                int temp = vIntArr[vIndex];
                vIntArr[vIndex] = vIntArr[i];
                vIntArr[i] = temp;
                vIndex++;
            }
        }
        //System.out.println(Arrays.toString(vIntArr));
        return vIntArr;
    }


    //Method#2:  2 Pointers & Same Array
    public static int[] moveZeroArray2(int[] vIntArr) {
        if (vIntArr.length == 1) {
            //System.out.println(Arrays.toString(vIntArr));
            return vIntArr;
        }
        int vCount = 0;
        int vIndex = 0;
        for (int i = 0; i < vIntArr.length; i++) {
            if (vIntArr[i] == 0) {
                vCount++;
            } else {
                vIntArr[vIndex++] = vIntArr[i];
            }
        }
        for (int i = 0; i < vCount; i++) {
            vIntArr[vIndex++] = 0;
        }
        //System.out.println(Arrays.toString(vIntArr));
        return vIntArr;
    }


    //Method#1: Create new array
    public static int[] moveZeroArray1(int[] vIntArr) {
        int[] vResultArr = new int[vIntArr.length];

        if (vIntArr.length == 1) {
            vResultArr = vIntArr;
        }
        int vCount = 0;
        int vIndex = 0;
        for (int i = 0; i < vIntArr.length; i++) {
            if (vIntArr[i] == 0) {
                vCount++;
            } else {
                vResultArr[vIndex++] = vIntArr[i];
            }
        }
        for (int i = 0; i < vCount; i++) {
            vResultArr[vIndex++] = 0;
        }
        System.out.println(Arrays.toString(vResultArr));
        return vResultArr;
    }
}
