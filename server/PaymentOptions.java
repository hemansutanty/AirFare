import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class PaymentOptions extends JFrame implements ActionListener
{	
	Container cn;
	JLabel mode_pay,card_no,total_amount;
	ButtonGroup mode;
	JRadioButton card,cash;
	JTextField card_not,total_amountt;
	JButton boarding_pass;
	PaymentOptions()
	{	
		setTitle("Payment Mode");
		cn=getContentPane();
		setLayout(null);
		mode_pay=new JLabel("Choose Mode of Payment");mode_pay.setBounds(170,20,300,30);cn.add(mode_pay);
		mode=new ButtonGroup();
		card= new JRadioButton("Card");card.setBounds(150,70,100,20);cn.add(card);
		cash= new JRadioButton("Cash");cash.setBounds(270,70,100,20);cn.add(cash);
		mode.add(card);mode.add(cash);
		card_no=new JLabel("Card No:");card_no.setBounds(30,150,80,20);cn.add(card_no);	
		card_not=new JTextField(100);card_not.setBounds(150,150,130,20);cn.add(card_not);
		total_amount=new JLabel("Total Amount(Rs.):");total_amount.setBounds(30,200,120,20);cn.add(total_amount);
		total_amountt=new JTextField(100);total_amountt.setBounds(150,200,130,20);cn.add(total_amountt);
		boarding_pass=new JButton("Boarding Pass");boarding_pass.setBounds(350,300,150,30);cn.add(boarding_pass);
		boarding_pass.addActionListener(this);
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
		if(ae.getSource()==boarding_pass)
		setVisible(false);
		new PassengerDetails();
	}
	
	public static void main(String args[])
	{
		new PaymentOptions();

	}
}