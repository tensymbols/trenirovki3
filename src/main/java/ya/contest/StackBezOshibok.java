package ya.contest;

import java.util.Scanner;
import java.util.LinkedList;


public class StackBezOshibok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack S = new MyStack();
        while(sc.hasNext()){
            String s = sc.next();
            switch(s){
                case "push":
                    S.push(sc.nextInt());
                    break;
                case "pop":
                    S.pop();
                    break;
                case "back":
                    S.back();
                    break;
                case "size":
                    S.size();
                    break;
                case "clear":
                    S.clear();
                    break;
                case "exit":
                    System.out.println("bye");
                    return;
            }
        }
    }
}
class MyStack{
    private LinkedList<Integer> data =new LinkedList<>();
    public void push(int n){
        data.add(n);
        System.out.println("ok");
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("error");
        }
        else{
            System.out.println(data.getLast());
            data.removeLast();
        }
    }
    public void back(){
        if(isEmpty()){
            System.out.println("error");
        }
        else{
            System.out.println(data.getLast());
        }

    }
    public void clear(){
        System.out.println("ok");
        data = new LinkedList<>();
    }
    public void size(){
        System.out.println(data.size());
    }
    private boolean isEmpty(){
        return data.size()==0;
    }


}