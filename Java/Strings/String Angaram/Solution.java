import java.util.Scanner;

public class Solution {

    static String sort(String str){
        String sortedString="";
        char[] charStr=str.toCharArray();
        for(int i=0;i<charStr.length;i++){
            for(int j=i+1;j<charStr.length;j++){
                if(charStr[i]<charStr[j]){
                    char temp=charStr[i];
                    charStr[i]=charStr[j];
                    charStr[j]=temp;
                }
            }
        }
        sortedString=String.valueOf(charStr);
        return sortedString;
    }
    
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(!(a.length()==b.length())){
            return false;
        }
        else{
         a=a.toLowerCase();
        b=b.toLowerCase();
        String sortA=sort(a);
        String sortB=sort(b);
        return sortA.equals(sortB);   
        }
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
