package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;



public class Pickup extends JFrame implements ActionListener
{
	
	JButton  back,submit;
	JTable table;
	JLabel name,age,company,model,location,type,gender, available;
	Choice cartype;
	
	public Pickup()
	{
		getContentPane().setBackground(Color.black);
		setLayout(null);
		
		JLabel data = new JLabel("Pickup Services");
		data.setBounds(370,20,180,30);
		data.setFont(new Font("Raleway",Font.BOLD,20));
		data.setForeground(Color.white);
		add(data);
		
		type = new JLabel("Type of Car");
		type.setBounds(60,80,80,30);
		type.setForeground(Color.white);
		type.setFont(new Font("Ralewy",Font.BOLD,13));
		add(type);
		
		cartype = new Choice();
		cartype.setBounds(150,80,150,25);
		cartype.setBackground(Color.white);
		add(cartype);
		
		try 
		{
			Conn con = new Conn();
			ResultSet rs = con.stmt.executeQuery("select * from drivers");
			
			while(rs.next())
			{
				cartype.add(rs.getString("company"));
			}
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		name = new JLabel("Name");
		name.setBounds(100,130,80,30);
		name.setForeground(Color.white);
		add(name);
		
		age = new JLabel("Age");
		age.setBounds(200,130,80,30);
		age.setForeground(Color.white);
		add(age);
		
		company = new JLabel("Company");
		company.setBounds(300,130,90,30);
		company.setForeground(Color.white);
		add(company);
		
		
		model = new JLabel("Model");
		model.setBounds(400,130,90,30);
		model.setForeground(Color.white);
		add(model);
		
		location = new JLabel("Location");
		location.setBounds(500,130,90,30);
		location.setForeground(Color.white);
		add(location);
		
		gender = new JLabel("Gender");
		gender.setBounds(600,130,90,30);
		gender.setForeground(Color.white);
		add(gender);
		
		available = new JLabel("Available");
		available.setBounds(700,130,90,30);
		available.setForeground(Color.white);
		add(available);
		
		table = new JTable();
		table.setBounds(80,170,700,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setFont(new Font("Raleway",Font.BOLD,14));
		add(table);
		
		try 
		{
			Conn conn = new Conn();
			
			ResultSet rs = conn.stmt.executeQuery("select * from drivers");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
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
					String query1 = "select * from drivers where company = '" +cartype.getSelectedItem()+ "'";
					Conn con = new Conn();
					ResultSet rs;
					rs = con.stmt.executeQuery(query1);
					
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
		new Pickup();

	}

}
