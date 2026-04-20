package Interview;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] vInputArr = {1,2,3,4};
        int vTarget = 5;
//        System.out.println("Input Arr: " + Arrays.toString(vInputArr));
//        int vResult = getArrLen(vInputArr);
//        System.out.println("Array Length: " + vResult);
//
        int[] vResult = twoSum(vInputArr, vTarget);
        System.out.println("Two Sum: " + Arrays.toString(vResult));
    }

    public static int[] twoSum(int[] vInputArr, int vTarget)
    {
        int[] vResult = new int[2];
        for (int i=0; i<vInputArr.length; i++)
        {
            for (int j=i+1; j<vInputArr.length; j++)
            {
                int vSum = vInputArr[i]+ vInputArr[j];
                if (vSum==vTarget)
                {
                    return new int[] {i, j};
                }
            }
        }
        return vResult;
    }
}
