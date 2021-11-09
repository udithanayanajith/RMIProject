package Taxi_Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import CODE.Taxi_Remote_Interface;

public class Taxi_server {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		System.out.println("Starting The Server............!!!");
		try {
			Taxi_Remote_Interface rmt_intface=new Taxi_Implementation();
			Registry taxi_reg=LocateRegistry.createRegistry(2020);
			taxi_reg.rebind("TaxiService2020", rmt_intface);
			
			System.out.println("Taxi Server started,Taxi Service is running now....!");
			
		} catch (RemoteException e) {
			// TODO: handle exception
			System.out.println("Error....!!!"+e.toString());
			e.printStackTrace();
		}
	}

}
