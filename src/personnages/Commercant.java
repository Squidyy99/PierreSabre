package personnages;

public class Commercant extends Humain {

    public Commercant(String nom, int argent) {
        super(nom, "thé", argent);
    }

    public int seFaireExtorquer() {
        int somme = getArgent(); //  get l'argent 
        perdreArgent(somme);
        parler("J’ai tout perdu! Le monde est trop injuste .");
        return somme;
    }

    public void recevoir(int argent) {
        gagnerArgent(argent); // Pour pouvoir modifier l'argent via une fonction de la classe Humain
        
        // Si l'attribut argent était en protected (protected int argent;), alors on aurait pu faire : this.argent += argent;
        
        parler(argent + " sous ! Je te remercie généreux donateur!");
    }
} 

