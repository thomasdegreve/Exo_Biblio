package bibliotheque.gestion;

import bibliotheque.metier.*;
import bibliotheque.utilitaires.CDFactoryBeta;
import bibliotheque.utilitaires.DVDFactoryBeta;
import bibliotheque.utilitaires.LivreFactoryBeta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.choixListe;

public class Gestion {
    Scanner sc = new Scanner(System.in);
//on a ôté static pour les listes qui n'est plus nécessaire
    private List<Auteur> laut = new ArrayList<>();
    private List<Lecteur> llect = new ArrayList<>();
    private List<Ouvrage> louv= new ArrayList<>();
    private List<Exemplaire> lex = new ArrayList<>();
    private List<Rayon> lrayon= new ArrayList<>();
    private List<Location> lloc = new ArrayList<>();


    public void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,LocalTime.of(2,0,0),(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

         a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        a.addOuvrage(d);


        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);
        e.setRayon(r);


        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        e.setRayon(r);


        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lloc.add(loc);
        loc.setDateRestitution(LocalDate.of(2023,2,4));

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
        lloc.add(loc);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","restitution","fin"));
      do{
        int choix = choixListe(options);

            switch (choix){
                case 1 :gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                case 7 : gestRestitution();break;
                default:System.exit(0);
            }
        }  while (true);
    }

    private void gestRestitution() {
        // Lister les exemplaires en location
        System.out.println("Exemplaires en location :");
        for (Location loc : lloc) {
            System.out.println(loc.getExemplaire());
        }

        // Choix de l'exemplaire à restituer
        int choix = choixListe(lex);
        Exemplaire exemplaire = lex.get(choix);

        // Enregistrer la restitution de l'exemplaire
        exemplaire.getLloc().get(exemplaire.getLloc().size() - 1).enregistrerRetour();
        System.out.println("Restitution enregistrée pour l'exemplaire " + exemplaire.getMatricule());
    }

    private void gestLocations() {
        // Ne lister que les exemplaires disponibles et les trier par matricule
        System.out.println("Exemplaires disponibles : ");
        for (Exemplaire exemplaire : lex) {
            if (!exemplaire.enLocation()) {
                System.out.println(exemplaire);
            }
        }


        int choixExemplaire = choixListe(lex);
        Exemplaire exemplaire = lex.get(choixExemplaire);


        int choixLecteur = choixListe(llect);
        Lecteur lecteur = llect.get(choixLecteur);

        // Création de la location
        Location loc = new Location(LocalDate.now(), null, lecteur, exemplaire);
        lloc.add(loc);

        System.out.println("Location enregistrée pour l'exemplaire " + exemplaire.getMatricule() +
                " par le lecteur " + lecteur.getNom() + " " + lecteur.getPrenom());
    }


    private void gestLecteurs() {
        System.out.println("numéro");
        int num=sc.nextInt();
        sc.skip("\n");
        System.out.println("nom ");
        String nom=sc.nextLine();
        System.out.println("prénom ");
        String prenom=sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn= LocalDate.of(a,m,j);
        System.out.println("adresse");
        String adr=sc.nextLine();
        System.out.println("mail");
        String mail=sc.nextLine();
        System.out.println("tel ");
        String tel=sc.nextLine();
        Lecteur lect = new Lecteur(num,nom,prenom,dn,adr,mail,tel);
        llect.add(lect);
        System.out.println("lecteur créé");

    }

    private void gestRayons() {
        System.out.println("Code du rayon : ");
        String code = sc.next();
        System.out.println("Genre du rayon : ");
        String genre = sc.next();
        Rayon r = new Rayon(code, genre);
        System.out.println("Rayon créé : " + r);

        lrayon.add(r);

        // Attribuer des exemplaires au rayon
        System.out.println("Attribuer des exemplaires au rayon :");
        while (true) {
            int choixExemplaire = choixListe(lex);
            Exemplaire exemplaire = lex.get(choixExemplaire);

            // Vérifier si l'exemplaire n'est pas déjà dans un rayon
            boolean estDansUnRayon = false;
            for (Rayon rayon : lrayon) {
                if (rayon.getLex().contains(exemplaire)) {
                    estDansUnRayon = true;
                    break;
                }
            }

            if (!estDansUnRayon) {
                r.addExemplaire(exemplaire);
                System.out.println("Exemplaire ajouté au rayon.");
            } else {
                System.out.println("Cet exemplaire est déjà attribué à un rayon.");
            }

            System.out.println("Voulez-vous ajouter un autre exemplaire au rayon ? (oui/non)");
            String reponse = sc.next();
            if (!reponse.equalsIgnoreCase("oui")) {
                break;
            }
        }
    }

    private void gestExemplaires() {
        System.out.println("matricule ");
        String mat = sc.next();
        System.out.println("etat  ");
        String etat = sc.next();
        System.out.println("ouvrage ");
        int choix = choixListe(louv);
        Exemplaire ex = new Exemplaire(mat, etat, louv.get(choix - 1));
        lex.add(ex);
        System.out.println("exemplaire créé");

        // Trier les rayons par ordre de code
        Collections.sort(lrayon, new Comparator<Rayon>() {
            @Override
            public int compare(Rayon r1, Rayon r2) {
                return r1.getCodeRayon().compareTo(r2.getCodeRayon());
            }
        });
    }

    private void gestOuvrages() {
      /*  Ouvrage o = null;
        System.out.println("titre");
        String titre= sc.nextLine();
        System.out.println("age minimum");
        int ageMin= sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");

        LocalDate dp= Utilitaire.lecDate();
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        switch (choix){
                case 1 :
                           System.out.println("isbn ");
                           String isbn = sc.next();
                           System.out.println("pages ");
                           int nbrePages = sc.nextInt();
                           sc.skip("\n");
                           TypeLivre[] ttl = TypeLivre.values();
                           List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
                            choix = Utilitaire.choixListe(ltl);
                            TypeLivre tl = ttl[choix-1];
                           System.out.println("résumé du livre :");
                           String resume = sc.nextLine();
                           o=new Livre(titre,ageMin,dp,ploc,langue,genre,isbn,nbrePages,tl,resume);
                           ;break;
                case 2 :
                            System.out.println("code : ");
                            long code= sc.nextLong();
                            System.out.println("nombre de plages :");
                            byte nbrePlages= sc.nextByte();
                            LocalTime dureeTotale = Utilitaire.lecTime();
                            o=new CD(titre,ageMin,dp,ploc,langue,genre,code,nbrePlages,dureeTotale);
                            ;break;
                case 3 :
                            System.out.println("code : ");
                            code= sc.nextLong();
                            dureeTotale=Utilitaire.lecTime();
                            byte nbreBonus= sc.nextByte();
                            o=new DVD(titre,ageMin,dp,ploc,langue,genre,code,dureeTotale,nbreBonus);
                            System.out.println("autres langues");
                            List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
                            do{
                                choix=Utilitaire.choixListe(langues);
                                if(choix==langues.size())break;
                                ((DVD)o).getAutresLangues().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set et pas de doublon avec langue d'origine
                            }while(true);
                           System.out.println("sous-titres");
                            do{
                             choix=Utilitaire.choixListe(langues);
                             if(choix==langues.size())break;
                             ((DVD)o).getSousTitres().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set
                             }while(true);
                            ;break;
            }*/



        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = choixListe(lto);
        Ouvrage o = null;

     switch(choix) {
            case 1 : o = new LivreFactoryBeta().create();break;
            case 2 : o = new CDFactoryBeta().create();break;
            case 3 : o = new DVDFactoryBeta().create();break;
        }
       /* List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();*/
        louv.add(o);
        System.out.println("ouvrage créé");
        // Attribuer les auteurs par boucle
        System.out.println("Attribuer des auteurs à l'ouvrage :");
        boolean continuer = true;
        do {
            choix = choixListe(laut);
            Auteur auteurChoisi = laut.get(choix - 1);
            if (!o.getAuteurs().contains(auteurChoisi)) {
                o.addAuteur(auteurChoisi);
                System.out.println("Auteur ajouté à l'ouvrage.");
            } else {
                System.out.println("Cet auteur est déjà associé à cet ouvrage.");
            }

            System.out.println("Voulez-vous ajouter un autre auteur ? (Oui/Non)");
            String reponse = sc.next().toLowerCase();
            if (!reponse.equals("oui")) {
                continuer = false;
            }
        } while (continuer);
    }

       private void gestAuteurs() {
           System.out.println("nom ");
           String nom = sc.nextLine();
           System.out.println("prénom ");
           String prenom = sc.nextLine();
           System.out.println("nationalité");
           String nat = sc.nextLine();
           Auteur a = new Auteur(nom, prenom, nat);
           laut.add(a);
           System.out.println("écrivain créé");
           System.out.println("Attribuer des ouvrages à l'auteur :");
           boolean continuer = true;
           do {
               int choix = choixListe(louv);
               Ouvrage ouvrageChoisi = louv.get(choix - 1);

               if (!auteur.getOuvrages().contains(ouvrageChoisi)) {
                   (//correction )      auteur.addOuvrage(ouvrageChoisi);
                   System.out.println("Ouvrage ajouté à l'auteur.");
               } else {
                   System.out.println("Cet ouvrage est déjà associé à cet auteur.");
               }

               System.out.println("Voulez-vous attribuer un autre ouvrage ? (Oui/Non)");
               String reponse = sc.next().toLowerCase();
               if (!reponse.equals("oui")) {
                   continuer = false;
               }
           } while (continuer);
       }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.populate();
        g.menu();
    }


}
