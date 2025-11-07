package java_crud_linkdin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CRUD_Gestion_Etudiants {
    private static final String URL = "jdbc:mysql://localhost/CRUD_Gestion_Etudiants";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Méthode de connexion
    public static Connection Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            return null;
        }
    }

    // Méthode main
    public static void main(String[] args) {
        Connection con = Connect(); // se connecter à MySQL

        if (con != null) {
            ajouterEtudiant ajout = new ajouterEtudiant();
            ajout.ajouterEtudiant(con); // appel de la méthode d’ajout
        } else {
            System.out.println("❌ Connexion échouée !");
        }
    }
}
