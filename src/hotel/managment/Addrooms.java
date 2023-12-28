package hotel.managment;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Addrooms extends JFrame implements ActionListener
{
	JButton cancel,add;
	JTextField tfroom,tfprice;
	JComboBox bedtype,cleanoption,availablecombo;
	

	public Addrooms() 
	{
		JLabel addroom = new JLabel("Add Rooms");
		addroom.setBounds(360,30,200,60);
		addroom.setForeground(Color.white);
		addroom.setFont(new Font("Railway",Font.BOLD,30));
		add(addroom);
		
		JLabel jlroomno = new JLabel("Room no.");
		jlroomno.setBounds(220,120,120,30);
		jlroomno.setForeground(Color.white);
		jlroomno.setFont(new Font("Railway",Font.PLAIN,15));
		add(jlroomno);
		
		tfroom = new JTextField();
		tfroom.setBounds(450,120,150,30);
		tfroom.setFont(new Font("Railway",Font.PLAIN,15));
		add(tfroom);
		
		JLabel jlavailable = new JLabel("Available");
		jlavailable.setBounds(220,180,120,30);
		jlavailable.setForeground(Color.white);
		jlavailable.setFont(new Font("Railway",Font.PLAIN,15));
		add(jlavailable);
		
		String str[] = {"Available","Occupied"};
		availablecombo = new JComboBox(str);
		availablecombo.setBounds(450,180,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		JLabel jlclean = new JLabel("Cleaning Status");
		 jlclean.setBounds(220,230,120,30);
		 jlclean.setForeground(Color.white);
		 jlclean.setFont(new Font("Railway",Font.PLAIN,15));
		add(jlclean);
		
		String	clea[] = {"Cleaned","Dirty"};
		cleanoption = new JComboBox(clea);
		cleanoption.setBounds(450,230,150,30);
		cleanoption.setBackground(Color.white);
		add(cleanoption);
		
		JLabel jlprice = new JLabel("Price");
		jlprice.setBounds(220,280,120,30);
		jlprice.setForeground(Color.white);
		jlprice.setFont(new Font("Railway",Font.TRUETYPE_FONT,15));
		add(jlprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(450,280,150,30);
		tfprice.setFont(new Font("Railway",Font.BOLD,15));
		add(tfprice);
		
		JLabel jlbed = new JLabel("Bed Type");
		jlbed.setBounds(220,330,120,30);
		jlbed.setForeground(Color.white);
		jlbed.setFont(new Font("Railway",Font.PLAIN,15));
		add(jlbed);
		
		String	typebed[] = {"Single","Doubled"};
		bedtype = new JComboBox(typebed);
		bedtype.setBounds(450,330,150,30);
		bedtype.setBackground(Color.white);
		add(bedtype);
		
		add = new JButton("ADD");
		add.setBounds(270,400,100,30);
		add.setBackground(Color.white);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(470,400,100,30);
		cancel.setBackground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fifth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,550,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,550);
		add(image);
		
		setLayout(null);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		setBounds(280,130,900,550);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add)
		{
			String room = tfroom.getText();
			String bed = (String)bedtype.getSelectedItem();
			String price = tfprice.getText();
			String clean = (String)cleanoption.getSelectedItem();
			String available = (String)availablecombo.getSelectedItem();
			
			try 
			{
				Conn con = new Conn();
				
				
				String query = "insert into rooms values('"+room+"','"+available+"','"+clean+"','"+price+"','"+bed+"')";
				con.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Added room successfully");
				setVisible(false);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == cancel)
		{
			setVisible(false);
		}
	}

	public static void main(String[] args) 
	{
		new Addrooms();
	}

}
