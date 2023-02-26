package ya.contest;

import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;



public class QueueBezOshibok {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File fin = new File("input.txt");
        File fout = new File("output.txt");
        PrintWriter pw = new PrintWriter(fout);

        BufferedReader br = new BufferedReader(new FileReader(fin));

        String [] strs = br.lines().toArray(String[]::new);
        MyQueue Q = new MyQueue(pw);
        for(int i = 0; i< strs.length; i++){
            String[] line = strs[i].split(" ");
            switch(line[0]){
                case "push":
                    Q.push(Integer.parseInt(line[1]));
                    break;
                case "pop":
                    Q.pop();
                    break;
                case "front":
                    Q.front();
                    break;
                case "size":
                    Q.size();
                    break;
                case "clear":
                    Q.clear();
                    break;
                case "exit":
                    pw.write("bye");
                    pw.close();
                    br.close();
                    return;
            }
        }
        pw.close();
       br.close();
    }
}
class MyQueue{
    private LinkedList<Integer> data = new LinkedList<>();
    private PrintWriter pw;
    public MyQueue(PrintWriter pw){
        this.pw=pw;
    }
    public void push(int n){
        data.add(n);
        pw.write("ok\n");
    }
    public void pop(){
        if(isEmpty()){
            pw.write("error\n");
        }
        else{
            pw.write(data.getFirst().toString()+'\n');
            data.removeFirst();
        }
    }
    public void front(){
        if(isEmpty()){
            pw.write("error\n");
        }
        else{
            pw.write(data.getFirst().toString()+'\n');
        }

    }
    public void clear(){
        pw.write("ok\n");
        data = new LinkedList<>();
    }
    public void size(){
        String s = String.format("%d\n", data.size());
        pw.write(s);
    }
    private boolean isEmpty(){
        return data.size()==0;
    }


}