package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Connexion {

	private static Connection connect = null;
	// Connect to your database.
	// Replace server name, username, and password with your credentials


	public static Connection getInstance() {
		if (connect == null) {
			String connectionUrl =
					"jdbc:sqlserver://localhost\\SQLEXPRESS01;database=bdd_adopteunstagiaire;"
							+ "user=groupe1;"
							+ "password=sio;"
							+ "encrypt=true;"
							+ "trustServerCertificate=true;";
			try (Connection connection = DriverManager.getConnection(connectionUrl)) {
				System.out.println("connecté");
				connect = DriverManager.getConnection(connectionUrl);
			}
			// Handle any errors that may have occurred.
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;
	}

	private Connexion() {
		super();
	}

	public static ResultSet executeQuery(String requete) {
		Statement st = null;
		ResultSet rs = null;
		System.out.println("requete = " + requete);
		try {
			st = getInstance().createStatement();
			rs = st.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Echec de la tentative d'exécution de requete : " + requete + " [" + e.getMessage() + "]");
		}
		return rs;
	}

	public static void fermer() {
		try {
			getInstance().close();
			System.out.println("deconnexion ok");
		} catch (SQLException e) {
			connect = null;
			System.out.println("echec de la fermeture");
		}
	}
}