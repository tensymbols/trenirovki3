package ya.contest;

import java.io.*;
import java.util.*;
public class VagonSortLite {
    public static void main(String[] args) throws IOException {
        File fin = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(fin));
        File fout = new File("output.txt");
        PrintWriter pw = new PrintWriter(fout);
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        Queue<Integer> Cars = new LinkedList<>();
        for (int i = 0; i <N ; i++) {
            Cars.add(Integer.parseInt(s[i]));
        }
        Stack<Integer> Tupik = new Stack<>();
        int currNum = 1;
        int currCar = Cars.poll();
        Tupik.push(currCar);
        while (!Cars.isEmpty()){
            while(currCar!=currNum){

            }
        }
    }
}
