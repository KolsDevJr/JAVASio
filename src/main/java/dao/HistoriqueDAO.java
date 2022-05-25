package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import stage.Historique;

public class HistoriqueDAO extends DAO<Historique> {
	private static final String TABLE = "Historique";
	private static final String CLE_PRIMAIRE = "Id";

	private static final String ID_ELEVE = "Id_élève";
	private static final String ID_ENTREPRISE ="Id_entreprise";
	private static final String ID_METHODE = "Id_méthode";
	private static final String ID_RETOUR = "Id_retour";

	private static HistoriqueDAO instance=null;

	public static HistoriqueDAO getInstance(){
		if (instance==null){
			instance = new HistoriqueDAO();
		}
		return instance;
	}

	//private HistoriqueDAO() {
		//super();
	//}

	@Override
	public boolean create(Historique obj) {
		return false;
	}
	@Override
	public boolean delete(Historique obj) {
		return false;
	}
	@Override
	public boolean update(Historique obj) {
		return false;
	}

	@Override
	public Historique read(int id) {
		Historique historique = null;
		if (donnees.containsKey(id)) {
			//System.out.println("r�cup�r�");
			historique=donnees.get(id);
		}
		else {
			//System.out.println("recherch� dans la BD");
			try {

				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				int idElev = rs.getInt(ID_ELEVE);
				int idEntre = rs.getInt(ID_ENTREPRISE);
				int idMethode = rs.getInt(ID_METHODE);
				int idRet = rs.getInt(ID_RETOUR);

				historique = new Historique (id, idElev, idEntre, idMethode,idRet);
				donnees.put(id, historique);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return historique;
	}



	//	@Override
//	public boolean create(Avion av) {
//		boolean succes=true;
//		try {
//			String requete = "INSERT INTO "+TABLE+" ("+NOM_AV+","+LOCALISATION+" , "+CAPACITE+") VALUES (?, ?, ?)";
//			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
//			// on pose un String en param�tre 1 -1er '?'- et ce String est le nom de l'avion
//			pst.setString(1, av.getNom());
//			pst.setString(2, av.getLoc());
//			pst.setInt(3, av.getCapacite());
//			// on ex�cute la mise � jour
//			pst.executeUpdate();
//
//			//R�cup�rer la cl� qui a �t� g�n�r�e et la pousser dans l'objet initial
//			ResultSet rs = pst.getGeneratedKeys();
//			if (rs.next()) {
//				av.setNumero(rs.getInt(1));
//			}
//			donnees.put(av.getNumero(), av);
//
//		} catch (SQLException e) {
//			succes=false;
//			e.printStackTrace();
//		}
//
//		return succes;
//	}
//
//	@Override
//	public boolean delete(Avion av) {
//		boolean succes = true;
//		try {
//			int id = av.getNumero();
//			String requete = "DELETE FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = ?";
//			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
//			pst.setInt(1, id);
//			pst.executeUpdate();
//			donnees.remove(id);
//		} catch (SQLException e) {
//			succes=false;
//			e.printStackTrace();
//		}
//		return succes;
//	}
//
//	@Override
//	public boolean update(Avion obj) {
//		boolean succes=true;
//
//		String nom =obj.getNom();
//		String loc =obj.getLoc();
//		int capacite = obj.getCapacite();
//		int id = obj.getNumero();
//
//		try {
//			String requete = "UPDATE "+TABLE+" SET "+NOM_AV+" = ?, "+LOCALISATION+" = ?, "+CAPACITE+" = ? WHERE "+CLE_PRIMAIRE+" = ?";
//			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete) ;
//			pst.setString(1,nom) ;
//			pst.setString(2,loc) ;
//			pst.setInt(3, capacite) ;
//			pst.setInt(4, id) ;
//			pst.executeUpdate() ;
//			donnees.put(id, obj);
//		} catch (SQLException e) {
//			succes = false;
//			e.printStackTrace();
//		}
//		return succes;
//	}
//
	//
//	public void afficheSelectEtoileAvion() {
//		System.out.println("--- Avion non utilis� ---");
//		String clauseWhere = CLE_PRIMAIRE+" NOT IN (SELECT "+CLE_PRIMAIRE+" From Vol)";
//		Connexion.afficheSelectEtoile("Avion", clauseWhere);
//
//		System.out.println("--- Avion contraint par Vol --- ");
//		clauseWhere = CLE_PRIMAIRE+" IN (SELECT "+CLE_PRIMAIRE+" From Vol)";
//		Connexion.afficheSelectEtoile("Avion", clauseWhere);
//
//	}
//




}
