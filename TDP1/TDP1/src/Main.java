import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Combien de notes voulez-vous saisir ? ");
        int nbNotes = scanner.nextInt();

        int[] tNotes = new int[nbNotes];

        for (int i = 0; i < nbNotes; i++) {
            System.out.println("Saisie de la note n°" + (i + 1));
            tNotes[i] = saisieNote(0, 20);
        }

        afficherNotes(tNotes);
    }

    public static int saisieNote(int nMin, int nMax) {
        Scanner scanner = new Scanner(System.in);
        int note;
        do {
            System.out.printf("Saisissez une note entre "+nMin+" et "+nMax+": ");
            note = scanner.nextInt();

            if (note > nMax || note < nMin){
                System.out.println("Note incorrect, Veuillez recommencer");
            }
        }while (note > nMax || note < nMin);

        return note;
    }

    public static void saisieNote(int nbNote, int nMin, int nMax) {
        for (int i = 0; i < nbNote; i++) {
            saisieNote(nMin, nMax);
        }
    }

    public static double calculMoyenne(int[] tNotes){
        double somme = 0;
        for (int i = 0; i < tNotes.length; i++) {
            somme += tNotes[i];
        }
        return ((double) somme / tNotes.length);
    }

    public static int calculMin(int[] tNotes){
        int tempMin = tNotes[0];
        for (int i = 0; i < tNotes.length; i++) {
            if (tempMin > tNotes[i]) {
                tempMin = tNotes[i];
            }
        }
        return tempMin;
    }

    public static int calculMax(int[] tNotes){
        int tempMin = tNotes[0];
        for (int i = 0; i < tNotes.length; i++) {
            if (tempMin < tNotes[i]) {
                tempMin = tNotes[i];
            }
        }
        return tempMin;
    }

    public static void afficherNotes(int[] tNotes){
        double moyenne = calculMoyenne(tNotes);
        int min = calculMin(tNotes);
        int max = calculMax(tNotes);

        String message =
                "Statistiques des notes :\n" +
                        "Moyenne : " + moyenne + "\n" +
                        "Minimum : " + min + "\n" +
                        "Maximum : " + max;

        JOptionPane.showMessageDialog(null, message, "Résultats", JOptionPane.INFORMATION_MESSAGE);
    }
}