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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    Map<Integer, Long>  birdsSighting=arr.stream()
    .collect(Collectors
    .groupingBy(Function.identity(), Collectors.counting()));
    int sight=0;
    long maxCount=0;
    for(Map.Entry<Integer, Long> entry:birdsSighting.entrySet()){
        if(entry.getValue()>1){
            if(sight==0||entry.getKey()<sight){
                sight=entry.getKey();
                maxCount=entry.getValue();
            }
            else if(entry.getValue()>maxCount){
                sight=entry.getKey();
                maxCount=entry.getValue();
            }
            else if(maxCount==entry.getValue()&&entry.getKey()<sight){
                sight=entry.getKey();
                maxCount=entry.getValue();
            }
            else{}
        }
    }
    return sight;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
