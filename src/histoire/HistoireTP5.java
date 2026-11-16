package histoire;

import personnages.Commercant;
import personnages.Ronin;
import personnages.Yakuza;
import personnages.Samourai;
import personnages.Traitre;
import personnages.GrandMere;



public class HistoireTP5 {
    public static void main(String[] args) {
    	
        Commercant marco = new Commercant("Marco", 20);
        Commercant chonin = new Commercant("Chonin", 40);
        Commercant kumi = new Commercant("Kumi", 10);
        Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
        Ronin roro = new Ronin("Roro", "shochu", 60);

        marco.faireConnaissanceAvec(roro);
        marco.faireConnaissanceAvec(yaku);
        marco.faireConnaissanceAvec(chonin);
        marco.faireConnaissanceAvec(kumi);
        
        marco.listerConnaissance();
        roro.listerConnaissance();
        yaku.listerConnaissance();
        
        
        // PART 1 =>
        
        Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
        akimoto.faireConnaissanceAvec(marco);
        akimoto.boire("thé");
        
        // PART 2  =>
        
        Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
        masako.faireLeGentil();
        masako.ranconner(kumi);
        masako.ranconner(chonin);
        masako.ranconner(marco);
        akimoto.faireConnaissanceAvec(masako);
        masako.direBonjour();
        masako.ranconner(marco);
        
        // PART 3 =>
     
        GrandMere grandma = new GrandMere("Grand-mère", 10);
        grandma.faireConnaissanceAvec(marco);
        grandma.faireConnaissanceAvec(yaku); 
        grandma.faireConnaissanceAvec(masako);
        grandma.ragoter();
        
    }
}