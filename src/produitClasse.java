public class produitClasse {

	private int code ;
	private String designation ;
	private String categorie ;
	private int Qte ;
	private float prix ;
	private float tva ;
	public produitClasse(int code, String designation, String categorie, int qte, float prix, float tva) 
	
	{
		super();
		this.code = code;
		this.designation = designation;
		this.categorie = categorie;
		Qte = qte;
		this.prix = prix;
		this.tva = tva;
	}
	public int getCode() {
		return code;
	}
	public String getDesignation() {
		return designation;
	}
	public String getCategorie() {
		return categorie;
	}
	public int getQte() {
		return Qte;
	}
	public float getPrix() {
		return prix;
	}
	public float getTva() {
		return tva;
	}
	
	
}
