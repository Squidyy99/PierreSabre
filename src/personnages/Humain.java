package personnages;

public class Humain {
    private String nom;
    private String boissonFavorite;
    private int argent;
    
  // Attributs => mémoire ( max  30)
    
    protected int nbConnaissance = 0;
    protected Humain[] memoire = new Humain[30];
    

    public Humain(String nom, String boissonFavorite, int argent) {
        this.nom = nom;
        this.boissonFavorite = boissonFavorite;
        this.argent = argent;
    }

    public String getNom() {
        return nom;
    }

    public String getBoissonFavorite() {
        return boissonFavorite;
    }

    public int getArgent() {
        return argent;
    }

    protected void parler(String texte) {
        System.out.println("(" + nom + ") - " + texte);
    }

    public void direBonjour() {
        parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite + ".");
    }

    public void boire() {
        parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
    }

    public void gagnerArgent(int gain) {
        this.argent += gain;
    }

    public void perdreArgent(int perte) {
        this.argent -= perte;
    }

    public void acheter(String bien, int prix) {
        if (this.argent >= prix) {
            parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir un " + bien + " à " + prix + " sous");
            perdreArgent(prix);
        } else {
            parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous.");
        }
    }
    
 // New method (Part 1) //

    public void faireConnaissanceAvec(Humain autreHumain) {
        this.direBonjour();
        autreHumain.repondre(this);
        this.memoriser(autreHumain);
    }

    protected void memoriser(Humain humain) {
        if (nbConnaissance < memoire.length) {
            memoire[nbConnaissance] = humain;
            nbConnaissance++;
        } else {
        	
            for (int i = 0; i < memoire.length - 1; i++) {
                memoire[i] = memoire[i + 1];
            }
            memoire[memoire.length - 1] = humain;
        }
    }

    public void repondre(Humain humain) {
        this.direBonjour();
        this.memoriser(humain);
    }

    public void listerConnaissance() {
        String texte = "Je connais beaucoup de monde dont : ";
        for (int i = 0; i < nbConnaissance; i++) {
            texte += memoire[i].getNom();
            if (i < nbConnaissance - 1) {
                texte += ", ";
            }
        }
        parler(texte);
    }
}
