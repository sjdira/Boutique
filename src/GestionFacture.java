import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.proteanit.sql.DbUtils;

public class GestionFacture extends JFrame {

	private Image calcu = new ImageIcon(lesGestions.class.getResource("/test/calcul.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ResultSet res = null ;
	private Image stat = new ImageIcon(GestionFacture.class.getResource("/test/btq.jpg")).getImage().getScaledInstance(747, 491, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField idfc;
	private JTextField mntPaye;
	private JTextField verser;
	private JTextField textField;
	private JTextField ett;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFacture frame = new GestionFacture();
					frame.setVisible(true);
					frame.setTitle("Gestion Facture");
					frame.setLocationRelativeTo(null);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionFacture() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idf = new JLabel("Identifiant");
		idf.setBackground(new Color(255, 0, 0));
		idf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		idf.setBounds(10, 11, 134, 30);
		contentPane.add(idf);
		
		JLabel idclt = new JLabel("Client");
		idclt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		idclt.setBounds(10, 66, 134, 30);
		contentPane.add(idclt);
		
		JLabel lblMontantOaye = new JLabel("Montant paye");
		lblMontantOaye.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblMontantOaye.setBounds(10, 119, 134, 30);
		contentPane.add(lblMontantOaye);
		
		JLabel lblNewLabel_2_1 = new JLabel("montant verser");
		lblNewLabel_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(347, 11, 134, 30);
		contentPane.add(lblNewLabel_2_1);
		
		idfc = new JTextField();
		idfc.setBounds(154, 15, 106, 27);
		contentPane.add(idfc);
		idfc.setColumns(10);
		
		mntPaye = new JTextField();
		mntPaye.setColumns(10);
		mntPaye.setBounds(154, 123, 106, 27);
		contentPane.add(mntPaye);
		
		verser = new JTextField();
		verser.setColumns(10);
		verser.setBounds(544, 15, 106, 27);
		contentPane.add(verser);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBackground(new Color(255, 255, 240));
		ajouter.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		ajouter.setBounds(373, 168, 108, 30);
		contentPane.add(ajouter);
		
		JButton modifier = new JButton("Modifier");
		modifier.setBackground(new Color(255, 255, 240));
		modifier.setBounds(542, 168, 108, 30);
		contentPane.add(modifier);
		
		
		String[] colonne = {};
		String[][] data = {};
		JTable table = new JTable(data , colonne);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(37, 209, 613, 196);
		contentPane.add(scrollPane);
		
		JLabel recherchePar = new JLabel("Rechercher Par");
		recherchePar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		recherchePar.setBounds(36, 416, 134, 30);
		contentPane.add(recherchePar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		comboBox.setBackground(new Color(255, 255, 240));
		comboBox.setBounds(191, 423, 106, 20);
		comboBox.addItem("Identifiant");
		comboBox.addItem("afficher tous");
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(37, 469, 122, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton recherche = new JButton("Rechercher");
		recherche.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		recherche.setBackground(new Color(255, 255, 240));
		recherche.setBounds(191, 469, 106, 23);
		contentPane.add(recherche);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		retour.setBackground(new Color(255, 255, 240));
		retour.setBounds(559, 469, 91, 23);
		contentPane.add(retour);
		
		JButton impr = new JButton("Imprimer");
		impr.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 13));
		impr.setBackground(new Color(255, 255, 240));
		impr.setBounds(457, 469, 91, 23);
		contentPane.add(impr);
		
		JLabel etat = new JLabel("état");
		etat.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		etat.setBounds(350, 66, 142, 30);
		contentPane.add(etat);
		
		ett = new JTextField();
		ett.setColumns(10);
		ett.setBounds(544, 70, 106, 27);
		contentPane.add(ett);
		
		JLabel clc = new JLabel("");
		clc.setIcon(new ImageIcon(calcu));
		clc.setBounds(270, 109, 50, 55);
		contentPane.add(clc);
		
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
		clt.setBounds(156, 66, 104, 30);
		contentPane.add(clt);
		
		
        retour.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lesGestions.main(new String[]{});   
				dispose();
				
			}
		});

		  
        
