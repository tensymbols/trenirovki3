package ya.contest;

import java.util.Scanner;
import java.util.Stack;

class SkobPosledovatelnost {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Character> S = new Stack<>();
        String str = sc.next();

        boolean right = true;

        if(str.length() %2!=0 || str.length() ==0) right =false;
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c=='{'){
                S.add(c);
            }else{
                if(S.empty()) {
                    right =false;
                    break;
                }
                char top = S.pop();
                if(!((top == '(' && c==')') ||
                        (top == '[' && c==']') ||
                        (top == '{' && c=='}'))) {
                    right=false;
                    break;
                }
            }
        }
        if(right && S.empty()) System.out.println("yes");
        else System.out.println("no");
    }
}