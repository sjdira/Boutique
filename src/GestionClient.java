import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

public class GestionClient extends JFrame {

	ResultSet res = null ;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionClient frame = new GestionClient();
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Gestion Client");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionClient() {
		
		setBackground(new Color(51, 204, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 672);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Identifiant = new JLabel("Identifiant");
		Identifiant.setBackground(new Color(255, 0, 0));
		Identifiant.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		Identifiant.setFont(new Font("Arial", Font.BOLD, 17));
		Identifiant.setBounds(10, 14, 140, 43);
		contentPane.add(Identifiant);
		
		JLabel nom = new JLabel("Nom");
		nom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nom.setBackground(new Color(255, 0, 0));
		nom.setFont(new Font("Arial", Font.BOLD, 17));
		nom.setBounds(10, 83, 156, 43);
		
		contentPane.add(nom);
		
		
		JLabel Prenom = new JLabel("Prenom");
		Prenom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		Prenom.setBackground(new Color(255, 0, 0));
		Prenom.setFont(new Font("Arial", Font.BOLD, 17));
		Prenom.setBounds(10, 145, 156, 43);
		contentPane.add(Prenom);
		
		JLabel Adresse = new JLabel("Adresse ");
		Adresse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		Adresse.setBackground(new Color(255, 0, 0));
		Adresse.setFont(new Font("Arial", Font.BOLD, 17));
		Adresse.setBounds(439, 11, 156, 49);
		contentPane.add(Adresse);
		
		JLabel Postal = new JLabel("Code Postal");
		Postal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		Postal.setBackground(new Color(255, 0, 0));
		Postal.setFont(new Font("Arial", Font.BOLD, 17));
		Postal.setBounds(439, 83, 156, 43);
		contentPane.add(Postal);
		
		JLabel ville = new JLabel("Ville");
		ville.setBackground(new Color(255, 0, 0));
		ville.setFont(new Font("Arial", Font.BOLD, 17));
		ville.setBounds(439, 145, 156, 43);
		contentPane.add(ville);
		
		JTextField textField = new JTextField();
		textField.setBounds(197, 16, 173, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(197, 85, 173, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 147, 173, 43);
		contentPane.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(636, 16, 173, 43);
		contentPane.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(636, 85, 173, 43);
		contentPane.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(636, 147, 173, 43);
		contentPane.add(textField_5);
		
		JLabel typedoc = new JLabel("Rechercher Par");
		typedoc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		typedoc.setFont(new Font("Arial Black", Font.BOLD, 17));
		typedoc.setBounds(32, 535, 181, 43);
		contentPane.add(typedoc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		comboBox.setBackground(new Color(255, 255, 240));
		comboBox.setBounds(234, 548, 125, 20);
		comboBox.addItem("Identifiant");
		comboBox.addItem("afficher tous");
		contentPane.add(comboBox);
		
		JTextField textField_6 = new JTextField();
		textField_6.setBounds(32, 589, 145, 33);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton Recherche = new JButton("Rechercher");
		Recherche.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		Recherche.setBackground(new Color(255, 255, 240));
		Recherche.setBounds(234, 588, 125, 34);
		contentPane.add(Recherche);
		
		String[] colonne = {};
		String[][] data = {};
		JTable table = new JTable(data , colonne);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(42, 261, 836, 276);
		contentPane.add(scrollPane);
		
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBackground(new Color(255, 255, 240));
		ajouter.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		ajouter.setBounds(112, 217, 119, 33);
		contentPane.add(ajouter);
		ajouter.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		
		JButton modifier = new JButton("Modifier");
		modifier.setBackground(new Color(255, 255, 240));
		modifier.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		modifier.setBounds(403, 217, 119, 33);
		contentPane.add(modifier);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setBackground(new Color(255, 255, 240));
		supprimer.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		supprimer.setBounds(688, 217, 120, 33);
		contentPane.add(supprimer);
		
		JButton retour = new JButton("Retour");
		retour.setBounds(811, 577, 81, 33);
		contentPane.add(retour);
		retour.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		retour.setBackground(new Color(255, 255, 240));
		retour.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		
		retour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {


					lesGestions.main(new String[]{});   
					dispose();
					
				}
			});
		
		supprimer.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
				
				String IDS = textField.getText();
				int IDus = Integer.parseInt(IDS);
				
				int c = JOptionPane.showConfirmDialog(null,"supprimer le client va supprimer tous les commandes ");
				if(c==JOptionPane.OK_OPTION)
				{
					int b = new ServiceClient().deleteClientCommande(IDus);
					int a = new ServiceClient().deleteClient(IDus);
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
				else
				{}

                  }
                  });
		
		
		modifier.addActionListener(new ActionListener() 
		
		{
				
				
				public void actionPerformed(ActionEvent arg0) {
					
					      String ids = textField.getText();
					      int IDus = Integer.parseInt(ids);
					      client c = new client(IDus, textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
		          	  int a = new ServiceClient().modifierClient(c);
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
			}); 
		
		
		
		ajouter.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				String IDS = textField.getText();
                int ID = Integer.parseInt(IDS);
                
                if(textField_1.getText().equals("") || textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals(""))
                {
               	 JOptionPane.showMessageDialog(null, " entrer toutes les informations ");
                }
                
                else
                {
                	client c = new client(ID, textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
                    int a = new ServiceClient().ajouterClient(c);
                    if(a == 1)
                    {
                    	 textField.setText("");
	   					 textField_1.setText("");
		       		     textField_2.setText("");
		       		     textField_3.setText("");
		       		     textField_4.setText("");
		       		     textField_5.setText("");
                    	JOptionPane.showMessageDialog(null, "bien ajouter");
                    }
                	
                }	
			}
		});
		
		Recherche.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().equals("Identifiant"))
				   {
					if(textField_6.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Entrer l'Identifiant svp");
					}
					else
					{
						String IDS = textField_6.getText();
				           int id = Integer.parseInt(IDS);
				           res = new ServiceClient().rechercherParId(id);
				           table.setModel(DbUtils.resultSetToTableModel(res));
				           textField_6.setText("");
					}    
				   }
				   else if(comboBox.getSelectedItem().equals("afficher tous"))
				   {
					   res = new ServiceClient().Afficher();
			           table.setModel(DbUtils.resultSetToTableModel(res));
				   }
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
  		   public void mouseClicked(MouseEvent e) {

                   int ligne = table.getSelectedRow();
                   int id = (int) table.getModel().getValueAt(ligne, 0);
                   String ids =Integer.toString(id);
                   String nom = (String) table.getModel().getValueAt(ligne, 1);
                   String prenom = (String) table.getModel().getValueAt(ligne, 2);
                   String adresse = (String) table.getModel().getValueAt(ligne, 3);
                   String code = (String) table.getModel().getValueAt(ligne, 4);
                   String ville  = (String) table.getModel().getValueAt(ligne, 5);
                   textField.setText(ids);
                   textField_1.setText(nom);
                   textField_2.setText(prenom);
                   textField_3.setText(adresse);
                   textField_4.setText(code);
                   textField_5.setText(ville);
                   
  				
  			}
  	});
		
				
	}

}
