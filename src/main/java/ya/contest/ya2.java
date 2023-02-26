package ya.contest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ya2 {
    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File("input.txt");
        Scanner sc = new Scanner(fin);

        long N = sc.nextInt();
        long X = sc.nextInt();
        long T = sc.nextLong();
        ArrayList<long[]> masses = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            long curr = sc.nextInt();
            if(curr-X<0) curr = (X-curr) +X;
            masses.add( new long[]{curr, i });
        }

        Collections.sort(masses, Comparator.comparingLong(arr -> arr[0]));

        long q = 0;
        ArrayList<Long> ideal= new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            long diff = Math.abs(masses.get(i)[0]-X);

            if(diff <= T) {

                T-=diff;
                q++;
                ideal.add(masses.get(i)[1]+1);
            }
        }
        System.out.println(q);
        Collections.sort(ideal);
        for(var i: ideal)
            System.out.println(i);
    }
}
