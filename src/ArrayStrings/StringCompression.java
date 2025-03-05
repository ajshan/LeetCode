package ArrayStrings;
import java.util.Arrays;
public class StringCompression {
    //Input: chars = ['a','a','b','b','c','c','c']
    //Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
    //Input: chars = ['a']
    //Output: Return 1, and the first character of the input array should be: ['a']
    //Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
    //Output: Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
    public static void main(String[] args) {
        char[] vInputChar = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};//Output 6
        //char[] vInputChar = {'a'};//output 1
        //char[] vInputChar = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};//output 4
        //char[] vInputChar = {'a','b','c'};//output 3
        System.out.println("Input: " + Arrays.toString(vInputChar));
        int vLength = compress2(vInputChar);
        System.out.println("Output (Length): " + vLength);
    }
    //Method2: For Each Element in StringBuilder to Assign value in InputArray
    public static int compress2(char[] vInputChar) {
        if (vInputChar.length == 0) {
            return 0;
        }
        if (vInputChar.length == 1) {
            return 1;
        }
        StringBuilder vSb = new StringBuilder();
        for (int i = 0; i < vInputChar.length; i++) {
            int vCount = 0;
            char vInitialChar = vInputChar[i];
            while (i < vInputChar.length && vInputChar[i] == vInitialChar) {
                vCount++;
                i++;
            }
            if (vCount == 1) {
                vSb.append(vInitialChar);
            } else {
                vSb.append(vInitialChar).append(vCount);
            }
            //Decrement i when (vInputChar[i] != vInitialChar)
            i--;
        }
        System.out.println("SB: " + vSb.toString());
        for(int i=0;i<vSb.length();i++)
        {
            vInputChar[i]=vSb.charAt(i);
            System.out.println("Inserting Value: "+vInputChar[i]);
        }
        System.out.println("Compressed Char Array: " + Arrays.toString(vInputChar));
        return vSb.length();
    }

    //Method1: For Each Element in StringBuilder to Assign value in InputArray
    public static int compress1(char[] vInputChar) {
        if (vInputChar.length == 0) {
            return 0;
        }
        if (vInputChar.length == 1) {
            return 1;
        }
        StringBuilder vSb = new StringBuilder();
        for (int i = 0; i < vInputChar.length; i++) {
            int vCount = 0;
            char vInitialChar = vInputChar[i];
            while (i < vInputChar.length && vInputChar[i] == vInitialChar) {
                vCount++;
                i++;
            }
            if (vCount == 1) {
                vSb.append(vInitialChar);
            } else {
                vSb.append(vInitialChar).append(vCount);
            }
            //Decrement i when (vInputChar[i] != vInitialChar)
            i--;
        }
        System.out.println("SB: " + vSb.toString());
        vInputChar = vSb.toString().toCharArray();
        System.out.println("Compressed Char Array: " + Arrays.toString(vInputChar));
        return vSb.length();
    }



}
