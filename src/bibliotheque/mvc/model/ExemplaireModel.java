package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class ExemplaireModel extends DAOExemplaire {
    private List<Exemplaire> ldatas = new ArrayList<>();

    @Override
    public Exemplaire add(Exemplaire exemplaire) {
        boolean present = ldatas.contains(exemplaire);
        if (!present) {
            ldatas.add(exemplaire);
            notifyObservers();
            return exemplaire;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Exemplaire exemplaire) {
        boolean ok = ldatas.remove(exemplaire);
        notifyObservers();
        return ok;
    }

    @Override
    public Exemplaire update(Exemplaire exemplaire) {
        int p = ldatas.indexOf(exemplaire);
        if (p < 0) return null;
        ldatas.set(p, exemplaire);
        notifyObservers();
        return exemplaire;
    }

    @Override
    public Exemplaire read(Exemplaire exemplaire) {
        int p = ldatas.indexOf(exemplaire);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Exemplaire> getAll() {
        return ldatas;
    }

    @Override
    public List<Exemplaire> listerExemplaires(Ouvrage ouvrage) {
        // Implémentation spécifique à votre cas
        return null;
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon rayon) {
        // Implémentation spécifique à votre cas
        return null;
    }
}
