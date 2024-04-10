package bibliotheque.mvc.model;

import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class DAORayon {
    private List<Rayon> rayons;

    public DAORayon() {
        this.rayons = new ArrayList<>();
    }

    public List<Rayon> getAll() {
        return rayons;
    }

    public Rayon add(Rayon rayon) {
        rayons.add(rayon);
        return rayon;
    }

    public boolean remove(Rayon rayon) {
        return rayons.remove(rayon);
    }

    public Rayon update(Rayon rayon) {
        int index = rayons.indexOf(rayon);
        if (index != -1) {
            rayons.set(index, rayon);
            return rayon;
        }
        return null;
    }
    public Rayon read(String codeRayon) {
        for (Rayon rayon : rayons) {
            if (rayon.getCodeRayon().equals(codeRayon)) {
                return rayon;
            }
        }
        return null;
    }


}
