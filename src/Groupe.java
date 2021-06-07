public class Groupe implements Runnable {
    int id;
    int nb;
    Salle s;

    public Groupe(int id, int nb, Salle s) {
        this.id = id;
        this.nb = nb;
        this.s = s;
    }


    @Override
    public void run() {
        System.out.println("Je suis le groupe N:"+id+" nb: "+nb);
        s.reserver(id,nb);
    }
}
