package bibliotheque.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import bibliotheque.sectionlivres.*;
import bibliotheque.client.Emprunteur;
import bibliotheque.recherche.*;

public class MenuSecondaire{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Livre> listLivre = new ArrayList<>();
    static ArrayList<Emprunteur> listEmprunteur = new ArrayList<>();
    
    public MenuSecondaire(){}

    public static void gestionLivre() {
        int choixLivre;
        System.out.println("\n\t *****\tGestion Livre\t*****");
        System.out.println("\t Veillez choisir le numero correspondant à votre choix");
        System.out.println("\t 0 ) Retour au menu principale");
        System.out.println("\t 1 ) Afficher les Livres disponible");
        System.out.println("\t 2 ) Ajouter un nouveau Livre");
        System.out.println("\t 3 ) Modifier un livre");
        System.out.println("\t 4 ) Supprimer un livre");
        System.out.println("\t 5 ) Mettre à jour les stocks");
        System.out.println("\t 6 ) Chercher un livre");
        do{
            choixLivre = sc.nextInt();
            switch (choixLivre) {
                case 0:
                   new MenuPrincipale();
                    break;
                case 1:
                    afficherLivre();
                    break;
                case 2:
                    ajouterLivre();
                    break;
                case 3:
                    modifierLivre();
                    break;
                case 4:
                    supprimerLivre();
                    break;
                case 5:
                    modifierStock();
                case 6:
                    rechercheLivre();
                default:
                    System.out.println("\t Choix invalide! veillez réessayer");
            }
        }while (choixLivre != 0);
        sc.close();
    }

    public static void ajouterLivre() {
        int choixTypeLivre;
        String categorie;
        System.out.println("Veuillez choisir la catégorie de livre que vous souhaiter ajouter : ");
        System.out.println("0. Revenir en arrière");
        System.out.println("1. Roman");
        System.out.println("2. Recueille de Poemes");
        System.out.println("3. Science et Nature");
        System.out.println("4. Fiction");
        System.out.println("5. Essais et documents");
        
        do {
            System.out.print("Choix : ");
            choixTypeLivre = sc.nextInt();
            sc.nextLine();
            switch (choixTypeLivre) {
                case 0:
                    gestionLivre();
                    return;
                case 1:
                    categorie = "nouveau Roman";
                    ajoutLivre(categorie, choixTypeLivre);
                    return;
                case 2:
                    categorie = "nouveau Recueil de Poemes";
                    ajoutLivre(categorie, choixTypeLivre);
                    break;
                case 3:
                    categorie = "nouveau livre de Science et Nature";
                    ajoutLivre(categorie, choixTypeLivre);
                    return;
                case 4:
                    categorie = "nouveau livre de Fiction";
                    ajoutLivre(categorie, choixTypeLivre);
                    return;
                case 5:
                    categorie = "nouvel Essais ou document";
                    ajoutLivre(categorie, choixTypeLivre);
                    return;
                default:
                    System.out.println("\t Choix invalide! veillez réessayer");
            }
        } while (choixTypeLivre != 0);

    }


