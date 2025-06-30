
package Packages;

/**
 *
 * @author Muksoft
 */
public class Produit {
    private String nom;
    private int quantite;
    private double prixUnitaire;

    public Produit(String nom, int quantite, double prixUnitaire){
       this.nom = nom;
       this.quantite = quantite;
       this.prixUnitaire = prixUnitaire;
          }
    
    public String getNom() { return nom; }
    public void setNom(String nom){ this.nom = nom;}
    
    public int getQuantite() {return quantite;}
    public void setQuantite(int quantite) { this.quantite = quantite;}
    
    public double getPrixUnitaire(){ return prixUnitaire;}
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire;}
    
    @Override
    public String toString(){ return nom + "-" + quantite + "-" + prixUnitaire +"FC";
    }
}


