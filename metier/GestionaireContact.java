package metier;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileWriter;

public class GestionaireContact {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void ajoutContact(String nom, String email, String telephone) {
        Contact contact = new Contact(nom, email, telephone);
        contacts.add(contact);
    }

    public void afficherContacts(){
        for(Contact contact: contacts){
            System.out.println(contact.toString());
        }
    }

    public String rechercheContact(String nom){
        for (Contact contact: contacts){
            if(nom.equals(contact.getNom())){
                return contact.toString();
            }
        }
        return "Contact: " + nom + " nom trouvé";
    }
    
    private boolean verifierCatactVide(String nom){
        return !nom.trim().isEmpty() ? true : false;
    }

    public void modifierContact(String nomActuel ,String nom, String email, String telephone ) {
        if (!verifierCatactVide(nomActuel)) {
            System.out.println("Contact: nom vide");
            return;
        }
        for(Contact contact: contacts) {
            if (nomActuel.equals(contact.getNom())) {
                if (verifierCatactVide(nom)) {
                    contact.setNom(nom);
                }
                if (verifierCatactVide(email)) {
                    contact.setEmail(email); 
                }
                if (verifierCatactVide(telephone)) {
                    contact.setTelephone(telephone);
                }
                System.out.println("Contact: modifié");
            } else {
                System.out.println("Contact: " + nomActuel + " Nom trouver");
            }
        }
    }

    public void supprimerContact(String nom) {
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            Contact contact = it.next();
            if (nom.equals(contact.getNom())){
                contacts.remove(contact);
                System.out.println("Contact: supprimé "+contact);
                return;
            }
        }
        System.out.println("Contact: " + nom + " nom trouvé");
    }

    public void sauvegarderContacts(String nomFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))){
            for(Contact contact: contacts) {
                
                writer.write(contact.toString()+",");
                writer.newLine();
            }
            System.out.print("Contacts sauvegardés dans "+nomFichier+"\n");
        } catch (Exception e) {
            System.out.print("Erreur lors de la sauvegarde : "+e.getMessage());
        }
    }

    public void chargerContacts(String nomFichier) {
        System.out.println("\n" + "Les Contacts sauvardées dans le fichier "+nomFichier +"\n");
       try {
         File file = new File(nomFichier);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line.toString()+"/n");
        }
        scanner.close();
       } catch (Exception e) {
              System.out.println("Erreur lors du chargement: "+e.getMessage());
       }
    }
}
