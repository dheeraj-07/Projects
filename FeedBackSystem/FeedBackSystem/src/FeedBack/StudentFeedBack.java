package FeedBack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentFeedBack extends JFrame {
	JFrame frame=new JFrame();
	private JPanel contentPane;
	private JTextField dsid;
	private JTextField fsub;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFeedBack frame = new StudentFeedBack();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFeedBack() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 569);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea ffeed = new JTextArea();
		ffeed.setBounds(236, 266, 433, 174);
		contentPane.add(ffeed);
		
		JLabel lblNewLabel = new JLabel("FeedBack");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 269, 127, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(96, 156, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		dsid = new JTextField();
		dsid.setBounds(236, 151, 127, 20);
		contentPane.add(dsid);
		dsid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Roll Number");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(96, 121, 127, 14);
		contentPane.add(lblNewLabel_2);	
		JComboBox drollno = new JComboBox();
		drollno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297", "298", "299", "300"}));
		drollno.setBounds(236, 115, 49, 22);
		contentPane.add(drollno);
		
		JLabel lblNewLabel_3 = new JLabel("Drop Your FeedBack Here");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 39));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 41, 768, 69);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<ArrayList<String>> fname = new JComboBox(new importFacName().getList().toArray());
		fname.setBounds(236, 185, 181, 22);
		contentPane.add(fname);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a;
				int b;
				String c,d,f;
				a=Integer.parseInt((String) drollno.getSelectedItem());
				b=Integer.parseInt(dsid.getText());
				c=(String) fname.getSelectedItem();
				d=fsub.getText();
				f=ffeed.getText();
				try {
					new Feed(a,b,c,d,f);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame,"FeedBack Recorded","A plain message",JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(328, 462, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Select Faculty");
		lblNewLabel_4.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(96, 191, 127, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox<ArrayList<String>> ffname = new JComboBox(new importFacName().getList().toArray());
		fname.setBounds(236, 185, 181, 22);
		contentPane.add(fname);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Subject");
		lblNewLabel_5.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(96, 231, 127, 14);
		contentPane.add(lblNewLabel_5);
		
		fsub = new JTextField();
		fsub.setBounds(236, 226, 160, 20);
		contentPane.add(fsub);
		fsub.setColumns(10);
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 0, 109, 23);
		contentPane.add(btnNewButton_1);
	}
}
