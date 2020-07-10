import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Gestion_Commande extends JFrame {

	private ResultSet res = null ;
	private ResultSet res1 = null ;
	private JPanel contentPane;
	private JTextField commande;
	private JTextField quantite;
	private JTextField idrecherche;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Commande frame = new Gestion_Commande();
					frame.setVisible(true);
					frame.setTitle("Gestion Commande");
					frame.setLocationRelativeTo(null);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Gestion_Commande() 
	
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(211, 211, 211));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idcommande = new JLabel("Identifiant Commande");
		idcommande.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		idcommande.setBounds(10, 11, 163, 28);
		contentPane.add(idcommande);
		
		JLabel idclient = new JLabel("Client");
		idclient.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		idclient.setBounds(10, 67, 148, 28);
		contentPane.add(idclient);
		
		commande = new JTextField();
		commande.setBounds(183, 13, 120, 28);
		contentPane.add(commande);
		commande.setColumns(10);
		
		JLabel idproduit = new JLabel("Produit");
		idproduit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		idproduit.setBounds(387, 11, 163, 28);
		contentPane.add(idproduit);
		
		JLabel qte = new JLabel("Quantite");
		qte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		qte.setBounds(387, 67, 148, 28);
		contentPane.add(qte);
		
		JLabel dispo = new JLabel("");
		dispo.setBounds(697, 67, 48, 28);
		contentPane.add(dispo);
		
		quantite= new JTextField();
		quantite.setColumns(10);
		quantite.setBounds(567, 69, 120, 28);
		contentPane.add(quantite);
		
		String[] colonne = {};
		String[][] data = {};
		JTable table = new JTable(data , colonne);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 157, 693, 224);
		contentPane.add(scrollPane);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBackground(new Color(255, 255, 240));
		ajouter.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		ajouter.setBounds(58, 118, 100, 28);
		contentPane.add(ajouter);
		
		JButton modifier = new JButton("Modifier");
		modifier.setBackground(new Color(255, 255, 240));
		modifier.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		modifier.setBounds(320, 118, 100, 28);
		contentPane.add(modifier);
		
		JLabel rechercherPar = new JLabel("Rechercher Par");
		rechercherPar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rechercherPar.setBounds(26, 392, 140, 28);
		contentPane.add(rechercherPar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		comboBox.setBackground(new Color(255, 255, 240));
		comboBox.addItem("Identifiant");
		comboBox.addItem("afficher tous");
		comboBox.setBounds(184, 396, 107, 24);
		contentPane.add(comboBox);
		
		idrecherche = new JTextField();
		idrecherche.setBounds(26, 431, 107, 26);
		contentPane.add(idrecherche);
		idrecherche.setColumns(10);
		
		JButton recherche = new JButton("Rechercher");
		recherche.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		recherche.setBackground(new Color(255, 255, 240));
		recherche.setBounds(184, 431, 107, 26);
		contentPane.add(recherche);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		retour.setBackground(new Color(255, 255, 240));
		retour.setBounds(635, 453, 89, 23);
		contentPane.add(retour);
		
		JButton annuler = new JButton("Annuler");
		annuler.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		annuler.setBackground(new Color(255, 255, 240));
		annuler.setBounds(595, 118, 100, 28);
		contentPane.add(annuler);
		
		JComboBox clt = new JComboBox();
		res = new ServiceClient().select_client();
		try {
			while(res.next())
			{		
				clt.addItem(Integer.toString(res.getInt(1)));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		clt.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		clt.setBackground(new Color(255, 255, 240));
		clt.setBounds(183, 67, 120, 28);
		contentPane.add(clt);
		
		JComboBox prd = new JComboBox();
		res1 = new serviceProduit().select_produit();
		try {
			while(res1.next())
			{
				
				prd.addItem(Integer.toString(res1.getInt(1)));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		prd.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		prd.setBackground(new Color(255, 255, 240));
		prd.setBounds(567, 11, 120, 28);
		contentPane.add(prd);
		
		
		retour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lesGestions.main(new String[]{});   
				dispose();
				
			}
		});
	
        ajouter.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
		       int idcomm = Integer.parseInt(commande.getText());
		       int idclient = Integer.parseInt((String) clt.getSelectedItem());
               int idproduit = Integer.parseInt((String) prd.getSelectedItem());
               int Qte = Integer.parseInt(quantite.getText());
               float prix = new serviceCmd().selectPrix(idproduit);
               float tva = new serviceProduit().select_tva(idproduit);
               float total_prix =( Qte*prix) + (Qte*prix*tva) ;
               int qt = new serviceCmd().select_qte(idproduit);
               
               
               
               if(((String) clt.getSelectedItem()).equals("")||((String) prd.getSelectedItem()).equals("")||quantite.getText().equals(""))
               {
              	 JOptionPane.showMessageDialog(null, " entrer toutes les informations ");
               }
               else if(Qte <= 0 || Qte > qt )
               {
            	   JOptionPane.showMessageDialog(null, " les informations et incorrect  ");
               }
               
               else
               {
            	   commande c = new commande(idcomm, idclient, idproduit, Qte, total_prix);
            	   int a = new serviceCmd().ajouterCmd(c);
                   if(a == 1)
                   {
                   	int b = new serviceProduit().demunue_qte_prd(idproduit, Qte);
                   	JOptionPane.showMessageDialog(null, "bien ajouter");
                   }
               }
               
			}
		});
      recherche.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(comboBox.getSelectedItem().equals("Identifiant"))
				   {
					if(idrecherche.getText().equals(""))
					   {
						   JOptionPane.showMessageDialog(null, "Enter l'identifiant svp");
					   }
					else
					{
						String IDS = idrecherche.getText();
				        int id = Integer.parseInt(IDS);
				        res = new serviceCmd().rechercherCMD(id);
				        table.setModel(DbUtils.resultSetToTableModel(res));
			            idrecherche.setText("");
					}   
				   }
				   else if(comboBox.getSelectedItem().equals("afficher tous"))
				   {
					   res = new serviceCmd().afficher();
			           table.setModel(DbUtils.resultSetToTableModel(res));
				   }
			}
		});
        table.addMouseListener(new MouseAdapter() {
   		   public void mouseClicked(MouseEvent e) {

                    int ligne = table.getSelectedRow();
                    int idcmd = (int) table.getModel().getValueAt(ligne, 0);
                    String idcmds =Integer.toString(idcmd);
                    int idclient = (int) table.getModel().getValueAt(ligne, 1);
                    String idclts =Integer.toString(idclient);
                    int idprd = (int) table.getModel().getValueAt(ligne, 2);
                    String idprds =Integer.toString(idprd);
                    int qtea = (int) table.getModel().getValueAt(ligne, 3);
                    String qtes =Integer.toString(qtea);
                    commande.setText(idcmds);
                    clt.setSelectedItem(idclts);
                    prd.setSelectedItem(idprds);
                    quantite.setText(qtes);  				
   			}
   	});
        
        modifier.addActionListener(new ActionListener() {
    		
    		
    		public void actionPerformed(ActionEvent arg0) {
    			
    			int idcomm = Integer.parseInt(commande.getText());
 		        int idclient = Integer.parseInt((String) clt.getSelectedItem());
                int idproduit = Integer.parseInt((String) prd.getSelectedItem());
                int Qte = Integer.parseInt(quantite.getText());
                float prix = new serviceCmd().selectPrix(idproduit);
                float tva = new serviceProduit().select_tva(idproduit);
                float total_prix =( Qte*prix) + (Qte*prix*tva) ;
    			      
    			      
    	          commande c = new commande(idcomm, idclient, idproduit, Qte,total_prix);    
               	  int a = new serviceCmd().modifier_cmd(c) ;          	  
               		if(a==1)
               	  {
               		     JOptionPane.showMessageDialog(null,"bien modifier");
               		     commande.setText("");
               		     quantite.setText("");
               	  }
               	  else
               	  {
               		  JOptionPane.showMessageDialog(null,"ne pas modifier");
               	  }
    		}
    	}); 
  
        
        annuler.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			String IDS = commande.getText();
			int IDus = Integer.parseInt(IDS);
			String produit =(String)prd.getSelectedItem();
			int prdt = Integer.parseInt(produit);
			String qte = quantite.getText();
			int ss = Integer.parseInt(qte);

			
			int a = new serviceCmd().annuler(IDus ,prdt);
			if(a==1)
			{
				int b = new serviceProduit().augmt_qte_prd(prdt, ss);
				int c = new serviceProduit().modifierProduit_stat2(prdt, ss);
				JOptionPane.showMessageDialog(null, "Commande Annuler");
				
			}
			else if(a==0)
			{
				JOptionPane.showMessageDialog(null, "Commande ne pas Annuler");
			}
		
}
});
        
            qte.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					int produit =  Integer.parseInt((String)prd.getSelectedItem());    
					int qt = new serviceCmd().select_qte(produit);
					dispo.setText(Integer.toString(qt));
					
					
				}catch(Exception e) {}
				
			}

			public void mouseEntered(MouseEvent e) {
				qte.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				qte.setBackground(new Color(47,79,79));
			}
			public void mousePressed(MouseEvent e) {
				qte.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				qte.setBackground(new Color(70,80,80));
			}
		});
	}
}
