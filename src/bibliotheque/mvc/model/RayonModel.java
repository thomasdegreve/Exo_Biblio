package bibliotheque.mvc.model;

import bibliotheque.metier.Rayon;
import bibliotheque.metier.Exemplaire;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RayonModel extends DAORayon {
    private List<Rayon> ldatas = new ArrayList<>();

    @Override
    public Rayon add(Rayon rayon) {
        boolean present = ldatas.contains(rayon);
        if (!present) {
            ldatas.add(rayon);
            notifyObservers();
            return rayon;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Rayon rayon) {
        boolean ok = ldatas.remove(rayon);
        notifyObservers();
        return ok;
    }

    @Override
    public Rayon update(Rayon rayon) {
        int p = ldatas.indexOf(rayon);
        if (p < 0) return null;
        ldatas.set(p, rayon);
        notifyObservers();
        return rayon;
    }

    @Override
    public Rayon read(Rayon rayon) {
        int p = ldatas.indexOf(rayon);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Rayon> getAll() {
        return ldatas;
    }

    @Override
    public Set<Exemplaire> listerExemplaires(Rayon rayon) {
        return rayon.getLex();
    }
}
