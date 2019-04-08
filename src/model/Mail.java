package model;

import java.lang.reflect.Array;

public class Mail {


    private String author;
    private String[] destinataires;
    private String[] copies;
    private String[] copies_caches;
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

    public String[] getCopies_caches() {
        return copies_caches;
    }

    public void setCopies_caches(String[] copies_caches) {
        this.copies_caches = copies_caches;
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
}
