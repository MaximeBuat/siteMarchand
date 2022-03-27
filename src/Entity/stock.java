/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author maxim
 */
public class stock {
    private String genre;
    private String typVet;
    private String taille;
    private String couleur;
    private int prix;
    private int quantite;
    
    public stock(String unGenre, String unTypVet, String uneTaille, String uneCouleur, int unPrix, int uneQuantite) {
        genre = unGenre;
        typVet = unTypVet;
        taille = uneTaille;
        couleur = uneCouleur;
        prix = unPrix;
        quantite = uneQuantite;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the typVet
     */
    public String getTypVet() {
        return typVet;
    }

    /**
     * @return the taille
     */
    public String getTaille() {
        return taille;
    }

    /**
     * @return the couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * @return the prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
}
