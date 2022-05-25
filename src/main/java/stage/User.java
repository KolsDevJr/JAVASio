package stage;

public class User {

    private int idUtilisateur;
    private int idProfil;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;

    /**
     * ON ajoute des commentaires
     * @param idUtilisateur
     * @param idProfil
     * @param nom
     * @param prenom
     * @param login
     * @param mdp
     */
    public User(int idProfil, String nom, String  prenom, String login, String mdp) {
        super();
        this.idProfil=idProfil;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp=mdp;
    }
    public User(int idUtilisateur,int idProfil, String nom, String  prenom, String login, String mdp) {
        super();
        this.idUtilisateur = idUtilisateur;
        this.idProfil=idProfil;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp=mdp;
    }

    /**
     * Encore d'autres
     * @return la localisation
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUtilisateur=" + idUtilisateur +
                ", idProfil=" + idProfil +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

}
