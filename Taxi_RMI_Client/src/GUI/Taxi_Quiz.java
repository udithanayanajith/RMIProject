package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.Color;


public class Taxi_Quiz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taxi_Quiz frame = new Taxi_Quiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * creating a globle vriable to collect answers
	 */

	
	/**
	 * Create the frame.
	 */

	private JCheckBox q1_chk3;
	


	public Taxi_Quiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Give a Feedback For Me");
		lblNewLabel.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 56));
		lblNewLabel.setBounds(125, 25, 587, 79);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("01) Do you think taxi fare are resonable ?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(37, 159, 402, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("02)  How friendly was the driver ?");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(37, 271, 402, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("03) How was the suplied facilities ?"
				+ " (Eg: A/C, Usb charging slots etc)");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(37, 385, 596, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(37, 195, 721, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox q1_chk1 = new JCheckBox("Yes");
		q1_chk1.setFont(new Font("Dialog", Font.PLAIN, 18));
		q1_chk1.setBackground(new Color(240, 230, 140));
		q1_chk1.setBounds(0, 0, 155, 31);
		panel.add(q1_chk1);
		
		JCheckBox q1_chk2 = new JCheckBox("No");
		q1_chk2.setFont(new Font("Dialog", Font.PLAIN, 18));
		q1_chk2.setBackground(new Color(240, 230, 140));
		q1_chk2.setBounds(264, 0, 97, 31);
		panel.add(q1_chk2);
		
		q1_chk3 = new JCheckBox("May be");
		q1_chk3.setFont(new Font("Dialog", Font.PLAIN, 18));
		q1_chk3.setBackground(new Color(240, 230, 140));
		q1_chk3.setBounds(523, 0, 120, 31);
		panel.add(q1_chk3);
		q1_chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(q1_chk3.isSelected())
				{
					Answers.setQ1_3(1);
					q1_chk1.setSelected(false);
					q1_chk2.setSelected(false);
					Answers.setQ1_1(0);
					Answers.setQ1_2(0);

				}

			}
		});
		q1_chk2.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent arg0) {
			}
		});
		q1_chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q1_chk2.isSelected())
				{	
					Answers.setQ1_2(1);
					q1_chk1.setSelected(false);
					q1_chk3.setSelected(false);
					Answers.setQ1_1(0);
					Answers.setQ1_3(0);



				}

				
			}
		});
		q1_chk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(q1_chk1.isSelected())
				{
					Answers.setQ1_1(1);
					q1_chk2.setSelected(false);
					q1_chk3.setSelected(false);
					Answers.setQ1_2(0);
					Answers.setQ1_3(0);

				}
			
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 238, 144));
		panel_1.setBounds(37, 307, 721, 31);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox q2_chk1 = new JCheckBox("Very good");
		q2_chk1.setFont(new Font("Dialog", Font.PLAIN, 18));
		q2_chk1.setBackground(new Color(240, 230, 140));
		q2_chk1.setBounds(0, 0, 152, 31);
		panel_1.add(q2_chk1);
		
		JCheckBox q2_chk2 = new JCheckBox("Good");
		q2_chk2.setFont(new Font("Dialog", Font.PLAIN, 18));
		q2_chk2.setBackground(new Color(240, 230, 140));
		q2_chk2.setBounds(265, 0, 97, 31);
		panel_1.add(q2_chk2);
		
		JCheckBox q2_chk3 = new JCheckBox("Not at all");
		q2_chk3.setFont(new Font("Dialog", Font.PLAIN, 18));
		q2_chk3.setBackground(new Color(240, 230, 140));
		q2_chk3.setBounds(518, 0, 122, 31);
		panel_1.add(q2_chk3);
		q2_chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(q2_chk3.isSelected())
				{	
					Answers.setQ2_3(1);
					q2_chk1.setSelected(false);
					q2_chk2.setSelected(false);
					Answers.setQ2_1(0);
					Answers.setQ2_2(0);
				}

			}
			
		});
		q2_chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q2_chk2.isSelected())
				{	
					Answers.setQ2_2(1);
					q2_chk1.setSelected(false);
					q2_chk3.setSelected(false);
					Answers.setQ2_1(0);
					Answers.setQ2_3(0);
					
				}

			}
		});
		q2_chk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q2_chk1.isSelected())
				{
					Answers.setQ2_1(1);
					q2_chk2.setSelected(false);
					q2_chk3.setSelected(false);		
					Answers.setQ2_2(0);
					Answers.setQ2_3(0);
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(144, 238, 144));
		panel_2.setBounds(37, 421, 721, 31);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JCheckBox q3_chk1 = new JCheckBox("Very good");
		q3_chk1.setFont(new Font("Dialog", Font.PLAIN, 18));
		q3_chk1.setBackground(new Color(240, 230, 140));
		q3_chk1.setBounds(0, 0, 155, 31);
		panel_2.add(q3_chk1);
		
		JCheckBox q3_chk2 = new JCheckBox("Good");
		q3_chk2.setFont(new Font("Dialog", Font.PLAIN, 18));
		q3_chk2.setBackground(new Color(240, 230, 140));
		q3_chk2.setBounds(269, 0, 97, 31);
		panel_2.add(q3_chk2);
		
		JCheckBox q3_chk3 = new JCheckBox("Not at all");
		q3_chk3.setFont(new Font("Dialog", Font.PLAIN, 18));
		q3_chk3.setBackground(new Color(240, 230, 140));
		q3_chk3.setBounds(522, 0, 120, 31);
		panel_2.add(q3_chk3);
		q3_chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(q3_chk3.isSelected())
				{
					Answers.setQ3_3(1);
					q3_chk1.setSelected(false);
					q3_chk2.setSelected(false);
					Answers.setQ3_1(0);	
					Answers.setQ3_2(0);
				}

			}
			
		});
		q3_chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q3_chk2.isSelected())
				{					
					Answers.setQ3_2(1);
					q3_chk1.setSelected(false);
					q3_chk3.setSelected(false);
					Answers.setQ3_1(0);
					Answers.setQ3_3(0);
				}			
			}
		});
		q3_chk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q3_chk1.isSelected())
				{	
					Answers.setQ3_1(1);
					q3_chk2.setSelected(false);
					q3_chk3.setSelected(false);
					Answers.setQ3_3(0);
					Answers.setQ3_2(0);

				}	
			}
		});
		
	
		
		JButton btnNewButton = new JButton("Next Page\r\n");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(153, 102, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				if(  (q1_chk1.isSelected()||q1_chk2.isSelected()||q1_chk3.isSelected())&&(q2_chk1.isSelected()||q2_chk2.isSelected()||q2_chk3.isSelected())
						&&(q3_chk1.isSelected()||q3_chk2.isSelected()||q3_chk3.isSelected())  )
				{	 
					Taxi_Quiz_2 quiz2=new Taxi_Quiz_2();
					quiz2.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select all boxes");
				}

			}
		});
		btnNewButton.setBounds(206, 520, 305, 40);
		contentPane.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 0, 153));
		panel_3.setBounds(12, 121, 793, 5);
		contentPane.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login log=new login();
				log.setVisible(true);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(669, 42, 136, 31);
		contentPane.add(btnNewButton_1);
		
		
				
	}



}
