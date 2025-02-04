package metier;

public class Contact {
   private String nom;
   private String email;
   private String telephone;

   public Contact(String nom, String email, String telephone){
    this.nom = nom;
    this.email = email;
    this.telephone = telephone;
   }

   public String getNom(){
    return this.nom;
   }
   public String getEmail(){
    return this.email;
   }
   public String getTelephone(){
    return this.telephone;
   }

   public void setNom(String nom) {
    this.nom = nom;
   }
   public void setEmail(String email) {
    this.email = email;
   }
   public void setTelephone(String telephone) {
    this.telephone = telephone;
   }

   public String toString(){
    return "Nom: "+this.nom+" Email: "+this.email+" Telephone: "+this.telephone;
   }
}
