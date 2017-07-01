import java.util.ArrayList;
import java.util.List;
/**
 *Reverse digits of an integer.
 Example1: x = 123, return 321
 Example2: x = -123, return -321
 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class Reverse {
    public int reverse(int x) {
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
            return 0;
        List list = new ArrayList();
        // 1.判断x的正负号
        int flag = x > 0 ? 1 : -1;
        // 2.取x的绝对值的长度
        x = Math.abs(x);
        int len = 1;
        while(Math.pow(10,len) <= x) {
            len++;
        }
        // 3.获取x的每位数
        int temp = (int)Math.pow(10,len-1);
        int subx = x;
        for(int i = 0;i < len;i++){
            list.add(subx / temp);
            subx = subx % temp;
            temp = temp / 10;
        }
        // 4.逆序
        Long rlx = 0L;
        Long t = 1L;
        for(int i = 0;i < list.size();i++){
            rlx += ((int)list.get(i) * t);
            t *= 10;
            if((rlx >= Integer.MAX_VALUE && flag == 1) || (-rlx <= Integer.MIN_VALUE && flag == -1))
                return 0;
        }
        int reverseX = Integer.parseInt(String.valueOf(rlx));
        // 6.添加正负号
        reverseX = reverseX * flag;
        return reverseX;
    }

    public static void main(String[] args) {
        int a = -2147483648;
        Reverse reverse = new Reverse();
        int reverseX = reverse.reverse(a);
        System.out.print(reverseX);
    }
}
