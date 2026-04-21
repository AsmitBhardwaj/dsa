import java.util.Scanner;

public class rock {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //num of rocks
        int rocks = sc.nextInt();

        //cost of litre
        int lit = sc.nextInt();
        
        int totalcost = rocks * lit;
        System.out.print(totalcost);
    
    }
}
