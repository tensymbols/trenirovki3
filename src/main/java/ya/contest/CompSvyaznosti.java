package ya.contest;

import java.io.*;
import java.util.*;
public class CompSvyaznosti {
    public static void dfs(ArrayList<Integer>[] adjList, ArrayList<Integer> comp,
                           int v, boolean[] visited){
        visited[v]=true;
        comp.add(v);
        for (int i = 0; i < adjList[v].size(); i++) {
            int neigh = adjList[v].get(i);
            if(!visited[neigh]){

                dfs(adjList,comp,neigh ,visited);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        File fin = new File("input.txt");
        File fout = new File("output.txt");
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String[] s;
        s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        ArrayList<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        ArrayList<Integer> comp;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");

            adjList[Integer.parseInt(s[0])-1].add(Integer.parseInt(s[1])-1);
            adjList[Integer.parseInt(s[1])-1].add(Integer.parseInt(s[0])-1);
        }
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(visited[i]==false){
                comp = new ArrayList<>();
                dfs(adjList,comp, i, visited);
                comps.add(comp);
            }
        }
        PrintWriter pw = new PrintWriter(fout);
        pw.write(comps.size()+"\n");
        for (int i = 0; i < comps.size(); i++) {
            var currComp = comps.get(i);
            pw.write(currComp.size()+"\n");
            for (int j = 0; j < currComp.size(); j++) {
                pw.write(currComp.get(j)+1+" ");
            };
            pw.write("\n");
        }
        pw.close();
    }
}
