package TwoPointers;

import java.util.Arrays;

public class ContainerWithMostWater {
    //Input: height = [1,8,6,2,5,4,8,3,7]
    //Output: 49
    //Input: height = [1,1]
    //Output: 1

    public static void main(String[] args) {
        int[] vHeightArr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input Array: " + Arrays.toString(vHeightArr));
        int vResult = calculateArea2(vHeightArr);
        System.out.println("Result (Area): " + vResult);
    }
    //Method#2: Optimized O(n) - While Loop
    public static int calculateArea2(int[] vHeightArr) {
        int vMaxArea = 0;
        System.out.println("Length: " + vHeightArr.length);
        int j = vHeightArr.length - 1;
        int i = 0;
        while (j > i) {
            //Get Min Height
           int vHeightMin = Math.min(vHeightArr[i], vHeightArr[j]);
            //System.out.println("Height (min): " + vHeightMin);
            //Get Width
            int vWidth = j - i;
            //System.out.println("j: " + j + "; i: " + i + "; Width(j-i): " + vWidth);
            //Get Area
            int vArea = vHeightMin * vWidth;
            //Get/Compare Max Area
            vMaxArea = Math.max(vMaxArea, vArea);
            System.out.print("Area: " + vArea);
            System.out.println("; Max Area: " + vMaxArea);
            //If Height of left pillar is less --> get height of next pillar
            if (vHeightArr[i] <= vHeightArr[j]) {
                i++;
            }
            //else Height of last right pillar is less --> get height of previous to last pillar
            else {
                j--;
            }
        }
        System.gc();
        return vMaxArea;
    }

    //Method#1: Brute Force - O(n^2)
    public static int calculateArea1(int[] vHeightArr) {
        System.out.println("Length: " + vHeightArr.length);
        int vMaxArea = 0;
        int vArea = 0;
        for (int i = 0; i < vHeightArr.length; i++) {
            //i=first pillar
            //j=next pillar
            //System.out.println("_".repeat(20) + i);
            for (int j = i + 1; j < vHeightArr.length; j++) {
                int vHeightMin = Math.min(vHeightArr[i], vHeightArr[j]);
                //System.out.println("Height (min): " + vHeightMin);
                int vWidth = j - i;
                //System.out.println("j: " + j + "; i: " + i + "; Width(j-i): " + vWidth);
                vArea = vHeightMin * vWidth;
                vMaxArea = Math.max(vMaxArea, vArea);
            }
            System.out.print("Calculated Area: " + vArea);
            System.out.println("; Max Area: " + vMaxArea);
        }
        System.out.println("Result: " + vMaxArea);
        return vMaxArea;
    }
}
