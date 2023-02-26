package ya.contest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Gistogramma {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("file.in");

        Map<Character, Integer> h = new HashMap<>() ;
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            String s = sc.next();

            for(int i=0; i<s.length();i++){
                char c = s.charAt(i);
                if(c!=' ' && c!= '\n') {
                    if (h.get(c) != null)
                        h.put(c, h.get(c) + 1);
                    else h.put(c, 1);
                }
            }
        }
        int maxVal=0;

        for(var e: h.entrySet())
            if (e.getValue()>maxVal) maxVal=e.getValue();

        Map<Character, Integer> treeh = new TreeMap<>(h);
        char[][] mx = new char[h.size()][maxVal];

        for (int i = 0; i < mx.length; i++)
            mx[i]=new char[maxVal];

        int j=0;
        for(var e: treeh.entrySet()){
            for (int i = 0;i<maxVal; i++){
                if(i>=e.getValue()) mx[j][i]=' ';
                else mx[j][i]='#';
            }
            j++;
        }

        for (int k = mx[0].length-1 ; k >=0; k--) {
            for (int i = 0; i < mx.length; i++) {
                System.out.print(mx[i][k]);
            }
            System.out.println("");
        }
        for(var i: treeh.entrySet()){
            System.out.print(i.getKey());
        }

    }
}