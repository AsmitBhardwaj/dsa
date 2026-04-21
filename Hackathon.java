import java.util.Scanner;

public class Hackathon{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //num of hackathons
        int num = sc.nextInt();

        //money spent by dep
        int mon = sc.nextInt();

        //money won each hackathin
        int hac = sc.nextInt();

        int ans = hac * num;
        System.out.println(ans);

    }
}