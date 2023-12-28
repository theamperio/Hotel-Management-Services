package hotel.managment;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener
{
	 JButton newcustomer,rooms,departments,check,employee,customer,manager, status,room,pickup,search,logout;
	public Reception()
	{
		getContentPane().setBackground(Color.black);
	
	   newcustomer = new JButton("New customer Form");
	   newcustomer.setBounds(10,30,200,30);
	   newcustomer.setBackground(Color.white);
	   newcustomer.setForeground(Color.black);
	   newcustomer.addActionListener(this);
	   add(newcustomer);
			   
	   rooms = new JButton("Rooms");
	   rooms.setBounds(10,70,200,30);
	   rooms.setBackground(Color.white);
	   rooms.setForeground(Color.black);
	   rooms.addActionListener(this);
	   add(rooms);
	   
	   departments = new JButton("Departments");
	   departments.setBounds(10,110,200,30);
	   departments.setBackground(Color.white);
	   departments.setForeground(Color.black);
	   departments.addActionListener(this);
	   add(departments);
	   
	   employee = new JButton("All Employees");
	   employee.setBounds(10,150,200,30);
	   employee.setBackground(Color.white);
	   employee.setForeground(Color.black);
	   employee.addActionListener(this);
	   add(employee);
	   
	   customer = new JButton("Customer INFO");
	   customer.setBounds(10,190,200,30);
	   customer.setBackground(Color.white);
	   customer.setForeground(Color.black);
	   customer.addActionListener(this);
	   add(customer);
	   
	   manager = new JButton("Manager INFO");
	   manager.setBounds(10,230,200,30);
	   manager.setBackground(Color.white);
	   manager.setForeground(Color.black);
	   manager.addActionListener(this);
	   add(manager);
	   
	    check = new JButton("CheckOUT");
	   check.setBounds(10,270,200,30);
	   check.setBackground(Color.white);
	   check.setForeground(Color.black);
	   check.addActionListener(this);
	   add(check);
	   
	   status = new JButton("Update Status");
	   status.setBounds(10,310,200,30);
	   status.setBackground(Color.white);
	   status.setForeground(Color.black);
	   status.addActionListener(this);
	   add(status);
	   
	   room = new JButton("Update Rooms Status");
	   room.setBounds(10,350,200,30);
	   room.setBackground(Color.white);
	   room.setForeground(Color.black);
	  room.addActionListener(this);
	   add(room);
	   
	  pickup = new JButton("Pickup Services");
	   pickup .setBounds(10,390,200,30);
	   pickup .setBackground(Color.white);
	   pickup .setForeground(Color.black);
	   pickup.addActionListener(this);
	   add(pickup);
	   
	   search = new JButton("Search Rooms");
	   search.setBounds(10,430,200,30);
	   search.setBackground(Color.white);
	   search.setForeground(Color.black);
	   search.addActionListener(this);
	   add(search);
			   
	   logout = new JButton("Log out");
	   logout.setBounds(10,470,200,30);
	   logout.setBackground(Color.white);
	   logout.setForeground(Color.black);
	   logout.addActionListener(this);
	   add(logout);
	   
	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250,30,500,470);
		add(image);
	   
		setLayout(null);
		setBounds(280,130,800,570);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == newcustomer)
		{
			new Addcustomer();
			setVisible(false);
		}
		else if(ae.getSource()== rooms)
		{
			new Room();
			setVisible(false);
		}
		else if(ae.getSource()== departments)
		{
			new Department();
			setVisible(false);
		}
		else if(ae.getSource()== employee)
		{
			new Employee();
			setVisible(false);
		}
		else if(ae.getSource()== customer)
		{
			new Customer();
			setVisible(false);
		}
		else if(ae.getSource()== manager)
		{
			new Manager();
			setVisible(false);
		}
		else if(ae.getSource()== search)
		{
			new SearchRoom();
			setVisible(false);
		}
		else if (ae.getSource()== status)
		{
			new UpdateCheck();
			setVisible(false);
		}
		else if (ae.getSource() == room)
		{
			new UpdateCheck();
			setVisible(false);
		}
		else if (ae.getSource() == pickup)
		{
			new Pickup();
			setVisible(false);
		}
		else if (ae.getSource() == logout)
		{
			new Hotelmanagement();
			setVisible(false);
		}
		else if (ae.getSource() == check)
		{
			new Checkout();
			setVisible(false);
		}
	}
	
	public static void main(String[] args)
	{
		new Reception();

	}

}
