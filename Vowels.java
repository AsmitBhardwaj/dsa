import java.util.Scanner;

public class Vowels {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //make the sentence into a single String

        String str = sc.nextLine();
        String word = str.trim();
        word = word.toLowerCase();

        int count = 0;
        int n = word.length();
        for(int i = 0; i < n; i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                count++;
            }
        }

        System.out.println(count);


    }
    
}
