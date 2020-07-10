import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceClient implements InterfaceClient {

	Statement stmt = null ;
	ResultSet res = null ;
	CallableStatement cstmt = null ;
	
	Connection con = Connect.getconnection();
	
	public int ajouterClient(client c) {
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call ajouterClient2(?,?,?,?,?,?)}");
			calstmt.setInt(1,c.getIdClient());
			calstmt.setString(2,c.getNomClient());
			calstmt.setString(3,c.getPrenomClient());
			calstmt.setString(4,c.getAdresseClient());
			calstmt.setString(5,c.getCodePostalClient());
			calstmt.setString(6,c.getVilleClient());
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}


	@Override
	public ResultSet rechercherParId(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call rechercherClient(?)}");
			calstmt.setInt(1, id);
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}


	@Override
	public ResultSet Afficher() {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call afficher}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}


	@Override
	public int modifierClient(client c) {
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call modifierClient(?,?,?,?,?,?)}");
			calstmt.setInt(1,c.getIdClient());
			calstmt.setString(2,c.getNomClient());
			calstmt.setString(3,c.getPrenomClient());
			calstmt.setString(4,c.getAdresseClient());
			calstmt.setString(5,c.getCodePostalClient());
			calstmt.setString(6,c.getVilleClient());
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}


	@Override
	public int deleteClient(int id) {
		
		
		
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call supprimer_Client(?)}");
			calstmt.setInt(1,id);
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	public int deleteClientCommande(int id) {
		
		
		
		try
		{
			CallableStatement calstmt1 = con.prepareCall("{ call delete_commande_par_client(?)}");
			calstmt1.setInt(1,id);
			int b = calstmt1.executeUpdate();
			return b ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	
	public int incr_client()
	{

		try
		{
			CallableStatement calstmt1 = con.prepareCall("{ call max_id_client}");
			res = calstmt1.executeQuery();
			res.next();
			
				return res.getInt(1);
			
		}catch(SQLException e)
		{}
		
		return 0;
	
	}
	public ResultSet select_client()
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call select_client}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}
	
}