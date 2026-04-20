package DynamicProgramming;

import java.util.*;

public class CoinChange {
    //Input: coins = [1,5,10], amount = 12   //Output: 3
    //Input: coins = [2], amount = 3        //Output: -1
    //Input: coins = [1], amount = 0        //Output: 0
    public static void main(String[] args) {
        int[] vCoinArr = {1, 5, 10};
        int vAmount = 12;

//        int[] vCoinArr = {2};
//        int vAmount = 3;

        Arrays.sort(vCoinArr);
        System.out.println("Input Array: " + Arrays.toString(vCoinArr));
        int vResult = minCoin3(vCoinArr, vAmount);
        System.out.println("Output: " + vResult);
    }
    public static int minCoin3(int[] vCoinArr, int vAmount) {
        //Create a new array of size MaxAmount+1 and fill it with Max+1 value
        int[] vNewArr = new int[vAmount + 1];
        for(int i = 1; i<= vAmount; i++)
        {
            vNewArr[i]= vAmount + 1;
        }
        //System.out.println("Updated Array: " + Arrays.toString(vNewArr));
        for(int vCoinValue : vCoinArr)
        {
            System.out.println("-----Considering coin: " + vCoinValue);
            for(int i = vCoinValue; i <= vAmount; i++)
            {
                System.out.print(" vNewArr[i] " + vNewArr[i]);
                System.out.print("; vNewArr[i - vCoinValue]" + vNewArr[i - vCoinValue]);
                vNewArr[i]=Math.min(vNewArr[i], vNewArr[i - vCoinValue]+1);
                System.out.println("; Updated Array: " + Arrays.toString(vNewArr));
            }
        }
        if(vNewArr[vAmount]> vAmount)
        {
            return -1;
        }
        System.gc();
        return vNewArr[vAmount];
    }
    public static int minCoin2(int[] vCoinArr, int vAmount) {
    //Create an array of len>amount i.e. Amount+1
    int vMaxAmount = vAmount + 1;
    int[] vNewArr = new int[vMaxAmount];
    //Fill the array with MaxAmount Number
    Arrays.fill(vNewArr,vMaxAmount);
    System.out.println("A New Array: " + Arrays.toString(vNewArr));
    vNewArr[0] = 0;
    System.out.println("B New Array: " + Arrays.toString(vNewArr));

    for (int i = 1; i <= vAmount; i++) {
        System.out.println("----------Counter: " + i);
        for (int coin : vCoinArr) {
            if (i >= coin) {
                int value1 = vNewArr[i];
                System.out.print("Considering coin: " + coin);
                System.out.print("; Value1, Value2: (" + value1);
                int value2 = vNewArr[i - coin] + 1;
                System.out.print("," + value2);
                vNewArr[i] = Math.min(value1, value2);
                System.out.println("); Min: " + vNewArr[i]);
                System.out.println("Updated Array: " + Arrays.toString(vNewArr));
            }
        }
    }
    if(vNewArr[vAmount] > vAmount)
    {
        return -1;
    }
    //Result = last index value
    return vNewArr[vAmount];
}
    public static int minCoin1(int[] vCoinArr, int vAmount) {
    int vCoinTotal = 0;
    int vRemainder = 0;
    for (int i = vCoinArr.length - 1; i >= 0; i--) {
        if (vCoinArr[i] > vAmount) {
            continue;
        }
        System.out.println("Remaining Amount: " + vAmount);
        if (vCoinArr[i] > vAmount) {
            continue;
        }
        System.out.println("Considering: " + vCoinArr[i]);
        vRemainder = vAmount % vCoinArr[i];
        System.out.println("Remainder: " + vRemainder);
        //Quotient=Dividend/Divisor;
        int vCoinCount = vAmount / vCoinArr[i];
        System.out.println("Coin Count: " + vCoinCount);
        vCoinTotal += vCoinCount ;
        System.out.println("Coin Count Total: " + vCoinTotal);
        if (vRemainder == 0) {
               break;
        } else {
            vAmount = vRemainder;
        }
    }
    System.out.println("Final Remaining Amount: " + vAmount);
    if (vRemainder!=0)
    {return -1;}
    return vCoinTotal;
}


}
