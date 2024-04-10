package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import java.util.List;

public abstract class DAOExemplaire {

    public abstract Exemplaire add(Exemplaire exemplaire);

    public abstract boolean remove(Exemplaire exemplaire);

    public abstract Exemplaire update(Exemplaire exemplaire);

    public abstract Exemplaire read(Exemplaire exemplaire);

    public abstract List<Exemplaire> getAll();


}
