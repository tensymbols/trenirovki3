package ya.contest;

import java.io.*;

import java.util.Arrays;


class Diego {
    public static int search(int arr[], int target, int size) {
        if(size==0) return 0;

        int left = 0;
        int right = size - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if(pivot-1<0){
                if(arr[pivot] >= target){
                    return 0;
                }
            }else{
                if(arr[pivot-1]<target && arr[pivot]>=target)
                    return pivot;
            }
            if (arr[pivot]== target) return pivot;
            if (arr[pivot] > target) {
                right = pivot - 1;
            }
            if (arr[pivot] < target) {
                left = pivot + 1;
            }
        }
        return size;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] sints = br.readLine().split(" ");

        for(int i = 0; i<n;i++){
            arr[i]=Integer.parseInt(sints[i]);
        }


        Arrays.sort(arr);
        int[] arr2 = new int[n];

        int j = 0;
        arr2[0] = arr[0];
        j++;
        for (int i = 1; i < n; i++) {
            if(arr[i]!=arr[i-1]) {
                arr2[j]=arr[i];
                j++;
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder();
        File fout = new File("output.txt");
        PrintWriter pw = new PrintWriter(fout);
        String[] sints2 = br.readLine().split(" ");
        for(int i = 0; i<k; i++){

            s.append(search(arr2,Integer.parseInt(sints2[i]), j)+" ");
        }
        br.close();
        pw.write(s.toString());
        pw.close();
    }
}