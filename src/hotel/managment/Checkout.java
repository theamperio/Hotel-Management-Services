package hotel.managment;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Checkout extends JFrame implements ActionListener
{
	Choice custom;
	JLabel tfroom,jlin,jlout;
	JButton checkout,back;
	public Checkout()
	{
		getContentPane().setBackground(Color.black);
		setLayout(null);
		
		JLabel head = new JLabel("Check-Out");
		head.setBounds(320,20,150,30);
		head.setForeground(Color.white);
		head.setFont(new Font("Raleway",Font.BOLD,20));
		add(head);
		
		JLabel jlid = new JLabel("Customer I'd");
		jlid.setBounds(250,70,100,30);
		jlid.setForeground(Color.white);
		jlid.setFont(new Font("Raleway",Font.BOLD,12));
		add(jlid);
		
		custom = new Choice();
		custom.setBounds(370,70,120,30);
		add(custom);
		
		JLabel jlroom = new JLabel("Room No");
		jlroom.setBounds(250,130,100,30);
		jlroom.setForeground(Color.white);
		jlroom.setFont(new Font("Raleway",Font.BOLD,12));
		add(jlroom);
		
		tfroom = new JLabel();
		tfroom.setBounds(370,130,120,25);
		tfroom.setForeground(Color.white);
		tfroom.setFont(new Font("Raleway",Font.BOLD,12));
		add(tfroom);
		
		JLabel jlcheckin = new JLabel("Check-In");
		jlcheckin.setBounds(250,190,100,30);
		jlcheckin.setForeground(Color.white);
		jlcheckin.setFont(new Font("Raleway",Font.BOLD,12));
		add(jlcheckin);
		
		jlin = new JLabel();
		jlin.setBounds(370,190,150,25);
		jlin.setForeground(Color.white);
		jlin.setFont(new Font("Raleway",Font.BOLD,12));
		add(jlin);
		
		Date date = new Date();
		JLabel jlcheckout = new JLabel("Check-Out");
		jlcheckout.setBounds(250,250,100,30);
		jlcheckout.setForeground(Color.white);
		jlcheckout.setFont(new Font("Raleway",Font.BOLD,12));
		add(jlcheckout);
		
		jlout = new JLabel(""+date);
		jlout.setForeground(Color.white);
		jlout.setFont(new Font("Raleway",Font.BOLD,12));
		jlout.setBounds(370,250,150,25);
		add(jlout);
		
		checkout = new JButton("Check-Out");
		checkout.setBounds(260,300,100,30);
		checkout.setForeground(Color.black);
		checkout.setBackground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
		back.setBounds(390,300,100,30);
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
		
		try
		{
			Conn con = new Conn();
			ResultSet rs = con.stmt.executeQuery("select * from customers");
			while(rs.next())
			{
				custom.add(rs.getString("idnum"));
				tfroom.setText(rs.getString("room"));
				jlin.setText(rs.getString("time"));
			}
		}
		catch (SQLException e)
		{			
			e.printStackTrace();
		}
		
		setBounds(300,200,800,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Reception();
		}
		else
		{
			String q1 = "delete from customers where idnum = '"+custom.getSelectedItem()+"'";
			String q2 = "update rooms set availabilty = 'Available' where roomno = '"+tfroom.getText()+"'";
			
			try {
				Conn con = new Conn();
				con.stmt.executeUpdate(q1);
				con.stmt.executeUpdate(q2);
				
				JOptionPane.showMessageDialog(null, "Check Out");
				
				
			} catch (SQLException e) {


				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		new Checkout();

	}

}
