package hotel.managment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener
{

	
	public Dashboard()
	{
		
		setBounds(190,20,1050,700);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.png"));
		Image i2 = i1.getImage().getScaledInstance(1050, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1050,700);
		add(image);
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.GRAY);
		
		
		
		JLabel dash = new JLabel("Hotel Management Dashboard");
		dash.setBounds(250,20,550,60);
		dash.setBackground(Color.WHITE);
		dash.setFont(new Font("serif",Font.BOLD, 40));
		dash.setOpaque(false);
		image.add(dash);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(440,210,170,35);
		image.add(mb);
		
		JMenu hotel = new JMenu("Hotel Management");
		mb.setFont(new Font("serif",Font.BOLD, 25));
		mb.add(hotel);
		
		JMenuItem rec = new JMenuItem("Reception");
		hotel.add(rec);
		rec.addActionListener(this);

		JMenu admin = new JMenu("Admin");
		mb.setFont(new Font("serif",Font.BOLD, 25));
		mb.add(admin);
		
		JMenuItem employee = new JMenuItem("Add Employee");
		admin.add(employee);
		employee.addActionListener(this);
		
		JMenuItem room = new JMenuItem("Add Rooms");
		admin.add(room);
		room.addActionListener(this);
		
		JMenuItem driver = new JMenuItem("Add Drivers");
		admin.add(driver);
		driver.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Add Employee"))
		{
			new AddEmployee();
		}
		else if (ae.getActionCommand().equals("Add Rooms"))
		{
			new Addrooms();
		}
		else if (ae.getActionCommand().equals("Add Drivers"))
		{
			new AddDriver();
		}
		else if (ae.getActionCommand().equals("Reception"))
		{
			new Reception();
		}
	}

	public static void main(String[] args)
	{
		new Dashboard();

	}

}