    public static void ajoutLivre(String categorie, int choixTypeLivre) {
        String titre;
        String nomAuteur;
        String nomEditeur;
        Langue langueChoix = Langue.FRANCAIS;
        int nombrePages = 1;
        int nombreExempleaires = 1;
        int anneePublication;
        int choixLangue;
        System.out.println("Ajout d'un " + categorie);
        System.out.print("Titre :");
        titre = sc.nextLine();
        System.out.print("Auteur : ");
        nomAuteur = null;
        while (nomAuteur == null) {
            try {
                nomAuteur = sc.nextLine();

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Veuillez entrez un nom ! ");
                System.out.print("Auteur :");
            }
        }
        System.out.print("Nombres d'exemplaires : ");
        while (true) {
            try {
                nombreExempleaires = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Veuillez entrer un nombre !");
                System.out.println("Nombres d'Exemplaires : ");
            }
        }
        sc.nextLine();
        System.out.print("Nom de l'éditeur : ");
        nomEditeur = null;
        while (nomEditeur == null) {
            try {
                nomEditeur = sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Veuillez entre un nom ");
                System.out.print("Nom de l'editeur : ");
            }
        }
        System.out.print("Année de publication : ");
        while (true) {
            try {
                anneePublication = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                sc.nextInt();
                System.out.println("Veuillez entrer une année en chiffre");
                System.out.print("Entrer une Année (1234) : ");
            }
        }
        System.out.println("Veuillez entrez choisir une langue : ");
        System.out.println("\t1. Français");
        System.out.println("\t2. Anglais");
        System.out.println("\t3. Allemand");
        System.out.println("\t4. Espagnol");
        System.out.println("\t5. Italien");
        System.out.println("\t6. Portugais");
        System.out.println("\tChoix : ");
        do {
            choixLangue = sc.nextInt();
            switch (choixLangue) {
                case 1:
                    langueChoix = Langue.FRANCAIS;
                    break;
                case 2:
                    langueChoix = Langue.ANGLAIS;
                    break;
                case 3:
                    langueChoix = Langue.ALLEMAND;
                    break;
                case 4:
                    langueChoix = Langue.ESPAGNOL;
                    break;
                case 5:
                    langueChoix = Langue.ITALIEN;
                    break;
                case 6:
                    langueChoix = Langue.PORTUGAIS;
                    break;
                default:

                    choixLangue = 0;
                    System.out.print("Veuillez entrer un chiffre entre 1 et 6 : ");

            }
        } while (choixLangue != 0);
        switch (choixTypeLivre) {
            case 1:
                listLivre.add(new Roman(titre, nomAuteur, nombrePages, nombreExempleaires,
                        anneePublication, nomEditeur, langueChoix));
                System.out.println("Le Roman a bien été ajouter");
                break;
            case 2 :
                listLivre.add(new RecueillePoemes(titre, nomAuteur, nombrePages, nombreExempleaires,
                        anneePublication, nomEditeur, langueChoix));
                System.out.println("Le Recueille de poeme à bien été ajouter");
                 break;
            case 3:
                listLivre.add(new ScienceNature(titre, nomAuteur, nombrePages, nombreExempleaires,
                        anneePublication, nomEditeur, langueChoix));
                    System.out.println("Le Livre de Science et nature à été ajouter ");
                    break;
            case 4: 
                listLivre.add(new Fiction(titre, nomAuteur, nombrePages, nombreExempleaires,
                        anneePublication, nomEditeur, langueChoix));
                System.out.println("Le Livre de Fiction à bien été ajouter");
                break;
            case 5:
                listLivre.add(new EssaisDocuments(titre, nomAuteur, nombrePages, nombreExempleaires,
                        anneePublication, nomEditeur, langueChoix));
                
                System.out.println("Le Livre d'Essai ou de document à bien été ajouter");
                break;
            default:
                    System.out.println("\t Choix invalide! veillez réessayer");
        }
    }

    public static void modifierLivre() {
        if(listLivre.isEmpty()){
            System.out.println("Il n'y a pas de livre enregistrer");
        }
        int choixUser;
        System.out.println("----------------- Modification de Livre---------------");
        release();
        do{
            choixUser = sc.nextInt();
            sc.nextLine();
            switch(choixUser){

                case 0 :
                    gestionLivre();
                    return;
                case 1 :
                    String nomLivre;
                    System.out.print("Veuillez entrer le nom du livre : ");
                    nomLivre = sc.nextLine();
                    searchLivre.rechercheLivreByTitre(listLivre, nomLivre).modifierCeLivre();
                    return;
                case 2 :
                    String id = null;
                    System.out.println("Veuillez entrer l'identifiant du livre au format[ id-000 ] : ");
                    System.out.print("Entrer l'identifiant : ");
                    
                    boolean isId= true;
                    int compteur = 0;

                    while(isId){
                        id = sc.nextLine();
                        if(compteur == 4){
                            break;
                        }
                        isId = verifierId(id);
                        compteur++;
                    }
                    searchLivre.rechercheLivreById(listLivre, id).modifierCeLivre();
                    return;
                default:
                    System.out.println("\t Choix invalide! veillez réessayer");
            }
        }while(choixUser !=0 );
    }

    public static void afficherLivre(){
        if(listLivre.isEmpty()){
            System.out.println("Il n'y pas de livre enregistrer");
        }
        else{
            System.out.println("Les livres enregistrés sont : ");
            for(Livre livre : listLivre){
                livre.afficherCeLivre();
            }
        }
    }

