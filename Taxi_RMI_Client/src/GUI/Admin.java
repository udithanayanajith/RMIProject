package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import CODE.Taxi_Remote_Interface;
import javax.swing.JLabel;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.rmi.Naming;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForView = new JLabel("Taxi Feedback System\r\n");
		lblLoginForView.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 52));
		lblLoginForView.setBounds(131, 13, 534, 61);
		contentPane.add(lblLoginForView);
		
		JButton btnNewButton_2 = new JButton("Add or SignUp a Driver\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sign_up signup=new Sign_up();
				signup.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(12, 122, 248, 31);
		contentPane.add(btnNewButton_2);
		
		JButton bar_btn = new JButton("View Chart");
		bar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String final_Url;
					Taxi_Remote_Interface bar_chart=(Taxi_Remote_Interface)Naming.lookup("rmi://127.0.0.1:2020/TaxiService2020");
					bar_chart.barChart();
					//get the chart url from Taxi server and initialize to an image ad display
					final_Url=bar_chart.barChart();				
					URL url= new URL(final_Url);
					BufferedImage image = ImageIO.read(url.openStream());

					JFrame frame = new JFrame();
					 frame.setBounds(900, 100, 800, 650);
				        JLabel label = new JLabel(new ImageIcon(image));
				        
				        frame.getContentPane().add(label);
				        frame.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"Error with loading Bar chart");
				}
			}
		});
		bar_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bar_btn.setBounds(283, 122, 184, 31);
		contentPane.add(bar_btn);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login lg=new login();
				lg.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(717, 38, 97, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 207, 797, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		Object[] coloum= {"Count","Complain"};
		//Object[] row=new Object[0];
		model.setColumnIdentifiers(coloum);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("View Complains");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//viewing complains 
    			try {
    				ArrayList<String> a=new ArrayList<String>();
					Taxi_Remote_Interface view_complain=(Taxi_Remote_Interface) Naming.lookup("rmi://127.0.0.1:2020/TaxiService2020");
					a=view_complain.taxi_complain();
					
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					Object[] row=new Object[2];
					for(int i=0;i<a.size();)
					{
						row[0]=a.get(i);
						row[1]=a.get(i+1);
						model.addRow(row);
						i=i+2;
					}
							
					btnNewButton_1.setEnabled(false);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Is the Taxiserver running?");
				} 
										
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(502, 122, 163, 30);
		contentPane.add(btnNewButton_1);
	}
}
