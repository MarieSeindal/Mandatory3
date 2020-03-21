
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
        int[] naboListe = new int[numOfIngredients - 1];

        // generer 2d array med boom-par
        int[][] boomInput = new int[2][numOfBoomPairs];
        for (int i = 0; i < numOfBoomPairs; i++) {
            boomInput[0][i] = tastatur.nextInt();
            boomInput[1][i] = tastatur.nextInt();
        }

        // generer Adjacency Matrix, med true på ulovlige kombinationer
        boolean[][] boomTable = new boolean[numOfIngredients][numOfIngredients];
        for (int i = 0; i < numOfIngredients; i++) {
            for (int j = 0; j < numOfIngredients; j++) {
                boomTable[i][j] = false;
            }
        }
        for (int i = 0; i < numOfBoomPairs; i++) {
            boomTable[boomInput[0][i]] [boomInput[1][i]] = true;
            boomTable[boomInput[1][i]] [boomInput[0][i]] = true;
        }

        for (int i = 0; i < numOfIngredients; i++) { //todo
            for (int j = 0; j < numOfIngredients; j++) {
                System.out.print(boomTable[i][j] + " ");
            }
            System.out.println("");
        }



        for (int i = 0; i < numOfIngredients; i++) { //todo
            for (int j = 0; j < numOfIngredients; j++) { //todo
                //System.out.println("BoomTable efter boom markering: " + boomTable[i][j] + ", index: " + i + ";" + j); //todo
            } //todo
        } // todo


//////// Tjek for ulovlige naboer

        boolean[] potte1 = new boolean[numOfIngredients]; // initialiserer vores potter
        boolean[] potte2 = new boolean[numOfIngredients];

        for (int i = 0; i < numOfIngredients; i++) { //todo Irrelevant, da den er flase før jeg sætter den til false???
            //System.out.println("Potte tjek1, potte 1: " + potte1[i] + ", potte 2: " + potte2[i] + ", index: " + i);
            potte1[i] = false;
            potte2[i] = false;
            //System.out.println("Potte tjek2, potte 1: " + potte1[i] + ", potte 2: " + potte2[i] + ", index: " + i);

        }

        boolean boom = false; // Vi er ikke eksploderet endnu ;-)

        for (int i = 0; i < numOfIngredients; i++) { //Tjek hver ingrediens

            //Tjek potte 1
            //Sammenlig indgredient i med boomTable. Den er true hvor der er ulovlige forbindelser
            for (int j = 0; j < numOfIngredients; j++) { // tjek for hver potentiel nabo (aka hver ingrediens)

                boolean notPotte1 = false; // if true, then its not in potte 1
                for (j = j; j < numOfIngredients; j++) { // potte 1

                    if (boomTable[i][j] || boomTable[j][i]) { //Hvis den er der, skal den ud af for-loopet og fortsætte til potte 2
                        System.out.println(i + " har ugyldig nabo: " + j);
                        notPotte1 = true;
                        j++;
                        break;
                    }
                    // Da vi lægger dem i potten i kronologisk rækkefølge, så behøver vi ikke tjekke efer den nabo vi er nået til, (Ny linje)
                    // da vi ikke har putttet efterfølge naboer i endnu.
                    else if (j == i) {
                        potte1[i] = true; // Hvis den ikke finder en ulovlig nabo, så "Put den i potten"
                        System.out.println("Potte 1 tilføjet indegrediens: " + i); //todo
                        break;
                    }
                    else if(!notPotte1){
                        potte1[i] = true; // Hvis den ikke finder en ulovlig nabo, så "Put den i potten"
                        System.out.println("Potte 1 tilføjet indegrediens: " + i); //todo
                        break;
                    }

                }

                if (!potte1[i]) { // Hvis den ikke er i potte 1, så tjek her her
                    for (j = j; j < numOfIngredients; j++) {
                        if (boomTable[i][j] || boomTable[j][i]) { //Hvis den også er her, skal den ud af for-loopet og BOOM! Da der ikke er nogen mulig plads til den.

                            System.out.println(i + " har ugyldig nabo: " + j);
                            boom = true; // Sætter boom til true
                            System.out.println("BOOM!");
                            break;

                        }
                        if (!boom) {
                            potte2[i] = true; // Hvis den ikke finder en ulovlig nabo, så "Put den i potten"
                            System.out.println("Potte 2 tilføjet indgrediens: " + i); //todo
                            break;
                        }
                    }

                }
                break;
            }
            //Tjek om boom er opstået, hvis ja bryd ud
            if (boom)
                break;

        }

////////Print resultat

        //Generer resultat potte 1
        String potte1Res = "";
        for (int i = 0; i < numOfIngredients; i++) { //Aflæs potte 1
            if (potte1[i]) {
                potte1Res += i;
                potte1Res += " ";
            }
        }

        //Generer resultat potte 2
        String potte2Res = "";
        for (int i = 0; i < numOfIngredients; i++) { //Aflæs potte 2
            if (potte2[i]) {
                potte2Res += i;
                potte2Res += " ";
            }
        }

        if (!boom && potte1Res.length() >= potte2Res.length())
            System.out.println(potte1Res + "\n" + potte2Res);
        else if (!boom && potte1Res.length() <= potte2Res.length())
            System.out.println(potte2Res + "\n" + potte1Res);



    }
}
