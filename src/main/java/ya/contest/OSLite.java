package ya.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class OSLite {
    public static void removeAndAdd(ArrayList<int[]> systems, int[] system, int index){
        int ix = index;
        if(ix>0 && systems.get(ix-1)[1]>=system[0]) {
            systems.remove(ix-1);
            ix--;
        }
        if(ix<systems.size()){
            int next = systems.get(ix)[0];

            while(next<=system[1] && ix<systems.size()){
                next = systems.get(ix)[0];
                if(next<=system[1])systems.remove(ix);
            }
        }

        if(ix <systems.size()) systems.add(ix,system);
        else systems.add(system);

    }
    public static void putOS(ArrayList<int[]> systems, int[] system){
        if(systems.size()==0) {
            removeAndAdd(systems,system, systems.size());
            return;
        }
        if(systems.get(0)[0]>system[0]) {
            removeAndAdd(systems,system, 0);
            return;
        }
        else{
            for (int i = 0; i < systems.size()-1; i++) {
                if(systems.get(i)[0]<=system[0] && systems.get(i+1)[0] >=system[0]){
                    removeAndAdd(systems,system, i+1);
                    return;
                }
            }
        }
        removeAndAdd(systems,system, systems.size());

    }
    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File("input.txt");
        Scanner sc = new Scanner(fin);
        int M = sc.nextInt();
        int N = sc.nextInt();
        ArrayList<int[]> systems = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            putOS(systems, new int[] {sc.nextInt(), sc.nextInt()});
        }
        System.out.println(systems.size());
    }
}
