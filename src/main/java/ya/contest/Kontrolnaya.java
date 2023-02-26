package ya.contest;
import java.util.*;

public class Kontrolnaya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int vars = sc.nextInt();
        int PetyaRow = sc.nextInt();
        int PetyaPlace = sc.nextInt();

        int PetyaPos = (PetyaRow-1)*2+PetyaPlace;
        boolean front = (PetyaPos-vars>0);
        boolean behind = (PetyaPos+vars<=n);
        if(!(front || behind)) System.out.println(-1);
        else{

            int VasyaPos1 = PetyaPos+vars;
            int VasyaPlace1 = (VasyaPos1 % 2==0) ? 2 : 1;
            int VasyaRow1 = (VasyaPos1-VasyaPlace1+2)/2;


            int VasyaPos2 = PetyaPos-vars;
            int VasyaPlace2 = (VasyaPos2 % 2==0) ? 2 : 1;
            int VasyaRow2 = (VasyaPos2-VasyaPlace2+2)/2;

            if(Math.abs(VasyaRow1-PetyaRow)<=Math.abs(VasyaRow2-PetyaRow) && behind)
                System.out.println(VasyaRow1+" "+VasyaPlace1);
            else
                System.out.println(VasyaRow2+" "+ VasyaPlace2);
        }
    }
}
