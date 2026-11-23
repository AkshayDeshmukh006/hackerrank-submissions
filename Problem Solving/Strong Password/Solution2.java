import java.io.*;
import java.util.regex.*;

class Result2 {

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
    int count=0;
        
    boolean isUpperCase=false, isLowerCase=false,isNumber=false, isSpecial=false;
    for(char c:password.toCharArray()){
        if(c>='A'&&c<='Z'){
            isUpperCase=true;
        }
        else if(c>='a'&&c<='z'){
            isLowerCase=true;
        }
        else if(c>='0'&&c<='9'){
            isNumber=true;
        }
        else{
            isSpecial=true;
        }
    }
    if(!isUpperCase){
        count++;
    }
    if(!isLowerCase){
        count++;
    }
    if(!isNumber){
        count++;
    }
    if(!isSpecial){
        count++;
    }
    if(password.length()+count<6){
        count+=6-(password.length()+count);
        return count;
    }
    else{
        return count;
    }
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result2.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
