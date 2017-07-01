import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 Some hints:
 Could negative integers be palindromes? (ie, -1)
 If you are thinking of converting the integer to string, note the restriction of using extra space.
 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 There is a more generic way of solving this problem.
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int len = 1;
        List list = new ArrayList();
        while(Math.pow(10,len) <= x){
            len++;
        }
        int temp = (int)Math.pow(10,len-1);
        int subx = x;
        for(int i = 0;i < len;i++){
            list.add(subx / temp);
            subx = subx % temp;
            temp = temp / 10;
        }
        for(int i = 0;i < list.size();i++){
            int begin = (int) list.get(i);
            int end = (int) list.get(list.size() -1 - i);
            if(begin != end)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        Boolean flag = isPalindrome.isPalindrome(10);
        System.out.print(flag);
    }
}
