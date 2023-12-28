package hotel.managment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


import javax.swing.*; 


public class Hotelmanagement extends JFrame implements ActionListener
{

	public Hotelmanagement()
	{
		
		setBounds(190,20,1024,768);
		setLayout(null);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
		JLabel image = new JLabel(i);
		image.setBounds(0,0,1024,768);
		add(image);
		
		JLabel jl = new JLabel("WELCOME");
		jl.setBounds(430,270,300,100);
		jl.setForeground(Color.WHITE);
		jl.setFont(new Font("serif",Font.HANGING_BASELINE, 40));
		jl.setFont(new Font("serif",Font.BOLD, 30));
		image.add(jl);
		
		JLabel jl1 = new JLabel("HOTEL MANAGEMENT SYSTEM");
		jl1.setBounds(210,560,630,70);
		jl1.setForeground(Color.black);
		jl1.setFont(new Font("serif",Font.HANGING_BASELINE, 40));
		jl1.setFont(new Font("serif",Font.BOLD, 40));
		jl1.setBackground(Color.LIGHT_GRAY);
		jl1.setOpaque(true);
		image.add(jl1);
		
		JButton con = new JButton("Continue....");
		con.setBounds(430, 430, 130, 35);
		con.setForeground(Color.BLACK);
		con.setBackground(Color.white);
		con.setFont(new Font("serif",Font.BOLD, 18));
		con.addActionListener(this);
		image.add(con);
		
		
		setVisible(true);
		
		
}
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login();
	}
	



	public static void main(String[] args)
	{
		new Hotelmanagement();

	}

}
