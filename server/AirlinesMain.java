import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.io.*;
class AirlinesMain extends UnicastRemoteObject implements Airlines
{
	String ss,dd,fno="",qry,qry2;
	int no_of_seats,maxt;
	Connection con;
	Statement st;
	ResultSet rs;
	String full[]= new String[9];
	
	AirlinesMain()throws RemoteException
	{
		System.out.println("server is ready");
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "password");
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:airlinepro","system","uctc");*/
			st=con.createStatement();
			System.out.println("After DB connetion");
		}catch(Exception ob){
			ob.printStackTrace();
		}
	}
	public String flightno(String src,String des)
	{
		ss=src;	dd=des;
		System.out.println("Hello Flightno");
		try
		{
		qry="SELECT * FROM flight  where SOURCE='"+ss+"' and DESTINATION='"+dd+"' ";
		rs=st.executeQuery(qry);
		if(rs.next())
		{fno=rs.getString("FLIGHTNO");}
		else
		{fno="No Flights Available";}
		}
		catch(SQLException aa)
		{System.out.println(aa);}		
		return fno;
	}
	public int noOfSeats(String flightno)
	{
		ss=flightno;
		try
		{
			qry="SELECT * FROM flight  where FLIGHTNO='"+ss+"' ";
			rs=st.executeQuery(qry);
			if(rs.next())
			{no_of_seats=rs.getInt("NOOFSEATS");}
			else
			{no_of_seats=0;}
		}
		catch(SQLException aa)
		{System.out.println(aa);}		
			return no_of_seats;
	}
	public int passengerDetails(String p_name,int p_age,String p_add,String p_gender,int seats_booked)
	{
		System.out.println("Working");
		try
		{
			qry2="SELECT MAX(TICKETNO) FROM passenger";
			rs=st.executeQuery(qry2);
			if(rs.next())
			{maxt=rs.getInt(1);}

			if(maxt==0)
			{maxt=5000;}
			maxt++;
			qry="INSERT INTO passenger values('"+p_name+"',"+p_age+",'"+p_add+"','"+p_gender+"',"+seats_booked+","+maxt+")";
			st.executeUpdate(qry);
		}
		catch(SQLException abd)
		{System.out.println(abd);}
		return maxt;
	}
	public void boardingDetails(int ticket_no,int amount,String mode,String cardno)
	{
		System.out.println("Working");
		try
		{
			qry="INSERT INTO payment values("+ticket_no+","+amount+",'"+mode+"','"+cardno+"')";
			st.executeUpdate(qry);
		}
		catch(SQLException abe)
		{System.out.println(abe);}
		
	}
	public void boardingDetails(int ticket_no,int amount,String mode)
	{
		System.out.println("Working");
		try
		{
			qry="INSERT INTO payment values("+ticket_no+","+amount+",'"+mode+"')";
			st.executeUpdate(qry);
		}
		catch(SQLException abf)
		{System.out.println(abf);}
			
	}
	public String[] finalDetails(int ticket_no)
	{
		
		full[0]=fno;
		try
		{
			qry="SELECT * FROM flight  where FLIGHTNO='"+fno+"'";
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				full[1]=rs.getString("FLIGHTNAME");
				full[2]=rs.getString("SOURCE");
				full[3]=rs.getString("DESTINATION");
			}
			qry="SELECT * FROM PASSENGER where TICKETNO='"+ticket_no+"'";
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				full[4]=rs.getString("PASSENGERNAME");
				full[5]=rs.getString("PASSENGERAGE");
				full[6]=rs.getString("PASSENGERGENDER");
				full[7]=rs.getString("SEATSBOOKED");
				full[8]=rs.getString("TICKETNO");
				
			}
		}
		catch(SQLException aa)
		{System.out.println(aa);}
		return full;
		
			
	}
	public static void main(String ar[])
	{
		
		String name ="Airlines";
		/*if (System.getSecurityManager() == null) {
    		System.setSecurityManager(new SecurityManager());
		}*/
		try
		{
			
			/*Airlines engine = new AirlinesMain();
			Airlines stub =(Airlines) UnicastRemoteObject.exportObject(engine, 0);*/
			AirlinesMain obj=new AirlinesMain();
			Naming.rebind("AirlinesAction",obj);
			/*Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("AirlinesMain bound");
            */
		}
		catch(Exception aaa)
		{System.out.println(aaa);}
	}
}
