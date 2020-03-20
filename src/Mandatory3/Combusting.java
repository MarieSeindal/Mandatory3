
package Mandatory3;
//algoritme:
//der er to boolean arrays af længde n
// tjek for det første tal-input om boolean værdien er 0 i det første array
// hvis den er 0 så sæt den til 1 og sæt andet input tals tilsvarende booleanske værdi i array 2 til 1
// gentag
// til sidst: hvis samme talværdi er sat til 1 i begge arrays så returner BOOM
// ellers returner de tilsvarende talværdier

//input er:
// N - antal ingredienser
// M - antal parvise exploderende ingredienser
// M antal linjer, hver linje med to tal skilt af mellemrum


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Combusting {

    public static void main(String[] args) {

//////// Input
        Scanner tastatur = new Scanner(System.in);
        int numOfIngredients = tastatur.nextInt();          //n
        int numOfBoomPairs = tastatur.nextInt();            //m

        // Array fra 0 til det højeste nr. indgredient
        int[] indgredients = new int[numOfIngredients];
        int[] naboListe = new int[numOfIngredients];
        for (int i =0; i<numOfIngredients; i++){
            indgredients[i]=i;                              // Dette er alle ingredienser, som skal tjekkes om de siger boom.
            naboListe[i]=i;                                 // Dette er alle ingredienser, som skal ind på nabolisten. Senere kommer deres naboer ind på

        }

        //
        LinkedList<Integer> boomListe = new LinkedList<>();

        for (int i =0; i<numOfBoomPairs*2; i++){
            naboListe.
        }

//////// Sorter Indgredienser


//////// Tjek for ulovlige naboer

        boolean[] potte1 = new boolean[numOfIngredients]; // initialiserer vores potter
        boolean[] potte2 = new boolean[numOfIngredients];




    }


//    public static void main(String[] args) {
//        Combusting c = new Combusting();
//        c.combust();
//
//    }


}
