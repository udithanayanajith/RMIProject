package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import CODE.Taxi_Remote_Interface;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.rmi.Naming;
import java.awt.event.ActionEvent;


public class Sign_up extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField driver_name;
	private JTextField vehicle_number;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField con_password;
	
//	Vector<Drivers>driver=new Vector<>();
	Taxi_Remote_Interface sign_up=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up frame = new Sign_up();
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
	public Sign_up() {
		setBackground(new Color(255, 51, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForView = new JLabel("Taxi Feedback System\r\n");
		lblLoginForView.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 56));
		lblLoginForView.setBounds(156, 13, 638, 66);
		contentPane.add(lblLoginForView);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login lg=new login();
				lg.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(721, 80, 107, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(92, 161, 94, 14);
		contentPane.add(lblNewLabel);
		
		driver_name = new JTextField();
		driver_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		driver_name.setColumns(10);
		driver_name.setBounds(310, 154, 306, 31);
		contentPane.add(driver_name);
		
		JLabel lblNewLabel_1 = new JLabel("Vehecle Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(85, 217, 167, 14);
		contentPane.add(lblNewLabel_1);
		
		vehicle_number = new JTextField();
		vehicle_number.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vehicle_number.setColumns(10);
		vehicle_number.setBounds(310, 210, 216, 31);
		contentPane.add(vehicle_number);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(88, 274, 153, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_username.setColumns(10);
		txt_username.setBounds(310, 267, 216, 31);
		contentPane.add(txt_username);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(92, 329, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_password.setBounds(310, 322, 216, 31);
		contentPane.add(txt_password);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(92, 386, 160, 14);
		contentPane.add(lblNewLabel_4);
		
		con_password = new JPasswordField();
		con_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		con_password.setBounds(310, 379, 218, 31);
		contentPane.add(con_password);
			
		
		JButton btnNewButton = new JButton("Register");
		
		btnNewButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					
        			Taxi_Remote_Interface sign_up=(Taxi_Remote_Interface) Naming.lookup("rmi://127.0.0.1:2020/TaxiService2020");																	
					
        			if(driver_name.getText().equals("")||vehicle_number.getText().equals("") || txt_username.getText().equals("")||txt_password.getText().equals("")||con_password.getText().equals("") ){			
						JOptionPane.showMessageDialog(null, "Please fill all the filed");
					}
					else {
						if(txt_password.getText().equals(con_password.getText()))
						{	
							
			/*				byte[] password = null;
							
							try {
								password = new String(txt_password.getText()).getBytes("UTF-8");//Initializing the password field to decode
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							*/
							//String encoded=datatype.printBase64Binary(password);//decoding the password field using Base64 binary method
							 
							sign_up.addDriver(driver_name.getText(), vehicle_number.getText(), txt_username.getText(), txt_password.getText());

							
							JOptionPane.showMessageDialog(null,"Sucssesfully added details to database");
							System.out.println( "All fields are filed");
						
							driver_name.setText("");
							vehicle_number.setText("");
							txt_password.setText("");
							txt_username.setText("");
							con_password.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null, "Please enter correct password");
						}
						
					}
				}
				catch (Exception e) {
					// TODO: handle exception
		            e.printStackTrace();
		            System.out.println("Is the Taxiserver running?");
		            System.out.println("An error occured: "+e.toString());	
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(348, 459, 167, 37);
		contentPane.add(btnNewButton);
	}
}
