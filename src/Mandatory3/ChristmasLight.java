package Mandatory3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChristmasLight {
    public static void main(String[] args) {

////////// take input
        Scanner sc = new Scanner(System.in);
        int numOfhouses = sc.nextInt();
        ArrayList<Integer> houses = new ArrayList<>();
        for (int i = 0; i < numOfhouses; i++) {
            houses.add(sc.nextInt());
        }

////////// Sort list of houses
        Collections.sort(houses);

////////// Find the longest chain
        int longestCount=0;
        int currentCount=0;

        for (int i = 0; i<numOfhouses-1; i++){
            //System.out.println("Comparing: " + houses.get(i) + "+1 " + houses.get(i+1) );
            if (houses.get(i)+1 == houses.get(i+1)){
                //Hvis det nuværende husnummer+1 er lig med det næste husnummer
                currentCount++;
                if (currentCount>longestCount) //Find kun den største kæde af husnumre
                    longestCount=currentCount;
            }
            else
                currentCount=0;

        }
        longestCount++; //Jeg tæller alle "Forbindelserne" mellem husene, og den vil gerne have antal huse. Derfor +1.
        System.out.println(longestCount);


    }
}
