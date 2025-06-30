
package Packages;

/**
 *
 * @author Muksoft
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class FenetrePrincipale extends JFrame
{
  private GestionnaireStock stock;
  private JTextField nomField, quantiteField, prixField;
  private JButton addButton, updateButton, deleteButton;
  private JTable productTable;
  private DefaultTableModel tableModel;
  
  public FenetrePrincipale(){
      stock=new GestionnaireStock();
      
      setTitle("Gestion de stock");
      setSize(600,400);
      
setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(null);
      
      nomField = new JTextField();
      quantiteField = new JTextField();
      prixField = new JTextField();
      nomField.setBounds(20, 20, 150, 25);
      quantiteField.setBounds(180, 20, 80, 25);
      prixField.setBounds(270, 20, 80, 25);
      
addButton = new JButton("Ajouter");
    updateButton = new JButton("Mettre à jour");
    deleteButton = new JButton ("Supprimer");
    addButton.setBounds(360, 20, 90, 25);
    updateButton.setBounds(460, 20, 110, 25);
    deleteButton.setBounds(360, 60, 210, 25);
    
    tableModel = new DefaultTableModel(new Object[]{"Nom","Quantite","Prix"},0);
    productTable = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(productTable);
    scrollPane.setBounds(20, 100, 550, 200);
    
    add(nomField);
    add(quantiteField);
    add(prixField);        
    add(addButton);
    add(updateButton);  
    add(deleteButton);    
    add(scrollPane);
    
    //Actions
    addButton.addActionListener(e->{
        String nom = nomField.getText();
        int quantite =
Integer.parseInt(quantiteField.getText());
        double prix =
Double.parseDouble(prixField.getText());
        Produit p = new Produit(nom, quantite, prix);
        stock.ajouterProduit(p);
        tableModel.addRow(new Object[]{nom, quantite, prix});
    });
    
      updateButton.addActionListener(e->{
          int row = productTable.getSelectedRow();
          if (row>=0){
String nom = nomField.getText();
        int quantite =
Integer.parseInt(quantiteField.getText());
        double prix =
Double.parseDouble(prixField.getText());
        Produit p = new Produit(nom, quantite, prix);
        stock.mettreAJourProduit(row,p);
        tableModel.setValueAt(nom, row, 0);
        tableModel.setValueAt(quantite, row, 1);
        tableModel.setValueAt(prix, row, 2);
          }        
      });
      
      deleteButton.addActionListener(e->{
          int row = productTable.getSelectedRow();
          if (row>=0){
              stock.supprimerProduit(row);
              tableModel.removeRow(row);
            }
      });
      
     productTable.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e){               
                int row =
    productTable.getSelectedRow();
                if(row>=0){
                Produit p = stock.getProduit(row);
                nomField.setText(p.getNom());
                quantiteField.setText(String.valueOf(p.getQuantite()));
                prixField.setText(String.valueOf(p.getPrixUnitaire()));
              }  
            }  
          });
     
      setVisible(true);
    }
 public static void main(String[]args){
         new FenetrePrincipale();
 }
}