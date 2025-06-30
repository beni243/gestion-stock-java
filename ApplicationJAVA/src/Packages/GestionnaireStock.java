
package Packages;

/**
 *
 * @author Muksoft
 */
import java.util.ArrayList;

public class GestionnaireStock {
    private ArrayList<Produit> listeProduits = new ArrayList<>();
    
    public void ajouterProduit(Produit p){
         listeProduits.add(p);
    }
    
    public void mettreAJourProduit(int index, Produit p){
       listeProduits.set(index, p); 
    }
    
    public void supprimerProduit(int index){
        listeProduits.remove(index);
    }
    
    public Produit getProduit(int index){
          return listeProduits.get(index);    
    }
    
    public ArrayList<Produit> getTousProduits(){
          return listeProduits;
    }
}
