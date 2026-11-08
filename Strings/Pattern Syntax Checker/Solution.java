import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
    private static String validatePattern(String regex){
        try{
            Pattern p=Pattern.compile(regex);
            return "Valid";
        }
        catch(PatternSyntaxException e){
            return "Invalid";
        }
    }
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
          	//Write your code
            System.out.println(validatePattern(pattern));
            testCases--;
		}
	}
}



