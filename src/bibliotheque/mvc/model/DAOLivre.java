package bibliotheque.mvc.model;

import bibliotheque.metier.Livre;
import java.util.List;

public abstract class DAOLivre {

    public abstract Livre add(Livre livre);

    public abstract boolean remove(Livre livre);

    public abstract Livre update(Livre livre);

    public abstract Livre read(Livre livre);

    public abstract List<Livre> getAll();

    // Add other methods as needed based on your application requirements
}
