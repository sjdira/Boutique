import java.sql.ResultSet;

public interface interfaceFacture {

	int ajouter_Facture(Facture f );
	ResultSet rechercher(int id);
	ResultSet afficher();
	int modifier(Facture f);
	float select_montant(int id);
}
