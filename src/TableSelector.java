import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Label;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class TableSelector {

	private JFrame frame;
	private Player hi = new Player(10000, 1,"hi", 1);
	static ArrayList<Table> tables = new ArrayList<Table>();
	static int index;		// used for index of list
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableSelector window = new TableSelector();
					window.frame.setVisible(true);
					final int noLimit = 999999999;	// used for high limit table
					// initializing tables
					
					tables.add(new Table(6, 5, 1000));		// table 1
					tables.add(new Table(6, 5, 1000));		// table 2
					tables.add(new Table(2, 25, 5000));		// table 3
					tables.add(new Table(1, 25, 5000));		// table 4
					tables.add(new Table(2, 100, 10000));	// table 5
					tables.add(new Table(1, 100, noLimit));	// table 6
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TableSelector() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		
		
		
		// table list
		
		String listData[] =  { 
				"Table 1\t	Minimum $5\t	Maximum $1,000\t	Deck 6 ",
				"Table 2\t	Minimum $5\t	Maximum $1,000\t	Deck 6 ",
				"Table 3\t	Minimum $25\tMaximum $5,000\t	Deck 2",
				"Table 4\t	Minimum $25\tMaximum $5,000\t	Deck 1",
				"Table 5\t	Minimum $100\tMaximum $10,000\tDeck 2",
				"Table 6\t	Minimum $100\tMaximum None\t	Deck 1"		
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
					close();
					open();
					
					
				}
			}
			
			/**
			 * closing current window method
			 */
			public void close() {
				WindowEvent windowClosingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
			}
			
			public void open() {
				tableView game = new tableView();
				game.setVisible(true);
			}
			
		
			
		});
		
		
		
		tableList.setBackground(Color.LIGHT_GRAY);					// background font
		Font tableListFont = new Font("Arial",Font.PLAIN, 14);	
		
		tableList.setFont(tableListFont);						// setting the font for the list	
		tableList.setForeground(Color.BLUE);
		frame.getContentPane().add(tableList, BorderLayout.CENTER);
	
		// labels at the bottom
		Label chips = new Label("ID : " + hi.getId() + "\tChips :" + hi.getChips() + "\tLevel : " + hi.getLevel() ); 
		frame.getContentPane().add(chips, BorderLayout.SOUTH);
		
		
		
		// menu bar
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar.add(mntmHome);
	}
	
	

}
