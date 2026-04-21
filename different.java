import java.util.Scanner;

public class different {
    public static void main(String[] agrs){
        
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextDouble()){
            //take the first number
            double n1 = sc.nextDouble();
            double n2 = sc.nextDouble();

            double dif = n1 - n2;
            double abs = Math.abs(dif);

            System.out.println(abs);
        }
    }
}
