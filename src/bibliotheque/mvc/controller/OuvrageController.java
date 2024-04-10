package bibliotheque.mvc.controller;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.model.DAOOuvrage;
import bibliotheque.mvc.view.AbstractViewOuvrage;

import java.util.List;

public class OuvrageController {
    protected DAOOuvrage model;
    protected AbstractViewOuvrage view;

    public OuvrageController(DAOOuvrage model, AbstractViewOuvrage view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Ouvrage> getAll() {
        return model.getAll();
    }

    public Ouvrage add(Ouvrage ouvrage) {
        return model.add(ouvrage);
    }

    public boolean remove(Ouvrage ouvrage) {
        return model.remove(ouvrage);
    }

    public Ouvrage update(Ouvrage ouvrage) {
        return model.update(ouvrage);
    }

    public Ouvrage search(Ouvrage ouvrage) {
        return model.read(ouvrage);
    }
}
