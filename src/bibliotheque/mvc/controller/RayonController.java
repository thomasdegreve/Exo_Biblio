package bibliotheque.mvc.controller;

import bibliotheque.metier.Rayon;
import bibliotheque.mvc.model.DAORayon;
import bibliotheque.mvc.view.AbstractViewRayon;

import java.util.List;

public class RayonController {
    protected DAORayon model;
    protected AbstractViewRayon view;

    public RayonController(DAORayon model, AbstractViewRayon view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Rayon> getAll() {
        return model.getAll();
    }

    public Rayon add(Rayon rayon) {
        return model.add(rayon);
    }

    public boolean remove(Rayon rayon) {
        return model.remove(rayon);
    }

    public Rayon update(Rayon rayon) {
        return model.update(rayon);
    }

    public Rayon search(Rayon rayon) {
        return model.read(rayon);
    }
}
