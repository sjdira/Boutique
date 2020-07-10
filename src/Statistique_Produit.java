import java.awt.Toolkit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;




public class Statistique_Produit {

	ResultSet res = null;
	public Statistique_Produit()
	{

		DefaultPieDataset data = new DefaultPieDataset();
		
		try {
			int i=1;
			ResultSet res = new serviceProduit().select_stat_prd();
			while(res.next())
			{ 
				float val = ((float)res.getInt(2)/(new serviceProduit().select_somme_qte_vendu()))*100 ;
				data.setValue("produit "+res.getInt(1), val);
				
			}
			JFreeChart chart = ChartFactory.createPieChart("Statistique Produits :",data,true,true,false);
		    ChartFrame f1 = new ChartFrame("Statistique Produits", chart);
		    //f1.setIconImage(Toolkit.getDefaultToolkit().getImage(Statistique_Produit.class.getResource("/test/rtr.png")));
		    f1.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/test/btq.png")));
		    f1.pack();
		   // f1.setLocationRelativeTo(null);
		    f1.setVisible(true);
		   
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Statistique_Produit s = new Statistique_Produit();

	}

}
