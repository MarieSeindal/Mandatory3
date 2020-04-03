import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Hands2 {

    // make a list for each person, containing the person they hand shaked.
    // Then check patient0 and his handshakes.
    // Then check the lists for his handhakes.

    public static void main(String[] args) {

//////////input
        Scanner sc = new Scanner(System.in);

        int patientZero = sc.nextInt();
        int totalPeople = sc.nextInt();
        int peopleNowInfected = 1;
        int amountOfHandshakes = sc.nextInt();






        boolean[] infected = new boolean[totalPeople];
        infected[patientZero]=true; // true infect patient 0

        Stack<Integer> peopsToCheck = new Stack<>();




    }

}
