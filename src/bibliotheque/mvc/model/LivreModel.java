package bibliotheque.mvc.model;

import bibliotheque.metier.Livre;

import java.util.ArrayList;
import java.util.List;

public class LivreModel extends DAOLivre {
    private List<Livre> ldatas = new ArrayList<>();

    @Override
    public Livre add(Livre livre) {
        boolean present = ldatas.contains(livre);
        if (!present) {
            ldatas.add(livre);
            notifyObservers();
            return livre;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Livre livre) {
        boolean ok = ldatas.remove(livre);
        notifyObservers();
        return ok;
    }

    @Override
    public Livre update(Livre livre) {
        int p = ldatas.indexOf(livre);
        if (p < 0) return null;
        ldatas.set(p, livre);
        notifyObservers();
        return livre;
    }

    @Override
    public Livre read(Livre livre) {
        int p = ldatas.indexOf(livre);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Livre> getAll() {
        return ldatas;
    }
}