        ajouter.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent arg0) {
					
					String IDS = idfc.getText();
	                int ID = Integer.parseInt(IDS);
	                int idclient = Integer.parseInt((String)clt.getSelectedItem());
	                float mntp = Float.parseFloat(mntPaye.getText());
	                float mntv = Float.parseFloat(verser.getText());
	                float reste = mntp-mntv;
	                String et = ett.getText();
	                
	                
	                if(((String)clt.getSelectedItem()).equals("") || mntPaye.getText().equals("")||verser.getText().equals("")||ett.getText().equals(""))
	                {
	               	 JOptionPane.showMessageDialog(null, " entrer toutes les informations ");
	                }
	                
	                else
	                {
	                	Facture f = new Facture(ID, idclient, mntp, mntv,reste, et);
	                    int a = new serviceFacture().ajouter_Facture(f);
	                    if(a == 1)
	                    {
	                  
	                    	int b = new serviceCmd().supprimer_cmd(idclient);
	                    	JOptionPane.showMessageDialog(null, "bien ajouter");
	                    }
	                	
	                }	
				}
			});
        
        
		  recherche.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent arg0) {
					
					if(comboBox.getSelectedItem().equals("Identifiant"))
					   {
						
						if(textField.getText().equals(""))
						   {
							   JOptionPane.showMessageDialog(null, "Enter l'identifiant svp");
						   }
						else
						{
							 String IDS = textField.getText();
					         int id = Integer.parseInt(IDS);
					         res = new serviceFacture().rechercher(id);
					         table.setModel(DbUtils.resultSetToTableModel(res));
					         textField.setText("");
						}
						  
				           
				           
					   }
					   else if(comboBox.getSelectedItem().equals("afficher tous"))
					   {
						   res = new serviceFacture().afficher();
				           table.setModel(DbUtils.resultSetToTableModel(res));
					   }
				}
			});
		  
		  
			table.addMouseListener(new MouseAdapter() {
		  		   public void mouseClicked(MouseEvent e) {

		                   int ligne = table.getSelectedRow();
		                   int idfacture = (int) table.getModel().getValueAt(ligne, 0);
		                   String idcmds =Integer.toString(idfacture);
		                   int idclient = (int) table.getModel().getValueAt(ligne, 1);
		                   String idclts =Integer.toString(idclient);
		                   Double mntpy = (Double) table.getModel().getValueAt(ligne, 2);
		                   String mntpys = Double.toString(mntpy);
		                   Double mntv = (Double) table.getModel().getValueAt(ligne, 3);
		                   String mntvs = Double.toString(mntv);
		                   String etat = (String) table.getModel().getValueAt(ligne, 6);
		                   
		                   idfc.setText(idcmds);
		                   clt.setSelectedItem(idclts);
		                   mntPaye.setText(mntpys);
		                   verser.setText(mntvs);
		                   ett.setText(etat);		
		  			}
		  	});
		
			modifier.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent arg0) {
					
					      String IDfcts = idfc.getText();
					      int Ifacture = Integer.parseInt(IDfcts);
					      String mntpys = mntPaye.getText();
					      float montantpy = Float.parseFloat(mntpys);
					      String mntverse = verser.getText();
					      float montantver = Float.parseFloat(mntverse);
					      float rest = montantpy -montantver;
					      String etatf = ett.getText();
					      
					      
			          Facture f = new Facture(Ifacture, montantpy, montantver,rest, etatf)  ;
		           	  int a = new serviceFacture().modifier(f);        	  
		           		if(a==1)
		           	  {
		           		     JOptionPane.showMessageDialog(null,"bien modifier");
		           		     //ID.setText(new serviceUsagers().incrUsager());
		           		  idfc.setText("");
		           		  mntPaye.setText("");
		           		  verser.setText("");
		           		  ett.setText("");
		           	  }
		           	  else
		           	  {
		           		  JOptionPane.showMessageDialog(null,"ne pas modifier");
		           	  }
				}
			}); 
			
			table.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e)
				{
					impr.addActionListener(new ActionListener() {		
						public void actionPerformed(ActionEvent arg0) {
							
							try {
								int ligne = table.getSelectedRow();
			                    int idfacture = (int) table.getModel().getValueAt(ligne, 0);
			                    String idcmds =Integer.toString(idfacture);
			                    int idclient = (int) table.getModel().getValueAt(ligne, 1);
			                    String idclts =Integer.toString(idclient);
			                    Double mntpy = (Double) table.getModel().getValueAt(ligne, 2);
			                    String mntpys = Double.toString(mntpy);
			                    Double mntv = (Double) table.getModel().getValueAt(ligne, 3);
			                    String mntvs = Double.toString(mntv);
			                    Double reste = (Double) table.getModel().getValueAt(ligne, 4);
			                    String restes = Double.toString(reste);
			                    Date date = (Date) table.getModel().getValueAt(ligne, 5);
			                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			                    String strDate = dateFormat.format(date);  
			                    String etat = (String) table.getModel().getValueAt(ligne, 6);
			                   
			                    Document doc = new Document();
					   		    PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("factures\\facture.pdf"));
					   		    doc.open();
						   		Paragraph para1 = new Paragraph(" La Facture NUMERO "+idfacture);
					   			para1.setAlignment(Paragraph.ALIGN_CENTER);
					   		   
					   		    Paragraph para = new Paragraph("---------------------------------------------");
					   			para.setAlignment(Paragraph.ALIGN_CENTER);
					   			doc.add(para1);
					   		    doc.add(para);
						   		
					   		    PdfPTable table = new PdfPTable(2);
					   			PdfPCell c1 = new PdfPCell(new Paragraph("facture "));
					   			PdfPCell c11 = new PdfPCell(new Paragraph(idcmds));
					   			table.addCell(c1);table.addCell(c11);
					   			c1 = new PdfPCell(new Paragraph("client "));
					   			c11= new PdfPCell(new Paragraph(idclts));
					   			table.addCell(c1);table.addCell(c11);
					   			c1 = new PdfPCell(new Paragraph("Montant paye  "));
					   			c11= new PdfPCell(new Paragraph(mntpys));
					   			table.addCell(c1);table.addCell(c11);
					   			c1 = new PdfPCell(new Paragraph("Montant verser "));
					   			c11= new PdfPCell(new Paragraph(mntvs));
					   			table.addCell(c1);table.addCell(c11);
					   			c1 = new PdfPCell(new Paragraph("Montant reste"));
					   			c11= new PdfPCell(new Paragraph(restes));
					   			table.addCell(c1);table.addCell(c11);
					   			c1 = new PdfPCell(new Paragraph("état "));
					   			c11= new PdfPCell(new Paragraph(etat));
					   			table.addCell(c1);table.addCell(c11);
					   			c1 = new PdfPCell(new Paragraph("Date Facture "));
					   			c11= new PdfPCell(new Paragraph(strDate));
					   			table.addCell(c1);table.addCell(c11);
					   			doc.add(new Paragraph("\n\n"));
					   			doc.add(table);
					   			doc.add(new Paragraph("\n\n"));
					   		    doc.close();  		    
					   		 
					   	}catch(Exception e1) {
					   		System.out.println(e1);
					   	}}
					});
				}
				
			});
			

	    	clc.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent arg0) {
					try
					{
						
						int idclt = Integer.parseInt((String)clt.getSelectedItem());
						float mnt = new serviceFacture().select_montant(idclt);
						String stg_mnt = Float.toString(mnt);
						mntPaye.setText(stg_mnt);
						
						
					}catch(Exception e) {}
					
				}

				public void mouseEntered(MouseEvent e) {
					clc.setBackground(new Color(30,60,60));
				}
				
				public void mouseExited(MouseEvent e) {
					clc.setBackground(new Color(47,79,79));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					clc.setBackground(new Color(60,80,80));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					clc.setBackground(new Color(70,80,80));
				}
			});
		
	}
}
