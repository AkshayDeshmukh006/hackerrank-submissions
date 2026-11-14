import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    String time="";
    String[] timeSplit=s.split(":");
    int hour=Integer.parseInt(timeSplit[0]);
    if(s.endsWith("PM")&&hour!=12){
        hour+=12;
        time+=hour;
        time+=":"+timeSplit[1]+":"+timeSplit[2];
    }
    else if(s.endsWith("PM")&&hour==12){
        time=s;
    }
    else{
        if(Integer.parseInt(timeSplit[0])==12){
            time+="00:";
            time+=timeSplit[1]+":"+timeSplit[2];
        }
        else{
            time=s;
        }
    }
    time=time.replaceAll("(AM|PM|am|pm)", "");
    return time;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
