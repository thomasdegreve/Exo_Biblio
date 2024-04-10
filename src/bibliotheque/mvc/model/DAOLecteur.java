package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;
import java.util.List;

public abstract class DAOLecteur {

    public abstract Lecteur add(Lecteur lecteur);

    public abstract boolean remove(Lecteur lecteur);

    public abstract Lecteur update(Lecteur lecteur);

    public abstract Lecteur read(Lecteur lecteur);

    public abstract List<Lecteur> getAll();

    // Ajoutez d'autres méthodes si nécessaire en fonction des besoins de votre application
}
