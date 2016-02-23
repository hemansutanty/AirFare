import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PassengerDetails extends JFrame implements ActionListener
{
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9,lab;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,tel;
	Container cn;
	JButton b;
	
	PassengerDetails() 
	{
		setTitle("boarding pass");
		cn=getContentPane();
		cn.setLayout(null);
		
		l1=new JLabel("Flight no:");l1.setBounds(10,10,100,30);cn.add(l1);
		t1=new JTextField(20);t1.setBounds(100,10,120,30);cn.add(t1);
		l2=new JLabel("Flight Name:");l2.setBounds(10,50,100,30);cn.add(l2);
		t2=new JTextField(20);t2.setBounds(100,50,120,30);cn.add(t2);
		l3=new JLabel("Source:");l3.setBounds(10,100,100,30);cn.add(l3);
		t3=new JTextField(20);t3.setBounds(100,100,120,30);cn.add(t3);
		l4=new JLabel("Destination:");l4.setBounds(260,100,100,30);cn.add(l4);
		t4=new JTextField(20);t4.setBounds(370,100,120,30);cn.add(t4);
		
		

		l5=new JLabel("Passenger Details:");l5.setBounds(230,150,200,70);cn.add(l5);
		l6=new JLabel("Name:");l6.setBounds(10,240,100,30);cn.add(l6);
		t6=new JTextField(20);t6.setBounds(100,240,120,30);cn.add(t6);
		l7=new JLabel("Age:");l7.setBounds(290,240,100,30);cn.add(l7);
		t7=new JTextField(20);t7.setBounds(330,240,120,30);cn.add(t7);
		l8=new JLabel("Gender:");l8.setBounds(10,280,100,30);cn.add(l8);
		t8=new JTextField(20);t8.setBounds(100,280,120,30);cn.add(t8);
		l9=new JLabel("Seats:");l9.setBounds(290,280,100,30);cn.add(l9);
		t9=new JTextField(20);t9.setBounds(330,280,120,30);cn.add(t9);
		lab=new JLabel("Ticket No:");lab.setBounds(10,300,200,70);cn.add(lab);
		tel=new JTextField(20);tel.setBounds(100,320,120,30);cn.add(tel);
		b=new JButton("Finish");b.setBounds(400,400,120,30);cn.add(b);
		b.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		setSize(600,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
	}	

	public static void main(String ar[])
	{
		new PassengerDetails();
	}
}

		
