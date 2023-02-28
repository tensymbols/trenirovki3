package ya.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SNTP {
    public static int timeToSec(String[] time){
        int ctime=0;
        ctime+=Integer.parseInt(time[0])*3600;
        ctime+=Integer.parseInt(time[1])*60;
        ctime+=Integer.parseInt(time[2]);
        return ctime;
    }
    public static String secToTime(long time){
        StringBuilder ctime = new StringBuilder();
        long ttime=time;
        long h = ttime/3600;
        ttime-=h*3600;
        long m = ttime/60;
        ttime-=m*60;
        long s = ttime;

        if(h<10) ctime.append("0");
        ctime.append(h+":");
        if(m<10) ctime.append("0");
        ctime.append(m+":");
        if(s<10) ctime.append("0");
        ctime.append(s);
        return ctime.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File("input.txt");
        Scanner sc = new Scanner(fin);
        int A = timeToSec(sc.nextLine().split(":"));
        int B = timeToSec(sc.nextLine().split(":"));
        int C = timeToSec(sc.nextLine().split(":"));
        if(C<A) C+=86400;
        long deliveryTime = Math.round((C-A)/2.0);

        long currTime = (B+deliveryTime) %86400;
        System.out.println(secToTime(currTime));
    }
}