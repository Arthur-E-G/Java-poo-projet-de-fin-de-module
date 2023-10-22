package bibliotheque.sectionlivres;

// La classe Editeur permet de representer les editeurs de livres

public class Editeur {
    private String nomEditeur;

    public Editeur() {
    }

    public Editeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

}