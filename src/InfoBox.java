import javax.swing.JOptionPane;

public class InfoBox {
	/* 	ERROR			= 	0
		INFORMATION		=	1
	WARNING_MESSAGE		=	2
	QUESTION_MESSAGE	=	3
	PLAIN_MESSAGE		=	4
	*/
	
	public static void infoBox(String infoMessage, String location, int type)
    {	
		
       JOptionPane.showMessageDialog(null, infoMessage,  location, type);
    }
}

