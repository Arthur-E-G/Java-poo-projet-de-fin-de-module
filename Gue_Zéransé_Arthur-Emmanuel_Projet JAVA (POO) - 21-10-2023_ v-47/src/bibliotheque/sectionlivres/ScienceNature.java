package bibliotheque.sectionlivres;

public class ScienceNature extends Livre {

    private String identifiant = "lc-";

    public ScienceNature() {
        super();
        this.identifiant += compteur;
    }

    public ScienceNature(String titre, String nomAuteur, int nombrePages, int nombreExemplaires, int anneePublication,
            String nomEditeur, Langue langue) {
        super(titre, nomAuteur, nombrePages, nombreExemplaires, anneePublication, nomEditeur, langue);
        this.identifiant += compteur;
    }

    public ScienceNature(String titre, int nombreExemplaires) {
        super(titre, nombreExemplaires);
        this.identifiant += compteur;
    }

    public ScienceNature(String titre, int nombreExemplaires, String nomAuteur) {
        super(titre, nombreExemplaires, nomAuteur);
        this.identifiant += compteur;
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }
}
