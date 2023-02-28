package ya.contest;

import java.io.*;

public class MatrixSum {
    public static void main(String[] args) throws IOException {
        File fin = new File("08.in");
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

            int sum=0;
            for (int j = x1; j <=x2  ; j++) {
                int X1 = j*M+y1;
                int X2 = j*M+y2;
                if(X1-1>=0) sum+=mxSum[X2]-mxSum[X1-1];
                else sum+=mxSum[X2];
            }
            pw.write(sum+"\n");
        }
        br.close();
        pw.close();
    }
}