    public static void supprimerLivre(){
        int choixUser;
        release();
        do{
            choixUser = sc.nextInt();
            sc.nextLine();
            switch(choixUser){

                case 0 :
                    gestionLivre();
                    return;
                case 1 :
                    String nomLivre;
                    System.out.print("Veuillez entrer le nom du livre : ");
                    nomLivre = sc.nextLine();
                    listLivre.remove(searchLivre.rechercheLivreByTitre(listLivre, nomLivre));
                         if(searchLivre.rechercheLivreByTitre(listLivre, nomLivre) != null){
                            System.out.println("Le livre à été supprimer");
                        }
                    return;
                case 2 :
                    String id = null;
                    System.out.println("Veuillez entrer l'identifiant du livre au format[ id-000 ] : ");
                    System.out.print("Entrer l'identifiant : ");
                    
                    boolean isId= true;
                    int compteur = 0;

                    while(isId){
                        id = sc.nextLine();
                        if(compteur == 4){
                            break;
                        }
                        isId = verifierId(id);
                        compteur++;
                    }
                    listLivre.remove(searchLivre.rechercheLivreById(listLivre, id));
                        if(searchLivre.rechercheLivreById(listLivre, id) != null){
                            System.out.println("Le livre à été supprimer");
                        }
                    return;
                default:
                    System.out.println("\t Choix invalide! veillez réessayer");
            }
        }while(choixUser !=0 );
    }
    
    
    public static void modifierStock(){

        if(listLivre.isEmpty()){
            System.out.println("il n'y a pas de livre enregistrer");
            return;
        }
        System.out.println("Les Livres  sont :");

        for(Livre livre : listLivre){
            
            livre.afficherQuantite();
        }
        int choixUser;
        System.out.println("-----------------Modification de Stock ---------------");
        release();
        int newQuantite;
        do{
            choixUser = sc.nextInt();
            sc.nextLine();
            switch(choixUser){
                

                case 0 :
                    gestionLivre();
                    return;
                case 1 :
                    String nomLivre;
                    System.out.print("Veuillez entrer le nom du livre : ");
                    nomLivre = sc.nextLine();
                    System.out.print("Entrer la nouvelle quantité : ");
                    newQuantite = sc.nextInt();
                    searchLivre.rechercheLivreByTitre(listLivre, nomLivre).setNombreExemplaires(newQuantite);
                    System.out.println("La Quantité a été mise à jour.");
                    return;
                case 2 :
                    String id = null;
                    System.out.println("Veuillez entrer l'identifiant du livre au format[ id-000 ] : ");
                    System.out.print("Entrer l'identifiant : ");
                    System.out.print("Entrer la nouvelle quantité : ");
                    newQuantite = sc.nextInt();
                    System.out.println("Le livre à été supprimer");
                    return;
                default :
                    System.out.println("\t Choix invalide! veillez réessayer");
            }
        }while(choixUser !=0 );
    }
    public static boolean verifierId(String id){
        CharSequence indicateur = id.subSequence(0, 1);
        char tiret = id.charAt(2);
        if((tiret == '-') || indicateur != "le" || indicateur != "ab" || indicateur != "lb" 
                 || indicateur != "le" || indicateur != "ld" || indicateur != "la" 
                 || indicateur != "lc"){
             System.out.println("L'identifiant n'est pas valide");
            return false;
        }
        else{
            return true;
        }
    }

    public static void rechercheLivre(){
        int choixUser;
        System.out.println("Veuillez choisir une méthode de recherche : ");
        System.out.println("0. Retour au menu principale");
        System.out.println("1. Recherche par titre");
        System.out.println("2. Recherche par Auteur");
        System.out.println("3. Recherche par catégorie");
        System.out.print("Choix : ");
            do{
                choixUser = sc.nextInt();
                sc.nextLine();
                    switch(choixUser){
                        
                        case 0 :
                            gestionLivre();
                            break;
                        case 1 :
                            String nomLivre;
                            System.out.print("Veuillez entrer le nom du livre : ");
                            nomLivre = sc.nextLine();
                            searchLivre.rechercheLivreByTitre(listLivre, nomLivre).afficherCeLivre();;
                            return;
                        case 2 :
                            String nomAuteur;
                            System.out.print("Veuillez entrer le nom de l'Auteur: ");
                            nomAuteur = sc.nextLine();
                            if(searchLivre.rechercheLivreByAuteur(listLivre, nomAuteur) == null){
                                System.out.println("Le livre n'a pas été trouvé");
                            }
                            searchLivre.rechercheLivreByAuteur(listLivre, nomAuteur).afficherCeLivre();;
                            return;
                        case 3 :
                            String categorie;
                            System.out.print("Veuillez entrer la categorie du livre : ");
                            categorie  = sc.nextLine();
                            searchLivre.rechercheLivreByCategorie(listLivre, categorie);
                            return;
                    }

            }while(choixUser != 0);
    }

