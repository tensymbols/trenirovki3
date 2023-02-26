package ya.contest;
import java.util.Scanner;
public class HorStroka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        long q = 0;
        for (int i = 0; i < N-1; i++) {
            if(arr[i]<=arr[i+1]) {
                q+=arr[i];
                arr[i]=0;

            }else{
                q+=arr[i+1];
            }
        }
        System.out.println(q);
    }
}
