import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */

    public static void bonAppetit(int[] bill, int k, int b) {
    // Write your code here
    long annaBill=0;
    if(k<bill.length){
        for(int i=0;i<bill.length;i++){
            if(i!=k){
                annaBill+=bill[i];
            }
        }
        annaBill/=2;
        if(b>annaBill){
            System.out.println(b-annaBill);
        }
        else if(b==annaBill){
            System.out.println("Bon Appetit");
        }
        else{}
    }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int[] bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt).mapToInt(x->x).toArray();

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
