package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Addcustomer extends JFrame implements ActionListener
{
	JComboBox tfid ;
	JTextField tfnum,tfname,tfcountry,tfdeposit;
	JRadioButton rbmale,rbfemale;
	Choice croom;
	JLabel checktime;
	JButton add,back;
	
	public Addcustomer()
	{
		getContentPane().setBackground(Color.GRAY);
	
	
		JLabel label = new JLabel("Customer Form");
		label.setBounds(280,20,300,40);
		label.setFont(new Font("Raleway",Font.BOLD,30));
		add(label);
		
		
		JLabel jlid = new JLabel("Customer I'D");
		jlid.setBounds(230,80,150,30);
		jlid.setFont(new Font("Raleway",Font.BOLD,15));
		add(jlid);
		
		String str[] = {"Passport","Aadhar card","Driveing License","Voter-ID card"};
		tfid = new JComboBox(str);
		tfid.setBackground(Color.white);
		tfid.setBounds(380,80,150,30);
		add(tfid);
		
		JLabel jlnum = new JLabel("I'D Number");
		jlnum.setBounds(230,130,150,30);
		jlnum.setFont(new Font("Raleway",Font.BOLD,15));
		add(jlnum);
		
		tfnum = new JTextField();
		tfnum.setBounds(380,130,150,30);
		add(tfnum);
		
		JLabel jlname = new JLabel("Customer Name");
		jlname.setBounds(230,180,150,30);
		jlname.setFont(new Font("Raleway",Font.BOLD,15));
		add(jlname);
		
		tfname = new JTextField();
		tfname.setBounds(380,180,150,30);
		add(tfname);
		
		JLabel jlgender = new JLabel("Gender");
		jlgender.setBounds(230,230,150,30);
		jlgender.setFont(new Font("Raleway",Font.BOLD,15));
		add(jlgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(380,230,70,30);
		rbmale.setFont(new Font("Tahoma", Font.BOLD,14));
		rbmale.setBackground(Color.gray);
		rbmale.setForeground(Color.black);
		add(rbmale);
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(450,230,90,30);
		rbfemale.setFont(new Font("Tahoma", Font.BOLD,14));
		rbfemale.setBackground(Color.gray);
		rbfemale.setForeground(Color.black);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel jlcountry = new JLabel("Country");
		jlcountry.setBounds(230,270,150,30);
		jlcountry.setFont(new Font("Raleway",Font.BOLD,15));
		add(jlcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(380,270,150,30);
		add(tfcountry);
		
		JLabel jlcroom = new JLabel("Room Allocated");
		jlcroom .setBounds(230,320,150,30);
		jlcroom .setFont(new Font("Raleway",Font.BOLD,15));
		add(jlcroom );
		
		croom = new Choice();
		try 
		{
			Conn conn = new Conn();
			
			String query = "select * from rooms";
			ResultSet rs = conn.stmt.executeQuery(query);
			
			while(rs.next())
			{
				croom.add(rs.getString("roomno"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		croom.setBounds(380,320,150,40);
		add(croom);
		
		
		JLabel jltime = new JLabel("Check-in Time");
		jltime.setBounds(230,370,150,30);
		jltime.setFont(new Font("Raleway",Font.BOLD,15));
		add(jltime);
		
		Date date = new Date();
		
		checktime = new JLabel(""+date);
		checktime.setBounds(380,370,150,30);
		checktime.setFont(new Font("Raleway",Font.BOLD,15));
		add(checktime);
		
		JLabel jldeposit = new JLabel("Deposit");
		jldeposit.setBounds(230,420,150,30);
		jldeposit.setFont(new Font("Raleway",Font.BOLD,15));
		add(jldeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(380,420,150,30);
		add(tfdeposit);
		
		add = new JButton("ADD");
		add.setBounds(240,470,100,30);
		add.setBackground(Color.white);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Cancel");
		back.setBounds(400,470,100,30);
		back.setBackground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		setLayout(null);
		setBounds(280,130,800,570);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add)
		{
			String id = (String)tfid.getSelectedItem();
			String idnum = tfnum.getText();
			String name = tfname.getText();
			String country = tfcountry.getText();
			String deposit = tfdeposit.getText();
			String gender = null;
			if(rbmale.isSelected())
			{
				gender = "male";
			}
			else
			{
				gender = "female";
			}
			
			String room = croom.getSelectedItem();
			String time= checktime.getText();
			
			try
			{
				Conn con = new Conn();
				
				String query = "insert into customers values('"+id+"','"+idnum+"','"+name+"','"+country+"','"+deposit+"','"+gender+"','"+room+"','"+time+"')";
				String query2 = "update rooms set availabilty = 'occuied' where roomno = '"+room+"'";
				con.stmt.executeUpdate(query);
				con.stmt.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"Added Customer successfully");
				setVisible(false);
				
				new Reception();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		else if (ae.getSource() == back)
		{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args)
	{
		new Addcustomer();

	}

}
