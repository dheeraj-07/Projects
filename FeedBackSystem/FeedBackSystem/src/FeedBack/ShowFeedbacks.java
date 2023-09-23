package FeedBack;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowFeedbacks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowFeedbacks frame = new ShowFeedbacks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowFeedbacks() throws ClassNotFoundException, SQLException{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 561);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll No");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 51, 108, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 93, 108, 418);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(750, 11, 17, 500);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(141, 51, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Faculty Name");
		lblNewLabel_2.setBounds(269, 51, 128, 14);
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty Subject");
		lblNewLabel_3.setBounds(417, 51, 128, 14);
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FeedBack");
		lblNewLabel_4.setBounds(574, 51, 166, 14);
		lblNewLabel_4.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentPane.add(lblNewLabel_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(149, 93, 110, 418);
		textArea_1.setEditable(false);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(269, 93, 128, 418);
		textArea_2.setEditable(false);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(414, 93, 131, 418);
		textArea_3.setEditable(false);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(574, 93, 166, 418);
		textArea_4.setEditable(false);
		contentPane.add(textArea_4);
		
		JLabel lblNewLabel_5 = new JLabel("FEEDBACKS");
		lblNewLabel_5.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 730, 29);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Reture Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AfterLogin().setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 0, 118, 23);
		contentPane.add(btnNewButton);
		
		
		Connection con=null;
		Statement stmt=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty1","root","");
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from feedbacktable");
		while(rs.next()) {
			textArea.append(rs.getString("rollno")+"\n");
			textArea_1.append(rs.getString("studentid")+"\n");
			textArea_2.append(rs.getString("facname")+"\n");
			textArea_3.append(rs.getString("facsubject")+"\n");
			textArea_4.append(rs.getString("feedback")+"\n");
		}
		con.close();
	}
}
