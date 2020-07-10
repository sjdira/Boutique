import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class lesGestions extends JFrame {
	private Image client = new ImageIcon(lesGestions.class.getResource("/test/client.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	private Image facture = new ImageIcon(lesGestions.class.getResource("/test/facture.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	private Image produit = new ImageIcon(lesGestions.class.getResource("/test/warehouse-stock-pngrepo-com.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	private Image commande = new ImageIcon(lesGestions.class.getResource("/test/cmd.jpg")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	private Image stat = new ImageIcon(lesGestions.class.getResource("/test/stock-exchange-icon-png-28.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	private Image retour = new ImageIcon(lesGestions.class.getResource("/test/rtr.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lesGestions frame = new lesGestions();
					frame.setVisible(true);
					frame.setTitle("Admin Section");
					frame.setLocationRelativeTo(null);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public lesGestions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 166, 178, 122);
		lblNewLabel.setIcon(new ImageIcon(client));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 178, 122);
		lblNewLabel_1.setIcon(new ImageIcon(produit));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(339, 0, 178, 122);
		lblNewLabel_2.setIcon(new ImageIcon(facture));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(339, 154, 178, 122);
		lblNewLabel_3.setIcon(new ImageIcon(commande));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Les produits");
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(39, 121, 86, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Les factures");
		lblNewLabel_4_1.setBackground(Color.GRAY);
		lblNewLabel_4_1.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4_1.setBounds(381, 121, 86, 22);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Les clients");
		lblNewLabel_4_2.setBackground(Color.GRAY);
		lblNewLabel_4_2.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4_2.setBounds(39, 279, 86, 22);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Les commandes\r\n");
		lblNewLabel_4_3.setBackground(Color.GRAY);
		lblNewLabel_4_3.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4_3.setBounds(370, 279, 123, 22);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(168, 76, 178, 113);
		lblNewLabel_5.setIcon(new ImageIcon(stat));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Statistique");
		lblNewLabel_6.setBackground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(203, 187, 130, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(223, 244, 86, 54);
		lblNewLabel_7.setIcon(new ImageIcon(retour));
		contentPane.add(lblNewLabel_7);
		
    	lblNewLabel.addMouseListener(new MouseAdapter() 
    	
    	{
		
		public void mouseClicked(MouseEvent arg0) {
			try
			{
				GestionClient.main(new String[]{});
				
				dispose();
			}catch(Exception e) {}
			
		}

		public void mouseEntered(MouseEvent e) 
		{
			lblNewLabel.setBackground(new Color(30,60,60));
		}
		
		public void mouseExited(MouseEvent e) {
			lblNewLabel.setBackground(new Color(47,79,79));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			lblNewLabel.setBackground(new Color(60,80,80));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			lblNewLabel.setBackground(new Color(70,80,80));
		}
	});
    	
    	lblNewLabel_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					Gestion_Produit.main(new String[]{});
					dispose();
				}catch(Exception e) {}
				
			}

			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setBackground(new Color(70,80,80));
			}
		});
    	lblNewLabel_3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					Gestion_Commande.main(new String[]{});
					
					dispose();
				}catch(Exception e) {}
				
			}

			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setBackground(new Color(70,80,80));
			}
		});
    	lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					GestionFacture.main(new String[]{});
					
					dispose();
				}   catch(Exception e) {}
				
			}

			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setBackground(new Color(70,80,80));
			}
		});
    	lblNewLabel_5.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					Statistique_Produit.main(new String[]{});
					
				}   catch(Exception e) {}
				
			}

			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setBackground(new Color(70,80,80));
			}
		});
    	lblNewLabel_7.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					admin.main(new String[]{});
					
					dispose();
				}catch(Exception e) {}
				
			}

			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setBackground(new Color(70,80,80));
			}
		});
	}
}
