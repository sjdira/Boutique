import java.sql.*;
public class Facture {

	private int idfacture ;
	private int idclient ;
	private float montantpaye ;
	private float montantVerser ;
	private float reste ;
	private Date date ;
	private String etat ;
	
	public Facture(int idfacture, int idclient, float montantpaye, float montantVerser, float reste, String etat) 
	{
		super();
		this.idfacture = idfacture;
		this.idclient = idclient;
		this.montantpaye = montantpaye;
		this.montantVerser = montantVerser;
		this.reste = reste;
		this.etat = etat;
	}
	
	public Facture(int idfacture, float montantpaye, float montantVerser, float reste, String etat) 
	{
		super();
		this.idfacture = idfacture;
		this.montantpaye = montantpaye;
		this.montantVerser = montantVerser;
		this.reste = reste;
		this.etat = etat;
	}

	
	public int getIdfacture() {
		return idfacture;
	}
	
	public int getIdclient() {
		return idclient;
	}
	
	public float getMontantpaye() {
		return montantpaye;
	}
	
	public float getMontantVerser() {
		return montantVerser;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getEtat() {
		return etat;
	}
	
	public float getReste() {
		return reste;
	}
	
}