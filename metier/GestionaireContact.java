package metier;

import java.util.ArrayList;
import java.util.Iterator;

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
}
