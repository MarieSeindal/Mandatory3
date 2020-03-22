
package Mandatory3;

//input er:
// N - antal ingredienser
// M - antal parvise exploderende ingredienser
// M antal linjer, hver linje med to tal skilt af mellemrum


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Combusting {
    static class Graph{
        int numOfIngredients;
        LinkedList<Integer> adjList[];

        Graph(int numOfIngredients){
            this.numOfIngredients = numOfIngredients;
            //definerer størrelsen
            adjList = new LinkedList[numOfIngredients];

            for(int i = 0; i < numOfIngredients; i++){
                adjList[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(Graph graph, int src, int dest){
        graph.adjList[src].add(dest);
        graph.adjList[dest].add(src);
    }

    static void printGraph(Graph graph){
        for(int m = 0; m<graph.numOfIngredients; m++){
            System.out.print("adjecency list: "+ m);

            for(Integer p: graph.adjList[m]){
                System.out.print(" -> "+p);
            }

            System.out.println("\n");
        }
    }


    public static void main(String[] args) {

//////// Input
        Scanner tastatur2 = new Scanner(System.in);
        int numOfIngredients = tastatur2.nextInt();          //n
        int numOfBoomPairs = tastatur2.nextInt();            //m
///// TEstDATA

        //int numOfIngredients = 6;          //n
        //int numOfBoomPairs = 6;


        //Scanner tastatur2 = new Scanner(System.in);
        Graph graph = new Graph(numOfIngredients);
        addEdge(graph, tastatur2.nextInt(),tastatur2.nextInt());
        addEdge(graph, tastatur2.nextInt(),tastatur2.nextInt());
        addEdge(graph, tastatur2.nextInt(),tastatur2.nextInt());
        addEdge(graph, tastatur2.nextInt(),tastatur2.nextInt());
        addEdge(graph, tastatur2.nextInt(),tastatur2.nextInt());
        addEdge(graph, tastatur2.nextInt(),tastatur2.nextInt());

//        Graph graph = new Graph(numOfIngredients);
//        addEdge(graph, 0,1);
//        addEdge(graph, 1,2);
//        addEdge(graph, 2,3);
//        addEdge(graph, 3,4);
//        addEdge(graph, 1,5);
//        addEdge(graph, 3,5);

        printGraph(graph);

        // Array fra 0 til det højeste nr. indgredient
        int[] indgredients = new int[numOfIngredients];
        int[] naboListe = new int[numOfIngredients - 1];

        // generer 2d array med boom-par
        /*
        int[][] boomInput = new int[2][numOfBoomPairs];
        int numOfIngredients = tastatur.nextInt();          //n
        int numOfBoomPairs = tastatur.nextInt();   for (int i = 0; i < numOfBoomPairs; i++) {
            boomInput[0][i] = tastatur.nextInt();
            boomInput[1][i] = tastatur.nextInt();
        }*/


        // generer Adjacency Matrix, med true på ulovlige kombinationer
//        boolean[][] boomTable = new boolean[numOfIngredients][numOfIngredients];
//        for (int i = 0; i < numOfIngredients; i++) {
//            for (int j = 0; j < numOfIngredients; j++) {
//                boomTable[i][j] = false;
//            }
//        }
//        for (int i = 0; i < numOfBoomPairs; i++) {
//            boomTable[boomInput[0][i]] [boomInput[1][i]] = true;
//            boomTable[boomInput[1][i]] [boomInput[0][i]] = true;
//        }

        //det stemmer
//        for (int i = 0; i < numOfIngredients; i++) { //todo
//            for (int j = 0; j < numOfIngredients; j++) {
//                System.out.print(boomTable[i][j] + " ");
//            }
//            System.out.println("");
//        }



//        for (int i = 0; i < numOfIngredients; i++) { //todo
//            for (int j = 0; j < numOfIngredients; j++) { //todo
//                //System.out.println("BoomTable efter boom markering: " + boomTable[i][j] + ", index: " + i + ";" + j); //todo
//            } //todo
//        } // todo


//////// Tjek for ulovlige naboer

        boolean[] potte1 = new boolean[numOfIngredients]; // initialiserer vores potter, de er pr default false
        boolean[] potte2 = new boolean[numOfIngredients];



        boolean boom = false; // Vi er ikke eksploderet endnu ;-)



////////Check naboerne
        for(int m = 0; m<graph.numOfIngredients; m++){
            for(Integer p: graph.adjList[m]){
                //hvis p ikke er i potte1
                if(potte1[p] == false){
                    System.out.print("for "+m+" :");
                    System.out.print("naboen "+p+" er ikke i potte1");
                    System.out.println(" ======= putter "+m+" i potte1");
                    potte1[m] = true;
                    break;
                    //putter ingredienserne i
                }

                //hvis p er i potte1 men ikke er i potte2
                else if(potte2[p] == false){
                    System.out.print("for "+m+" :");
                    System.out.print("naboen "+p+" er ikke i potte2");
                    System.out.println(" ======= putter "+m+" i potte2");
                    //putter ingredienserne i
                    potte2[m] = true;
                    break;
                }
                //eller er p i begge potter  == BOOM
                else if(potte1[p] ==true && potte2[p] == true){
                    System.out.print("for "+m+" :");
                    System.out.println("BOOM");
                    //putter ingredienserne i
                    break;
                }
            }
        }




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
