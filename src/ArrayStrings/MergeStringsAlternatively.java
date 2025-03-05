package ArrayStrings;

public class MergeStringsAlternatively {
    public static void main(String[] args) {
        String vWord1 = "ab";
        String vWord2 = "pqr";
        //String vResult = mergeStringsAlt1(vWord1, vWord2);
        String vResult = mergeStringsAlt2(vWord1, vWord2);
        System.out.println("Concatenated Result: " + vResult);
    }

    //Method#1 Using StringBuilder (Optimized)
    public static String mergeStringsAlt2(String vWord1, String vWord2)
    {
        int vLen1 = vWord1.length();
        int vLen2 = vWord2.length();
        int i=0;
        int j=0;
        StringBuilder vResult = new StringBuilder();
        while(i<vLen1||j<vLen2)
        {
            if (i<vLen1) {
                vResult.append(vWord1.charAt(i++));
            }
            if (j<vLen2) {
                vResult.append(vWord2.charAt(j++));
            }
        }
        return vResult.toString();
    }
    //Method#1 Using String
    public static String mergeStringsAlt1(String vWord1, String vWord2)
    {
        String vResult = "";
        int vLowestStringLength = Math.min(vWord1.length(), vWord2.length());
        String s1,s2;
        for (int i=0; i<vLowestStringLength; i++)
        {
            char vChar1 = vWord1.charAt(i);
            char vChar2 = vWord2.charAt(i);
            s1 = String.format("%c",vChar1);
            s2 = String.format("%c",vChar2);
            vResult = vResult + s1 + s2;
        }
        if (vWord1.length()<vWord2.length())
        {
            String vSubString = vWord2.substring(vLowestStringLength);
            vResult = vResult + vSubString;
        }
        else {
            String vSubString = vWord1.substring(vLowestStringLength);
            vResult = vResult + vSubString;
        }
        return vResult;
    }
}
