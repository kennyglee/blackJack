import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class TableView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
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
	public TableView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -22, 712, 506);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		int tableIndex = TableSelector.index;
		
		Table thisTable = TableSelector.tables.get(tableIndex);
		final int min	=	thisTable.getMinBet();
		final int max = 	thisTable.getMaxBet();
		
		
		
		System.out.println("this table's maxBuyIn is = " + thisTable.getMaxBet());
		System.out.println("this table's minBuyIn is = " + thisTable.getMinBet());
		System.out.println("this table's numOfDeck is = " + thisTable.getNumOfDecks());
		System.out.println("this table number is = "  + (tableIndex+1));
		
		
		int x, y; // used for setBounds for button
		
		ArrayList<Player> playersOnTable = thisTable.getPlayers();
		
		//playersOnTable.
		
		
		JButton button_1 = new JButton("Sit");			//index 0
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BuyInPage page = new BuyInPage(min);
						//  page = new BuyInPage();
				page.setVisible(true);
				
				
			}
		});
		button_1.setBounds(45, 304, 60, 19);
		panel.add(button_1);
		
		
		JButton button_2 = new JButton("Sit");			// index 1
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_2.setBounds(148, 361, 60, 19);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Sit");			// index 2
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_3.setBounds(266, 387, 60, 19);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Sit");			// index 3
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_4.setBounds(389, 387, 60, 19);
		panel.add(button_4);
		
		JButton button_5 = new JButton("Sit");			// index 4
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_5.setBounds(508, 356, 60, 19);
		panel.add(button_5);
		
		JButton button_6 = new JButton("Sit");			// index 5
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_6.setBounds(605, 304, 60, 19);
		panel.add(button_6);
		
		
		
		
		
		
		
		
		JLabel topLabel = new JLabel("Table " + (tableIndex+1) + " \t\t" + thisTable.getNumOfDecks() + "\t Deck Min: $" + min + "\t Max: $" + max);
		topLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		topLabel.setBounds(168, 22, 407, 36);
		panel.add(topLabel);
		

		
		JLabel lblNewLabelv = new JLabel("");
		lblNewLabelv.setBounds(6, 22, 700, 500);
		panel.add(lblNewLabelv);
		lblNewLabelv.setIcon(new ImageIcon("/Users/Kenny/Google Drive/UCSD/Sophomore/CSE 110/images/table edited final.jpg"));
		
		
		
		
		
	}
	
	
}
