package bibliotheque.mvc.controller;

import bibliotheque.metier.Livre;
import bibliotheque.mvc.model.DAOLivre;
import bibliotheque.mvc.view.AbstractViewLivre;

import java.util.List;

public class LivreController {

    protected DAOLivre model;
    protected AbstractViewLivre view;

    public LivreController(DAOLivre model, AbstractViewLivre view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Livre> getAll() {
        return model.getAll();
    }

    public Livre add(Livre livre) {
        return model.add(livre);
    }

    public boolean remove(Livre livre) {
        return model.remove(livre);
    }

    public Livre update(Livre livre) {
        return model.update(livre);
    }

    public Livre search(Livre livre) {
        return model.read(livre);
    }
}
