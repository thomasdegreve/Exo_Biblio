package bibliotheque.mvc.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewRayon implements Observer {

    protected RayonController rayonController;
    protected List<Rayon> rayons;

    public void setController(RayonController rayonController) {
        this.rayonController = rayonController;
    }

    public abstract void menu();

    public abstract void displayList(List<Rayon> rayons);

    public List<Rayon> getAll() {
        return rayons;
    }

    @Override
    public void update (List<Rayon> rayons) {
        this.rayons = rayons;
        displayList(rayons);
    }
}
