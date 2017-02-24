import java.util.Scanner;

public class Pave {

    public static void main(String[] args) {
        int h = 1;
        int lo = 1;
        int la = 1;

        System.out.println("Entrez la hauteur");
        Scanner scan = new Scanner (System.in);

        do {
            h = scan.nextInt();

            if(h<0) {
                System.out.println("Merci de donner une valeur positive à la hauteur");
            }
        } while (h<0);


        System.out.println("Entrez la longueur");

        do {
            lo = scan.nextInt();

            if(lo<0) {
                System.out.println("Merci de donner une valeur positive à la longueur");
            }
        } while (lo<0);

        System.out.println("Entrez la largeur");

        do {
            la = scan.nextInt();

            if(la<0) {
                System.out.println("Merci de donner une valeur positive à la largeur");
            }
        } while(la<0);

        int v = h*lo*la;
        System.out.println("La hauteur est égale à " + h + " ,la longueur est égale à "+ lo + " et la largeur est égale à " + la);
        System.out.println("Le volume est de " + v + " m3");

    }
}
