package Source;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.*;


public class TableSelector extends JFrame{

	//final fields
	final int NOLIMIT = 999999999;			// used for high limit table
	
	// private fields
	static Player hi = new Player(25, 1,"hi", 1);	// temporary player
	private int index;		// used for index of list
	
	//static fields
	static ArrayList<Table> tables = new ArrayList<Table>();		// list of tables
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//initialize 
					//TableSelector frame = new TableSelector();
					//frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * No-Arg Constructor
	 * Description : calls the initialize method
	 */
	public TableSelector() {
		// calling the initialize method
		//initialize();
	}

	public TableSelector (Player thisPlayer) {
		initialize(thisPlayer);
	}
	
	
	/**
	 * holds the design and main function of the TableSelector Class
	 */
	private void initialize(final Player thisPlayer) {
		// initializing the tables array for the tables
		tables.add(new Table(6, 5, 1000));		// table 1
		tables.add(new Table(6, 5, 1000));		// table 2
		tables.add(new Table(2, 25, 5000));		// table 3
		tables.add(new Table(1, 25, 5000));		// table 4
		tables.add(new Table(2, 100, 10000));	// table 5
		tables.add(new Table(1, 100, NOLIMIT));	// table 6
		
		// initializing the main frame
		setBounds(300, 300, 700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// table list
		String listData[] =  { 
				"Table 1\t	Minimum $5\t	Maximum $1,000\t	Deck 6 ",
				"Table 2\t	Minimum $5\t	Maximum $1,000\t	Deck 6 ",
				"Table 3\t	Minimum $25\t	Maximum $5,000\t	Deck 2",
				"Table 4\t	Minimum $25\t	Maximum $5,000\t	Deck 1",
				"Table 5\t	Minimum $100\t	Maximum $10,000\t	Deck 2",
				"Table 6\t	Minimum $100\t	Maximum None\t		Deck 1"		
		}; 
		
		final JList tableList = new JList(listData);
		
		tableList.setForeground(Color.WHITE);
		tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableList.setFixedCellHeight(20);
		
		
		tableList.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					 
				if(arg0.getClickCount() == 2 ) {
					index = tableList.getSelectedIndex();
				//	System.out.println("TableSelector mouseClicked index is"  +index);
					close();
					open(thisPlayer);

				}
			}
			
			
			
		});
		
		
		
		tableList.setBackground(Color.LIGHT_GRAY);					// background font
		Font tableListFont = new Font("Arial",Font.PLAIN, 14);	
		
		tableList.setFont(tableListFont);						// setting the font for the list	
		tableList.setForeground(Color.BLUE);
		getContentPane().add(tableList, BorderLayout.CENTER);
	
		// labels at the bottom
		Label chips = new Label("ID : " + thisPlayer.getId() + "\tChips :" + thisPlayer.getChips() + "\tLevel : " + thisPlayer.getLevel() ); 
		getContentPane().add(chips, BorderLayout.SOUTH);
		
		
		
		// menu bar
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar.add(mntmHome);
	}
	
	/**
	 * closing current window method
	 */
	public void close() {
		this.setVisible(false);
		dispose();
	}
	
	public void open(Player thisPlayer) {
		System.out.println("Table Selector Open() index "+index);
		TableView game = new TableView(index, thisPlayer);
		System.out.println("++");
		game.setVisible(true);
	}
	

}
