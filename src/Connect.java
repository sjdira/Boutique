import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connect {
	
	static String url = "jdbc:sqlserver://ServerName;databaseName=boutique";	//Il faut remplir "ServerName" avec le nom de serveur de votre SQLServer 2014
    static String user = "sa";
    static String key = "Password";		//Il faut remplir 'key' avec le mot de passe de votre SQLServer 2014

	private static Connection con ;
	
	static
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url,user,key);
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Remplir \"ServerName\" et \"Password\" de votre SQLServer en class 'Connect'");
		}
		
	}
	
	public static Connection getconnection()
	{
		return con ;
	}
}
