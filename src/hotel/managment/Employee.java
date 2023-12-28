package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Employee extends JFrame implements ActionListener
{

	JTable table;
	JLabel name,gender,job,salary,phone,email,aadhar,age;
	JButton back;
	
	public Employee()
	{
		getContentPane().setBackground(Color.black);
		JLabel j1 = new JLabel("Employee Deatils");
		j1.setBounds(370,20,250,30);
		j1.setFont(new Font("Raleway",Font.BOLD,20));
		j1.setForeground(Color.white);
		add(j1);
		
		
		name = new JLabel("Name");
		name.setBounds(90,70,80,30);
		name.setForeground(Color.white);
		name.setFont(new Font("Raleway",Font.BOLD,13));
		add(name);
		
		
		age = new JLabel("Age");
		age.setBounds(200,70,80,30);
		age.setForeground(Color.white);
		age.setFont(new Font("Raleway",Font.BOLD,13));
		add(age);
		
		gender = new JLabel("Gender");
		gender.setBounds(310,70,80,30);
		gender.setForeground(Color.white);
		gender.setFont(new Font("Raleway",Font.BOLD,13));
		add(gender);

		
		job = new JLabel("Job");
		job.setBounds(420,70,80,30);
		job.setForeground(Color.white);
		job.setFont(new Font("Raleway",Font.BOLD,13));
		add(job);
		
		salary = new JLabel("Salary");
		salary.setBounds(530,70,80,30);
		salary.setForeground(Color.white);
		salary.setFont(new Font("Raleway",Font.BOLD,13));
		add(salary);
		
		phone = new JLabel("Phone no");
		phone.setBounds(640,70,80,30);
		phone.setForeground(Color.white);
		phone.setFont(new Font("Raleway",Font.BOLD,13));
		add(phone);
		
		email = new JLabel("Email");
		email.setBounds(750,70,80,30);
		email.setForeground(Color.white);
		email.setFont(new Font("Raleway",Font.BOLD,13));
		add(email);
		
		aadhar = new JLabel("Aadhar no");
		aadhar.setBounds(860,70,80,30);
		aadhar.setForeground(Color.white);
		aadhar.setFont(new Font("Raleway",Font.BOLD,13));
		add(aadhar);
		
		table = new JTable();
		table.setBounds(60,110,900,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setFont(new Font("Raleway",Font.BOLD,12));
		add(table);
		
		try 
		{
			Conn con = new Conn();
			
			ResultSet rs = con.stmt.executeQuery("select * from employee");
			
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
		new Employee();

	}

}

