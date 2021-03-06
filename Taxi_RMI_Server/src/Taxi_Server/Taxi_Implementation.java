package Taxi_Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import CODE.Taxi_Remote_Interface;

//Inheritance
public class Taxi_Implementation extends UnicastRemoteObject implements Taxi_Remote_Interface{
	private static Connection conn;
	
	private static final long serialVersionUID = 1L;
	
	protected Taxi_Implementation() throws RemoteException {
		super();

		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_feedback_system", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void addAnswer(int q1_1,int q1_2,int q1_3,int q2_1,int q2_2,int q2_3,int q3_1,int q3_2,int q3_3,int q4_1,int q4_2,int q4_3,int q5_1,int q5_2,int q5_3,int q6_1,int q6_2,int q6_3) throws RemoteException {
		// TODO Auto-generated method stub

		try {
			String query="UPDATE `answers` SET `attempt`=`attempt`+1, `q1_1`=`q1_1`+?, `q1_2`=`q1_2`+?,`q1_3`=`q1_3`+? , "
					+ "  `q2_1`=`q2_1`+?,`q2_2`=`q2_2`+?,`q2_3`=`q2_3`+? ,   `q3_1`=`q3_1`+?,`q3_2`=`q3_2`+?,`q3_3`=`q3_3`+? ,"
					+ "  `q4_1`=`q4_1`+?,`q4_2`=`q4_2`+?,`q4_3`=`q4_3`+?,  `q5_1`=`q5_1`+?,`q5_2`=`q5_2`+?,`q5_3`=`q5_3`+? , "
					+ "  `q6_1`=`q6_1`+?,`q6_2`=`q6_2`+?,`q6_3`=`q6_3`+? ";
							
			PreparedStatement pts=conn.prepareStatement(query);
			
			pts.setInt(1, q1_1);
			pts.setInt(2, q1_2);
			pts.setInt(3, q1_3);
			
			pts.setInt(4, q2_1);
			pts.setInt(5, q2_2);
			pts.setInt(6, q2_3);
			
			pts.setInt(7, q3_1);
			pts.setInt(8, q3_2);
			pts.setInt(9, q3_3);
			
			pts.setInt(10, q4_1);
			pts.setInt(11, q4_2);
			pts.setInt(12, q4_3);
			
			pts.setInt(13, q5_1);
			pts.setInt(14, q5_2);
			pts.setInt(15, q5_3);
			
			pts.setInt(16, q6_1);
			pts.setInt(17, q6_2);
			pts.setInt(18, q6_3);
						
			pts.executeUpdate();
				
			//JOptionPane.showMessageDialog(null,"Sucssesfully saved data into database");
			System.out.println("Sucssesfully saved data into database");
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error with Updating values");
		}

				
	}
	@Override 				//checking Logindetails and  decoding the password
	
	public boolean driverLogin(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result=false;
		try 
		{			
			
			String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password= '" + password +"'";
			
			PreparedStatement  pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();

					while (rs.next()) {
						if (rs.getString("password").equalsIgnoreCase(password)) {				
							result = true;														 
						} else {
							result = false;
							
						}
					}
						return result; //result		
	
			} 
			catch(Exception e) 
			{
				System.out.println("Implementation error in cath clouse");
				System.out.println(e.getMessage().toString());
				return false;
			}
	}
	
	//Add Driver Details
	@Override
	public void addDriver(String d_name, String v_number, String driver_username, String driver_password) throws RemoteException {
		// TODO Auto-generated method stub	
		try {
			
			String query="INSERT INTO `user` (`driver_name`,`vehicle_number`,`username`,`password`) VALUES (?,?,?,?) ";
			PreparedStatement pts=conn.prepareStatement(query);
			
			pts.setString(1, d_name);
			pts.setString(2, v_number);
			pts.setString(3, driver_username);
			pts.setString(4, driver_password);
						
			pts.executeUpdate();
			
			System.out.println("Sucssesfully added details to database");
			
		
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error with updating driver details");
			JOptionPane.showMessageDialog(null," Username is already exists !!!");
		}
	}
	
	//making a complain
	@Override
	public void addComplain(String sug) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			//complains
			
			String query="INSERT INTO `complains` (`complain`) VALUES (?) ";
			PreparedStatement pts=conn.prepareStatement(query);
			
