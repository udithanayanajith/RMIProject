package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import CODE.Taxi_Remote_Interface;
import javax.swing.JTextField;


public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txt_pws;
	private JTextField user_name;
/**
 * 
 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
												
						login frame = new login();
						frame.setVisible(true);
											
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
}
	

	/**
	 * Create the frame.
	 */
	public login() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 604);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 102, 102));
		contentPane.setBackground(new Color(153, 102, 255));
		contentPane.setBorder(UIManager.getBorder("DesktopIcon.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForView = new JLabel("Taxi Feedback System\r\n");
		lblLoginForView.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 52));
		lblLoginForView.setBounds(218, 28, 534, 61);
		contentPane.add(lblLoginForView);
		
		txt_pws = new JPasswordField();
		txt_pws.setFont(new Font("Dialog", Font.PLAIN, 18));
		txt_pws.setBounds(289, 222, 286, 37);
		contentPane.add(txt_pws);
		
		
		
		
		JButton btnNewButton = new JButton("Login\r\n");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try
				{
					Taxi_Remote_Interface taxi_login=(Taxi_Remote_Interface) Naming.lookup("rmi://127.0.0.1:2020/TaxiService2020");
					
					if(taxi_login.driverLogin(user_name.getText(),txt_pws.getText()))
					{	
						Admin ad=new Admin();
						ad.setVisible(true);
						dispose();

					}
					else {
						JOptionPane.showMessageDialog(null, "Password do not match");
					}
				}
				catch (Exception e1)
				{
					// TODO: handle exception				
		            e1.printStackTrace();
		            System.out.println("Is the Taxiserver running?");
		            System.out.println("An error occured: "+e1.toString());	
				}
			}
		});
		
		
		btnNewButton.setBounds(289, 298, 286, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Questionnaire\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Taxi_Quiz quiz1=new Taxi_Quiz();
				quiz1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 36));
		btnNewButton_1.setBounds(236, 392, 402, 68);
		contentPane.add(btnNewButton_1);
		
		user_name = new JTextField();
		user_name.setFont(new Font("Dialog", Font.PLAIN, 18));
		user_name.setBounds(289, 157, 286, 36);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username\r\n\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(118, 157, 161, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password\r\n\r\n");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPassword.setBounds(118, 237, 147, 23);
		contentPane.add(lblPassword);
		
	}
}
