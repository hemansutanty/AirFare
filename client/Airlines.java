import java.rmi.*;
interface Airlines extends Remote
{
	public String flightno(String src, String des)throws RemoteException;
	public int noOfSeats(String flightno)throws RemoteException;
	public int passengerDetails(String flight_no,String p_name,int p_age,String p_add,String p_gender,int seats_booked)throws RemoteException;
	public void boardingDetails(int ticket_no,int amount,String mode,String cardno)throws RemoteException;
	public void boardingDetails(int ticket_no,int amount,String mode)throws RemoteException;
	public String[] finalDetails(int ticket_no)throws RemoteException;
}
 