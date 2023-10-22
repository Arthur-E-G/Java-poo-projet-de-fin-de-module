package bibliotheque.menu;


import java.util.Scanner;

public class MenuPrincipale {
    public  MenuPrincipale() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n\t **********\tLE MENU PRINCIPALE DE NOTRE BIBLIOTHEQUE\t**********");
            System.out.println("\t Veillez choisir le numero correspondant à votre choix");
            System.out.println("\t 0 ) Quitter l'application");
            System.out.println("\t 1 ) Gestion des Emprunteurs");
            System.out.println("\t 2 ) Gestion des Livres");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            switch (choix) {
                case 0:
                    System.out.println("\t Fermeture en cours ...");
                    break;
                case 1:
                    MenuSecondaire.gestionEmprunteur();
                    break;
                case 2:
                    MenuSecondaire.gestionLivre();
                    break;
                default:
                    System.out.println("\t Choix invalide, veillez réessayer");
                    break;
            }
        } while (choix != 0);

        sc.close();
    }
}
