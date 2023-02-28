package ya.contest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;



public class DequeBezOshibok {
    public static void main(String[] args) throws IOException {

        File fin = new File("input.txt");
        File fout = new File("output.txt");
        PrintWriter pw = new PrintWriter(fout);

        BufferedReader br = new BufferedReader(new FileReader(fin));

        String [] strs = br.lines().toArray(String[]::new);
        MyDeque Q = new MyDeque(pw);
        for(int i = 0; i< strs.length; i++){
            String[] line = strs[i].split(" ");
            switch(line[0]){
                case "push_front":
                    Q.push_front(Integer.parseInt(line[1]));
                    break;
                case "pop_front":
                    Q.pop_front();
                    break;
                case "push_back":
                    Q.push_back(Integer.parseInt(line[1]));
                    break;
                case "pop_back":
                    Q.pop_back();
                    break;
                case "front":
                    Q.front();
                    break;
                case "back":
                    Q.back();
                    break;
                case "size":
                    Q.size();
                    break;
                case "clear":
                    Q.clear();
                    break;
                case "exit":
                    pw.write("bye\n");
                    pw.close();
                    br.close();
                    return;
            }
        }
        pw.close();
        br.close();
    }
}
class MyDeque{
    private List<Integer> data = new ArrayList<>();
    private PrintWriter pw;
    public MyDeque(PrintWriter pw){
        this.pw=pw;
    }
    public void push_front(int n){
        data.add(0, n);
        pw.write("ok\n");
    }
    public void push_back(int n){
        data.add(n);
        pw.write("ok\n");
    }
    public void pop_front(){
        if(isEmpty()){
            pw.write("error\n");
        }
        else{
            pw.write(data.get(0).toString()+'\n');
            data.remove(0);
        }
    }
    public void pop_back(){
        if(isEmpty()){
            pw.write("error\n");
        }
        else{
            pw.write(data.get(data.size()-1).toString()+'\n');
            data.remove(data.size()-1);
        }
    }
    public void front(){
        if(isEmpty()){
            pw.write("error\n");
        }
        else{
            pw.write(data.get(0).toString()+'\n');
        }

    }
    public void back(){
        if(isEmpty()){
            pw.write("error\n");
        }
        else{
            pw.write(data.get(data.size()-1).toString()+'\n');
        }

    }
    public void clear(){
        pw.write("ok\n");
        data = new ArrayList<>();
    }
    public void size(){
        String s = String.format("%d\n", data.size());
        pw.write(s);
    }
    private boolean isEmpty(){
        return data.size()==0;
    }
}