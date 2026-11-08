import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    private static String[] tokens(String s){
        // get Matcher for Pattern Matching
        s=s.replaceAll("[^a-zA-Z ]", " ");      
        
        String[] strToken=s.split("\\s");
        //String[] cleanToken=removeBlanks(strToken);
        return strToken;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String[] strToken=tokens(s);
        List<String> content=new ArrayList<>();
        
        for(String token:strToken){
            if(!token.isEmpty()){
                content.add(token);
            }
        }
        System.out.println(content.size());
        content.forEach(System.out::println);
        scan.close();
    }
}

