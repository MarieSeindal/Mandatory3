import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Hands {

    // make a list for each person, containing the person they hand shaked.
    // Then check patient0 and his handshakes.
    // Then check the lists for his handhakes.

    public static void main(String[] args) {

//////////input and start
        Scanner sc = new Scanner(System.in);

        int patientZero = sc.nextInt();
        int totalPeople = sc.nextInt();
        int peopleNowInfected = 1;
        int amountOfHandshakes = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(totalPeople);
        
        for (int i = 0; i < amountOfHandshakes; i++) { // graph with handshakes
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        
        boolean[] infected = new boolean[totalPeople];
        infected[patientZero]=true; // true infect pation 0

        // make a boolean table totPeop x totPeop, where its set to true if the index people know each other.

        boolean[][] handshakeTable = new boolean[totalPeople][totalPeople];

        for (int i = 0; i <totalPeople; i++) {
            int currentP = patientZero;

            for (int j = 0; j < graph.get(patientZero).size(); j++) { //

            }


        }

        
//////////Logic






    }
}
