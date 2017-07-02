import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to find  longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        // 1.求数组中最短的字符串
        int minlen = strs[0].length();
        int minIndex = 0;
        for(int i = 0;i < strs.length;i++){
            if(minlen > strs[i].length()) {
                minlen = strs[i].length();
                minIndex = i;
            }
        }
        if(minlen == 0)
            return "";
        // 2.将最短的字符串拆分为单个字符
        char[] chars = strs[minIndex].toCharArray();
        // 3.求公共的字符串
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while(index < minlen) {
            sb.append(chars[index]);
            for (int k = 0; k < strs.length; k++) {
                if (!strs[k].startsWith(sb.toString())) {
                    if(index == 0)
                        return "";
                    else{
                        sb.deleteCharAt(sb.length()-1);
                        return sb.toString();
                    }
                }
            }
            index++;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String[] strings = {"aa","ab"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String maxString = longestCommonPrefix.longestCommonPrefix(strings);
        System.out.print(maxString);
    }
}
