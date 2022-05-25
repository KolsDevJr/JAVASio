package stage;

public class Historique {

	private int id;
	private int idEleve;
	private int idEntreprise;
	private int idMethode;
	private int idRetour;
	
	/**
	 * ON ajoute des commentaires
	 */
	public Historique(int id, int idEleve,int idEntreprise,int idMethode,int idRetour) {
		super();
		this.id = id;
		this.idEleve = idEleve;
		this.idEntreprise = idEntreprise;
		this.idMethode = idMethode;
		this.idRetour = idRetour;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the idEleve
	 */
	public int getIdEleve() {
		return idEleve;
	}

	/**
	 * @return the idEntreprise
	 */
	public int getIdEntreprise() {
		return idEntreprise;
	}

	/**
	 * @return the idMethode
	 */
	public int getIdMethode() {
		return idMethode;
	}

	/**
	 * @return the idRetour
	 */
	public int getIdRetour() {
		return idRetour;
	}

	@Override
	public String toString() {
		return "Historique [id=" + id + ", idEleve=" + idEleve + ", idEntreprise=" + idEntreprise + ", idMethode="
				+ idMethode + ", idRetour=" + idRetour + "]";
	}
	
}

