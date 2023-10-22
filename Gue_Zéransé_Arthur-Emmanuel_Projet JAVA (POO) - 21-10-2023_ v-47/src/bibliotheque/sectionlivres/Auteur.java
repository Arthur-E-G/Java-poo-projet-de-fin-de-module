package bibliotheque.sectionlivres;

// La classe Auteur permet de representer les auteurs de livres

public class Auteur {

    private String nomAuteur;

    public Auteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
}