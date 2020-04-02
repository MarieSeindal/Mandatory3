import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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

////////// https://www.baeldung.com/java-multi-dimensional-arraylist
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(totalPeople);

        for (int i = 0; i < totalPeople; i++) {
            graph.add(new ArrayList());
        }
        
        for (int i = 0; i < amountOfHandshakes; i++) { // graph with handshakes
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            //graph.get(b).add(a);
            //todo test for the array array thing is alright
            System.out.println(graph.toString());
        }
////////////////////////////////////////////////////////////////////////



        boolean[] infected = new boolean[totalPeople];
        infected[patientZero]=true; // true infect patient 0

        //Current person to check handshakes.
        int currentP = patientZero;
        Stack<Integer> neigboursToBeChecked = new Stack<Integer>();
        neigboursToBeChecked.push(patientZero);

        boolean end = false;
        while(!end){
            
            for (int j = 0; j < graph.get(currentP).size(); j++) { // infects all the neighbors of node currentP
                infected[graph.get(currentP).get(j)]=true;
                neigboursToBeChecked.push(graph.get(currentP).get(j)); // adds the neigbour to a stack of neighbours to check through
                peopleNowInfected++;

            }

            currentP = neigboursToBeChecked.peek(); // selects the nex neighbour to infect people
            neigboursToBeChecked.pop();
            System.out.println(currentP); // todo


            if (neigboursToBeChecked.empty()) {
                end = true;
                System.out.println(peopleNowInfected);
            }

        }

    }

}
