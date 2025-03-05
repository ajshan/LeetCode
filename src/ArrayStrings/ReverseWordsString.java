package ArrayStrings;

public class ReverseWordsString {
    //Input: s = "the sky is blue"
    //Output: "blue is sky the"

    //Input: s = "  hello world  "
    //Output: "world hello"

    //Input: s = "a good   example"
    //Output: "example good a"

    public static void main(String[] args) {
        String s1 = "  hello world  ";
        System.out.println("Input: " + s1);
        String vResult = reverseWords2(s1);
        System.out.print("Output: " + vResult);
    }

    //Method#2: Optimized using regex \\s+ to remove single/multiple spaces
    public static String reverseWords2(String s1) {
        String[] vStrArr = s1.trim().split("\\s+");
        StringBuilder vSb = new StringBuilder();
        for (int i = vStrArr.length - 1; i >= 0; i--) {
            vSb.append(vStrArr[i]).append(" ");
        }
        return vSb.toString().trim();
    }
    //Method#1: Brute Force
    public static String reverseWords1(String s1) {
        String[] vStrArr = s1.trim().split(" ");
        StringBuilder vSb = new StringBuilder();

        for (int i = vStrArr.length - 1; i >= 0; i--) {
            if (vStrArr[i].isEmpty()) {
                continue;
            }
            vSb.append(vStrArr[i].trim()).append(" ");
        }
        return vSb.toString().trim();
    }
}
