package java_crud_linkdin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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
    public static void main(String[] args) throws SQLException {
        Connection con = Connect(); // se connecter à MySQL
        Scanner sc = new Scanner(System.in);

        if (con != null) {
            int choix;

            do {
                System.out.println("\n******** MENU GESTION ETUDIANTS ********");
                System.out.println("1️ => Ajouter un étudiant");
                System.out.println("2️ => Find student by ID");
                System.out.println("3 => Afficher les étudiants");
                System.out.println("4 => Supprimer un étudiant");
                System.out.println("5 => MODIFIER UN ETUDIANT");
                System.out.println("0️ => Quitter");
                System.out.print("👉 Votre choix : ");
                choix = sc.nextInt();

                switch (choix) {
                    case 1:
                        System.out.println("******** AJOUTER UN ETUDIANT ********");
                        ajouterEtudiant ajout = new ajouterEtudiant();
                        ajout.ajouterEtudiant(con, sc);
                        break;

                    case 2:
                        System.out.println("******** Find student by ID ********");
                        afficherIdEtudiant by_Id=new afficherIdEtudiant();
                        by_Id.afficherIdEtudiant(con, sc);
                        break;
                    case 3:
                        System.out.println("******** AFFICHER LES ETUDIANTS ********");
                        afficherListEtudiant aff = new afficherListEtudiant();
                        aff.afficherListEtudiant(con);
                        break;
                    case 4:
                        System.out.println("******** SUPPRIMER UN ETUDIANT ********");
                        deleteEtudiantById del = new deleteEtudiantById();
                        del.deleteEtudiantById(con, sc);
                        break;
                    case 5:
                        System.out.println("******** MODIFIER UN ETUDIANT ********");
                        updateEtudiant up = new updateEtudiant();
                        up.updateEtudiant(con, sc);
                        break;
                    case 0:
                        System.out.println("👋 Fin du programme. À bientôt !");
                        break;

                    default:
                        System.out.println("❌ Choix invalide !");
                        break;
                }
            } while (choix != 0);
        } else {
            System.out.println("❌ Connexion échouée !");
        }

        sc.close();
    }
}
