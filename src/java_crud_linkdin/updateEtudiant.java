package java_crud_linkdin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateEtudiant {

    public void updateEtudiant(Connection con, Scanner sc) {
        try {
            System.out.print("ID de l'étudiant à modifier : ");
            int id = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Nouveau nom : ");
            String nom = sc.nextLine();

            System.out.print("Nouveau prénom : ");
            String prenom = sc.nextLine();

            System.out.print("Nouvel âge : ");
            int age = sc.nextInt();

            String sql = "UPDATE etudiants SET nom = ?, prenom = ?, age = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setInt(3, age);
            ps.setInt(4, id);

            int result = ps.executeUpdate();
            ps.close();

            if (result > 0) {
                System.out.println("✅ Étudiant mis à jour avec succès !");
            } else {
                System.out.println("⚠️ Aucun étudiant trouvé avec cet ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }
}
