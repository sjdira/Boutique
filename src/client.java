public class client {

	private int IdClient; 
	private String NomClient ;
	private String PrenomClient ;
	private String AdresseClient ;
	private String CodePostalClient ;
	private String VilleClient ;
	
	
	public client(int idClient, String nomClient, String prenomClient, String adresseClient, String codePostalClient,String villeClient) {
		super();
		IdClient = idClient;
		NomClient = nomClient;
		PrenomClient = prenomClient;
		AdresseClient = adresseClient;
		CodePostalClient = codePostalClient;
		VilleClient = villeClient;
	}
	
	
	
	public int getIdClient() {
		return IdClient;
	}


	public String getNomClient() {
		return NomClient;
	}


	public String getPrenomClient() {
		return PrenomClient;
	}


	public String getAdresseClient() {
		return AdresseClient;
	}


	public String getCodePostalClient() {
		return CodePostalClient;
	}


	public String getVilleClient() {
		return VilleClient;
	}

}