package ya.contest;

import java.io.*;

import java.util.*;
public class Pyanitsa {
    public static void main(String[] args) throws IOException {

        File fin = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(fin));
        File fout = new File("output.txt");
        PrintWriter pw = new PrintWriter(fout);
        Deque<Integer> firstPlayer = new ArrayDeque<>();
        Deque<Integer> secondPlayer = new ArrayDeque<>();

        String s1[] = br.readLine().split(" ");
        String s2[] = br.readLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            firstPlayer.add(Integer.parseInt(s1[i]));
            secondPlayer.add(Integer.parseInt(s2[i]));
        }
        int k =0;
        boolean botva = false;
        while(firstPlayer.size()!=0 && secondPlayer.size()!=0){
            if(k==1e6) {
                botva = true;
                break;
            }
            k++;
            int first = firstPlayer.pollFirst();
            int second = secondPlayer.pollFirst();
            if((first>second && !( first == 9 && second == 0)) || first == 0 && second == 9 ){
                firstPlayer.addLast(first);
                firstPlayer.addLast(second);
            } else{
                secondPlayer.addLast(first);
                secondPlayer.addLast(second);
            }
        }
        if(botva) pw.write("botva");
        else if(firstPlayer.size()==0) pw.write("second "+k);
        else pw.write("first "+k);
        pw.close();

    }
}
