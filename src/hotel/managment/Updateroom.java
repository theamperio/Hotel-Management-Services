package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Updateroom extends JFrame implements ActionListener
{
  Choice custom;
  JTextField tfroom,tfavailable,tfclean,tfpaid,tfpending;
  JButton back,check,update;
	public Updateroom() 
	{
		getContentPane().setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel head = new JLabel("Update Room Status");
		head.setBounds(290,20,250,30);
		head.setFont(new Font("Raleway",Font.BOLD,20));
		head.setForeground(Color.white);
		add(head);
		
		JLabel jlid = new JLabel("Customer ID");
		jlid.setBounds(210,90,100,30);
		jlid.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlid);
		
		custom = new Choice();
		custom.setBounds(350,90,120,30);
		add(custom);
		
		try
		{
			Conn con = new Conn();
			ResultSet rs = con.stmt.executeQuery("select * from customers");
			while(rs.next())
			{
				custom.add(rs.getString("idnum"));
			}
		}
		catch (SQLException e)
		{			
			e.printStackTrace();
		}
		
		JLabel jlavailable = new JLabel("Availablity");
		jlavailable.setBounds(210,150,100,30);
		jlavailable.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlavailable);
		
		tfavailable = new JTextField();
		tfavailable.setBounds(350,150,120,25);
		add(tfavailable);
		
		JLabel jlroom = new JLabel("Room no");
		jlroom.setBounds(210,210,100,30);
		jlroom.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(350,210,120,25);
		add(tfroom);
		
		JLabel jlclean = new JLabel("Cleaning Status");
		jlclean .setBounds(210,270,120,30);
		jlclean .setFont(new Font("Raleway",Font.BOLD,14));
		add(jlclean );
		
		tfclean = new JTextField();
		tfclean.setBounds(350,270,120,25);
		add(tfclean);
		
		check = new JButton("Check");
		check.setBounds(260,320,100,30);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBounds(380,320,100,30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(310,370,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setBounds(280,130,750,450);
		setVisible (true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== back)
		{
			setVisible(false);
			new Reception();
		}
		else if(ae.getSource() == check)
		{
			String id = custom.getSelectedItem();
			
			try {
				Conn con = new Conn();
				String query = "select * from customers where idnum = '"+id+"'";
				
				ResultSet rs = con.stmt.executeQuery(query);
				
				while(rs.next())
				{
					tfroom.setText(rs.getString("room"));
					
				}
				
				ResultSet rs2 = con.stmt.executeQuery("select * from rooms where roomno = '"+tfroom.getText()+"'");
				
				while(rs2.next())
				{
					tfavailable.setText(rs2.getString("availabilty"));
					tfclean.setText(rs2.getString("cleaning_stuts"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else if (ae.getSource() == update)
		{
			String number = custom.getSelectedItem();
			String room = tfroom.getText();
			String available = tfavailable.getText();	
			String clean = tfclean.getText();
		 try {
			Conn conn = new Conn ();
			conn.stmt.executeUpdate("update rooms set availabilty = '"+available+"',cleaning_stuts = '"+clean+"' where roomno ='"+room+"'");
			
			JOptionPane.showMessageDialog(null,"Data Updated");
			setVisible(false);
			new Reception();
		} 
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		}
		}
	}

	public static void main(String[] args) 
	{
		new Updateroom();

	}

}
