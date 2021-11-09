/**
 * 
 */
package CODE;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 * @author Uditha Nayanajith
 *
 */
public interface Taxi_Remote_Interface extends Remote  {
	/**
	 * Retrieve specific question from the server. 
	 * @param i number of the question. 
	 * @return the Question. 
	 * @throws RemoteException
	 */

	public void addAnswer(int q1_1,int q1_2,int q1_3,int q2_1,int q2_2,int q2_3,int q3_1,int q3_2,int q3_3,int q4_1,int q4_2,int q4_3,int q5_1,int q5_2,int q5_3,int q6_1,int q6_2,int q6_3) throws RemoteException;
	public boolean driverLogin(String username,String password) throws RemoteException;
	public void addComplain(String sug) throws RemoteException; 
	public void addDriver(String d_name,String v_number,String driver_username,String driver_password) throws RemoteException;
	public ArrayList<String>taxi_complain() throws RemoteException;
	public String barChart() throws RemoteException;
	
	
}
