import java.sql.ResultSet;

public interface interfaceCmd {

	int ajouterCmd(commande c);
	float selectPrix(int id);
	ResultSet rechercherCMD(int id);
	ResultSet afficher();
	int modifier_cmd(commande c);
	int supprimer_cmd(int id);
	int select_qte(int id);
	
}
