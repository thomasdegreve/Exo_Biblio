package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemplaireViewConsole extends AbstractViewExemplaire {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        update(exemplaireController.getAll());
        List<String> options = List.of("Ajouter", "Retirer", "Rechercher", "Modifier", "Quitter");
        do {
            int choice = chooseOption(options);
            switch (choice) {
                case 1:
                    addExemplaire();
                    break;
                case 2:
                    removeExemplaire();
                    break;
                case 3:
                    searchExemplaire();
                    break;
                case 4:
                    modifyExemplaire();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void addExemplaire() {
        // Ajouter la logique pour ajouter un exemplaire
    }

    private void removeExemplaire() {
        // Ajouter la logique pour supprimer un exemplaire
    }

    private void searchExemplaire() {
        // Ajouter la logique pour rechercher un exemplaire
    }

    private void modifyExemplaire() {
        // Ajouter la logique pour modifier un exemplaire
    }

    @Override
    public void displayList(List<Exemplaire> exemplaireList) {
        // Ajouter la logique pour afficher la liste des exemplaires
    }
}
