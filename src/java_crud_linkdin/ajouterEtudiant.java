package java_crud_linkdin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ajouterEtudiant {

	 public void ajouterEtudiant(Connection con, Scanner sc2) {
	        try (Scanner sc = new Scanner(System.in)) {
	            System.out.print("Nom : ");
	            String nom = sc.nextLine();

	            System.out.print("Prénom : ");
	            String prenom = sc.nextLine();

	            System.out.print("Âge : ");
	            int age = sc.nextInt();

	            java.sql.Date dateInscription = java.sql.Date.valueOf(java.time.LocalDate.now());

	            String sql = "INSERT INTO etudiants (nom, prenom, age, date_inscription) VALUES (?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, nom);
	            ps.setString(2, prenom);
	            ps.setInt(3, age);
	            ps.setDate(4, dateInscription);

	            int result = ps.executeUpdate();
	            ps.close();

	            if (result > 0) {
	                System.out.println("✅ Étudiant ajouté avec succès !");
	            }

	        } catch (SQLException e) {
	            System.out.println("❌ Erreur SQL : " + e.getMessage());
	        }
	    }
}
