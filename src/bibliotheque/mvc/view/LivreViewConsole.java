package bibliotheque.mvc.view;

import bibliotheque.metier.Livre;
import java.util.List;
import java.util.Scanner;

public class LivreViewConsole extends AbstractViewLivre {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        update(livreController.getAll());
        List<String> options = List.of("Ajouter", "Retirer", "Rechercher", "Modifier", "Quitter");
        do {
            int choice = choix(options);
            switch (choice) {
                case 1:
                    // Call the method to add a livre
                    break;
                case 2:
                    // Call the method to remove a livre
                    break;
                case 3:
                    // Call the method to search for a livre
                    break;
                case 4:
                    // Call the method to update a livre
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    @Override
    public void displayList(List<Livre> livreList) {
        // Add logic to display the list of livres
    }
}
