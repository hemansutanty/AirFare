import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.rmi.*;
class PaymentOptions extends JFrame implements ActionListener,ItemListener
{	
	Container cn;
	JLabel mode_pay,card_no,total_amount;
	ButtonGroup mode;
	JRadioButton card,cash;
	JTextField card_not,total_amountt;
	JButton boarding_pass;
	String modes,cno,amt;
	int amtno;
	Airlines obj;
	int ticno;
	PaymentOptions(int tno)
	{	
		ticno=tno;
		setTitle("Payment Mode");
		cn=getContentPane();
		setLayout(null);
		mode_pay=new JLabel("Choose Mode of Payment");mode_pay.setBounds(170,20,300,30);cn.add(mode_pay);
		mode=new ButtonGroup();
		card= new JRadioButton("Card");card.setBounds(150,70,100,20);cn.add(card);
		card.addItemListener(this);
		cash= new JRadioButton("Cash");cash.setBounds(270,70,100,20);cn.add(cash);
		cash.addItemListener(this);
		mode.add(card);mode.add(cash);
		card_no=new JLabel("Card No:");card_no.setBounds(30,150,80,20);cn.add(card_no);card_no.setVisible(false);	
		card_not=new JTextField(100);card_not.setBounds(150,150,130,20);cn.add(card_not);card_not.setVisible(false);
		total_amount=new JLabel("Total Amount(Rs.):");total_amount.setBounds(30,200,120,20);cn.add(total_amount);total_amount.setVisible(false);
		total_amountt=new JTextField(100);total_amountt.setBounds(150,200,130,20);cn.add(total_amountt);total_amountt.setVisible(false);
		boarding_pass=new JButton("Boarding Pass");boarding_pass.setBounds(350,300,150,30);cn.add(boarding_pass);boarding_pass.setVisible(false);
		boarding_pass.addActionListener(this);
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
		setSize(600,600);
		setVisible(true);		
	}

	public void itemStateChanged(ItemEvent ie)
	{

		if(ie.getSource()==card)
		{
			modes="Card";
			card_no.setVisible(true);
			card_not.setVisible(true);
			total_amount.setVisible(true);
			total_amountt.setVisible(true);
			boarding_pass.setVisible(true);
		}
		
		if(ie.getSource()==cash)
		{
			modes="Cash";
			card_no.setVisible(false);
			card_not.setVisible(false);
			total_amount.setVisible(true);
			total_amountt.setVisible(true);
			boarding_pass.setVisible(true);
		}
	}
 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==boarding_pass)
		{
			try 	
			{
				cno = card_not.getText();
				amt = total_amountt.getText();
				amtno=Integer.parseInt(amt);
				if(modes=="Card")
				{obj.boardingDetails(ticno,amtno,modes,cno);}
				if(modes=="Cash")
				{obj.boardingDetails(ticno,amtno,modes);}			
				setVisible(false);
				new Passengerdetails(ticno);		
			} 
			catch(Exception e) 
			{System.out.println(e);}
					
		}
	}
	
}