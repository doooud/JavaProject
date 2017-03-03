import java.util.Scanner;

public class Main {

        public static void pave(String[] args) {
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

        public static void fibonacci(String[] args){

            int y = 0;
            int w = 1;
            int i;
            int z;

            for(i=0; i<= 20; i++){
                z = w + y;
                y = z;
                w = z - w;
                System.out.println(z);
        }

    }

        public static void  syracuse(String[] args){

            System.out.println("Veuillez entrer une valeur x < 14");
            int x;
            int y;
            Scanner scan = new Scanner (System.in);

            x = scan.nextInt();

            if(x <14){
                System.out.println("La suite de Syracuse est donc :");

                do{
                    if(x%2 == 0){
                        x = x/2;
                        System.out.println(x);
                    }
                    else{
                        x = 3*x +1;
                        System.out.println(x);
                    }
                }while(x != 1);

            }
            else{
                System.out.println("C'est non !");
                x = scan.nextInt();


            }
        }

        private static void fibonacci(){

            int y = 0;
            int w = 1;
            int z;
            int i;

            for(i=0; i<= 20; i++) {

                z = w + y;
                y = z;
                w = z - w;
                System.out.println(z);
            }

        }

        private static void  syracuse(){

        System.out.println("Veuillez entrer une valeur x < 14");
        int x;
        int y;
        Scanner scan = new Scanner (System.in);

        x = scan.nextInt();

        if(x <14 && x>0){
            System.out.println("La suite de Syracuse est donc :");

            do{
                if(x%2 == 0){
                    x = x/2;
                    System.out.println(x);
                }
                else{
                    x = 3*x +1;
                    System.out.println(x);
                }
            }while(x != 1);

        }
        else{
            System.out.println("C'est non !");
            x = scan.nextInt();


        }
    }

        public static void main(String[] args){

            Scanner scan = new Scanner (System.in);

            int foo;

            System.out.println("Rentrez 1 pour la suite de Fibonacci");
            System.out.println("Rentrez 2 pour la suite de Syracuse");

            do{
                foo = scan.nextInt();
            }while(foo != 1 && foo !=2);

            switch(foo){

                case 1:
                    fibonacci();
                    break;
                case 2:
                    syracuse();
                    break;
                default:
                    System.out.print("Non");
            }

        }
}


