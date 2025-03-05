package TwoPointers;

public class IsSubsequenceString {
    public static void main(String[] args) {
        //String vSub = "abc"; String vMain = "ahbgdc"; //true
        //String vSub = "axc"; String vMain = "ahbgdc"; //false
        //String vSub = "aaaaaa"; String vMain = "bbaaaa"; //true
        //String vSub = ""; String vMain = "bbaaaa"; //true
        String vSub = "acb"; String vMain = "ahbgdc"; //false
        System.out.println("Sub/Main: " + vSub + "/" + vMain);
        boolean vResult = isSubsequence2(vSub, vMain);
        System.out.println("Result: " + vResult);
    }
    //Method#1: Optimized (For + While Loop)
    public static boolean isSubsequence1(String vSub, String vMain) {
        boolean vMatchFound = false;
        if (vSub.isEmpty()) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < vSub.length(); i++) {
            vMatchFound = false;
            //System.out.println("j:" + j);
            while (j < vMain.length()) {
                //System.out.println("i/j: " + i + "/" + j);
                //System.out.println("Considering: " + vSub.charAt(i) + "; " + vMain.charAt(j));
                if (vSub.charAt(i) == vMain.charAt(j)) {
                    //System.out.println("Matched value: " + vSub.charAt(i));
                    vMatchFound = true;
                    break;
                }
                j++;
            }
            j++;
        }
        return vMatchFound;
    }
    //Method#2: While + Length Checker
    public static boolean isSubsequence2(String vSub, String vMain) {
        boolean vMatchFound = false;
        if (vSub.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < vSub.length() && j < vMain.length()) {
            System.out.println("Considering: " + vSub.charAt(i) + "; " + vMain.charAt(j));
            vMatchFound = false;
            if (vSub.charAt(i) == vMain.charAt(j)) {
                System.out.println("Matched value: " + vSub.charAt(i));
                vMatchFound = true;
                i++;
            }
            j++;
        }
        if (i != vSub.length()) {
            System.out.println("Could not process all records");
            vMatchFound = false;
        }
        return vMatchFound;
    }
}
