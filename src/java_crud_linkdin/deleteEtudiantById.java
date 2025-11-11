package java_crud_linkdin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteEtudiantById {
    public void deleteEtudiantById(Connection con, Scanner sc) {
        try {
            System.out.print("Id de l'étudiant à supprimer : ");
            int idEtudiant = sc.nextInt();

            String sql = "DELETE FROM etudiants WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEtudiant);

            int result = ps.executeUpdate();
            ps.close();

            if (result > 0) {
                System.out.println("✅ Étudiant supprimé avec succès !");
            } else {
                System.out.println("⚠️ Aucun étudiant trouvé avec cet ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }
}
