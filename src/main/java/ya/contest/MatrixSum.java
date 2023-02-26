package ya.contest;

import java.io.*;
import java.util.Scanner;
public class MatrixSum {
    public static void main(String[] args) throws IOException {
        long one = System.currentTimeMillis();
        File fin = new File("input.txt");
        File fout = new File("output.txt");

        BufferedReader br = new BufferedReader(new FileReader(fin));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);
        int [][] mx= new int[N][M];
        int [] mxSum = new int[N*M];
        for (int i = 0; i < N; i++) {
            mx[i] = new int[M];
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                mx[i][j]= Integer.parseInt(s[j]);
                int currIx = i*M+j;
                if(i+j!=0) mxSum[currIx] = mxSum[currIx-1]+mx[i][j];
                else mxSum[currIx]=mx[i][j];
            }
        }

        PrintWriter pw = new PrintWriter(fout);
        for (int i = 0; i < K; i++) {
            s= br.readLine().split(" ");
            int x1 =  Integer.parseInt(s[0])-1;
            int y1 =  Integer.parseInt(s[1])-1;
            int x2 =  Integer.parseInt(s[2])-1;
            int y2 =  Integer.parseInt(s[3])-1;
            int X1 = y1*M+x1;
            int X2 = y2*M+x2;
            System.out.println("COORDS: "+X1+","+X2);
            System.out.println(mxSum[X2]-mxSum[X1]);
        }
        br.close();
        pw.close();
        System.out.println(System.currentTimeMillis()-one);
    }
}