import java.sql.ResultSet;

public interface interfaceProduit {

   int ajouterProduit(produitClasse p);
   int modifierProduit(produitClasse p);
   ResultSet rechercher(int code);
   ResultSet afficher();
   int deleteProduit(int id);
   int demunue_qte_prd(int code , int qte);
   int augmt_qte_prd(int code , int qte);
   ResultSet select_produit();
   ResultSet select_stat_prd();
   int select_somme_qte_vendu();
}
