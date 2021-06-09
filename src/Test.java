public class Test {

    public Test() {
    }

    public static void main(String[] args) throws InterruptedException {
        Salle s = new Salle(20,10);

        for (int i=0; i<3; i++){
            Thread th = new Thread(new Groupe(i,1 + (int) (Math.random() * (15 - 1) + 1),s));
            th.start();
            //th.join();
            th.sleep(1000);
        }

        //Bilan
        System.out.println("\n**** \t Bilan \t ****");
        System.out.println("Taille de la salle: "+ s.nbPlacesRang*s.nbRangs);
        System.out.println("Nombre total des places reserves: "+ s.placereserve);
        System.out.println("Nombre de places encore disponibles: "+ (s.nbPlacesRang*s.nbRangs - s.placereserve ));
        System.out.println("Nombre total des membres des groupes: "+ s.placereserve);
        s.printSalle();
    }
}
