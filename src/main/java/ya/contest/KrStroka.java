package ya.contest;
import java.util.*;
public class KrStroka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] quantities = new int[26];
        int k = sc.nextInt();
        String s = sc.next();
        int left = 0;
        int result=0;
        for (int right = left; right < s.length(); right++) {
            int window_size = right - left + 1;
            int ix = ((int) s.charAt(right)) - 97;
            quantities[ix]++;
            if (window_size - getMax(quantities) <= k) {
                if (window_size > result) result = window_size;
            } else {
                int index = ((int) s.charAt(left)) - 97;
                quantities[index]--;
                left++;
            }
        }
        System.out.println(result);
    }
    private static int getMax(int arr[]){
        int temp=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>temp) temp = arr[i];
        }
        return temp;
    }
}
