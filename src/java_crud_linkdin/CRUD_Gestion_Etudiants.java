package java_crud_linkdin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD_Gestion_Etudiants {

    public static void main(String[] args) throws SQLException {

        Connection con = ConnectionManager.getConnection();  // <-- NEW
        Scanner sc = new Scanner(System.in);

        if (con != null) {
            int choix;

            do {
                System.out.println("\n******** MENU GESTION ETUDIANTS ********");
                System.out.println("1️ => Ajouter un étudiant");
                System.out.println("2️ => Find student by ID");
                System.out.println("3️ => Afficher les étudiants");
                System.out.println("4️ => Supprimer un étudiant");
                System.out.println("5️ => Modifier un étudiant");
                System.out.println("0️ => Quitter");
                System.out.print("👉 Votre choix : ");
                choix = sc.nextInt();

                switch (choix) {
                    case 1:
                        new ajouterEtudiant().ajouterEtudiant(con, sc);
                        break;

                    case 2:
                        new afficherIdEtudiant().afficherIdEtudiant(con, sc);
                        break;

                    case 3:
                        new afficherListEtudiant().afficherListEtudiant(con);
                        break;

                    case 4:
                        new deleteEtudiantById().deleteEtudiantById(con, sc);
                        break;

                    case 5:
                        new updateEtudiant().updateEtudiant(con, sc);
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
