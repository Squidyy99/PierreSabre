package personnages;

import java.util.Random;

public class GrandMere extends Humain {
    private Random random = new Random();

    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);
    }

    @Override
    public void faireConnaissanceAvec(Humain humain) {
        if (nbConnaissance < 30) {
            this.memoire[nbConnaissance] = humain;
            nbConnaissance++;
            humain.repondre(this);
        } else {
            parler("Oh ma pauvre tête, ma mémoire est pleine !");
        }
    }

    private String humainHasard() {
        if (nbConnaissance == 0) {
            return "personne";
        }
        int indiceAleatoire = random.nextInt(nbConnaissance);
        return memoire[indiceAleatoire].getNom();
    }

    @Override
    public void direBonjour() {
        parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire de la tisane.");
    }

    public void ragoter() {
        if (nbConnaissance < 1) {
            parler("Je ne connais personne, je ne peux pas ragoter !");
        } else {
            int indiceAleatoire = random.nextInt(nbConnaissance);
            Humain humain = memoire[indiceAleatoire];
            if (humain instanceof Traitre) {
                parler("Je sais bien que " + humain.getNom() + " est un traître petits cachotier. Sais-tu que c'est un chafouin ?");
            } else {
                parler("Je crois que " + humain.getNom() + " est un chafouin.");
            }
        }
    }
}