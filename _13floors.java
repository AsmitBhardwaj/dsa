import java.util.Scanner;

public class _13floors{
    public static void main(String[] args) {
      
      //get floor number
       Scanner sc = new Scanner(System.in);

        int floor = sc.nextInt();

        //if floor < 13
        if(floor < 13){ 
            System.out.print(floor);
        }
        //if floor is 13
        else if(floor == 13){
            System.out.print(floor+1);
        }
        //floor > 13
        else{
            System.out.print(floor+1);
        }
    

    
    }
}
