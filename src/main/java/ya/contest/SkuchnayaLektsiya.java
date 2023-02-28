package ya.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SkuchnayaLektsiya {
    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File("input.txt");
        File fout = new File("output.txt");
        long one = System.currentTimeMillis();
        Scanner sc = new Scanner(fin);
        String s = sc.nextLine();
        long[] q = new long[26];
        for (int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i)-97;
            long first = i+1;
            long second = s.length()-i;
            q[index]= q[index]+first*second;;
        }
        PrintWriter pw = new PrintWriter(fout);
        for (int i = 0; i < q.length; i++) {
            if(q[i]>0){
                pw.write(((char)(i+97))+": ");
                pw.write(q[i]+"\n");

            }
        }
        pw.close();
    }
}