    public static void release(){ // release est une méthode qui permet d'afficher un menu
        System.out.println("1. Recherche du livre par titre");
        System.out.println("2. Recherche du livre par identifiant");
        System.out.print("Choix : ");
    
    }

    
/*Cette partie de la classe MenuSecondaire est dédié à la 
    gestion des emprunteurs et des emprunts */

    

    public static void gestionEmprunteur() {
        Scanner sc = new Scanner(System.in);
        int choixEmprunteur;
        do {

            System.out.println("\n\t *****\tGestion des Emprunteurs\t*****");
            System.out.println("\t Veillez choisir le numero correspondant à votre choix");
            System.out.println("\t 0 ) Retour au menu principale");
            System.out.println("\t 1 ) Afficher les emprunteurs disponible");
            System.out.println("\t 2 ) Ajouter un prêt de Livre");
            System.out.println("\t 3 ) Rendre un Livre");
            System.out.println("\t 4 ) Rechercher un emprunteur");
            choixEmprunteur = sc.nextInt();
            switch (choixEmprunteur) {
                case 0:
                    new MenuPrincipale();
                    break;
                case 1:
                    afficherEmprunteur();
                    break;
                case 2:
                    ajouterEmprunt();
                    break;
                case 3:
                    rendreLivre();
                    break;
                case 4:
                    rechercheEmprunteur();
                    break;
                default:
                    System.out.println("\t Choix invalide! veillez réessayer");
                    break;
            }
        } while (choixEmprunteur != 0);
        sc.close();
    }
    public static void afficherEmprunteur() {
        System.out.println("\n\t *****\tLes emprunteurs de la bibliotheque\t*****");
        int nb = 0;
        if (listEmprunteur.isEmpty())
            System.out.println("\t Il n'y a pas encore d'emprunteur enregistrer dans cette bibliothéque");
        else {
            for (Emprunteur a : listEmprunteur) {
                String id = a.getIdEmprunteur();
                System.out.println("Nom :" + a.getNomEmprunteur());
                String titre =searchLivre.rechercheLivreById(listLivre, id).getTitre();
                System.out.println("Le titre est : " + titre);
                System.out.println("La date d'écheance est : " + a.getDateEcheance());
                nb++;
            }
        }
        System.out.println("\n\t " + nb + " Emprunteur trouvé! Appuyez sur entrer pour continuer...");
        sc.nextLine();
    }
    
    public static void affichercetEmprunteur(){

    }
    