			pts.setString(1, sug);						
			pts.executeUpdate();
			System.out.println("Sucssesfully made complain");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error with making complains");
			JOptionPane.showMessageDialog(null," Error !!!");
		}
			
	}

	
	@Override
	public ArrayList<String> taxi_complain() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String>get_complain=new ArrayList<String>();
		String arr[];
		arr=new String[2];
		try {
			String get_com="SELECT * FROM complains ";
	        PreparedStatement prt=conn.prepareStatement(get_com);
	        ResultSet rs=prt.executeQuery();
	               
	        while(rs.next())
	        {
	        	arr[0]=rs.getString("count");
	        	arr[1]=rs.getString("complain");
	        	
	        	get_complain.addAll(Arrays.asList(arr));

	        }
	        
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error with loading complains");
		}
		return get_complain;
	}
	
	@Override
	public String barChart() throws RemoteException {
		// TODO Auto-generated method stub
		String final_Url = null;

		//ArrayList<String>get_barChart=new ArrayList<String>();
		/**
		 * creating an array to get all data from db and initializing them to the variables
		 */
		
		String q1_1="",q1_2="",q1_3="",  q2_1="",q2_2="",q2_3="",q3_1="",q3_2="",q3_3="",
				q4_1="",q4_2="",q4_3="",q5_1="",q5_2="",q5_3="",q6_1="",q6_2="",q6_3="";		
		try {
			String sql1="SELECT * FROM `answers` ";
			PreparedStatement  pst=conn.prepareStatement(sql1);
			ResultSet rs=pst.executeQuery();
			
	        while(rs.next())
	        {
//	        	attempts=rs.getString(1);
	        	q1_1=rs.getString(2);
	        	q1_2=rs.getString(3);
	        	q1_3=rs.getString(4);
	        	
	        	q2_1=rs.getString(5);
	        	q2_2=rs.getString(6);
	        	q2_3=rs.getString(7);
	        	
	        	q3_1=rs.getString(8);
	        	q3_2=rs.getString(9);
	        	q3_3=rs.getString(10);
	        	
	        	q4_1=rs.getString(11);
	        	q4_2=rs.getString(12);
	        	q4_3=rs.getString(13);
	        	
	        	q5_1=rs.getString(14);
	        	q5_2=rs.getString(15);
	        	q5_3=rs.getString(16);
	        	
	        	q6_1=rs.getString(17);
	        	q6_2=rs.getString(18);
	        	q6_3=rs.getString(19);

	        }
	        
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error, with loading datato array");
		}
	        
		//Generating the Chart
		try 
		{
	    	//adding candidates names into a array
			ArrayList<String>question = new ArrayList<String>();
			question.add("Question_1");
			question.add("Question_2");
			question.add("Question_3");
			question.add("Question_4");
			question.add("Question_5");
			question.add("Question_6");
			
			//1st rating array
			
			ArrayList<String> rating_1 = new ArrayList<String>();
			rating_1.add(q1_1);
			rating_1.add(q2_1);
			rating_1.add(q3_1);
			rating_1.add(q4_1);
			rating_1.add(q5_1);
			rating_1.add(q6_1);

			//2nd rating array
			
			ArrayList<String> rating_2 = new ArrayList<String>();
			rating_2.add(q1_2);
			rating_2.add(q2_2);
			rating_2.add(q3_2);
			rating_2.add(q4_2);
			rating_2.add(q5_2);
			rating_2.add(q6_2);
			
			//3rd rating array
			ArrayList<String> rating_3 = new ArrayList<String>();
			rating_3.add(q1_3);
			rating_3.add(q2_3);
			rating_3.add(q3_3);
			rating_3.add(q4_3);
			rating_3.add(q5_3);
			rating_3.add(q6_3);
			
			//the chart url 
			System.setProperty("http.agent","Chrome");
			String ChartUrl = "https://quickchart.io/chart?width=400&height=300&c=";
			
			StringBuilder build_data = new StringBuilder();
		/**
		 * Reference is the quickchart.io web page chart online editor
		 * {type: 'bar', data: { labels: ['Q1', 'Q2', 'Q3', 'Q4'], datasets: [{ label: 'Users',  data: [50, 60, 70, 180]}, { label: 'Revenue', data: [100, 200, 300, 400]}] }}
		 * 
		 */
			/**
			 * Customizing the data to print the chart from  reference
			 */
			
			//data set to the label under the x axis
			
			int a=0;
			build_data.append("{type:'bar',data:{labels:[");
			for(String qust : question){
				build_data.append("\'" + qust + "\'");
				a++;
				if(a>0 && a<9)
				{
					build_data.append(",");
				}
			}
			
			// Data set to the rating 1
			
			int b=0;
			build_data.append("],datasets:[{label:'Rating_1',data:[");
			
			for (String rat_1 : rating_1 ){
				build_data.append(rat_1 + "");
				b++;
				if(b>0 && b<9)
				{
					build_data.append(",");
				}
			}
			
			// Data set to the rating 2
			int c=0;

			build_data.append("]},{label:'Rating_2',data:[");
			
			for(String rat_2 : rating_2)
			{
				build_data.append(rat_2 + "");
				c++;
				if(c>0 && c<9)
				{
					build_data.append(",");
				}
				
			}
			
			// Data set to the rating 3
			int d=0;
			build_data.append("]},{label:'Rating_3',data:[");
			
			for(String rat_3 : rating_3)
			{
				build_data.append(rat_3 + "");
				d++;
				if(d>0 && d<9)
				{
					build_data.append(",");
				}
				
			}			
					
			build_data.append("]}]}}");		
			String encodedURL = (build_data.toString());
			
			 final_Url = ChartUrl + encodedURL;
			 //Return the value to admin to disla the chart
		      
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error");
			
		} 
		
		return final_Url;
	}
	
	
	
}
