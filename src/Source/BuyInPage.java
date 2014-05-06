package Source;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class BuyInPage extends JFrame {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel buyInLabel;
	private int minimumBet;			// is initialized with the constructor;
	private int defaultSliderValue;
	private DecimalFormat df = new DecimalFormat("$###,###.###");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyInPage frame = new BuyInPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * sets the minimum Bet for this table.
	 * @param minimum
	 */
	public BuyInPage(int minimum, Player thisPlayer)
	{
		minimumBet = minimum;
		initialize(thisPlayer);
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public BuyInPage() {
		
		
		
	}
	
	private void initialize(final Player thisPlayer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		switch (minimumBet) {
		case 5 :
			defaultSliderValue = 100;
			break;
		case 25 :
			defaultSliderValue = 500;
			break;
		case 100 :
			defaultSliderValue = 1000;
			break;
	}
		String string = df.format(defaultSliderValue);
		
		
		slider = new JSlider(0, thisPlayer.getChips());
		
			
		/*** need to fix player when he doesn't have enough chips ***/
		
		
		
		
		buyInLabel =  new JLabel(string);
		buyInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		buyInLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buyInLabel.setBounds(130, 141, 193, 40);
		contentPane.add(buyInLabel);
		
		
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				buyInLabel.setText(df.format(slider.getValue())); 
			}
		});
		slider.setBounds(100, 100, 250, 30);
		//slider.set
		contentPane.add(slider);
		
		JButton btnBuyin = new JButton("Buy-In");
		btnBuyin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int howMuch = slider.getValue();
				System.out.println(howMuch);
				thisPlayer.setChips(thisPlayer.getChips() - howMuch);
				System.out.println(thisPlayer.getChips());
				
			}
		});
		
		btnBuyin.setBounds(170, 204, 117, 29);
		contentPane.add(btnBuyin);
	}
}
