package presentation;

import metier.GestionaireContact;

public class Principale {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le Gestionnaire de Contacts!");

        // Créer un gestionnaire de contacts
        GestionaireContact gestionaireContact = new GestionaireContact();

        // Ajouter des contacts
        gestionaireContact.ajoutContact("Emanuel", "emanuel@gmail.com", "003030300202");
        // gestionaireContact.ajoutContact("Nani", "Nani@gmail.com", "003030300202");
        // gestionaireContact.ajoutContact("Lola", "Lola@gmail.com", "003030300202");

        // Afficher les contacts
        gestionaireContact.afficherContacts();

        // Rechercher un contact
        // System.out.println(gestionaireContact.rechercheContact("Emanuel"));

        // Modifier un contact
        gestionaireContact.modifierContact("", "Sandrine", "sandrine@g.com", "02");
        
         System.out.println(gestionaireContact.rechercheContact("Emanuel"));

        // Supprimer un contact
        // gestionaireContact.supprimerContact("Nani");
        // System.out.println(gestionaireContact.rechercheContact("Sandrine"));
    }
  
}