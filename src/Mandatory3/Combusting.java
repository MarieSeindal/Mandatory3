
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

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Combusting {

    public void combust() {
        Scanner tastatur = new Scanner(System.in);
        int n = Integer.parseInt(tastatur.nextLine());

        int m = Integer.parseInt(tastatur.nextLine());

        int[] Ingredients = new int[n];

        for(int i = 0; i<Ingredients.length;i++){

        }



    }


    public static void main(String[] args) {
        Combusting c = new Combusting();
        c.combust();

    }


}
