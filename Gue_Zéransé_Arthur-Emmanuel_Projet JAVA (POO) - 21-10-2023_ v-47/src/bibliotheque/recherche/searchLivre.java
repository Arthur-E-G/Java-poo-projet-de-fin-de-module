package bibliotheque.recherche;

import java.util.ArrayList;

import bibliotheque.sectionlivres.Livre;

/*La classe searchLivre comprend des méthodes permettant
    la recherche et l'obtention de données  */

public class searchLivre {
    // La méthode rechercheLivreByTitre() permet d'effectuer une recherche dans la liste de livre en fonction du Titre
    public static Livre rechercheLivreByTitre(ArrayList<Livre> listLivre, String titre) {
        titre = titre.toLowerCase();
        for (Livre livre : listLivre) {
            String titreLivre = (String) livre.getTitre();
            if (titreLivre.toLowerCase().equals(titre)) {
                return livre;
            }
        }
        System.out.println("Le livre entré n'est pas enregistrer");
        return null;

    }

    // La méthode rechercheLivreByCategorie() d'effectuer une recherche dans la liste de livre en fonction de la Categorie
    public static void rechercheLivreByCategorie(ArrayList<Livre> listLivre, String categorie) {
        categorie = categorie.toLowerCase();
        int compteur = 0;
        for (Livre livre : listLivre) {
            if (livre.getClass().getName().toLowerCase().equals(categorie)) {
                ++compteur;
                System.out.println(compteur + ". " + livre.getTitre());
            }
        }
        if (compteur == 0) {
            System.out.println("La categorie entrer n'est pas enregistrer");
        }
    }
    
    // La méthode rechercheLivreByAuteur() d'effectuer une recherche dans la liste de livre en fonction de l'auteur
    public static Livre rechercheLivreByAuteur(ArrayList<Livre> listLivre, String nomAuteur) {
        nomAuteur = nomAuteur.toLowerCase();
        for (Livre livre : listLivre) {
            String titreLivre = (String) livre.getTitre();
            if (livre.getAuteur().toLowerCase().equals(nomAuteur)) {
                return livre;
            }
        }
        System.out.println("Le livre entré n'est pas enregistrer");
        return null;
    }

    // La méthode rechercheLivreById() d'effectuer une recherche dans la liste de livre en fonction de l'Id
    public static Livre rechercheLivreById(ArrayList<Livre> listLivre, String id){
        for(Livre livre : listLivre){
            if(livre.getIdentifiant().equals(id)){
                return livre;
            }
        }
        System.out.println("L'identifant n'a aucune correspondance");
        return null;
    }

}
