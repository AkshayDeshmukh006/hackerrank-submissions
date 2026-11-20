import java.io.*;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
     
     private static boolean checkGregoriaLeapYear(int year){
        if(year%400==0||(year%4==0&&year%100!=0))
        return true;
        else
        return false;
     }
     
     private static boolean checkJulianLeapYear(int year){
        if(year%4==0)
        return true;
        else
        return false;
     }
     
     private static int calculateDays(int year){
        int daysSum=((31*5)+(30*2));
        if(year==1918)
        daysSum-=13;
        return daysSum;
     }

    public static String dayOfProgrammer(int year) {
    // Write your code here
    int daysSum=calculateDays(year);
    if(year>=1700&&year<=1917){
        if(checkJulianLeapYear(year)){
            daysSum+=29;
        }
        else{
            daysSum+=28;
        }
    }
    else{
        if(checkGregoriaLeapYear(year)){
            daysSum+=29;
        }
        else{
            daysSum+=28;
        }
        
    }
    daysSum=daysSum<256?(256-daysSum):(daysSum-256);
    return daysSum+".09"+"."+year;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
