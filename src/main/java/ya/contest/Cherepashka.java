package ya.contest;

import java.io.*;
import java.util.*;

public class Cherepashka {
    public static void main(String[] args) throws IOException {
        File fin = new File("input.txt");
        File fout = new File("output.txt");
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String[] s;
        s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] mx = new int[N+1][M+1];
        for (int i = 0; i <= N; i++) mx[i] = new int[M+1];
        for (int i = 1; i <= N; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                mx[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                mx[i][j]+=Math.max(mx[i-1][j], mx[i][j-1]);
            }
        }
        int i = N;
        int j = M;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        while(i>1 || j>1){
            int first = 0;
            int second = 0;
            if(i>0){
                first = mx[i-1][j];
            }
            if(j>0){
                second = mx[i][j-1];
            }
            if(second>first){
                stack.addLast('R');
                j--;
               } else{
                stack.addLast('D');
                i--;
            }
        }
        PrintWriter pw = new PrintWriter(fout);
        pw.write(mx[N][M]+"\n");
        while (!stack.isEmpty()) pw.write(stack.pollLast()+" ");
        pw.close();

    }
}
