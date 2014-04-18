import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Label;


public class TableSelector {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableSelector window = new TableSelector();
					window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		String listData[] =  { 
				"Table 1		Minimum $5		Maximum $1,000",
				"Table 2		Minimum $5		Maximum $1,000",
				"Table 3		Minimum $25		Maximum $5,000",
				"Table 4		Minimum $25		Maximum $5,000",
				"Table 5		Minimum $100	Maximum	$10,000",
				"Table 6		Minimum $100	Maximum No Limit"		
		};
		
		JList list = new JList(listData);
		list.setFixedCellHeight(20);
		
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		list.setBackground(Color.GRAY);
		frame.getContentPane().add(list, BorderLayout.CENTER);
		
		JLabel lblSelectTable = DefaultComponentFactory.getInstance().createTitle("Select Table");
		frame.getContentPane().add(lblSelectTable, BorderLayout.NORTH);
		
		Label chips = new Label("chips"); ******
		Label 
		frame.getContentPane().add(label, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar.add(mntmHome);
	}

}
