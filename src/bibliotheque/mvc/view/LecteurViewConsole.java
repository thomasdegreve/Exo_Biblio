package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import java.util.List;
import java.util.Scanner;

public class LecteurViewConsole extends AbstractViewLecteur {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        update(lecteurController.getAll());
        List<String> options = List.of("Ajouter", "Retirer", "Rechercher", "Modifier", "Quitter");
        do {
            int choice = choix(options);
            switch (choice) {
                case 1:
                    // Appeler la méthode pour ajouter un lecteur
                    break;
                case 2:
                    // Appeler la méthode pour supprimer un lecteur
                    break;
                case 3:
                    // Appeler la méthode pour rechercher un lecteur
                    break;
                case 4:
                    // Appeler la méthode pour modifier un lecteur
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    @Override
    public void displayList(List<Lecteur> lecteurList) {
        // Ajouter la logique pour afficher la liste des lecteurs
    }
}
