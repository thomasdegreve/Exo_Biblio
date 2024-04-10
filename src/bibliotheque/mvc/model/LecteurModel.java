package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;

public class LecteurModel extends DAOLecteur {
    private List<Lecteur> ldatas = new ArrayList<>();

    @Override
    public Lecteur add(Lecteur lecteur) {
        boolean present = ldatas.contains(lecteur);
        if (!present) {
            ldatas.add(lecteur);
            notifyObservers();
            return lecteur;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Lecteur lecteur) {
        boolean ok = ldatas.remove(lecteur);
        notifyObservers();
        return ok;
    }

    @Override
    public Lecteur update(Lecteur lecteur) {
        int p = ldatas.indexOf(lecteur);
        if (p < 0) return null;
        ldatas.set(p, lecteur);
        notifyObservers();
        return lecteur;
    }

    @Override
    public Lecteur read(Lecteur lecteur) {
        int p = ldatas.indexOf(lecteur);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Lecteur> getAll() {
        return ldatas;
    }
}
