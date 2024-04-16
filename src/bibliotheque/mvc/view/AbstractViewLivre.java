package bibliotheque.mvc.view;

import bibliotheque.metier.Livre;
import bibliotheque.mvc.controller.LivreController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewLivre implements Observer {

    protected LivreController livreController;
    protected List<Livre> livreList;

    public void setController(LivreController livreController) {
        this.livreController = livreController;
    }

    public abstract void menu();

    public abstract void displayList(List<Livre> livreList);

    public List<Livre> getAll() {
        return livreList;
    }

    @Override
    public void update(List livreList) {
        this.livreList = livreList;
        displayList(livreList);
    }
}
