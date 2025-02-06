package presentation;

import java.util.Scanner;

import metier.GestionaireContact;

public class Principale {
    public static void main(String[] args) {
        // Créer un gestionnaire de contacts
        GestionaireContact gestionnaireContact = new GestionaireContact();
        
        // Charger les contacts depuis un fichier
        gestionnaireContact.chargerContacts("contacts.txt");

        //System.out.println(infoUser);
       Scanner scanner = new Scanner(System.in);

        while(true) {
            afficherMenu();
    
            // Vérifier si l'entrée est bien un entier
            if (!scanner.hasNextInt()) {
                System.out.println("Erreur : Veuillez entrer un nombre valide !");
                scanner.next(); // Consommer l'entrée invalide
                continue;
            }

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            if (choix == 7) {
                System.out.print("Au revoir!");
                break;
            }
            traiterChoix(gestionnaireContact,choix, scanner);
        }
        
    }

    private static void traiterChoix(GestionaireContact gestionnaireContact, int choix, Scanner scanner) {  
            switch (choix) {
                case 1:
                // Ajouter des contacts
                String nom = validerContact(scanner, "Nom");
                String email = validerContact(scanner, "Email");
                String telephone = validerContact(scanner, "Telephone");
                gestionnaireContact.ajoutContact(nom, email, telephone);
                break;
                case 2:
                // Afficher les contacts
                gestionnaireContact.afficherContacts();
                break;
                case 3:
                // Rechercher un contact
                String nomRecherche = validerContact(scanner, "Nom de recherche");
                gestionnaireContact.rechercheContact(nomRecherche);
                break;
                case 4:
                // Modifier un contact
                String nomActuel = validerContact(scanner, "Nom actuel pour modifier");
                String changerNom = validerContact(scanner, "Nom à changer pour modifier");
                String nomEmail = validerContactActuel(scanner, "Email pour modifier");
                String nomTelephone = validerContactActuel(scanner, "Telephone pour modifier");
                gestionnaireContact.modifierContact(nomActuel, changerNom, nomEmail, nomTelephone);
                break;
                case 5:
                // Supprimer un contact
                String supprimerContact = validerContactActuel(scanner, "Nom à supprimer");
                gestionnaireContact.supprimerContact(supprimerContact);
                break;
                case 6:
                // Sauvegarder les contacts dans un fichier
                gestionnaireContact.sauvegarderContacts("contacts.txt");
                break;
                default:
                System.out.println("Choix invalide");
                break;
            }
    }

    private static String  validerContact(Scanner scanner, String message) {
        String ligne;     
        do {
             System.out.println("Entrez Votre: "+message);
             ligne = scanner.nextLine().trim();
             if(ligne.isEmpty()) {
                 System.out.println("Le "+message+" est vide");
                }
            } while(ligne.isEmpty());
            return ligne;
    }
    private static String  validerContactActuel(Scanner scanner, String message) {
        System.out.println("Entrez Votre: "+message);
        return scanner.nextLine().trim();
    }
    private static void afficherMenu() {
    System.out.println("\nBienvenue dans le Gestionnaire de Contacts !");
    System.out.println("1 - Ajouter un contact");
    System.out.println("2 - Afficher tous les contacts");
    System.out.println("3 - Rechercher un contact");
    System.out.println("4 - Modifier un contact");
    System.out.println("5 - Supprimer un contact");
    System.out.println("6 - Sauvegarder les contacts");
    System.out.println("7 - Quitter");
    System.out.print("Votre choix : ");
    }

}