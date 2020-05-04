import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class info extends JFrame {

	private JPanel roomtypd;
	private JTextField last;
	private JTextField name;
	private JTextField email;
	private JTextField phone;
	public String fname;
	public String lname;
	public String mail;
	public String num;

	public static void infomation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					info frame = new info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 480);
		roomtypd = new JPanel();
		roomtypd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(roomtypd);
		roomtypd.setLayout(null);
		
		last = new JTextField();
		last.setBounds(290, 75, 300, 26);
		roomtypd.add(last);
		last.setColumns(10);
		
		String[] type = { "-- เลือกประเภทห้องของคุณ (RoomType) --","สแตนดาร์ด (Standard)", "ซูพีเรีย (Superior)", "ดีลักซ์ (Deluxe)", "สวีท (Suite)"};
		
		name = new JTextField();
		name.setBounds(290, 24, 300, 26);
		roomtypd.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FIRSTNAME     :");
		lblNewLabel.setBounds(182, 29, 96, 16);
		roomtypd.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LASTNAME      :");
		lblNewLabel_1.setBounds(182, 80, 96, 16);
		roomtypd.add(lblNewLabel_1);
		
		String typename = "Room type";
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname = name.getText();
				lname = last.getText();
				mail = email.getText();
				num = phone.getText();
				if(fname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Name");
				}
				else if(lname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter LastName");
				}
				else if(mail.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter E-Mail");
				}
				else if(num.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Phone number");
				}
				else {
					selectRoom sr = new selectRoom();
					data.saveinfo(fname, lname, mail, num);
					sr.room();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(473, 361, 117, 29);
		roomtypd.add(btnNewButton);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(290, 129, 300, 26);
		roomtypd.add(email);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL             :");
		lblNewLabel_2.setBounds(182, 133, 96, 16);
		roomtypd.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setBounds(290, 182, 300, 26);
		roomtypd.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PHONE            :");
		lblNewLabel_3.setBounds(182, 187, 96, 16);
		roomtypd.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/natthawut/Downloads/bg-color-triangles.png"));
		lblNewLabel_4.setBounds(0, 0, 800, 458);
		roomtypd.add(lblNewLabel_4);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
