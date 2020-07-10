import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class serviceFacture implements interfaceFacture {
    
    Statement stmt = null ;
	ResultSet res = null ;
	CallableStatement cstmt = null ;
	
	Connection con = Connect.getconnection();
	
	public int ajouter_Facture(Facture f) {
	
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call ajouter_facture(?,?,?,?,?,?,?)}");
			calstmt.setInt(1,f.getIdfacture());
			calstmt.setInt(2,f.getIdclient());
			calstmt.setFloat(3,f.getMontantpaye());
			calstmt.setFloat(4,f.getMontantVerser());
			calstmt.setFloat(5,f.getReste());
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			calstmt.setDate(6,date);
			calstmt.setString(7,f.getEtat());
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	@Override
	public ResultSet rechercher(int id) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call rechercher_facture(?)}");
			calstmt.setInt(1, id);
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
		
	}
	@Override
	public ResultSet afficher() {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call afficher_facture}");
			res = calstmt.executeQuery();
			
		}catch(SQLException e) {}
		return res;
	}
	@Override
	public int modifier(Facture f) {
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call modifier_facture(?,?,?,?,?)}");
			calstmt.setInt(1,f.getIdfacture());
			calstmt.setFloat(2, f.getMontantpaye());
			calstmt.setFloat(3, f.getMontantVerser());
			calstmt.setFloat(4, f.getReste());
			calstmt.setString(5, f.getEtat());
			int a = calstmt.executeUpdate();
			return a ;
			
		}catch(SQLException e)
		{}
		
		return 0;
	}
	public float select_montant(int id)
	{
		try
		{
			CallableStatement calstmt = con.prepareCall("{ call montant(?)}");
			calstmt.setInt(1,id);
			res = calstmt.executeQuery();
			res.next();
			return res.getFloat(1);
			
		}catch(SQLException e)
		{}
		
		return 0;
	}


}
