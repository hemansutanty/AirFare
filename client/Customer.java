import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
class Customer extends JFrame implements ActionListener,ItemListener
{
	JLabel sr,nm,ag,addr,gen;
	JTextField nm1,ag1,addr1;
	JComboBox m1;
	JRadioButton r1,r2;
	ButtonGroup r3;
	JButton b1;
	String aa[]={"","1","2","3","4","5"},passname,passadd,passgen,sb,flight_no;
	int seatbook,passage,tno;
	Container cn;
	Airlines obj;
	
	Customer(String flightno)
	{
		setTitle("customer detail entry");
		cn=getContentPane();
		cn.setLayout(null);
		flight_no = flightno;
		sr=new JLabel("Seats Required:");sr.setBounds(10,10,150,30);cn.add(sr);
		m1=new JComboBox(aa);m1.setBounds(110,10,100,30);cn.add(m1);
		m1.addActionListener(this);
		nm=new JLabel("Name:");nm.setBounds(30,60,80,30);cn.add(nm);
		nm1=new JTextField(20);nm1.setBounds(110,65,150,30);cn.add(nm1);
		ag=new JLabel("Age:");ag.setBounds(30,110,80,30);cn.add(ag);
		ag1=new JTextField(20);ag1.setBounds(110,110,150,30);cn.add(ag1);
		addr=new JLabel("Address:");addr.setBounds(30,160,120,30);cn.add(addr);
		addr1=new JTextField(20);addr1.setBounds(110,160,150,30);cn.add(addr1);
		gen=new JLabel("Gender:");gen.setBounds(30,210,80,30);cn.add(gen);
		r3=new ButtonGroup();
		r1=new JRadioButton("Male");r1.setBounds(120,210,100,30);cn.add(r1);
		r2=new JRadioButton("Female");r2.setBounds(230,210,200,30);cn.add(r2);
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.add(r1);r3.add(r2);
		b1=new JButton("Paynow");b1.setBounds(280,300,100,30);cn.add(b1);
		b1.addActionListener(this);
		/*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
		try
		{
			obj=(Airlines)Naming.lookup("AirlinesAction");
			/*String name = "Airlines";
            Registry registry = LocateRegistry.getRegistry("localhost");
            Airlines comp = (Airlines) registry.lookup(name);*/
		}
		catch(Exception ade)
		{System.out.println(ade);}
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		setSize(600,400);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent ie) {
                                             
		if(ie.getSource() == r1) 
        {passgen = "Male";  }
		if(ie.getSource() == r2) 
        {passgen = "Female";    }
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==b1) 
		{
			try {
				passname = nm1.getText();
				passage = Integer.parseInt(ag1.getText());
				passadd = addr1.getText();
				sb = (String)m1.getSelectedItem();
				seatbook = Integer.parseInt(sb);
				tno=obj.passengerDetails(flight_no,passname,passage,passadd ,passgen,seatbook);
				setVisible(false);
				new PaymentOptions(tno);
			} catch(Exception e) {System.out.println(e);}

		}
		
	}

	/*public static void main(String ar[])
	{
		new Customer();
	}*/
}

	