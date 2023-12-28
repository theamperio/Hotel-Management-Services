package hotel.managment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import net.proteanit.sql.DbUtils;



public class Room extends JFrame implements ActionListener
{
	JButton  back;
	JTable table;
	JLabel roomno,availabilty,cleaning_stuts,price,bed_type;
	
	public Room()
	{
		getContentPane().setBackground(Color.black);
		setLayout(null);
		
		JLabel data = new JLabel("Room Deatils");
		data.setBounds(370,20,150,30);
		data.setFont(new Font("Raleway",Font.BOLD,20));
		data.setForeground(Color.white);
		add(data);
		
		roomno = new JLabel("Room Deatils");
		roomno.setBounds(80,70,80,30);
		roomno.setForeground(Color.white);
		add(roomno);
		
		availabilty = new JLabel("Availabilty");
		availabilty.setBounds(230,70,80,30);
		availabilty.setForeground(Color.white);
		add(availabilty);
		
		cleaning_stuts = new JLabel("Cleaning Status");
		cleaning_stuts.setBounds(360,70,90,30);
		cleaning_stuts.setForeground(Color.white);
		add(cleaning_stuts);
		
		
		price = new JLabel("Price");
		price.setBounds(520,70,90,30);
		price.setForeground(Color.white);
		add(price);
		
		bed_type = new JLabel("Bed Type");
		bed_type.setBounds(650,70,90,30);
		bed_type.setForeground(Color.white);
		add(bed_type);
		
		
		
		table = new JTable();
		table.setBounds(60,100,700,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setFont(new Font("Raleway",Font.BOLD,14));
		add(table);
		
		try 
		{
			Conn con = new Conn();
			
			ResultSet rs = con.stmt.executeQuery("select * from rooms");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch(SQLException e)
		{
			
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(280,350,120,30);
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.addActionListener(this);
		table.add(back);
		
		
		setBounds(280,130,900,550);
		setVisible (true);
	}
		
		public void actionPerformed(ActionEvent ae)
		{
			setVisible(false);
			new Reception();
		}
		
	
	public static void main(String[] args) 
	{
		new Room();

	}

}
