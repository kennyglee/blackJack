import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;


public class tableView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tableView frame = new tableView();
					frame.setVisible(true);
					
			    	
			    	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tableView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -22, 712, 506);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		int tableIndex = TableSelector.index;
		
		Table thisTable = TableSelector.tables.get(tableIndex);
		int min	=	thisTable.getMinBuyIn();
		int max = 	thisTable.getMaxBuyIn();
		
		
		
		System.out.println("this table's maxBuyIn is = " + thisTable.getMaxBuyIn());
		System.out.println("this table's minBuyIn is = " + thisTable.getMinBuyIn());
		System.out.println("this table's numOfDeck is = " + thisTable.getNumOfDecks());
		System.out.println("this table number is = "  + (tableIndex+1));
		
		JButton button = new JButton("Sit");
		button.setBounds(148, 361, 60, 19);
		panel.add(button);
		
		JButton button_1 = new JButton("Sit");
		button_1.setBounds(266, 387, 60, 19);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Sit");
		button_2.setBounds(389, 387, 60, 19);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Sit");
		button_3.setBounds(508, 356, 60, 19);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Sit");
		button_4.setBounds(605, 304, 60, 19);
		panel.add(button_4);
		
		
		
		
		
		
		
		
		JLabel topLabel = new JLabel("Table " + (tableIndex+1) + " \t\t" + thisTable.getNumOfDecks() + "\t Deck Min: $" + min + "\t Max: $" + max);
		topLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		topLabel.setBounds(168, 22, 407, 36);
		panel.add(topLabel);
		
		JButton btnSit = new JButton("Sit");
		btnSit.setBounds(45, 304, 60, 19);
		panel.add(btnSit);
		
		JLabel lblNewLabelv = new JLabel("");
		lblNewLabelv.setBounds(6, 22, 700, 500);
		panel.add(lblNewLabelv);
		lblNewLabelv.setIcon(new ImageIcon("/Users/Kenny/Google Drive/UCSD/Sophomore/CSE 110/images/table edited final.jpg"));
		
		
		
		
		
	}
}
