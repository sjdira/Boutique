import java.sql.*;
public class commande {

	private int idCommande ;
	private int idclient ;
	private int idproduit;
	private int quantite ;
	private float prix_Total;
	private Date Date;

	public commande(int idCommande, int idclient, int idproduit, int quantite)
	{
		super();
		this.idCommande = idCommande;
		this.idclient = idclient;
		this.idproduit = idproduit;
		this.quantite = quantite;
	}

	public commande(int idCommande, int idclient, int idproduit, int quantite, float prix_Total)
	{
		super();
		this.idCommande = idCommande;
		this.idclient = idclient;
		this.idproduit = idproduit;
		this.quantite = quantite;
		this.prix_Total=prix_Total;
	}

	public float getPrix_Total() {
		return prix_Total;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public int getIdclient() {
		return idclient;
	}

	public int getIdproduit() {
		return idproduit;
	}

	public int getQuantite() {
		return quantite;
	}


	public Date getDate() {
		return Date;
	}
		
}