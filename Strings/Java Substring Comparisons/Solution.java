import java.util.Scanner;
import java.util.*;

public class Solution {

    public static int compare(String s1, String s2){
	return s1.compareTo(s2);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
	
	for(int i=0;i<(s.length()-k)+1;i++){
	   String substr=s.substring(i,k+i);
	   if(i==0){
		smallest=substr;
		largest=substr;
	   }
	   else{
		int result1=compare(smallest,substr);
	   	int result2=compare(largest,substr);
	    	if(result1>0){
	      	   smallest=substr;
	    	}
	    	else if(result2<0){
	         largest=substr;
	    	}
		else{

		}
	   }
	}
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      //printSubStr(s,k);
        System.out.println(getSmallestAndLargest(s, k));
    }
}