package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;



public class SearchRoom extends JFrame implements ActionListener
{
	JCheckBox available;
	JButton  back,submit;
	JTable table;
	JLabel roomno,availabilty,cleaning_stuts,price,beddtype,type;
	JComboBox bedtype;
	
	public SearchRoom()
	{
		getContentPane().setBackground(Color.black);
		setLayout(null);
		
		JLabel data = new JLabel("Search Room");
		data.setBounds(370,20,150,30);
		data.setFont(new Font("Raleway",Font.BOLD,20));
		data.setForeground(Color.white);
		add(data);
		
		type = new JLabel("Bed type");
		type.setBounds(60,80,80,30);
		type.setForeground(Color.white);
		type.setFont(new Font("Ralewy",Font.BOLD,13));
		add(type);
		
		String str[] = {"Single Bed","Dobule Bed"};
		bedtype = new JComboBox(str);
		bedtype.setBounds(150,80,150,25);
		bedtype.setBackground(Color.white);
		add(bedtype);
		
		available = new JCheckBox("Only Dispaly Available");
		available.setBounds(650,80,150,25);
		available.setBackground(Color.black);
		available.setForeground(Color.white);
		add(available);
		
		roomno = new JLabel("Room Deatils");
		roomno.setBounds(80,130,80,30);
		roomno.setForeground(Color.white);
		add(roomno);
		
		availabilty = new JLabel("Availabilty");
		availabilty.setBounds(230,130,80,30);
		availabilty.setForeground(Color.white);
		add(availabilty);
		
		cleaning_stuts = new JLabel("Cleaning Status");
		cleaning_stuts.setBounds(360,130,90,30);
		cleaning_stuts.setForeground(Color.white);
		add(cleaning_stuts);
		
		
		price = new JLabel("Price");
		price.setBounds(520,130,90,30);
		price.setForeground(Color.white);
		add(price);
		
		beddtype = new JLabel("Bed Type");
		beddtype.setBounds(650,130,90,30);
		beddtype.setForeground(Color.white);
		add(beddtype);
		
		table = new JTable();
		table.setBounds(80,170,700,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setFont(new Font("Raleway",Font.BOLD,14));
		add(table);
		
		try 
		{
			Conn conn = new Conn();
			
			ResultSet rss = conn.stmt.executeQuery("select * from rooms");
			
			table.setModel(DbUtils.resultSetToTableModel(rss));
		} 
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBounds(360,280,120,30);
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.addActionListener(this);
		table.add(back);
		
		submit = new JButton("Submit");
		submit.setBounds(220,280,120,30);
		submit.setBackground(Color.white);
		submit.setForeground(Color.black);
		submit.addActionListener(this);
		table.add(submit);
		
		setBounds(280,130,900,550);
		setVisible (true);
	}		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == submit)
			{
				try 
				{					
					String query1 = "select * from rooms where bed_type = '"+bedtype.getSelectedItem()+"'";
					String query2 = "select * from rooms where availabilty = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
					Conn con = new Conn();
					ResultSet rs;
					
					if(available.isSelected())
					{
						rs = con.stmt.executeQuery(query2);
					}
					else 
					{
						rs = con.stmt.executeQuery(query1);
					}
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
			}
			else
			{
			setVisible(false);
			new Reception();
			}
		}
		
	public static void main(String[] args) 
	{
		new SearchRoom();

	}

}
