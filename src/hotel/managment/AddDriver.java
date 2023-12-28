package hotel.managment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener
{

	JTextField tfname,tfage,tfcampony,tfmodel,tflocation;
	JComboBox jbgender,jbavail;
	JButton add,cancel;
	
	public AddDriver()
	{
		JLabel addroom = new JLabel("Add Drivers");
		addroom.setBounds(360,20,200,60);
		addroom.setForeground(Color.white);
		addroom.setFont(new Font("Railway",Font.BOLD,30));
		add(addroom);
		
		JLabel jlname = new JLabel("Name");
		jlname.setBounds(280,100,120,30);
		jlname.setForeground(Color.white);
		jlname.setFont(new Font("Railway", Font.BOLD,17));
		add(jlname);
		
		tfname = new JTextField();
		tfname.setBounds(450,100,150,30);
		tfname.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfname);
		
		JLabel jlavailable = new JLabel("Age");
		jlavailable.setBounds(280,140,120,30);
		jlavailable.setForeground(Color.white);
		jlavailable.setFont(new Font("Railway",Font.BOLD,17));
		add(jlavailable);
		
		tfage = new JTextField();
		tfage.setBounds(450,140,150,30);
		tfage.setBackground(Color.white);
		tfage.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfage);
		
		JLabel jlgender = new JLabel("Gender");
		jlgender.setBounds(280,180,120,30);
		jlgender.setForeground(Color.white);
		jlgender.setFont(new Font("Railway",Font.BOLD,17));
		add(jlgender);
		
		String	clea[] = {"Male","Female"};
		jbgender = new JComboBox(clea);
		jbgender.setBounds(450,180,150,30);
		jbgender.setBackground(Color.white);
		add(jbgender);
		
		JLabel jlcompany = new JLabel("Car Company");
		jlcompany.setBounds(280,220,120,30);
		jlcompany.setForeground(Color.white);
		jlcompany.setFont(new Font("Railway", Font.BOLD,17));
		add(jlcompany);
		
		tfcampony = new JTextField();
		tfcampony.setBounds(450,220,150,30);
		tfcampony.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfcampony);
		
		JLabel jlmodel = new JLabel("Car Model");
		jlmodel.setBounds(280,260,120,30);
		jlmodel.setForeground(Color.white);
		jlmodel.setFont(new Font("Railway", Font.BOLD,17));
		add(jlmodel);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(450,260,150,30);
		tfmodel.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfmodel);
		
		JLabel jlavail = new JLabel("Availablity");
		jlavail.setBounds(280,300,120,30);
		jlavail.setForeground(Color.white);
		jlavail.setFont(new Font("Railway",Font.BOLD,17));
		add(jlavail);
		
		String	avail[] = {"Available","Occupied"};
		jbavail = new JComboBox(avail);
		jbavail.setBounds(450,300,150,30);
		jbavail.setBackground(Color.white);
		add(jbavail);
		
		JLabel jllocation = new JLabel("Location");
		jllocation.setBounds(280,340,120,30);
		jllocation.setForeground(Color.white);
		jllocation.setFont(new Font("Railway", Font.BOLD,17));
		add(jllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(450,340,150,30);
		tflocation.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tflocation);
		
		add = new JButton("ADD");
		add.setBounds(310,400,100,30);
		add.setBackground(Color.white);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(470,400,100,30);
		cancel.setBackground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("siixth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,550,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,550);
		add(image);
		
		setLayout(null);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		setBounds(280,130,900,550);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add)
		{
			String name = tfname.getText();
			String age = tfage.getText();
			String company = tfcampony.getText();
			String model = tfmodel.getText();
			String location = tflocation.getText();
			String gender = (String)jbgender.getSelectedItem();
			String available =(String)jbavail.getSelectedItem();
			
	
			try
			{
				Conn con = new Conn();
				
				String query = "insert into drivers values('"+name+"','"+age+"','"+company+"','"+model+"','"+location+"','"+gender+"','"+available+"')";
				
				con.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Added Driver successfully");
				setVisible(false);
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource() == cancel)
		{
			setVisible(false);
		}
	}

	public static void main(String[] args)
	{
		new AddDriver();
	}

}
