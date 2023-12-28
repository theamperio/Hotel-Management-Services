package hotel.managment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Customer extends JFrame implements ActionListener
{
	JLabel id,idnum,name,country,deposit,gender,room,time;
	JTable table;
	JButton back;
	public Customer()
	{
		getContentPane().setBackground(Color.black);
		JLabel j1 = new JLabel("Customer Deatils");
		j1.setBounds(370,20,250,30);
		j1.setFont(new Font("Raleway",Font.BOLD,20));
		j1.setForeground(Color.white);
		add(j1);
		
		
		id = new JLabel("Identity");
		id.setBounds(90,70,80,30);
		id.setForeground(Color.white);
		id.setFont(new Font("Raleway",Font.BOLD,13));
		add(id);
		
		
		idnum = new JLabel("ID number");
		idnum.setBounds(200,70,80,30);
		idnum.setForeground(Color.white);
		idnum.setFont(new Font("Raleway",Font.BOLD,13));
		add(idnum);
		
		name = new JLabel("Name");
		name.setBounds(310,70,80,30);
		name.setForeground(Color.white);
		name.setFont(new Font("Raleway",Font.BOLD,13));
		add(name);

		
		country = new JLabel("Country");
		country.setBounds(420,70,80,30);
		country.setForeground(Color.white);
		country.setFont(new Font("Raleway",Font.BOLD,13));
		add(country);
		
		deposit = new JLabel("Deposit");
		deposit.setBounds(530,70,80,30);
		deposit.setForeground(Color.white);
		deposit.setFont(new Font("Raleway",Font.BOLD,13));
		add(deposit);
		
		gender = new JLabel("Gender");
		gender.setBounds(640,70,80,30);
		gender.setForeground(Color.white);
		gender.setFont(new Font("Raleway",Font.BOLD,13));
		add(gender);
		
		room = new JLabel("Room NO");
		room.setBounds(750,70,80,30);
		room.setForeground(Color.white);
		room.setFont(new Font("Raleway",Font.BOLD,13));
		add(room);
		
		time = new JLabel("Check-in");
		time.setBounds(860,70,80,30);
		time.setForeground(Color.white);
		time.setFont(new Font("Raleway",Font.BOLD,13));
		add(time);
		
		table = new JTable();
		table.setBounds(60,110,900,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setFont(new Font("Raleway",Font.BOLD,12));
		add(table);
		
		try 
		{
			Conn con = new Conn();
			
			ResultSet rs = con.stmt.executeQuery("select * from customers");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch(SQLException e)
		{
			
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(360,350,120,30);
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.addActionListener(this);
		table.add(back);
		
		
		setLayout(null);
		setBounds(280,130,1000,550);
		setVisible (true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args)
	{
		new Customer();
	}

}
