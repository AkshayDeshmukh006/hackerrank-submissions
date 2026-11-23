import java.io.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */
     
    public static int regexMatcher(String password, String pattern){
        int count=0;
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(password);
        return m.find()?0:(count+1);
    }
    
    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
    int count=regexMatcher(password, "[A-Z]")+
        regexMatcher(password, "[a-z]")+
        regexMatcher(password, "[\\d]")+
        regexMatcher(password, "[!@#\\$%\\^&\\*\\(\\)\\-\\+ ]");
        
    if(password.length()+count<6){
        count+=6-(password.length()+count);
        return count;
    }
    else{
        return count;
    }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
