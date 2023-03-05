package ya.contest;

import java.io.*;
import java.util.*;
public class Lineland {
    public static void main(String[] args) throws IOException {
        File fin = new File("input.txt");
        File fout = new File("output.txt");
        BufferedReader br = new BufferedReader(new FileReader(fin));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] cities = new int[N];
        for (int i = 0; i < cities.length; i++) cities[i]=-1;

        for (int i = 0; i <  N; i++) {
            int curr = Integer.parseInt(s[i]);
            while(!stack.isEmpty() && curr<stack.peekLast()[1]){

                int[] currElement = stack.pollLast();
                cities[currElement[0]]=i;
            }
            stack.add(new int[]{i, curr});

        }
        PrintWriter pw = new PrintWriter(fout);
        for (int i = 0; i < cities.length; i++) pw.write(cities[i]+" ");
        pw.close();
    }
}
