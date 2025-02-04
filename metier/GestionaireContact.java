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

    public void modifierContact(String nomActuel ,String nom, String email, String telephone ) {
        for(Contact contact: contacts) {
            if (nomActuel.equals(contact.getNom())) {
                if(nom != null) {
                    contact.setNom(nom);
                }
                contact.setNom(nom);    
                contact.setEmail(email);
                contact.setTelephone(telephone);
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
