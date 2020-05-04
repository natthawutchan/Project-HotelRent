import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;

import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class selectRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void room() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectRoom frame = new selectRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private long getday = 0;
	private String strdate;
	private String enddate;
	public String incode;
	private String room;
	private String result;
	
	
	private JTextField putcode;
	public selectRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] roombox = { "ห้องดีลักซ์ี - 1,290/วัน", "ห้องสุพีเรียร์เตียงแฝด - 1,590/วัน", "ห้องดีลักซ์สำหรับสามท่าน - 1,990/วัน", "ห้องเอ็กเซ็กคูทีฟสวีท - 2,150/วัน" };
		JLabel outladel = new JLabel("เลือกวันที่ออก");
		outladel.setBounds(342, 366, 117, 16);
		contentPane.add(outladel);
		
		JDateChooser outdate = new JDateChooser();
		outdate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		putcode = new JTextField();
		putcode.setBackground(new Color(204, 204, 204));
		putcode.setBounds(468, 404, 158, 26);
		contentPane.add(putcode);
		putcode.setColumns(10);
		
		JCheckBox codecheck = new JCheckBox("Code");
		putcode.setEnabled(false);
		codecheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if (codecheck.isSelected())
		        {
		        	putcode.setEnabled(true);
		        	}
		        else {
		        	putcode.setText("");
		            putcode.setEnabled(false);
		            
		        }	
				
			}
		});
		
        
        
		codecheck.setBounds(402, 405, 128, 23);
		contentPane.add(codecheck);
		outdate.setBounds(438, 356, 188, 26);
		
		contentPane.add(outdate);
		
		JDateChooser indate = new JDateChooser();
		indate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		indate.setBounds(105, 356, 190, 26);
		contentPane.add(indate);
		
		JComboBox comboBox = new JComboBox(roombox);
		comboBox.setBounds(128, 405, 240, 27);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DecimalFormat decimalFormat = new DecimalFormat("#.##");
		        decimalFormat.setGroupingUsed(true);
		        decimalFormat.setGroupingSize(3);
		        
				incode = putcode.getText().toString();
				SimpleDateFormat dcn = new SimpleDateFormat("dd MM yyy");
			    strdate = dcn.format(indate.getDate() );
			    enddate = dcn.format(outdate.getDate() );
			    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
				final LocalDate firstDate = LocalDate.parse(strdate, formatter);
		        final LocalDate secondDate = LocalDate.parse(enddate, formatter);
		        long days = ChronoUnit.DAYS.between(firstDate, secondDate);
		        getday = days;
				room = (String) comboBox.getSelectedItem();
				Checkout ck = new Checkout();
				
				fres = ck.calculate(room, getday);
				if(days<1) {
					JOptionPane.showMessageDialog(null, "Day Time is invalid");
				}
				else {
				if(putcode.isEnabled()) {
					System.out.println("isEnabled : "+incode);
				if (incode.equals("DBDL2020")) {
					float per = 10;
					System.out.println("Code : "+incode);
					res = ck.calculate(room, getday, per);
					JOptionPane.showMessageDialog(null, "Discount 10% Price is : "+decimalFormat.format(res)+" frome "+decimalFormat.format(fres));
					result = decimalFormat.format(res);
					
					
				}
				else if (incode.equals("NEW2020")) {
					float per = 20;
					System.out.println("newCode : "+incode);
					res = ck.calculate(room, getday, per);
					JOptionPane.showMessageDialog(null, "Discount 20% Price is : "+decimalFormat.format(res)+" frome "+decimalFormat.format(fres));
					result = decimalFormat.format(res);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Code !!!");
				}}
				else {
				res = ck.calculate(room, getday);
				JOptionPane.showMessageDialog(null, "No Discount Price is : "+decimalFormat.format(fres));
				result = decimalFormat.format(res);
				
				}	
				data.saveSR(room, strdate, enddate, result,res);
				data.addnamelist();
				ck.checkout();
			}}
		});
		
		JLabel lblNewLabel_2 = new JLabel("เลือกวันเข้าพัก");
		lblNewLabel_2.setBounds(6, 366, 117, 16);
		contentPane.add(lblNewLabel_2);
		btnNewButton.setBounds(654, 404, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("เลือกประเภทของห้อง");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(6, 409, 124, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/natthawut/Documents/Java Eclipse/HetelSql/roomtype.jpg"));
		lblNewLabel.setBounds(6, 6, 788, 328);
		contentPane.add(lblNewLabel);
		
		JLabel Backgroud = new JLabel("");
		Backgroud.setIcon(new ImageIcon("/Users/natthawut/Downloads/bg-color-triangles.png"));
		Backgroud.setBounds(0, 0, 800, 458);
		contentPane.add(Backgroud);
	}
	private float res = 0;
	private float fres = 0;
}


