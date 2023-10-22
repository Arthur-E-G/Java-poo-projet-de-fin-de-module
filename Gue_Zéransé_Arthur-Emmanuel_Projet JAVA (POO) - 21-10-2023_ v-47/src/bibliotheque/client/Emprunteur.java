package bibliotheque.client;

public class Emprunteur {
    /*La classe Emprunteur permet d'instancier les individus succeptible d'emprunter un livre */

    // variable d'instance
    private String nomEmprunteur;
    private String dateEcheance;
    private String idEmprunteur;
    

    public Emprunteur() {
    }

    public Emprunteur(String nomEmprunteur,String idEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
        
    }

    public Emprunteur(String nomEmprunteur, String idEmprunteur, String dateEcheance) {
        this.nomEmprunteur = nomEmprunteur;
        this.dateEcheance = dateEcheance;
    }

    public String getNomEmprunteur() {
        return nomEmprunteur;
    }

    public void setNomEmprunteur(String nomEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
    }

    public String getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(String dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
    

    
    public String getIdEmprunteur() {
        return idEmprunteur;
    }
    
    public void setIdEmprunteur(String idEmprunteur) {
        this.idEmprunteur = idEmprunteur;
    }

}