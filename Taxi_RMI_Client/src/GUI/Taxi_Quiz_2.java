package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

import CODE.*;

public class Taxi_Quiz_2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox q4_chk1;
	private JCheckBox q4_chk3;
	private JCheckBox q4_chk2;
	private JCheckBox q6_chk2;
	private JCheckBox q5_chk3;
	private JCheckBox q5_chk1;
	private JCheckBox q5_chk2;
	private JCheckBox q6_chk3;
	private JCheckBox q6_chk1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taxi_Quiz_2 frame = new Taxi_Quiz_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel panel_3;
	/**
	 * Create the frame.
	 */
	public Taxi_Quiz_2() {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(240, 230, 140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 657);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Give a Feedback For Me");
		lblNewLabel.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 56));
		lblNewLabel.setBounds(128, 21, 533, 71);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("04) Does the driver drives carefully ?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(78, 148, 367, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("05) How quick as the ordering prosses ?");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(73, 258, 348, 29);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("06) How was the service ?");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(73, 368, 348, 31);
		getContentPane().add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(73, 194, 638, 31);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		q4_chk1 = new JCheckBox("Yes");
		q4_chk1.setFont(new Font("Dialog", Font.PLAIN, 18));
		q4_chk1.setBackground(Color.PINK);
		q4_chk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q4_chk1.isSelected()) {
					Answers.setQ4_1(1);
					q4_chk2.setSelected(false);
					q4_chk3.setSelected(false);
					Answers.setQ4_2(0);
					Answers.setQ4_3(0);
					
				}
			}
		});
		q4_chk1.setBounds(0, 0, 136, 31);
		panel.add(q4_chk1);
		
		q4_chk2 = 	new JCheckBox("Quite a bit ");
		q4_chk2.setFont(new Font("Dialog", Font.PLAIN, 18));
		q4_chk2.setBackground(Color.PINK);
		q4_chk2.setBounds(260, 0, 130, 30);
		panel.add(q4_chk2);
		
		q4_chk3 = new JCheckBox("No");
		q4_chk3.setFont(new Font("Dialog", Font.PLAIN, 18));
		q4_chk3.setBackground(Color.PINK);
		q4_chk3.setBounds(507, 0, 131, 31);
		panel.add(q4_chk3);
		q4_chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q4_chk3.isSelected())
				{
					Answers.setQ4_3(1);
					q4_chk1.setSelected(false);
					q4_chk2.setSelected(false);
					Answers.setQ4_1(0);
					Answers.setQ4_2(0);

				}

			}
		});
		q4_chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q4_chk2.isSelected())
				{
					Answers.setQ4_2(1);
					q4_chk1.setSelected(false);
					q4_chk3.setSelected(false);
					Answers.setQ4_3(0);
					Answers.setQ4_1(0);

				}

			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 255));
		panel_1.setBounds(73, 305, 638, 31);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		q5_chk1 = new JCheckBox("Very good");
		q5_chk1.setFont(new Font("Dialog", Font.PLAIN, 18));
		q5_chk1.setBackground(Color.PINK);
		q5_chk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q5_chk1.isSelected()) {
				
					Answers.setQ5_1(1);
					q5_chk2.setSelected(false);
					q5_chk3.setSelected(false);
					Answers.setQ5_2(0);
					Answers.setQ5_3(0);
				}
			}
		});
		q5_chk1.setBounds(0, 0, 135, 31);
		panel_1.add(q5_chk1);
		
		q5_chk2 = new JCheckBox("Good");
		q5_chk2.setFont(new Font("Dialog", Font.PLAIN, 18));
		q5_chk2.setBackground(Color.PINK);
		q5_chk2.setBounds(260, 0, 130, 30);
		panel_1.add(q5_chk2);
		
		q5_chk3 = new JCheckBox("Not at all");
		q5_chk3.setFont(new Font("Dialog", Font.PLAIN, 18));
		q5_chk3.setBackground(Color.PINK);
		q5_chk3.setBounds(507, 0, 131, 31);
		panel_1.add(q5_chk3);
		q5_chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q5_chk3.isSelected())
				{
					Answers.setQ5_3(1);
					q5_chk1.setSelected(false);
					q5_chk2.setSelected(false);
					Answers.setQ5_2(0);
					Answers.setQ5_1(0);

				}				
			}
		});
		q5_chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(q5_chk2.isSelected())
				{
					Answers.setQ5_2(1);
					q5_chk1.setSelected(false);
					q5_chk3.setSelected(false);
					Answers.setQ5_1(0);
					Answers.setQ5_3(0);

				}

			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 255, 255));
		panel_2.setBounds(73, 412, 638, 31);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		q6_chk1 = new JCheckBox("Excellent");
		q6_chk1.setFont(new Font("Dialog", Font.PLAIN, 18));
		q6_chk1.setBounds(0, 0, 136, 31);
		panel_2.add(q6_chk1);
		q6_chk1.setBackground(Color.PINK);
		
		q6_chk2 = new JCheckBox("Fair");
		q6_chk2.setFont(new Font("Dialog", Font.PLAIN, 18));
		q6_chk2.setBounds(260, 0, 130, 30);
		panel_2.add(q6_chk2);
		q6_chk2.setBackground(Color.PINK);
		
		q6_chk3 = new JCheckBox("Not at all");
		q6_chk3.setFont(new Font("Dialog", Font.PLAIN, 18));
		q6_chk3.setBounds(507, 0, 131, 31);
		panel_2.add(q6_chk3);
		q6_chk3.setBackground(Color.PINK);
		q6_chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q6_chk3.isSelected())
				{
					Answers.setQ6_3(1);
					q6_chk1.setSelected(false);
					q6_chk2.setSelected(false);
					Answers.setQ6_2(0);
					Answers.setQ6_1(0);
					
				}				
				
			}
		});
		q6_chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q6_chk2.isSelected())
				{

					Answers.setQ6_2(1);
					q6_chk1.setSelected(false);
					q6_chk3.setSelected(false);
					Answers.setQ6_1(0);
					Answers.setQ6_3(0);

				}

			}
		});
		q6_chk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q6_chk1.isSelected()) {
					Answers.setQ6_1(1);
					q6_chk2.setSelected(false);
					q6_chk3.setSelected(false);
					Answers.setQ6_2(0);
					Answers.setQ6_3(0);
				}
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Taxi_Quiz quiz1=new Taxi_Quiz();
				quiz1.setVisible(true);	
				dispose();
			}
		});
		btnNewButton.setBounds(10, 36, 106, 31);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finish Attempt");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(153, 204, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(  (q4_chk1.isSelected()||q4_chk2.isSelected()||q4_chk3.isSelected()) && (q5_chk1.isSelected()||q5_chk2.isSelected()||q5_chk3.isSelected())
						&&(q6_chk1.isSelected()||q6_chk2.isSelected()||q6_chk3.isSelected())  )
				{
										
					int result=JOptionPane.showConfirmDialog(null,"Do you want make complaint or suggestions?", "Taxi Feedback System", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if(result==JOptionPane.YES_OPTION)
					{
						GartherData.main(null);
						Complains com=new Complains();
						com.setVisible(true);
						dispose();
					}
					if(result==JOptionPane.NO_OPTION)
					{
						
						JOptionPane.showMessageDialog(null,"Thank you for coparation");
						GartherData.main(null);
						login log=new login();
						log.setVisible(true);
						q4_chk1.setSelected(false);
						q4_chk2.setSelected(false);
						q4_chk3.setSelected(false);
						
						q5_chk1.setSelected(false);
						q5_chk2.setSelected(false);
						q5_chk3.setSelected(false);
	
						q6_chk1.setSelected(false);
						q6_chk2.setSelected(false);
						q6_chk3.setSelected(false);
						
						Taxi_Quiz quiz1=new Taxi_Quiz();
						quiz1.setVisible(false);	
						
						dispose();
					}
					
				
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select all boxes");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(242, 525, 266, 37);
		getContentPane().add(btnNewButton_1);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 0, 153));
		panel_3.setBounds(0, 110, 793, 5);
		getContentPane().add(panel_3);
	}
		
	public JCheckBox getQ4_chk1() {
		return q4_chk1;
	}
	public JCheckBox getQ4_chk3() {
		return q4_chk3;
	}
	public JCheckBox getQ4_chk2() {
		return q4_chk2;
	}
	public JCheckBox getQ6_chk2() {
		return q6_chk2;
	}
	public JCheckBox getQ5_chk3() {
		return q5_chk3;
	}
	public JCheckBox getQ5_chk1() {
		return q5_chk1;
	}
	public JCheckBox getQ5_chk2() {
		return q5_chk2;
	}
	public JCheckBox getQ6_chk3() {
		return q6_chk3;
	}
	public JCheckBox getQ6_chk1() {
		return q6_chk1;
	}
}











