package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.controller.LecteurController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewLecteur implements Observer {

    protected LecteurController lecteurController;
    protected List<Lecteur> lecteurList;

    public void setController(LecteurController lecteurController) {
        this.lecteurController = lecteurController;
    }

    public abstract void menu();

    public abstract void displayList(List<Lecteur> lecteurList);

    public List<Lecteur> getAll() {
        return lecteurList;
    }

    @Override
    public void update(List<Lecteur> lecteurList) {
        this.lecteurList = lecteurList;
        displayList(lecteurList);
    }
}
