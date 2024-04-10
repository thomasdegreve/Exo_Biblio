package bibliotheque.mvc.model;

import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Auteur;
import bibliotheque.metier.TypeLivre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OuvrageModel extends DAOOuvrage {
    private List<Ouvrage> ldatas = new ArrayList<>();

    @Override
    public Ouvrage add(Ouvrage ouvrage) {
        boolean present = ldatas.contains(ouvrage);
        if (!present) {
            ldatas.add(ouvrage);
            notifyObservers();
            return ouvrage;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Ouvrage ouvrage) {
        boolean ok = ldatas.remove(ouvrage);
        notifyObservers();
        return ok;
    }

    @Override
    public Ouvrage update(Ouvrage ouvrage) {
        int p = ldatas.indexOf(ouvrage);
        if (p < 0) return null;
        ldatas.set(p, ouvrage);
        notifyObservers();
        return ouvrage;
    }

    @Override
    public Ouvrage read(Ouvrage ouvrage) {
        int p = ldatas.indexOf(ouvrage);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Ouvrage> getAll() {
        return ldatas;
    }

    @Override
    public Set<Auteur> listerAuteurs(Ouvrage ouvrage) {
        return ouvrage.getLauteurs();
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur auteur, String genre) {
        // Implémentation spécifique à votre cas
        return null;
    }


}
