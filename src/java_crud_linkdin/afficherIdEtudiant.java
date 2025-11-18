package java_crud_linkdin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class afficherIdEtudiant {
	public void afficherIdEtudiant(Connection con, Scanner sc) throws SQLException {
	    System.out.print("Search by student ID: ");
	    int id = sc.nextInt();

	    String sql = "SELECT id, nom, prenom, age, date_inscription FROM etudiants WHERE id = ?";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id); // IMPORTANT: set the ID value

	        try (ResultSet rs = ps.executeQuery()) {

	            if (!rs.next()) {
	                System.out.println("❌ No student found with ID: " + id);
	                return;
	            }

	            System.out.println("Student information:");
	            System.out.println("ID | Nom | Prenom | Age | Date d'inscription");
	            System.out.println("--------------------------------------------");

	            do {
	                int idEtudiant = rs.getInt("id");
	                String nom = rs.getString("nom");
	                String prenom = rs.getString("prenom");
	                int age = rs.getInt("age");
	                java.sql.Date dateInscription = rs.getDate("date_inscription");

	                System.out.printf("%d | %s | %s | %d | %s%n",
	                        idEtudiant, nom, prenom, age, dateInscription);

	            } while (rs.next());
	        }

	    } catch (SQLException e) {
	        System.out.println("❌ SQL Error: " + e.getMessage());
	    }
	}

}
