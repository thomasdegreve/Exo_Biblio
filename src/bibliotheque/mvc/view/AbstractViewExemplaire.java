package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewExemplaire implements Observer {

    protected ExemplaireController exemplaireController;
    protected List<Exemplaire> exemplaireList;

    public void setController(ExemplaireController exemplaireController) {
        this.exemplaireController = exemplaireController;
    }

    public abstract void menu();

    public abstract void displayList(List<Exemplaire> exemplaireList);

    public List<Exemplaire> getAll() {
        return exemplaireList;
    }

    @Override
    public void update(List exemplaireList) {
        this.exemplaireList = exemplaireList;
        displayList(exemplaireList);
    }
}
