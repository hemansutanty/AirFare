import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
class CheckSeats extends JFrame implements ActionListener
{
	JLabel source,destination,flight_no,available_seats;
	JComboBox sourcec,destinationc;
	JButton get_seat,next,go_back,cancel;
	String aa[]={"","New York","London","Paris"};
	Container cn;
	String des_string,source_string,fno,seat;
	int seatno;
	Airlines obj;
	CheckSeats()
	{
		setTitle("Check For Seats ");
		cn=getContentPane();
		cn.setLayout(null);
		
		source=new JLabel("Source:");source.setBounds(30,30,150,20);cn.add(source);
		sourcec=new JComboBox(aa);sourcec.setBounds(130,30,120,20);cn.add(sourcec);
		sourcec.addActionListener(this);
		destination=new JLabel("Destination:");destination.setBounds(30,80,150,20);cn.add(destination);
		destinationc=new JComboBox(aa);destinationc.setBounds(130,80,120,20);cn.add(destinationc);
		destinationc.addActionListener(this);
		flight_no=new JLabel("Flight No:");flight_no.setBounds(30,130,200,20);cn.add(flight_no);
		flight_no.setVisible(false);
		get_seat=new JButton("Get Seat");get_seat.setBounds(300,130,100,20);cn.add(get_seat);
		get_seat.addActionListener(this);get_seat.setVisible(false);		
		available_seats=new JLabel("Available Seats:");available_seats.setBounds(30,180,250,20);cn.add(available_seats);available_seats.setVisible(false);
		go_back=new JButton("Go Back");go_back.setBounds(100,300,90,20);cn.add(go_back);
		go_back.addActionListener(this);
		cancel=new JButton("Cancel");cancel.setBounds(210,300,80,20);cn.add(cancel);
		cancel.addActionListener(this);cancel.setVisible(false);
		next=new JButton("Next");next.setBounds(320,300,80,20);cn.add(next);
		next.addActionListener(this);next.setVisible(false);	
		
		 /*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
		try
		{
			/*String name = "Airlines";
            Registry registry = LocateRegistry.getRegistry("localhost");*/
            obj = (Airlines)Naming.lookup("AirlinesAction");
            System.out.println(obj);
		}
		catch(Exception ade)
		{System.out.println(ade);}
	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent ae)
			{System.exit(0);}
		});

		setSize(600,400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==sourcec)
		{
			source_string=(String)sourcec.getSelectedItem();
		}
		if(ae.getSource()==destinationc)
		{
			des_string=(String)destinationc.getSelectedItem();
			if(source_string!=""&&des_string!="")
			{
				try
				{
	
					fno=obj.flightno(source_string,des_string);
					System.out.println(fno);
					flight_no.setVisible(true);get_seat.setVisible(true);cancel.setVisible(true);next.setVisible(true);
					flight_no.setText("Flight No:           "+fno);
					System.out.println(fno);
				}
				catch(Exception abc)
				{System.out.println(abc);}		
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please select both Source and Destination!","Input Error",JOptionPane.PLAIN_MESSAGE);
			}
			
		}
				
		if(ae.getSource()==get_seat)
		{
			try {
				seatno =obj.noOfSeats(fno);
				seat = String.valueOf(seatno);	
				available_seats.setText("Available Seats:           "+seat);
				available_seats.setVisible(true);
				System.out.println(seat);
			}
			catch(Exception ab)
			{System.out.println(ab);}
		}
		if(ae.getSource()==go_back)
		{
			setVisible(false);
			new Welcome();
		}
		if(ae.getSource()==cancel)
		{
			flight_no.setVisible(false);get_seat.setVisible(false);cancel.setVisible(false);next.setVisible(false);available_seats.setVisible(false);
			sourcec.setSelectedItem("");
			destinationc.setSelectedItem("");
		}
		if(ae.getSource()==next)
		{
			setVisible(false);
			new Customer(fno);
		}		
	
	}
	public static void main(String ar[])
	{
		new CheckSeats();
	}
}
