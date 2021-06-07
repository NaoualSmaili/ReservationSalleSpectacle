public class Salle {
    int nbRangs;
    int nbPlacesRang;
    boolean[][] placeLibres;
    static int placereserve;

    public Salle(int nbRangs, int nbPlacesRang) {
        this.nbRangs = nbRangs;
        this.nbPlacesRang = nbPlacesRang;
        placeLibres = new boolean[nbRangs][nbPlacesRang];

        for (int i = 0; i < nbRangs; i++) {
            for (int j = 0; j < nbPlacesRang; j++) {
                placeLibres[i][j] = true;
            }
        }

    }

    int placeDispo() {
        return ((nbRangs * nbPlacesRang) - placereserve);
    }

    boolean capaciteOk(int n) {
        return (placeDispo() > n);
    }

    int nContiguesAuRangI(int n, int i) {
        int cmp=0;

        for(int j=0; j<nbPlacesRang; j++){
            if(placeLibres[i][j]){
                cmp++;
            }
        }

        if (n > cmp) {
            return -1;
        }

        return nbPlacesRang-cmp;
    }

    boolean reserverContigues(int id, int n) {
        for (int i = 0; i < nbRangs; i++){
            if (nContiguesAuRangI(n, i) != -1) {
                for (int j = nContiguesAuRangI(n, i); j < n; j++) {
                    placeLibres[i][j] = false;
                }
                return true;
            }
        }
        return false;
    }

    boolean reserver(int id, int n) {
        boolean res;
        if (capaciteOk(n)) {
            if (reserverContigues(id, n)) {
                //reserver contigue

                System.out.println("Yeeey Place contigue");
            } else {
                //reserver normal
                int cmp = n;
                for (int i = 0; i < nbRangs; i++)
                    for (int j = 0; j < nbPlacesRang; j++) {
                        if (placeLibres[i][j] && cmp > 0) {
                            placeLibres[i][j] = false;
                            cmp--;
                        } else {
                            break;
                        }
                    }
                System.out.println("Ouups place Non contigue");
            }
            placereserve += n;
            res = true;
            System.out.println("Reservation validee pour le groupe: " + id + " !");
        } else {
            res = false;
            System.out.println("Error! Places non disponibles pour le groupe:" + id + "nombre! " + n);
        }

        return res;
    }

    void printSalle(){
        for (int i = 0; i < nbRangs; i++) {
            for (int j = 0; j < nbPlacesRang; j++) {
                if(placeLibres[i][j] = true){
                    System.out.print("--L--!");
                }else{
                    System.out.print("--R--!");
                }
            }
            System.out.println("\n");
        }
    }

}
