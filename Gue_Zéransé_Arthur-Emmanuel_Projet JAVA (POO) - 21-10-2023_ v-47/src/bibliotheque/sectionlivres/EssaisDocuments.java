package bibliotheque.sectionlivres;

public class EssaisDocuments extends Livre {

    // Variable d'instance
    private String identifiant = "lb-";

    public EssaisDocuments() {
        super();
        this.identifiant += compteur;
        compteur++;
    }

    public EssaisDocuments(String titre, String nomAuteur, int nombrePages, int nombreExemplaires, int anneePublication,
            String nomEditeur, Langue langue) {
        super(titre, nomAuteur, nombrePages, nombreExemplaires, anneePublication, nomEditeur, langue);
        this.identifiant += compteur;
        compteur++;
    }

    public EssaisDocuments(String titre, int nombreExemplaires) {
        super(titre, nombreExemplaires);
        this.identifiant += compteur;
        compteur++;
    }

    public EssaisDocuments(String titre, int nombreExemplaires, String nomAuteur) {
        super(titre, nombreExemplaires, nomAuteur);
        this.identifiant += compteur;
        compteur++;
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }
}