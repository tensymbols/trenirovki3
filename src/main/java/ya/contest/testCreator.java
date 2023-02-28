package ya.contest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class testCreator {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("input.txt");
        PrintWriter pw = new PrintWriter(f);
        pw.write("100000\n");
        for (int i = 0; i < 100000; i++) {
            pw.write("1000000000 ");
        }
        pw.write("\n");
        for (int i = 0; i < 100000; i++) {
            pw.write("1000000000 ");
        }
        pw.write("\n");
        pw.write("100000");
        pw.write("\n");
        for (int i = 0; i < 100000; i++) {
            pw.write("1000000000 ");
        }
        pw.close();
    }

}
