package SlidingWindow;

public class MaximumNumberOfVowelsinaSubstringofGivenLength {
    //Input: s = "abciiidef", k = 3  //Output: 3
    //Input: s = "aeiou", k = 2     //Output: 2
    //Input: s = "leetcode", k = 3  //Output: 2
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("Input String: " + s);
        int vResult = maxVowels(s, k);
        System.out.println("Result: " + vResult);
    }
    public static int maxVowels(String s, int k) {
        char[] vCharArr = s.toCharArray();
        int vFound = 0;
        int vMaxValue = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(vCharArr[i])) {
                vFound++;
            }
        }
        vMaxValue = Math.max(vMaxValue, vFound);
        System.out.println("1st Max Value: " + vMaxValue);
        //Start counter from kth value; Assign i = k;
        int i = k;
        while (i < vCharArr.length) {
            //if 0th value is vowel --> decrement 1 from found value
            int j = i - k;
            if (isVowel(vCharArr[j])) {
                vFound--;
            }
            //if kth value is vowel --> increment 1 in found value
            if (isVowel(vCharArr[i])) {
                vFound++;
            }
            System.out.println("Final Found Value: " + vFound);
            //Compare against last max value against found value
            vMaxValue = Math.max(vMaxValue, vFound);
            System.out.println("Max Value: " + vMaxValue);
            i++;
        }
        System.gc();
        return vMaxValue;
    }
    public static boolean isVowel(char vChar) {
        if (vChar == 'a' || vChar == 'e' || vChar == 'i' || vChar == 'o' || vChar == 'u') {
            return true;
        }
        return false;
    }
}
