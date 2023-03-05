package ya.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Postfix {
    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File("input.txt");
        File fout = new File("output.txt");
        Scanner sc= new Scanner(fin);
        String s = sc.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==1) continue;
            int num = s.charAt(i);
            if(num>=48 && num<=57){
                stack.add(num-48);
            }else{
                int second = stack.removeLast();
                int first = stack.removeLast();
                switch (s.charAt(i)){
                    case '+':
                        stack.add(first+second);
                        break;
                    case'-':
                        stack.add(first-second);
                        break;
                    case'*':
                        stack.add(first*second);
                        break;
                }
            }
        }
        System.out.println(stack.poll());
    }
}
