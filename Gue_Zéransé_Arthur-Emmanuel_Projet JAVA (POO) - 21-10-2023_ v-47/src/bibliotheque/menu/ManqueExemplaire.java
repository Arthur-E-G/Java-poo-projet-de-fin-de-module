package bibliotheque.menu;

import bibliotheque.sectionlivres.*;
import java.util.ArrayList;

/* La classe ManqueExemplaire est une classe d'erreur qui s'execute si l'on souhaite 
    emprunter un livre dont le nombre d'exemplaire est  égale à 0 */

public class ManqueExemplaire  extends Exception
{
    public ManqueExemplaire(Livre livre){
        if(livre.getNombreExemplaires() == 0){
            System.out.println("Il n'y a pas d'exemplaires disponibles");
            return;
        }
    }
}
