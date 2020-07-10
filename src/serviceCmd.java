import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public  class serviceCmd implements interfaceCmd {
	
	Statement stmt = null ;
	ResultSet res = null ;
	CallableStatement cstmt = null ;
	
	Connection con = Connect.getconnection();
	
	public int ajouterCmd(commande c) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call ajouter_commande(?,?,?,?,?,?)}");
			calstmt.setInt(1,c.getIdCommande());
			calstmt.setInt(2,c.getIdclient());
			calstmt.setInt(3,c.getIdproduit());
			calstmt.setInt(4,c.getQuantite());
			calstmt.setFloat(5, c.getPrix_Total());
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			calstmt.setDate(6,date);
			int a = calstmt.executeUpdate();
			int b = new serviceProduit().modifierProduit_stat(c.getIdproduit(), c.getQuantite());
			return a;
			
		}catch(SQLException e)
		{}
		
		return 0;
		
	}
	
	public float selectPrix(int id)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call prix_prd(?)}");
			calstmt.setInt(1, id);
			res = calstmt.executeQuery();
			res.next();
			return res.getFloat(1);
		
		}catch(SQLException e)
		{}
		return 0;
	}

	@Override
	public ResultSet rechercherCMD(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call rechercher_cmd(?)}");
			calstmt.setInt(1, id);
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}

	@Override
	public ResultSet afficher() {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call afficher_cmd}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}

	@Override
	public int modifier_cmd(commande c) {

		try
		{
			CallableStatement calstmt = con.prepareCall("{ call modifier_cmd(?,?,?,?,?)}");
			calstmt.setInt(1,c.getIdCommande());
			calstmt.setInt(2,c.getIdclient());
			calstmt.setInt(3,c.getIdproduit());
			calstmt.setInt(4,c.getQuantite());
			calstmt.setFloat(5, c.getPrix_Total());
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}

	@Override
	public int supprimer_cmd(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call delete_cmd(?)}");
			calstmt.setInt(1,id);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	public int annuler(int idcommande,int idproduit) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call annuler_cmd_produit(?,?)}");
			calstmt.setInt(1,idcommande);
			calstmt.setInt(2,idproduit);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	public int select_qte(int id)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call qte_dispo(?)}");
			calstmt.setInt(1,id);
			res = calstmt.executeQuery();
			res.next();
			
			return res.getInt(1) ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
}
