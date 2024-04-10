package bibliotheque.mvc.model;

import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class DAOOuvrage {
    private List<Ouvrage> ouvrages;

    public DAOOuvrage() {
        this.ouvrages = new ArrayList<>();
    }

    public List<Ouvrage> getAll() {
        return ouvrages;
    }

    public Ouvrage add(Ouvrage ouvrage) {
        ouvrages.add(ouvrage);
        return ouvrage;
    }

    public boolean remove(Ouvrage ouvrage) {
        return ouvrages.remove(ouvrage);
    }

    public Ouvrage update(Ouvrage ouvrage) {
        int index = ouvrages.indexOf(ouvrage);
        if (index != -1) {
            ouvrages.set(index, ouvrage);
            return ouvrage;
        }
        return null;
    }

    public Ouvrage read(String titre) {
        for (Ouvrage ouvrage : ouvrages) {
            if (ouvrage.getTitre().equals(titre)) {
                return ouvrage;
            }
        }
        return null;
    }
}
