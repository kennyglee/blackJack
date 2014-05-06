package Source;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.*;

import test.VerifyTest;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Login extends JFrame {
 
	// private fields
	private JPanel contentPane;				/** main Panel **/
	private JTextField textField;			/** textField for ID **/
	private JPasswordField passwordField;	/** passwordField for PW **/
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// initializing the Login Frame 
					Login frame = new Login();
					frame.setVisible(true);
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
	public Login() {
		// calling the initialize method
		initialize();
		
	}
	/**
	 * holds the design and main function of the Login Class
	 */
	private void initialize() {
		// initialize the main frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 300, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		// initialize and display the TextField for ID input
		textField = new JTextField();
		textField.setBounds(87, 77, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//initialize and display the passwordField for PW input
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 127, 134, 28);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		
		//initialize and display the label left of ID textField
		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		idLabel.setBounds(56, 82, 30, 16);
		contentPane.add(idLabel);
		
		//initialize and display the label left of PW passwordField
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pwLabel.setBounds(56, 132, 30, 16);
		contentPane.add(pwLabel);
		
		// temporary at the top of the login page
		JLabel lblForNowId = new JLabel("For now, ID: admin\n PW: admin");
		lblForNowId.setBounds(32, 17, 247, 42);
		contentPane.add(lblForNowId);
		
		//initialize and display the Login BUTTON
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBounds(87, 195, 117, 29);
		contentPane.add(loginButton);
		
		//  initialize and display the crate BUTTON 
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openCreateAccount();
			
			}
			
		});
		createButton.setBounds(87, 227, 117, 29);
		contentPane.add(createButton);
		
		
		
		// adding listener to the button
		loginButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(passwordField.getPassword());
				String id = textField.getText();
				
				try {
					Player player = Player.load(id);
					
					// if there is no player in the DB
					if(player == null) {
						InfoBox.infoBox("The User Does Not Exist", "Error: User Invalid!", 0);
						return;
					}
					
					
					
					if(player.validatePassword(textField.getText(), password)) {
						System.out.println("user is valid");
						openTableSelector(player);
					} else {
						
						System.out.println("User is not valid");
						InfoBox.infoBox("Check Your Password", "Error: Wrong Password!", 0);
						return;
				}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				/*if(!textField.getText().equalsIgnoreCase("admin")) {
					
					System.out.println();
					InfoBox.infoBox("WRONG ID!!", "Error: Wrong ID", 0);
				} else {
					
					InfoBox.infoBox("Successful Login!", "Login Successful", 1);
					close();		// close current Window
					openTableSelector();			// open TableSelector Window
		   			
				}*/
			}		// end of actionPerformed innerClass method
		});

		
	}
	
	/**
	 * Closing current Window Method
	 */
	public void close() {
		// initializing the Window_CLOSING EVENT
		WindowEvent windowClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
		
	}
	
	/**
	 * Opening tableSelector Frame Method
	 */
	public void openTableSelector(Player thisPlayer) {
		//initializing tableSelector Object and opening it
		TableSelector tableList = new TableSelector(thisPlayer);
		tableList.setVisible(true);
	}
	
	public void openCreateAccount() {
		// initializing createAccount Object and opening it
		CreateAccount createAccount = new CreateAccount();
		createAccount.setVisible(true);
		
	}
}