    // La méthode ajouterEmprunt permet d'ajouter des emprunteurs.
    public static void ajouterEmprunt(){
        String nomEmprunteur;
        System.out.println("----------------Ajout d'Emprunteur--------------------");
        System.out.println("Veullez entrer le nom de l'emprunteur et le(s) prénom(s) de l'emprunteur");
        System.out.println("Nom : ");
        nomEmprunteur = null;
        while(nomEmprunteur == null){
            try{
                nomEmprunteur = sc.nextLine();
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Veuillez entrer un nom !");
                System.out.print("Nom de l'Emprunteur : ");
            }
        }
        String dateEcheange = null;
        boolean dateValide = false;
        int choixUser;
            System.out.println("Méthode de choix : ");
            System.out.println("0. Revenir au menu precédant");
            System.out.println("1. Ajouter en recherchant le titre du livre");
            System.out.println("2. Ajouter avec l'id du livre");
            choixUser = sc. nextInt();
                switch(choixUser){
                    case 0: 
                        gestionEmprunteur();
                        break;
                    case 1:
                        String nomLivre;
                        String idEmprunteur = "";

                        System.out.println("Veuillez Entrer si le titre du livre ");
                        nomLivre = null;
                        while(nomLivre == null){
                            try{
                                nomLivre = sc.nextLine();
                            }catch(InputMismatchException e){
                                sc.nextLine();
                                System.out.println("Veuillez entrer le titre du livre !");
                                System.out.print("Titre du LIVRE : ");
                            }
                        }
                        idEmprunteur = searchLivre.rechercheLivreByTitre(listLivre, nomLivre).getIdentifiant();
                        
                        // Vérification que le nombre d'exemplaires est supéieur à 0

                        
                        
                        System.out.print("Veuillez entrer la date d'écheance (dd/MM/yyyy): ");
                            while(dateValide == false){
                                dateEcheange = sc.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate dateFourni = LocalDate.parse(dateEcheange, formatter);
                                LocalDate dateAujourdhui = LocalDate.now();

                                //Ici l'on si la date est égale à aujourd'hui ou ultérieure
                                if (dateFourni.isEqual(dateAujourdhui) || dateFourni.isAfter(dateAujourdhui)) {
                                    dateValide = true;
                                }
                                else{{
                                    System.out.println("Entrer une date ulterieur ou egale à celle d'aujourd'hui");
                                    System.out.println("Entrer la date d'écheance");
                                }}
                            }
                        listEmprunteur.add(new Emprunteur(nomEmprunteur, idEmprunteur, dateEcheange));
                        searchLivre.rechercheLivreByTitre(listLivre, nomLivre).empruntLivre();
                        return;
                    
                        case 2:
                            String idLivre;
                            System.out.println("Les livres sont : ");
                            afficherLivreDispo(listLivre);
                            System.out.println("Veuillez choisir un livre en utlisant l'identifiant du livres souhaiter : ");
                            System.out.println("Identifiant : ");
                            idLivre = null;
                            while(idLivre == null){
                            try{
                                idLivre = sc.nextLine();
                            }catch(InputMismatchException e){
                                sc.nextLine();
                                System.out.println("Veuillez entrer un identifiant compris dans la liste ci-desous !");
                                System.out.print("Id du LIVRE : ");
                            }
                        }
                            idEmprunteur = idLivre;

                            System.out.print("Veuillez entrer la date d'écheance (dd/MM/yyyy): ");
                            while(dateValide == false){
                                dateEcheange = sc.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate dateFourni = LocalDate.parse(dateEcheange, formatter);
                                LocalDate dateAujourdhui = LocalDate.now();

                                //Ici l'on si la date est égale à aujourd'hui ou ultérieure
                                if (dateFourni.isEqual(dateAujourdhui) || dateFourni.isAfter(dateAujourdhui)) {
                                    dateValide = true;
                                }
                                else{{
                                    System.out.println("Entrer une date ulterieur ou egale à celle d'aujourd'hui");
                                    System.out.println("Entrer la date d'écheance");
                                }}
                            }
                        listEmprunteur.add(new Emprunteur(nomEmprunteur, idEmprunteur, dateEcheange));
                        searchLivre.rechercheLivreById(listLivre, idLivre).empruntLivre();
                    
                        default: 
                            return;


                }
            
            
    }
    public static void afficherLivreDispo(ArrayList<Livre> listLivre){
        if(listLivre.isEmpty()){
            System.out.println("il n'y a pas encore de livre enregistrer");
            return;
        }
        System.out.println("Les livres sont");
        for(Livre livre : listLivre){
            System.out.println("Titre : " + livre.getTitre());
            System.out.println("id : " + livre.getIdentifiant());
        }
    }
    public static void rendreLivre(){
        String nomEmprunteur;
        String id;
        System.out.println("-----------Retour de livre -----------");
        System.out.println("Entrer le nom de l'empruntreur");
        nomEmprunteur = null;
            while(nomEmprunteur == null){
                try {
                    nomEmprunteur = sc.nextLine();
                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("Veuillez entrer un nom §!");
                    System.out.println("Nom de l'enprunteur : ");
                }
            }
            id = searchEmprunteur.rechercheEmprunteur( listEmprunteur, nomEmprunteur).getIdEmprunteur();
            listEmprunteur.remove(searchEmprunteur.rechercheEmprunteur( listEmprunteur, nomEmprunteur));
            searchLivre.rechercheLivreById(listLivre, id).renduLivre();
            System.out.println("Le livre à bien été rendu");
    }
    public static void rechercheEmprunteur(){
        String nom;

        System.out.println("--------------Recherche d'emprunteur------------");
        System.out.println("Entrer le nom de l'emprunteur : ");
        nom = null;
        while(nom == null){
            try{
                nom = sc.nextLine();
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("veillez entrer un nom !");
                System.out.print("Nom de l'emprunteur");
            }
        }
        String nomEmprunteur = searchEmprunteur.rechercheEmprunteur(listEmprunteur, nom).getNomEmprunteur();
        System.out.println("Nom :" + nomEmprunteur);
        if(searchEmprunteur.rechercheEmprunteur(listEmprunteur, nom) != null){
            String titre = searchLivre.rechercheLivreById(listLivre, searchEmprunteur.rechercheEmprunteur(listEmprunteur, nom).getIdEmprunteur()).getTitre();
            System.out.println("Le titre est : " + titre);
            String date = searchEmprunteur.rechercheEmprunteur(listEmprunteur, nom).getDateEcheance();
            System.out.println("La date d'écheance est : " + date);
        }

    }

    
}