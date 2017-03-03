import java.util.Scanner;

public class workSession1 {


    private static void ruler(int x, int y){

        Scanner scan = new Scanner (System.in);
        System.out.println("Taille de votre règle :");
        x = scan.nextInt();
        System.out.println("Division toute les :");
        y = scan.nextInt();


        int i;

        for(i=0; i<=x; i++){
            System.out.print("-");
            if(i % y == 0){
                System.out.print("|");
            }
        }

    }

    private static void power(int a, int n){

        Scanner scan = new Scanner (System.in);
        System.out.println("Donnez une valeur :");
        a = scan.nextInt();
        System.out.println("Donnez une puissance :");
        n = scan.nextInt();


        int i;
        int b = a;
        int c = 0;

        for(i=0; i<=n; i++){
            c = a * b;
        }

        System.out.println(c);

    }

    private static int premier(int w){

        Scanner scan = new Scanner (System.in);
        System.out.println("Donnez une valeur :");
        w = scan.nextInt();


        int v = 1;
        int f = 0;
        int i;
        int result = 1;

        for(i=2; i<w; i++){

            if(w%i == 0){
                result = f;
            }
        }
        
        if(result == 1){
            System.out.println("C'est un nombre premier");
            return result;

        }
        else{
            System.out.println("Ce n'est pas un nombre premier");
            return result;
        }

    }

    private static void table(){

        int i;
        int j;


        for(j = 0; j <= 10; j++){
            for(i=0; i<=10; i++){
                System.out.print(" "+ j*i + " ");
            }
            System.out.println();

        }

    }


    private static void calculerTable(int  nb, int max){

        Scanner scan = new Scanner (System.in);
        System.out.println("Combien de ligne (nb) :");
        nb = scan.nextInt();
        System.out.println("Combien de colonne (max) :");
        max = scan.nextInt();
        System.out.println("Voici votre table de multiplication");

        int j;
        int i;

        for(j = 0; j <= max; j++){
            for(i=0; i<=nb; i++){
                System.out.print(" "+ j*i + " ");
            }
            System.out.println();

        }

    }

    private static void recherche(int val, int size) {

        Scanner scan = new Scanner (System.in);

        System.out.println("Quelle valeur cherchez-vous ? :");
        val = scan.nextInt();

        System.out.println("Veuillez rentrer la taille de votre table :");
        size = scan.nextInt();

        int [] mytab  = new int[size];

        int z;

        for(z=0; z< mytab.length; z++){
            System.out.print("Entrez un nombre dans votre table : ");
            mytab[z] = scan.nextInt();
        }

        int i;
        int f = 1;
        int index = -1;

        for(i = 0; i < size; i++){
            if (mytab[i] == val){
                index = i;
            }
        }


        if(index < 0){
            System.out.println("L'élément n'est pas dans votre liste :" + (-f));
        }
        else{
            System.out.println("L'élément est dans votre liste et son index est : " + index);
        }

    }




    public static void main(String[] args){

        int foo;

        Scanner scan = new Scanner (System.in);

        System.out.println("Rentrez 1 pour la Règle");
        System.out.println("Rentrez 2 pour la Puissance");
        System.out.println("Rentrez 3 pour les nombres Premiers");
        System.out.println("Rentrez 4 pour la table demandée");
        System.out.println("Rentrez 5 pour la calculerTable");
        System.out.println("Rentrez 6 pour la Recherche");


        do{
            foo = scan.nextInt();
        }while(foo != 1 && foo !=2 && foo!=3 && foo!=4 && foo!=5 && foo!=6);


        switch(foo){
            case 1:
                ruler(0,0); //initialisation pour arguments
                break;
            case 2:
                power(0,0);
                break;
            case 3:
                System.out.println(premier(0));
                break;
            case 4:
                table();
                break;
            case 5:
                calculerTable(0, 0);
                break;
            case 6:
                recherche(0,0);
                break;
            default:
                System.out.print("Je ne comprends pas votre requête");
                break;
        }


    }





}
