package ya.contest;

import java.io.*;
import java.util.*;
public class PoiskVGlubinu {
    public static void dfs(ArrayList<Integer>[] adjList, ArrayList<Integer> comp,
                          int v, boolean[] visited){
        visited[v]=true;
        comp.add(v);
        for (int i = 0; i < adjList[v].size(); i++) {
            int neigh = adjList[v].get(i);
            if(visited[neigh]==false){

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
        ArrayList<Integer> comp = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");

            adjList[Integer.parseInt(s[0])-1].add(Integer.parseInt(s[1])-1);
            adjList[Integer.parseInt(s[1])-1].add(Integer.parseInt(s[0])-1);
        }
        dfs(adjList,comp, 0,visited);
        Collections.sort(comp);
        System.out.println(comp.size());
        for(var i: comp) System.out.print(i+1+" ");
    }
}
