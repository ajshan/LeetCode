package TwoPointers;

import java.util.Arrays;

public class ContainerWithMostWater {
    //Input: height = [1,8,6,2,5,4,8,3,7]
    //Output: 49
    //Input: height = [1,1]
    //Output: 1

    public static void main(String[] args) {
        int[] vHeightArr = {1,8,6,2,5,4,8,3,7};
        int vResult = calculateArea1(vHeightArr);
        System.out.println("Input Array: " + Arrays.toString(vHeightArr));
        System.out.println("Result (Area): " + vResult);
    }

    public static int calculateArea(int[] vHeightArr)
    {
        int r = vHeightArr.length - 1;
        int vMaxArea = 0;
        System.out.println(vHeightArr.length);
        for (int i=0; i<vHeightArr.length-1; i++)
        {
            System.out.println("r value: " + r);
            int vMin = Math.min(vHeightArr[i], vHeightArr[r]);
            System.out.println("Min: " + vMin);
            //Area = vMin * vCount--
            int vArea = vMin * (r-i);
            vMaxArea = Math.max(vMaxArea, vArea);
            System.out.println("Max Area: " + vMaxArea);

            r--;
        }
        System.out.println("Result: " + vMaxArea);
        return vMaxArea;
    }

    //O(n^2)
    public static int calculateArea1(int[] vHeightArr)
    {
        System.out.println("Length: " +vHeightArr.length);
        int vMaxArea = 0;
        for (int i=0; i<vHeightArr.length; i++)
        {
            //i=first pillar
            //j=next pillar
            System.out.println("_".repeat(20) + i);
            for (int j=i+1; j<vHeightArr.length; j++)
            {
                int vHeightMin = Math.min(vHeightArr[i], vHeightArr[j]);
                System.out.println("Height (min): " + vHeightMin);
                int vWidth = j-i;
                System.out.println("j: " + j + "; i: "+i + "; Width(j-i): " + vWidth);
                int vArea = vHeightMin * vWidth;
                vMaxArea = Math.max(vMaxArea, vArea);
                System.out.println("Max Area: " + vMaxArea);
            }
        }
        System.out.println("Result: " + vMaxArea);
        return vMaxArea;
    }

}
