package bibliotheque.recherche;

import java.util.ArrayList;

import bibliotheque.client.Emprunteur;

/*La classe searchEmprunteur permet d'effectuer des recherche dans la liste des Emprunteurs */

public class searchEmprunteur {

    /*   La méthode rechercheEmprunteur() permet d'effectuer 
        une recherche dans la liste des emprunteurs en fonction du nom*/
    public static Emprunteur rechercheEmprunteur(ArrayList<Emprunteur> listEmprunteur, String nom) {
        nom = nom.toLowerCase();

        for (Emprunteur e : listEmprunteur) {
            if (e.getNomEmprunteur().toLowerCase().equals(nom)) {
                
                return e;
            }
        }
        System.out.println("L'emprunteur entrer n'est pas enregistrer");
        return null;
    }
    /*   La méthode rechercheEmprunteurbyId() permet d'effectuer 
        une recherche dans la liste des emprunteurs en fonction 
        de l'identifiant du livre que ceux-ci ont emprunter*/
    public static String rechercheEmprunteurById(ArrayList<Emprunteur> listEmprunteur, String nom) {
     
        for (Emprunteur e : listEmprunteur) {
            if (e.getNomEmprunteur().toLowerCase().equals(nom)) {
                
                return e.getIdEmprunteur();
            }
        }
        return null;
    }
    
}
