package ArrayStrings;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        //Input: str1 = "ABCABC", str2 = "ABC"; Output: "ABC"
        //Input: str1 = "ABABAB", str2 = "ABAB"; Output: "AB"
        //Input: str1 = "LEET", str2 = "CODE"; Output: ""
//        String s1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
//        String s2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String s1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String s2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String vResult = getCommonDivisor(s1, s2);
        System.out.println("Greatest Common Divisor: " + vResult);
    }

    public static String getCommonDivisor(String s1, String s2) {
        String vResult = "", vChild;
        if (!(s1 + s2).equals(s2 + s1)) {
            return vResult = "";
        }
        int vChildLen, vParentLen;
        if (s1.length() <= s2.length()) {
            vChild = s1;
            vChildLen = s1.length();
            vParentLen = s2.length();
        } else {
            vChild = s2;
            vChildLen = s2.length();
            vParentLen = s1.length();
        }
        for (int i = vChildLen; i > 0; i--) {
            String vSubChild = vChild.substring(0, i);
            int vSubChildLen = vSubChild.length();
            //if (child.len % subchild.len == 0)
            //if (parent.len % subchild.len) == 0
            int vRemainder2 = vChildLen % vSubChildLen;
            int vRemainder3 = vParentLen % vSubChildLen;
            if ((vRemainder2 | vRemainder3) == 0) {
                vResult = vSubChild;
                System.out.println("Result: " + vResult);
                break;
            }
        }
        return vResult;
    }
}
