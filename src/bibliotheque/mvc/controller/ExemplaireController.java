package bibliotheque.mvc.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.model.DAOExemplaire;
import bibliotheque.mvc.view.AbstractViewExemplaire;

import java.util.List;

public class ExemplaireController {

    protected DAOExemplaire model;
    protected AbstractViewExemplaire view;

    public ExemplaireController(DAOExemplaire model, AbstractViewExemplaire view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Exemplaire> getAll() {
        return model.getAll();
    }

    public Exemplaire add(Exemplaire exemplaire) {
        return model.add(exemplaire);
    }

    public boolean remove(Exemplaire exemplaire) {
        return model.remove(exemplaire);
    }

    public Exemplaire update(Exemplaire exemplaire) {
        return model.update(exemplaire);
    }

    public Exemplaire search(Exemplaire exemplaire) {
        return model.read(exemplaire);
    }

    // Ajoutez d'autres méthodes si nécessaire en fonction des besoins de votre application
}
