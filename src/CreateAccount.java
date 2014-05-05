import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField pwField;
	private int sex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(91, 51, 61, 16);
		contentPane.add(idLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setBounds(91, 91, 61, 16);
		contentPane.add(pwLabel);
		
		JLabel sexLabel = new JLabel("SEX");
		sexLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sexLabel.setBounds(91, 141, 61, 16);
		contentPane.add(sexLabel);
		
		idField = new JTextField();
		idField.setBounds(164, 45, 134, 28);
		contentPane.add(idField);
		idField.setColumns(10);
		
		pwField = new JTextField();
		pwField.setColumns(10);
		pwField.setBounds(164, 85, 134, 28);
		contentPane.add(pwField);
		
		final JRadioButton maleRadio = new JRadioButton("MALE");
		maleRadio.setBounds(164, 139, 141, 23);
		contentPane.add(maleRadio);
		
		final JRadioButton femaleRadio = new JRadioButton("FEMALE");
		femaleRadio.setBounds(164, 174, 141, 23);
		contentPane.add(femaleRadio);
		
		ButtonGroup group = new ButtonGroup();
		group.add(maleRadio);
		group.add(femaleRadio);		
		
	    maleRadio.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            sex = 1;
	        }
	    });
	    
	    femaleRadio.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            sex = 2;
	        }
	    });
	    
		
		JButton createButton = new JButton("CREATE");
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			if(idField.getText().equals("") || pwField.getText().equals("") || !(maleRadio.isSelected() || femaleRadio.isSelected())) {
				InfoBox.infoBox("Take a Look At The Application Again!", "Error: Bad INPUT", 0);
				return;
			}
			try {
				Player.createPlayer(idField.getText(), pwField.getText(), 1000, sex, 1);
				close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		createButton.setBounds(194, 528, 117, 29);
		contentPane.add(createButton);
		
		
	}
	
	/**
	 * Closing current Window Method
	 */
	public void close() {
		// initializing the Window_CLOSING EVENT
		WindowEvent windowClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
		
	}
}
