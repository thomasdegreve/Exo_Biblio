package bibliotheque.mvc.controller;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.model.DAOLecteur;
import bibliotheque.mvc.view.AbstractViewLecteur;

import java.util.List;

public class LecteurController {

    protected DAOLecteur model;
    protected AbstractViewLecteur view;

    public LecteurController(DAOLecteur model, AbstractViewLecteur view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Lecteur> getAll() {
        return model.getAll();
    }

    public Lecteur add(Lecteur lecteur) {
        return model.add(lecteur);
    }

    public boolean remove(Lecteur lecteur) {
        return model.remove(lecteur);
    }

    public Lecteur update(Lecteur lecteur) {
        return model.update(lecteur);
    }

    public Lecteur search(Lecteur lecteur) {
        return model.read(lecteur);
    }


}
