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
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Complains extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4606788123591175487L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complains frame = new Complains();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String sug;
	/**
	 * Create the frame.
	 */
	
	
	
	public Complains() {
		setBackground(new Color(51, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForView = new JLabel("Taxi Feedback System\r\n");
		lblLoginForView.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 56));
		lblLoginForView.setBounds(156, 13, 609, 66);
		contentPane.add(lblLoginForView);
		
		JButton btnNewButton = new JButton("Close\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login log=new login();
				log.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(791, 67, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Type your Complain/Suggesions here");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(50, 119, 441, 23);
		contentPane.add(lblNewLabel);
		
		JTextArea txt_complain = new JTextArea();
		txt_complain.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txt_complain.setBounds(50, 155, 715, 282);
		contentPane.add(txt_complain);
		
		JButton btnNewButton_1 = new JButton("Submit\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(txt_complain.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please give a complain or suggesion !");
					}
					else {
						
						Taxi_Remote_Interface send_data =(Taxi_Remote_Interface) Naming.lookup("rmi://127.0.0.1:2020/TaxiService2020");	
						send_data.addComplain(txt_complain.getText());
						txt_complain.setText("");
						dispose();
						login log=new login();
						log.setVisible(true);
						
					}

				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Is the Taxi Server Running ?");
					e.printStackTrace();
					System.out.println("Error: "+e.toString());
					txt_complain.setText("");
					dispose();
				}

				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(327, 464, 235, 47);
		contentPane.add(btnNewButton_1);
		
		
	}
}
