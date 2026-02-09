import java.lang.String;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int random = tireNbAleatoire(0,20);
        System.out.printf("Vous avez tiré : "+random);
    }

    public static String tirerEnjeu() {

        double r = Math.random();

        if (r < 8.0 / 20) return "10";
        else if (r < 14.0 / 20) return "20";
        else if (r < 18.0 / 20) return "50";
        else if (r < 19.0 / 20) return "100";
        else return "banqueroute";
    }

    public static int tireNbAleatoire(int borneMin, int borneMax) {
        return (int)(Math.random() * (borneMax - borneMin + 1)) + borneMin;
    }

    public static int tireCaseAleatoire(int[] Tab) {
        return Tab[tireNbAleatoire(0, Tab.length)];
    }

    public static String masqueMot(String mot){
        String resultat = "";
        for(int i = 0; i < mot.length(); i++){
            char c = mot.charAt(i);

            if(Character.isLetter(c)){
                resultat += "_";
            }else {
                resultat += c;
            }
        }
        return resultat;
    }

    public static char saisieLettre(String enjeu, int cagnotte, String motMasque, int nbEssais){
        const invite
    }
}