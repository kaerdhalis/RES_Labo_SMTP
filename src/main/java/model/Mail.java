package model;

import java.lang.reflect.Array;

public class Mail {


    private String author;
    private String[] destinataires ;
    private String[] copies;
    private String sujet;
    private String texte;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getDestinataires() {
        return destinataires;
    }

    public void setDestinataires(String[] destinataires) {
        this.destinataires = destinataires;
    }

    public String[] getCopies() {
        return copies;
    }

    public void setCopies(String[] copies) {
        this.copies = copies;
    }



    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }


    public String toString(){

      String mail = "";
        mail +=String.format("Athor: %s\n",author);
        for(String s :destinataires){
            mail +=String.format("destinataire: %s",s);
        }
        mail+= "\n";
        mail +=String.format("Subject: %s\n",sujet);
        mail +=String.format("Athor: %s\n",texte);
        return mail;
    }
}
