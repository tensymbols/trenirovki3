package ya.contest;

import java.util.Scanner;

public class Kuznechik {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] kletki = new int[N];
        kletki[0]=1;

        for (int i = 1; i <N; i++) {
            int r = k;
            if(i<r) r = i;
            kletki[i]=0;
            for (int j = 1; j < r+1 ; j++) {
                kletki[i]=kletki[i]+kletki[i-j];
            }
        }
        System.out.println(kletki[N-1]);
    }
}
