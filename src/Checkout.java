import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Checkout extends JFrame {

	private JPanel contentPane;
	public static void checkout() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Checkout frame = new Checkout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private float price;
	
	public long calculate(String room,long days) {
		long result;
		if (room == "ห้องดีลักซ์ี - 1,290/วัน" ){
			this.price = 1290;
		}else if(room == "ห้องสุพีเรียร์เตียงแฝด - 1,590/วัน"){
			this.price = 1590;
		}else if(room == "ห้องดีลักซ์สำหรับสามท่าน - 1,990/วัน"){
			this.price = 1990;
		}else{
			this.price = 2150;
		}
		result = (long) (this.price * days);	
		return result;
		
	}
	
	public long calculate(String room,long days,float percent) {
		long result = 0;
			if (room == "ห้องดีลักซ์ี - 1,290/วัน" ){
				this.price = 1290;
			}else if(room == "ห้องสุพีเรียร์เตียงแฝด - 1,590/วัน"){
				this.price = 1590;
			}else if(room == "ห้องดีลักซ์สำหรับสามท่าน - 1,990/วัน"){
				this.price = 1990;
			}else{
				this.price = 2150;
			}	
		System.out.println(result);
		float per = 100-percent;
		result = (long) ((per*(this.price * days))/100);
		return result;
	}

	
	
	public Checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		data dd = new data();
		
		JLabel lblNewLabel_1 = new JLabel("Name  : ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_1.setBounds(80, 61, 72, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail :");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_3.setBounds(80, 113, 72, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Phone :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_2.setBounds(80, 161, 72, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Room-type :");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_4.setBounds(80, 210, 106, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date :");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_5.setBounds(80, 257, 72, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Price :");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_6.setBounds(80, 306, 72, 16);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Success !!! \nTotal : "+dd.getTotal()+" Bath \nThank you!!!");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(610, 389, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton more = new JButton("More");
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info in = new info();
				in.infomation();
				dispose();
			}
		});
		more.setBounds(460, 389, 117, 29);
		contentPane.add(more);
		
		JLabel lblNewLabel_7 = new JLabel("Total : ");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblNewLabel_7.setBounds(548, 60, 117, 29);
		contentPane.add(lblNewLabel_7);
		
		JLabel lastnamebox = new JLabel("");
		lastnamebox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lastnamebox.setText(dd.getLname());
		lastnamebox.setBounds(304, 61, 232, 16);
		contentPane.add(lastnamebox);
		
		JLabel total = new JLabel("_____________");
		total.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		String temp = String.valueOf(dd.getTotal());
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_8.setText(dd.getList());
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_8.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_8.setBounds(550, 96, 231, 281);
		contentPane.add(lblNewLabel_8);
		total.setText(temp);
		total.setBounds(624, 64, 87, 23);
		contentPane.add(total);
		
		JLabel namebox = new JLabel();
		namebox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		namebox.setText(dd.getFname());
		namebox.setBounds(164, 61, 154, 16);
		contentPane.add(namebox);
		
		JLabel mailbox = new JLabel();
		mailbox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mailbox.setText(dd.getMail());
		mailbox.setBounds(164, 113, 352, 16);
		contentPane.add(mailbox);
		
		JLabel phonebox = new JLabel("phone");
		phonebox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		phonebox.setText(dd.getPhon());
		phonebox.setBounds(164, 161, 339, 16);
		contentPane.add(phonebox);
		
		JLabel strbox = new JLabel("strdate");
		strbox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		strbox.setText(dd.getSdate());
		strbox.setBounds(153, 257, 140, 16);
		contentPane.add(strbox);
		
		JLabel roombox = new JLabel("room");
		roombox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		roombox.setText(dd.getRoom());
		roombox.setBounds(192, 210, 410, 16);
		contentPane.add(roombox);
		
		JLabel enddat = new JLabel("last");
		enddat.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		enddat.setText(dd.getEdate());
		enddat.setBounds(281, 257, 140, 16);
		contentPane.add(enddat);
		
		JLabel pricebox = new JLabel();
		pricebox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		pricebox.setText(dd.getPrice());
		pricebox.setBounds(150, 306, 271, 16);
		contentPane.add(pricebox);
		
		JLabel lblNewLabel_12 = new JLabel("-");
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(255, 257, 61, 16);
		contentPane.add(lblNewLabel_12);
		
		JLabel bg = new JLabel("");
		bg.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		bg.setBounds(0, 0, 800, 458);
		bg.setIcon(new ImageIcon("/Users/natthawut/Downloads/bg-color-triangles.png"));
		contentPane.add(bg);
		
		
	}
}