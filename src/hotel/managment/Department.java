package hotel.managment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener
{

	JTable table;
	JLabel department,budget;
	JButton back;
	
	public Department()
	{
		getContentPane().setBackground(Color.black);
		JLabel j1 = new JLabel("Department Deatils");
		j1.setBounds(370,20,250,30);
		j1.setFont(new Font("Raleway",Font.BOLD,20));
		j1.setForeground(Color.white);
		add(j1);
		
		
		department = new JLabel("Department");
		department.setBounds(150,70,90,30);
		department.setForeground(Color.white);
		department.setFont(new Font("Raleway",Font.BOLD,14));
		add(department);
		
		budget = new JLabel("Availabilty");
		budget.setBounds(480,70,80,30);
		budget.setForeground(Color.white);
		budget.setFont(new Font("Raleway",Font.BOLD,14));
		add(budget);
		
		table = new JTable();
		table.setBounds(60,100,700,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setFont(new Font("Raleway",Font.BOLD,12));
		add(table);
		
		try 
		{
			Conn con = new Conn();
			
			ResultSet rs = con.stmt.executeQuery("select * from department");
			
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
		setLayout(null);
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
		new Department();

	}

}
