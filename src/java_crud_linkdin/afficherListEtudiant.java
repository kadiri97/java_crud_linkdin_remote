package java_crud_linkdin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class afficherListEtudiant {
	public void afficherListEtudiant(Connection con) throws SQLException {
		String sql = "SELECT id,nom,prenom,age,date_inscription FROM etudiants";
		try (PreparedStatement ps = con.prepareStatement(sql);

				ResultSet rs = ps.executeQuery()) {
			System.out.println("Liste des étudiants :");
			System.out.println("ID|Nom|Prenom|Age|Date dinscription");
			System.out.println("-------------------------------------");
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int age = rs.getInt("id");
				java.sql.Date dateInscription = rs.getDate("date_insription");
				System.out.printf("%d | %s | %s | %d | %s%n", id, nom, prenom, age, dateInscription);
			}
		} catch (SQLException e) {
			System.out.println("❌ Erreur SQL : " + e.getMessage());
		}
	}
}
