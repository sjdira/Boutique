import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Gestion_Produit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField ID_Recherche;

	ResultSet res = null ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Produit frame = new Gestion_Produit();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
					frame.setTitle("Gestion Produits");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gestion_Produit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 629);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(8, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IDPROD = new JLabel("Identifiant ");
		IDPROD.setBackground(new Color(255, 0, 0));
		IDPROD.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		IDPROD.setBounds(20, 11, 115, 43);
		contentPane.add(IDPROD);
		
		JLabel designation = new JLabel("Designation");
		designation.setBackground(new Color(255, 0, 0));
		designation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		designation.setBounds(20, 69, 115, 43);
		contentPane.add(designation);
		
		JLabel categorie = new JLabel("Categorie");
		categorie.setBackground(new Color(255, 0, 0));
		categorie.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		categorie.setBounds(20, 124, 115, 43);
		contentPane.add(categorie);
		
		textField = new JTextField();
		textField.setBounds(145, 11, 152, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 69, 152, 43);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 124, 152, 43);
		contentPane.add(textField_2);
		
		JLabel QTE = new JLabel("Quantite ");
		QTE.setBackground(new Color(255, 0, 0));
		QTE.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		QTE.setBounds(380, 11, 115, 43);
		contentPane.add(QTE);
		
		JLabel prix = new JLabel("Prix Unitaire");
		prix.setBackground(new Color(255, 0, 0));
		prix.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		prix.setBounds(380, 69, 115, 43);
		contentPane.add(prix);
		
		JLabel tva = new JLabel("T V A");
		tva.setBackground(new Color(255, 0, 0));
		tva.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		tva.setBounds(380, 124, 115, 43);
		contentPane.add(tva);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(544, 12, 152, 43);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(544, 70, 152, 43);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(544, 125, 152, 43);
		contentPane.add(textField_5);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(56, 188, 676, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBounds(26, 11, 154, 32);
		ajouter.setBackground(new Color(255, 255, 240));
		panel.add(ajouter);
		
		JButton modifer = new JButton("Modifer");
		modifer.setBounds(258, 11, 154, 32);
		modifer.setBackground(new Color(255, 255, 240));
		panel.add(modifer);
		
		JButton supp = new JButton("Supprimer");
		supp.setBounds(522, 11, 154, 32);
		supp.setBackground(new Color(255, 255, 240));
		panel.add(supp);
		
		String[] colonne = {};
		String[][] data = {};
		JTable table = new JTable(data , colonne);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 242, 757, 240);
		contentPane.add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		comboBox.setBackground(new Color(255, 255, 240));
		comboBox.setBounds(178, 493, 127, 28);
		comboBox.addItem("Code Produit");
		comboBox.addItem("afficher tous");
		contentPane.add(comboBox);
		
		ID_Recherche = new JTextField();
		ID_Recherche.setBounds(20, 549, 115, 28);
		contentPane.add(ID_Recherche);
		ID_Recherche.setColumns(10);
		
		JButton recherche = new JButton("Rechercher");
		recherche.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		recherche.setBackground(new Color(255, 255, 240));
		recherche.setFont(new Font("Arial", Font.BOLD, 13));
		recherche.setBounds(183, 548, 122, 28);
		contentPane.add(recherche);
		
		JButton Retour = new JButton("Retour");
		Retour.setBounds(695, 561, 79, 33);
		Retour.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		Retour.setBackground(new Color(255, 255, 240));
		Retour.setBounds(695, 549, 99, 28);
		contentPane.add(Retour);
		
		JLabel rechercherPar = new JLabel("Rechercher Par");
		rechercherPar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rechercherPar.setBounds(30, 493, 127, 28);
		contentPane.add(rechercherPar);
		
		Retour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lesGestions.main(new String[]{});   
				dispose();
				
			}
		});
		
        ajouter.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				String IDS = textField.getText();
                int ID = Integer.parseInt(IDS);
                int Qte = Integer.parseInt(textField_3.getText());
                float prix = Float.parseFloat(textField_4.getText());
                float tva = Float.parseFloat(textField_5.getText());   
                //float tvaa = (float) (Math.round(tva * 100.0) / 100.0) ;
                
                if(textField_1.getText().equals("") || textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals(""))
                {
               	 JOptionPane.showMessageDialog(null, " entrer toutes les informations ");
                }
                else if(Qte <= 0 || prix <=0 || tva <= 0 || tva >= 1)
                {
                	 JOptionPane.showMessageDialog(null, " les informations et incorrect  ");
                }
                	
                
                else
                {
                	
                	produitClasse p = new produitClasse(ID, textField_1.getText(), textField_2.getText(),Qte,prix,tva);
                    int a = new serviceProduit().ajouterProduit(p);
                    if(a == 1)
                    {
                    	JOptionPane.showMessageDialog(null, "bien ajouter");
                    	 textField.setText("");
                         textField_1.setText("");
                         textField_2.setText("");
                         textField_3.setText("");
                         textField_4.setText("");
                         textField_5.setText("");
                    }
                	
                }	
			}
		});
        
         recherche.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().equals("Code Produit"))
				   {
					   if(ID_Recherche.getText().equals(""))
					   {
						   JOptionPane.showMessageDialog(null, "Enter l'identifiant svp");
					   }
					   else
					   {
						   String IDS = ID_Recherche.getText();
				           int id = Integer.parseInt(IDS);
				           res = new serviceProduit().rechercher(id);
				           table.setModel(DbUtils.resultSetToTableModel(res));
				           ID_Recherche.setText(""); 
					   }
					   
			           
			           
				   }
				   else if(comboBox.getSelectedItem().equals("afficher tous"))
				   {
					   res = new serviceProduit().afficher();
			           table.setModel(DbUtils.resultSetToTableModel(res));
				   }
			}
		});
        
        
        
        table.addMouseListener(new MouseAdapter() {
   		   public void mouseClicked(MouseEvent e) {

                    int ligne = table.getSelectedRow();
                    int id = (int) table.getModel().getValueAt(ligne, 0);
                    String code =Integer.toString(id);
                    String designation = (String) table.getModel().getValueAt(ligne, 1);
                    String categorie = (String) table.getModel().getValueAt(ligne, 2);
                    int qte = (int) table.getModel().getValueAt(ligne, 3);
                    String qtes =Integer.toString(qte);
                    double prix = (double) table.getModel().getValueAt(ligne, 4);
                    String prixs = Double.toString(prix); 
                    double tva  = (double) table.getModel().getValueAt(ligne, 5);
                    String tvas = Double.toString(tva);
                    textField.setText(code);
                    textField_1.setText(designation);
                    textField_2.setText(categorie);
                    textField_3.setText(qtes);
                    textField_4.setText(prixs);
                    textField_5.setText(tvas);
                    
   				
   			}
   	});
        
        modifer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				      String ids = textField.getText();
				      int IDp = Integer.parseInt(ids);
				      int Qte = Integer.parseInt(textField_3.getText());
		              float prix = Float.parseFloat(textField_4.getText());
		              float tva = Float.parseFloat(textField_5.getText());
				      
		              if(Qte < 0 || prix <=0 || tva <0 || tva >1)
		              {
		            	  JOptionPane.showMessageDialog(null, " les informations et incorrect  ");
		              }
		              else
		              {
		            	  produitClasse p = new produitClasse(IDp, textField_1.getText(), textField_2.getText(),Qte,prix, tva);
			           	  int a = new serviceProduit().modifierProduit(p);
			           	  if(a==1)
			           	  {
			           		     JOptionPane.showMessageDialog(null,"bien modifier");
			           		     textField.setText("");
			           		     textField_1.setText("");
			           		     textField_2.setText("");
			           		     textField_3.setText("");
			           		     textField_4.setText("");
			           		     textField_5.setText("");
			           	  }
			           	  else
			           	  {
			           		  JOptionPane.showMessageDialog(null,"ne pas modifier");
			           	  }
		              }      
			}
		}); 
        
        supp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			String IDS = textField.getText();
			int IDp = Integer.parseInt(IDS);
			int c = JOptionPane.showConfirmDialog(null, "delete le produit va supprimer les commandes");
			if(c==JOptionPane.OK_OPTION)
			{
				int b = new serviceProduit().deleteProduitCommande(IDp);
				int a = new serviceProduit().deleteProduit(IDp);
				if(a==1)
				{
				
					JOptionPane.showMessageDialog(null, "bien supprimer");
				
				 textField.setText("");
	   		     textField_1.setText("");
	   		     textField_2.setText("");
	   		     textField_3.setText("");
	   		     textField_4.setText("");
	   		     textField_5.setText("");
				}
				else
				{
				JOptionPane.showMessageDialog(null, "ne pas supprimer");
				} 
			}
			
			
			


}
});
        
		
		
	}
}
