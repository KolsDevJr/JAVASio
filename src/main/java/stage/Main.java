package stage;

import dao.Connexion;
import dao.HistoriqueDAO;
import dao.UserDAO;

public class Main {

	public static void main(String[] args) {


		Connexion.getInstance();
		System.out.println(UserDAO.getInstance().read(4));
		System.out.println(UserDAO.getInstance().readUser("pierre"));

		//Historique historique=HistoriqueDAO.getInstance().read(1);
		//System.out.println(historique);
	}

}

