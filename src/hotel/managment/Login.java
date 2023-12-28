package hotel.managment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	
	JLabel user;
	JTextField id;
	JLabel pass;
	JPasswordField password;
	JButton cancel;
	JButton login;
	Statement statement;
	
	public Login()
	{
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
		
		user = new JLabel("Enter I'D  :");
		user.setBounds(40,20,100,30);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("serif",Font.BOLD, 20));
		add(user);
		
		id = new JTextField();
		id.setBounds(150,20,150,30);
		add(id);
			
		 pass = new JLabel("Password  :");
		pass.setBounds(40,80,100,30);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("serif",Font.BOLD, 20));
		add(pass);
		
		password = new JPasswordField();
		password.setBounds(150,80,150,30);
		add(password);
		
		 cancel = new JButton("Cancel");
		cancel.setBounds(40,150,120,30);
		cancel.setForeground(Color.lightGray);
		cancel.setBackground(Color.black);
		cancel.setFont(new Font("serif",Font.BOLD,18));
		cancel.addActionListener(this);
		add(cancel);
		
		 login = new JButton("Login");
		login.setBounds(180,150,120,30);
		login.setForeground(Color.black);
		login.setBackground(Color.white);
		login.setFont(new Font("serif",Font.BOLD,18));
		login.addActionListener(this);
		add(login);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("second.png"));
		Image i1 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(350,10,200,200);
		add(image);
		
		setBounds(500,200,600,300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == login)
		{
			String enteredId = id.getText();  
			String enteredPassword = password.getText();
			
			
			try 
			{
				Conn con = new Conn();
				
				String query = "select * from login where ID ='"+enteredId+"'and password = '"+enteredPassword+"'	";
				ResultSet rs = con.stmt.executeQuery(query);
				  
				if(rs.next()) 
				{  
					setVisible(false);
					new Dashboard();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorect ID or Password");
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else if (ae.getSource() == cancel)
		{
			setVisible(false);
		}
	}

	public static void main(String[] args)
	{
		new Login();
	}

}
