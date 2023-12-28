package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener
{
	JTextField tfname,tfage,tfphone,tfemail,tfsalary,tfaadhar;
	JButton submit;
	JRadioButton rbmale,rbfemale;
	JComboBox cbjob;
	public AddEmployee()
	{
		setLayout(null);
		
		JLabel jlname = new JLabel("Name");
		jlname.setBounds(110,80,120,30);
		jlname.setForeground(Color.white);
		jlname.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlname);
		
		tfname = new JTextField();
		tfname.setBounds(250,80,150,30);
		tfname.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfname);
		
		JLabel jlemail = new JLabel("Email");
		jlemail.setBounds(110,130,120,30);
		jlemail.setForeground(Color.white);
		jlemail.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(250,130,150,30);
		tfemail.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfemail);
		
		JLabel jlage = new JLabel("Age");
		jlage.setBounds(110,180,120,30);
		jlage.setForeground(Color.white);
		jlage.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlage);
		
		tfage = new JTextField();
		tfage.setBounds(250,180,150,30);
		tfage.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfage);
		
		JLabel jlgender = new JLabel("Gender");
		jlgender.setBounds(110,230,120,30);
		jlgender.setForeground(Color.white);
		jlgender.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(250,230,70,30);
		rbmale.setFont(new Font("Tahoma", Font.BOLD,14));
		rbmale.setBackground(Color.black);
		rbmale.setForeground(Color.white);
		add(rbmale);
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(320,230,90,30);
		rbfemale.setFont(new Font("Tahoma", Font.BOLD,14));
		rbfemale.setBackground(Color.black);
		rbfemale.setForeground(Color.white);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel jljob = new JLabel("Job");
		jljob.setBounds(110,280,120,30);
		jljob.setForeground(Color.white);
		jljob.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jljob);
		
		String str[] = {"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Services","Chefs","Manager","Accountant"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(250,280,150,30);
		cbjob.setBackground(Color.black);
		cbjob.setForeground(Color.white);
		add(cbjob);
		
		JLabel jlphone = new JLabel("Phone");
		jlphone.setBounds(110,330,120,30);
		jlphone.setForeground(Color.white);
		jlphone.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(250,330,150,30);
		tfphone.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfphone);
		
		JLabel jlsalary = new JLabel("Salary");
		jlsalary.setBounds(110,380,120,30);
		jlsalary.setForeground(Color.white);
		jlsalary.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(250,380,150,30);
		tfsalary.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfsalary);
		
		JLabel jlaadhar = new JLabel("Aadhar no.");
		jlaadhar.setBounds(110,430,120,30);
		jlaadhar.setForeground(Color.white);
		jlaadhar.setFont(new Font("Tahoma", Font.BOLD,17));
		add(jlaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(250,430,150,30);
		tfaadhar.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(tfaadhar);
		
		submit = new JButton("Submit");
		submit.setBounds(220,510,90,30);
		submit.setBackground(Color.white);
		submit.setFont(new Font("Tahoma", Font.PLAIN,15));
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("forth.png"));
		Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(510,60,500,500);
		add(image);
					
		getContentPane().setBackground(Color.black);
		setVisible(true);
		setBounds(190,130,1050,650);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = tfname.getText();
		String age = tfage.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String salary = tfsalary.getText();
		String aadhar = tfaadhar.getText();
		String gender = null;
		if(rbmale.isSelected())
		{
			gender = "Male"; 
		}
		else if(rbfemale.isSelected())
		{
			gender = "Female";
		}
		String job = (String)cbjob.getSelectedItem();
		
		try 
		{
			Conn conn = new Conn();
			
			String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			conn.stmt.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null,"Added Employee successfully");
			setVisible(false);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		new AddEmployee();
	}

}
