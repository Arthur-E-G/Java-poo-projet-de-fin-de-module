package bibliotheque.sectionlivres;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Livre {
    static Scanner sc = new Scanner(System.in);

    // Définition variables de classe
    protected static int compteur = 1;

    // Définition des variables d'instance
    protected String titre;
    protected int nombreExemplaires;
    protected Auteur auteur;
    protected int nombrePages;
    protected Editeur editeur;
    protected int anneePublication;
    protected Langue langue;
    protected String identifiant = "al-"; 
    /* L'identifiant permet à donner un signe distinctif unique à chaque livre
        ainsi il ne peut pas etre modifier*/


    // Constructeurs
    public Livre() {
    }

    public Livre(String titre, String nomAuteur, int nombrePages, int nombreExemplaires, int anneePublication,
            String nomEditeur, Langue langue) {

        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
        this.auteur.setNomAuteur(nomAuteur);
        this.editeur.setNomEditeur(nomEditeur);
        this.nombrePages = nombrePages;
        this.anneePublication = anneePublication;
        this.langue = langue;
        this.identifiant += compteur;
        /* ici, l'on peut constater que l'identifiant changera de valeur
         grâce à compteur qui s'incremente au fil des instanciation */
    }

    public Livre(String titre, int nombreExemplaires) {
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
        this.identifiant += compteur;
    }

    public Livre(String titre, int nombreExemplaires, String nomAuteur) {
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
        this.auteur.setNomAuteur(nomAuteur);
        this.identifiant += compteur;
    }

    // Setters et Getters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }

    public String getAuteur() {
        return auteur.getNomAuteur();
    }

    public void setAuteur(String nomAuteur) {
        this.auteur.setNomAuteur(nomAuteur);
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getEditeur() {
        return editeur.getNomEditeur();
    }

    public void setEditeur(String nomEditeur) {
        this.editeur.setNomEditeur(nomEditeur);
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public String getIdentifiant() {
        return identifiant;
    }
    public void empruntLivre(){
        this.nombreExemplaires -= 1;
    }
    public void renduLivre(){
        this.nombreExemplaires += 1;
    }

    // afficherCeLivre() permet l'affichage des informations de chaque livre
    public void afficherCeLivre() {
        String categorie = this.getClass().getName();
        System.out.println("Titre : " + this.getTitre());
        switch (categorie) {
            case "EssaisDocuments":
                categorie = "Essai et Document";
                break;
            case "RecueillePoemes":
                categorie = "Recueil de poèmes";
                break;
            case "ScienceNature":
                categorie = "Science et Nature";
                break;
            default :
        }
        System.out.println("Categorie : " + categorie);
        System.out.println("Nom de l'Auteur : " + this.getAuteur());
        System.out.println("Nombre de Pages : " + this.getNombrePages());
        System.out.println("Editeur : " + this.getEditeur());
        System.out.println("Année de publication : " + this.getAnneePublication());
        System.out.println("Langue : " + this.getLangue());
        System.out.println("Nombres d'exemplaires : " + getNombreExemplaires());
        System.out.println("Identifiant : " + this.getIdentifiant());

    }

    // Modifier ce livre permet la modification des informations d'un livre
    public void modifierCeLivre(){
        String choix1, choix2, choix3, choix4, choix5, choix6, choix7;
        
        System.out.println("------------------- Modification du Livre -----------");
        System.out.println("Veuillez repondre par oui/");
        System.out.print("Modification du nombre d'exemplaire (oui/) : ");
            choix7 = sc.nextLine();
            choix7 = choix7.toLowerCase();
            switch(choix7){
                case "oui" :
                    int newAnneePublication;
                    System.out.print("Entrer le nombre d'exemplaire : ");
                    while(true){
                        try{
                            newAnneePublication = sc.nextInt();
                            break;
                        }catch(InputMismatchException e){
                            sc.nextLine();
                            System.out.println("Veuillez entrer un nombre");
                            System.out.print("Nombre de d'exemplaires : ");
                        }
                    }
                    this.setAnneePublication(newAnneePublication);
                case "":
                    break;
                default :
            }
            sc.nextLine();
        System.out.print("Modification du titre(oui/) : " );
            choix1 = sc.nextLine();
            choix1 = choix1.toLowerCase();
            switch(choix1){
                case "oui" :
                    String newTitre;
                    
                    System.out.print("Nouveau titre : ");
                    newTitre = sc.nextLine();
                    this.setTitre(newTitre);
                    break;
                case "" :
                    break;
                default :
            }
            System.out.println("Modification du nom de l'auteur(oui/) : ");
            choix2 = sc.nextLine();
            choix2 = choix2.toLowerCase();
            switch(choix2){
                case "oui" :
                    String newAuteur;
                    System.out.println("Entrer le nouveau nom d'auteur : ");
                    newAuteur = null;
                    while(newAuteur == null){
                        try{
                            newAuteur = sc.nextLine();
                        }catch(InputMismatchException e){
                            sc.nextLine();
                            System.out.println("Veuillez entrer un nom!");
                            System.out.println("NomAuteur : ");
                        }
                    }
                    this.setAuteur(newAuteur);
                    break;
                case "":
                    break;
                default :
            }
        System.out.print("Modification la langue (oui/non) : ");
            choix3 = sc.nextLine();
            choix3 = choix3.toLowerCase();
            switch(choix3){
                case "oui":
                    Langue newLangue;
                    int choixLangue;
                    System.out.println("Veuillez choisir une langue :");
                    System.out.println("\t1. Français");
                    System.out.println("\t2. Anglais");
                    System.out.println("\t3. Allemand");
                    System.out.println("\t4. Espagnol");
                    System.out.println("\t5. Italien");
                    System.out.println("\t6. Portugais");
                    System.out.print("Choix :");
                    choixLangue = sc.nextInt();
                    switch(choixLangue){
                        case 1 :
                            this.setLangue(Langue.FRANCAIS);
                            break;
                        case 2 :
                            this.setLangue(Langue.ANGLAIS);
                            break;
                        case 3 :
                            this.setLangue(Langue.ALLEMAND);
                            break;
                        case 4 :
                            this.setLangue(Langue.ESPAGNOL);
                            break;
                        case 5 :
                            this.setLangue(Langue.ITALIEN);
                            break;
                        case 6 :
                            this.setLangue(Langue.PORTUGAIS);
                            break;
                        default :
                    }
                case "non" :
                    break;
                default :
            }
            sc.nextLine();
        System.out.print("Modification de l'éditeur(oui/non)");
            choix4 = sc.nextLine();
            choix4 = choix4.toLowerCase();
            switch(choix4){
                case "oui" :
                    String nomEditeur;
                    System.out.print("Entrer le nom de l'Editeur");
                    nomEditeur = null;
                    while(nomEditeur == null){
                        try{
                            nomEditeur = sc.nextLine();
                        }catch(InputMismatchException e){
                           sc.nextLine();
                           System.out.println("Veuillez entrer un nom!");
                           System.out.print("Nom de l'editeur : ");
                        }
                    }
                    this.setEditeur(nomEditeur);
                    break;
                case "non":
                    break;
                default :
            }
        System.out.print("Modification du nombre de pages (oui/non)");
            choix5 = sc.nextLine();
            choix5 = choix5.toLowerCase();
            switch(choix5){
                case "oui" :
                    int newNbPages;
                    System.out.println("Entrer le nombres de pages : ");
                    while(true){
                        try{
                            newNbPages = sc.nextInt();
                            break;
                        }catch(InputMismatchException e){
                            sc.nextLine();
                            System.out.println("Veuillez entrer un nombre !");
                            System.out.print("Nombre de Pages : ");
                        }
                    }
                    this.setNombrePages(newNbPages);
                    break;
                case "non" :
                    break;
                default :
            }
            sc.nextLine();
        System.out.print("Modification de l'année de publication (oui/non) : ");
            choix6 = sc.nextLine();
            choix6 = choix6.toLowerCase();
            switch(choix6){
                case "oui" :
                    int newAnneePublication;
                    System.out.print("Entrer l'année de publication : ");
                    while(true){
                        try{
                            newAnneePublication = sc.nextInt();
                            break;
                        }catch(InputMismatchException e){
                            sc.nextLine();
                            System.out.println("Veuillez entrer un nombre");
                            System.out.print("Année de publication : ");
                        }
                    }
                    this.setAnneePublication(newAnneePublication);
                case "non":
                    break;
                default :
            }
    }
    public void afficherQuantite(){
        System.out.println(this.titre);
        System.out.println("\tQuantité : " + this.nombreExemplaires);
        System.out.println("Identifiant : " + this.getIdentifiant());
    }
}
