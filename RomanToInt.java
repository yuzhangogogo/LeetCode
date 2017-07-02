import java.util.HashMap;
import java.util.Map;
/**
 * Given a roman numeral, convert it to an integer.
 Input is guaranteed to be within the range from 1 to 3999.
 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。
 1、重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 2、右加左减：
 2.1 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
 2.2 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
 2.3 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 2.4 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
 2.5 左减数字必须为一位，比如8写成VIII，而非IIX。
 2.6 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
 3、加线乘千：
 3.1 在罗马数字的上方加上一条横线或者加上下标的Ⅿ，表示将这个数乘以1000，即是原数的1000倍。
 3.2 同理，如果上方有两条横线，即是原数的1000000（1000^{2}）倍。
 4、数码限制：
 4.1 同一数码最多只能出现三次，如40不可表示为XXXX，而要表示为XL。
 4.2 例外：由于IV是古罗马神话主神朱庇特（即IVPITER，古罗马字母里没有J和U）的首字，因此有时用IIII代替Ⅳ。
 */
public class RomanToInt {

    public int romanToInt(String s) {
        // 1.将字符串转化为单个字符
        char[] chars = s.toCharArray();
        // 2.存储罗马数字的规则
        Map romanMap = new HashMap();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        // 3.将字符转化为数字
        int[] ic = new int[chars.length];
        for(int i = 0;i < chars.length;i++){
            ic[i] = (int)romanMap.get(chars[i]);
        }
        // 4.按左加右减的规则转化数字
        for(int i = 0;i < chars.length;i++){
            if(i != chars.length - 1 && ic[i] < ic[i+1]){
                ic[i] = -ic[i];
            }
        }
        // 5.依次累加每个数
        int sum = 0;
        for(int i = 0;i < chars.length;i++){
            sum += ic[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        int sum = romanToInt.romanToInt("DCXXI");
        System.out.print(sum);
    }
}
