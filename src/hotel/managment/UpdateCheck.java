package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener
{
  Choice custom;
  JTextField tfroom,tfname,tfcheck,tfpaid,tfpending;
  JButton back,check,update;
	public UpdateCheck() 
	{
		getContentPane().setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel head = new JLabel("Update Status");
		head.setBounds(310,20,150,30);
		head.setFont(new Font("Raleway",Font.BOLD,20));
		head.setForeground(Color.white);
		add(head);
		
		JLabel jlid = new JLabel("Customer ID");
		jlid.setBounds(210,70,100,30);
		jlid.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlid);
		
		custom = new Choice();
		custom.setBounds(350,70,120,30);
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
		
		JLabel jlroom = new JLabel("Name");
		jlroom.setBounds(210,150,100,30);
		jlroom.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(350,110,120,25);
		add(tfroom);
		
		JLabel jlname = new JLabel("Room no");
		jlname.setBounds(210,110,100,30);
		jlname.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlname);
		
		tfname = new JTextField();
		tfname.setBounds(350,150,120,25);
		add(tfname);
		
		JLabel jlcheck = new JLabel("Check-in Time");
		jlcheck.setBounds(210,190,120,30);
		jlcheck.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlcheck);
		
		tfcheck = new JTextField();
		tfcheck.setBounds(350,190,120,25);
		add(tfcheck);
		
		JLabel jlpaid = new JLabel("Amount Paid");
		jlpaid.setBounds(210,230,120,30);
		jlpaid.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(350,230,120,25);
		add(tfpaid);
		
		JLabel jlpending = new JLabel("Amount Pending");
		jlpending.setBounds(210,270,120,30);
		jlpending.setFont(new Font("Raleway",Font.BOLD,14));
		add(jlpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(350,270,120,25);
		add(tfpending);
		
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
					tfname.setText(rs.getString("name"));
					tfcheck.setText(rs.getString("time"));
					tfpaid.setText(rs.getString("deposit"));
				}
				
				ResultSet rs2 = con.stmt.executeQuery("select * from rooms where roomno = '"+tfroom.getText()+"'");
				
				while(rs2.next())
				{
					String price = rs2.getString("price");
					int amount = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
					tfpending.setText(""+amount);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else if (ae.getSource() == update)
		{
			String number = custom.getSelectedItem();
			String room = tfroom.getText();
			String name = tfname.getText();	
			String check = tfcheck.getText();
			String paid = tfpaid.getText();	
			String pending = tfpending.getText();
			
		 try {
			Conn conn = new Conn ();
			conn.stmt.executeUpdate("update customers set room ='"+room+"',name = '"+name+"',time = '"+check+"',deposit = '"+paid+"' where idnum = '"+number+"'");
			
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
		new UpdateCheck();

	}

}
