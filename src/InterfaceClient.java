import java.sql.ResultSet;

public interface InterfaceClient {

	int ajouterClient(client c);
	ResultSet rechercherParId(int id);
	ResultSet Afficher();
	int modifierClient(client c);
	int deleteClient(int id);
	int deleteClientCommande(int id);
	int incr_client();
	ResultSet select_client();
}
