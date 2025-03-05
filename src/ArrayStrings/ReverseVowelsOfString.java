package ArrayStrings;

import java.util.ArrayList;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        //Input: s = "IceCreAm" Output: "AceCreIm"
        //Input: s = "leetcode" Output: "leotcede"
        String vInput = "IceCreAm";
        //Output: "AceCreIm
        System.out.println("Input: " + vInput);
        String vOutput = reverseVowels3(vInput);
        System.out.println("Output: " + vOutput);
    }

    //Method#3 Lists
    public static String reverseVowels3(String s1)
    {
        String vVowels = "aeiouAEIOU";
        char[] vCharArrVowel = vVowels.toCharArray();
        char[] vCharArrString = s1.toCharArray();
        ArrayList<Character> vArrListVowels = new ArrayList<>();
        for (char c : vCharArrVowel) {
            vArrListVowels.add(c);
        }
        System.out.println(vArrListVowels);

        ArrayList<Character> vArrListFilteredVowels = new ArrayList<>();
        for (char c : vCharArrString) {
            if (vArrListVowels.contains(c)) {
                vArrListFilteredVowels.add(c);
            }
        }
        System.out.println(vArrListFilteredVowels);

        StringBuilder vResult = new StringBuilder();
        int i = vArrListFilteredVowels.size() - 1;

        for (char c : vCharArrString) {
            if (vArrListVowels.contains(c)) {
                vResult.append(vArrListFilteredVowels.get(i--));
            } else {
                vResult.append(c);
            }
        }

        return vResult.toString();
    }
    //Method#2 Optimized Using While Loop + 2 Pointers
    public static String reverseVowels2(String s1) {
        int i = 0;
        int j = s1.length() - 1;
        char[] vCharArr = s1.toCharArray();
        String vVowels = "aeiouAEIOU";
        while (i < j) {
            while (i < j && !vVowels.contains(String.valueOf(vCharArr[i]))) {
                i++;
            }
            while (i < j && !vVowels.contains(String.valueOf(vCharArr[j]))) {
                j--;
            }
            char temp = vCharArr[i];
            System.out.println("Left Vowel: " + temp);
            vCharArr[i] = vCharArr[j];
            System.out.println("Right Vowel: " + vCharArr[j]);
            vCharArr[j] = temp;

            i++;
            j--;
        }
        String vResult = new String(vCharArr);
        return vResult;
    }
    //Method#1 Brute Force
    public static String reverseVowels1(String s1) {
        String vVowels = "aeiouAEIOU";
        String vResult = "";
        char[] vCharInputArray = s1.toCharArray();
        StringBuilder vTempSB = new StringBuilder();
        for (int i = 0; i < vCharInputArray.length; i++) {
            String vCharElement = String.valueOf(vCharInputArray[i]);
            if (vVowels.contains(vCharElement)) {
                vTempSB.append(vCharElement);
            }
        }
        if (vTempSB.length() == 0) {
            return s1;
        }
        System.out.println("Identified Vowels: " + vTempSB);
        int j = 0;
        for (int i = vCharInputArray.length - 1; i >= 0; i--) {
            String vElement = String.valueOf(vCharInputArray[i]);
            if (vVowels.contains(vElement)) {
                vCharInputArray[i] = vTempSB.charAt(j);
                vResult = new String(vCharInputArray);
                j++;
            }
        }
        return vResult;
    }


}
