import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;

public class admin extends JFrame {
	
	private Image img_utili = new ImageIcon(admin.class.getResource("/test/user.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	private Image img_key = new ImageIcon(admin.class.getResource("/test/key (2).png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_LOGIN = new ImageIcon(admin.class.getResource("/test/passwd.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_LOGO = new ImageIcon(admin.class.getResource("/test/btq.png")).getImage().getScaledInstance(100, 110, Image.SCALE_SMOOTH);
	private Image boutique = new ImageIcon(admin.class.getResource("/test/boutiqueimage.jpg")).getImage().getScaledInstance(472, 403, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField utilisateur;
	private JPasswordField code;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Admin Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public admin()
	
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 403);   
		
        contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setBackground(new Color(211, 211, 211));
   		setContentPane(contentPane);
   		contentPane.setLayout(null);
   		
   		JPanel panel = new JPanel();
   		panel.setBounds(38, 95, 378, 76);
   		panel.setBackground(new Color(211, 211, 211));
   		contentPane.add(panel);
   		panel.setLayout(null);
   		
   		utilisateur = new JTextField();
   		utilisateur.setHorizontalAlignment(SwingConstants.CENTER);
   		utilisateur.setFont(new Font("Century", Font.PLAIN, 15));
   		utilisateur.setBounds(27, 11, 273, 54);
   		panel.add(utilisateur);
   		utilisateur.setColumns(10);
   		
   		JLabel lblNewLabel_2 = new JLabel("");
   		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
   		lblNewLabel_2.setBounds(310, 11, 58, 54);
   		lblNewLabel_2.setIcon(new ImageIcon(img_utili));
   		panel.add(lblNewLabel_2);
   		
   		JPanel panel_1 = new JPanel();
   		panel_1.setBounds(38, 169, 378, 76);
   		panel_1.setBackground(new Color(211, 211, 211));
   		contentPane.add(panel_1);
   		panel_1.setLayout(null);
   		
   		JLabel passwd = new JLabel("");
   		passwd.setHorizontalAlignment(SwingConstants.CENTER);
   		passwd.setBounds(309, 11, 59, 54);
   		passwd.setIcon(new ImageIcon(img_LOGIN));
   		panel_1.add(passwd);
   		
   		code = new JPasswordField();
   		code.setHorizontalAlignment(SwingConstants.CENTER);
   		code.setBounds(28, 11, 271, 54);
   		panel_1.add(code);
   		
   		JLabel reponse = new JLabel("");
   		reponse.setHorizontalAlignment(SwingConstants.CENTER);
   		reponse.setBounds(61, 243, 310, 28);
   		contentPane.add(reponse);
   		
   		JLabel login = new JLabel("LOG IN");
   		login.setBackground(Color.GRAY);
   		login.setFont(new Font("Century", Font.PLAIN, 18));
   		login.setHorizontalAlignment(SwingConstants.CENTER);
   		
   		login.addMouseListener(new MouseAdapter() 
   		{
			
			public void mouseClicked(MouseEvent arg0) {
				
				if(utilisateur.getText().equals("admin") && code.getText().equals("admin123"))
				{
					lesGestions.main(new String[]{});
					dispose();
				}
				else if(utilisateur.getText().equals("") || code.getText().equals(""))
				{
					
					reponse.setText("svp entrer tous les champs");
				}
				else
				{
					reponse.setText("Utilisateur ou mot de passe incorrect");
				}
			}

			public void mouseEntered(MouseEvent e) {
				login.setBackground(new Color(30,60,60));
			}
			
			public void mouseExited(MouseEvent e) {
				login.setBackground(new Color(47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				login.setBackground(new Color(60,80,80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				login.setBackground(new Color(70,80,80));
			}
		});
   		
   		login.setBounds(25, 271, 378, 58);
   		contentPane.add(login);
   		
   		JLabel btq = new JLabel("");
   		btq.setBounds(162, 11, 209, 82);
   		btq.setIcon(new ImageIcon(img_LOGO));
   		contentPane.add(btq);
   		
   		JLabel lblNewLabel_3 = new JLabel("");
   		lblNewLabel_3.setBounds(114, 271, 64, 58);
   		lblNewLabel_3.setIcon(new ImageIcon(img_key));
   		contentPane.add(lblNewLabel_3);

	}
}