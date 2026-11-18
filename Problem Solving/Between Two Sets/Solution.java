import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    
        public static int[] sort(int[] x){
        for(int i=0;i<x.length;i++){
            for(int j=i+1;j<x.length;j++){
                if(x[i]<x[j]){
                    int temp=x[i];
                    x[i]=x[j];
                    x[j]=temp;
                }
            }
        }
        return x;
    }
    
    private static int findGcd(int a, int b){
        if(b==0){
            return a;
        }
        return findGcd(b, a%b);
    }
    
    private static int findLcm(int a, int b){
        if(a==0||b==0){
            return 0;
        }
        else{
            return (a*b)/findGcd(a,b);
        }
    }

    public static int getTotalX(int[] a, int[] b) {
    // Write your code here
    int lcm=a[0];
    int gcd=b[0];
    int result=0, multiple=0;
    for(int x:a){
        lcm=findLcm(lcm, x);
    }
    
    for(int x:b){
        gcd=findGcd(gcd, x);
    }
    
    while(multiple<=gcd){
        multiple+=lcm;
        if(gcd%multiple==0){
            result++;
        }
    }
    return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);
            
        int[] arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt).mapToInt(x->x).toArray();
            
        int[] brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt).mapToInt(x->x).toArray();

        int total = Result.getTotalX(arr, brr);

        //bufferedWriter.write(String.valueOf(total));
        //bufferedWriter.newLine();
        System.out.println(total);

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
