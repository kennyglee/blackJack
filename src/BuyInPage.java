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


public class BuyInPage extends JFrame {

	private JPanel contentPane;
	private int minimumBet;			// is initialized with the constructor;

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
	public BuyInPage(int minimum)
	{
		//this(); // error error 
		minimumBet = minimum;
		
		System.out.println(minimumBet);
	}
	
	
	/**
	 * Create the frame.
	 */
	public BuyInPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		int defaultSliderValue=0;
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
			
		System.out.println(defaultSliderValue);
		final JLabel buyInLabel = new JLabel(String.valueOf(defaultSliderValue));
		
		buyInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		buyInLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buyInLabel.setBounds(130, 141, 193, 40);
		contentPane.add(buyInLabel);
		
		
		final JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				buyInLabel.setText(String.valueOf(slider.getValue())); 
				 //setMinimum(10);
			}
		});
		slider.setBounds(100, 100, 250, 30);
		//slider.set
		contentPane.add(slider);
		
		
	}
}
