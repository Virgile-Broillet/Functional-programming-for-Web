import java.lang.String;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        jeu();
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

    public static char saisieLettre(String enjeu, int cagnotte, String motMasque, int nbEssais) {
        Scanner sc = new Scanner(System.in);
        String saisie;

        System.out.println("Mot à deviner : " + motMasque);
        System.out.println("Essais restants : " + nbEssais);
        System.out.println("Cagnotte actuelle : " + cagnotte + " €");
        System.out.println("Enjeu du tour : " + enjeu + " €");

        do {
            System.out.print("Proposez une lettre (A-Z) : ");
            saisie = sc.nextLine().trim().toUpperCase();

            if (saisie.length() != 1 || !saisie.matches("[A-Z]")) {
                System.out.println("Saisie invalide. Entrez une seule lettre (A-Z).");
            }

        } while (saisie.length() != 1 || !saisie.matches("[A-Z]"));

        return saisie.charAt(0);
    }

    public static Object[] tourJeu(String enjeu, String motR, String motM, char propo) {

        String nouveauMot = "";
        int occurrences = 0;

        for (int i = 0; i < motR.length(); i++) {
            if (Character.toUpperCase(motR.charAt(i)) == propo) {
                nouveauMot += motR.charAt(i);
                occurrences++;
            } else {
                nouveauMot += motM.charAt(i);
            }
        }
        Object gains;
        if (enjeu.equals("banqueroute")) {
            gains = "banqueroute";
        } else {
            int valeur = Integer.parseInt(enjeu);
            gains = valeur * occurrences;
        }

        return new Object[]{nouveauMot, gains};
    }
    public static void jeu() {

        String[] mots = {
                "ordinateur",
                "programmation",
                "java",
                "pendu",
                "fonction",
                "variable",
                "boucle",
                "condition",
                "algorithme",
                "tableau",
                "exception",
                "classe",
                "objet",
                "methode",
                "interface",
                "heredite",
                "compilateur",
                "developpement",
                "synchronisation",
                "framework"
        };

        String motReel = mots[(int)(Math.random() * mots.length)];
        String motMasque = masqueMot(motReel);

        int essais = 10;
        int cagnotte = 0;

        while (essais > 0 && !motMasque.equals(motReel)) {

            String enjeu = tirerEnjeu();

            char lettre = saisieLettre(enjeu, cagnotte, motMasque, essais);

            Object[] resultat = tourJeu(enjeu, motReel, motMasque, lettre);

            motMasque = (String) resultat[0];
            Object gains = resultat[1];

            if (gains.equals("banqueroute")) {
                cagnotte = 0;
                System.out.println("BANQUEROUTE ! Cagnotte remise à zéro.");
            }
            else if ((int) gains == 0) {
                essais--;
                System.out.println("Lettre absente...");
            }
            else {
                cagnotte += (int) gains;
                System.out.println("Bonne lettre ! Gain : " + gains);
            }
        }

        if (motMasque.equals(motReel)) {
            System.out.println("Bravo ! Mot trouvé : " + motReel);
            System.out.println("Cagnotte finale : " + cagnotte);
        } else {
            System.out.println("Perdu ! Le mot était : " + motReel);
        }
    }
}