package Mandatory3;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println();
        Arrays.toString(houses.toArray());


////////// Find the longest chain



    }
}
