import java.util.Scanner;

/**
 * Created by Andrew on 03/03/2017.
 */

public class workSession1 {

    private static void ruler(int x, int y){
        int i;

        for(i=0; i<=x; i++){
            System.out.print("-");
            if(i % y == 0){
                System.out.print("|");
            }
        }

    }

    private static void power(int a, int n){

        int i;
        int b = a;
        int c = 0;

        for(i=0; i<=n; i++){
            c = a * b;
        }

        System.out.println(c);

    }

    private static int premier(int w){

        int v = 1;
        int f = 0;
        int i;
        int result = 0;

        for(i=2; i<w; i++){

            if(w%i == 0){
                result = f;
            }
            else{
                result = v;
            }
        }
        
        return result;


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

        int j;
        int i;

        for(j = 0; j <= max; j++){
            for(i=0; i<=nb; i++){
                System.out.print(" "+ j*i + " ");
            }
            System.out.println();

        }

    }

    private static void recherche(int val, int [] tab) {

        int length = tab.length;
        int i;
        int f = 1;
        int index = -1;

        for(i = 0; i < length; i++){
            if (tab[i] == val){
                index = i;
            }
        }


        if(index < 0){
            System.out.println(-f);
        }
        else{
            System.out.println(index);
        }

    }




    public static void main(String[] args){

        int foo;

        Scanner scan = new Scanner (System.in);

        System.out.println("Rentrez 1 pour la Règle");
        System.out.println("Rentrez 2 pour la Puissance");
        System.out.println("Rentrez 3 pour les nombres Premiers");
        System.out.println("Rentrez 4 pour la calculerTable (15*10)");
        System.out.println("Rentrez 5 pour la Recherche");


        do{
            foo = scan.nextInt();
        }while(foo != 1 && foo !=2 && foo!=3 && foo!=4 && foo!=5);


        switch(foo){
            case 1:
                ruler(53, 10);
                break;
            case 2:
                power(16,2);
                break;
            case 3:
                System.out.println(premier(15));
                break;
            case 4:
                table();
                break;
            case 5:
                calculerTable(15, 10);
                break;
            case 6:
                int [] tab1 = {1,2,3,4,5};
                int [] tab2 = {1,2,3,4,5};
                int [] tab3 = {9, 8, 7, 6,5,4,3,2,1,0};
                int [] tab4 = {9, 8, 7, 6,5,4,3,2,1,0};

                recherche(55,tab1);
                recherche(5,tab2);
                recherche(9,tab3);
                recherche(5,tab4);
                break;
            default:
                System.out.print("Je ne comprends pas votre requête");
                break;
        }


    }





}
