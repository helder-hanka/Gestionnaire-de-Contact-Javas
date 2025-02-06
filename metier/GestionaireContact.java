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
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact trouvé");
            return;
        }
        for(Contact contact: contacts){
            System.out.println(contact.toString());
        }
    }

    public void rechercheContact(String nom){
        System.out.println("Recherchecontact: "+nom);
        for (Contact contact: contacts){
            if(nom.toLowerCase().equals(contact.getNom().toLowerCase())){
                System.out.println(contact.toString());
                return;
            }
        }
        System.out.println("Contact: " + nom + " nom trouvé");
        return ;
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
            if (nomActuel.toLowerCase().equals(contact.getNom().toLowerCase())) {
                if (!nom.isEmpty()) {
                    contact.setNom(nom);
                }
                if (!email.isEmpty()) {
                    contact.setEmail(email); 
                }
                if (!telephone.isEmpty()) {
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
                writer.write(contact.getNom()+";"+ contact.getEmail()+";"+contact.getTelephone()+",");
                writer.newLine();
            }
            System.out.print("Contacts sauvegardés dans "+nomFichier+"\n");
        } catch (Exception e) {
            System.out.print("Erreur lors de la sauvegarde : "+e.getMessage());
        }
    }

    public void chargerContacts(String nomFichier) {
        File file = new File(nomFichier);
        if (!file.exists()) {
            System.out.print("Aucun fichier de contacts trouvé."+"\n");
            return;
        }
        try (Scanner scanner = new Scanner(file)) {

            //contacts.clear();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                data = line.split(",");
                if (data.length ==3) {
                    ajoutContact(data[0], data[1], data[2]);
                }
            }
            System.out.println("\n" + "Les Contacts sauvardées dans le fichier "+nomFichier +"\n");
        scanner.close();
       } catch (Exception e) {
              System.out.println("Erreur lors du chargement: "+e.getMessage());
       }
    }
}
