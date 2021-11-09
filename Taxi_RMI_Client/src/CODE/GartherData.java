/**
 * 
 */
package CODE;
import java.rmi.Naming;
import GUI.Answers;
/**
 * @author Uditha Nayanajith
 *
 */
public class GartherData  {       
	
	
	public static void main(String[] args) {
		
		//sending captured data to data base;
		
		try {
			
			Taxi_Remote_Interface send_data =(Taxi_Remote_Interface) Naming.lookup("rmi://127.0.0.1:2020/TaxiService2020");	
			
			int q1_1=Answers.getQ1_1();
			int q1_2=Answers.getQ1_2();
			int q1_3=Answers.getQ1_3();
			
			int q2_1=Answers.getQ2_1();
			int q2_2=Answers.getQ2_2();
			int q2_3=Answers.getQ2_3();
			
			int q3_1=Answers.getQ3_1();
			int q3_2=Answers.getQ3_2();
			int q3_3=Answers.getQ3_3();
			
			int q4_1=Answers.getQ4_1();
			int q4_2=Answers.getQ4_2();
			int q4_3=Answers.getQ4_3();
			
			int q5_1=Answers.getQ5_1();
			int q5_2=Answers.getQ5_2();
			int q5_3=Answers.getQ5_3();
			
			int q6_1=Answers.getQ6_1();
			int q6_2=Answers.getQ6_2();
			int q6_3=Answers.getQ6_3();
			

			System.out.println("\n");
			
			send_data.addAnswer(q1_1, q1_2, q1_3, q2_1, q2_2, q2_3, q3_1, q3_2, q3_3, q4_1, q4_2, q4_3, q5_1, q5_2, q5_3, q6_1, q6_2, q6_3);

			
		} catch (Exception e1) {

			e1.printStackTrace();
			System.out.println("Error: "+e1.toString());
			
			
		}
		
		
		

	}

}
