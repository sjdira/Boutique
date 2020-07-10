import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class serviceProduit implements interfaceProduit {
    
    Statement stmt = null ;
	ResultSet res = null ;
	CallableStatement cstmt = null ;
	
	Connection con = Connect.getconnection();
	
	public int ajouterProduit(produitClasse p) {

		try
		{
			CallableStatement calstmt = con.prepareCall("{ call ajouterProduit (?,?,?,?,?,?)}");
			calstmt.setInt(1,p.getCode());
			calstmt.setString(2,p.getDesignation());
			calstmt.setString(3,p.getCategorie());
			calstmt.setInt(4,p.getQte());
			calstmt.setFloat(5,p.getPrix());
			calstmt.setFloat(6,p.getTva());
			int a = calstmt.executeUpdate();
			int b = ajouter_stat_prd(p.getCode());
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;	
	}
	public int ajouter_stat_prd(int id)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call ajouter_stat_prod (?)}");
			calstmt.setInt(1,id);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}

	@Override
	public int modifierProduit(produitClasse p) {
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call modifierPrd (?,?,?,?,?,?)}");
			calstmt.setInt(1,p.getCode());
			calstmt.setString(2,p.getDesignation());
			calstmt.setString(3,p.getCategorie());
			calstmt.setInt(4,p.getQte());
			calstmt.setFloat(5,p.getPrix());
			calstmt.setFloat(6,p.getTva());
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
public int modifierProduit_stat(int id , int qte) {
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call update_stat_prd (?,?)}");
			calstmt.setInt(1,id);
			calstmt.setInt(2,qte);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
public int modifierProduit_stat2(int id , int qte) {
	
	try
	{
		CallableStatement calstmt = con.prepareCall("{ call update_stat_prd2(?,?)}");
		calstmt.setInt(1,id);
		calstmt.setInt(2,qte);
		int a = calstmt.executeUpdate();
		return a ;
		
	}catch(SQLException e)
	{}
	
	return 0;
}

	@Override
	public ResultSet rechercher(int code) {
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call rechercherProduit(?)}");
			calstmt.setInt(1, code);
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
		
	}

	@Override
	public ResultSet afficher() {
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call afficher_prod}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
		
	}

	@Override
	public int deleteProduit(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call deleteProduit(?)}");
			calstmt.setInt(1,id);
			int a = calstmt.executeUpdate();
			int b = deleteProduit_statistique(id);
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	public int deleteProduit_statistique(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call delete_stat_prd(?)}");
			calstmt.setInt(1,id);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	
	public int deleteProduitCommande(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call delete_commande_par_produit(?)}");
			calstmt.setInt(1,id);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	public int demunue_qte_prd(int code , int qte)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call demenue_qte_prd(?,?)}");
			calstmt.setInt(1,code);
			calstmt.setInt(2,qte);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	public int augmt_qte_prd(int code , int qte)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call augmenter_qte_prd(?,?)}");
			calstmt.setInt(1,code);
			calstmt.setInt(2,qte);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	public ResultSet select_produit()
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call select_produit}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}
	
	public ResultSet select_stat_prd()
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call select_stat_prd}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}
	
	public int select_somme_qte_vendu()
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call sum_qte_vendu}");
			res = calstmt.executeQuery();
			res.next();
			return res.getInt(1);
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	public float select_tva(int idproduit)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call select_tva(?)}");
			calstmt.setInt(1, idproduit);
			res = calstmt.executeQuery();
			res.next();
			return res.getFloat(1);
		}catch(SQLException e)
		{}
		
		return 0;
	}
	}


