package ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class KidsWithGreatestNumOfCandies {
    public static void main(String[] args) {
        int[] vCandiesArr = {2, 3, 5, 1, 3};
        int vCandyExtra = 3;
        System.out.println(Arrays.toString(vCandiesArr));

        //ArrayList<Boolean> vArrListBool = hasExtraCandy1(vCandiesArr, vCandyExtra);
        //System.out.println(vArrListBool);

        boolean[] vResultArr = hasExtraCandy2(vCandiesArr, vCandyExtra);
        System.out.println(Arrays.toString(vResultArr));
    }

    //Method#2 Array only
    public static boolean[] hasExtraCandy2(int[] vCandiesArr, int vCandyExtra) {
        int vArrLen = vCandiesArr.length;
        boolean[] vResultBoolArr = new boolean[vArrLen];
        int vMaxCount = 0;
        for (int vCandy: vCandiesArr) {
            vMaxCount = Math.max(vCandy, vMaxCount);
        }

        for (int j = 0; j < vArrLen; j++) {
            boolean vhasExtra = false;
            if (vCandiesArr[j] + vCandyExtra >= vMaxCount) {
                vhasExtra = true;
            }
            vResultBoolArr[j] = vhasExtra;
        }
        return vResultBoolArr;
    }

    //Method#1 ArrayList (More optimized)
    public static ArrayList<Boolean> hasExtraCandy1(int[] vCandiesArr, int vCandyExtra) {
        boolean[] vResultBoolArr = {false};
        int vArrLen = vCandiesArr.length;

        ArrayList<Boolean> vArrListBool = new ArrayList<Boolean>();
        int vMaxCount = 0;
        for (int i = 0; i < vArrLen; i++) {
            vMaxCount = Math.max(vMaxCount, vCandiesArr[i]);
        }

        for (int j = 0; j < vArrLen; j++) {
            boolean vhasExtra = false;
            if (vCandiesArr[j] + vCandyExtra >= vMaxCount) {
                vhasExtra = true;
            }
            vArrListBool.add(vhasExtra);
        }
        return vArrListBool;
    }
}
