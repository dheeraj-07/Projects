package FeedBack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AfterLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tname;
	private JTextField tsub;
	private JTextField tdes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLogin frame = new AfterLogin();
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
	public AfterLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add/Delete Faculty");
		lblNewLabel.setFont(new Font("Consolas", Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 24, 641, 57);
		contentPane.add(lblNewLabel);
		
		tname = new JTextField();
		tname.setBounds(320, 92, 133, 20);
		contentPane.add(tname);
		tname.setColumns(10);
		
		tsub = new JTextField();
		tsub.setBounds(320, 131, 133, 20);
		contentPane.add(tsub);
		tsub.setColumns(10);
		
		tdes = new JTextField();
		tdes.setBounds(320, 174, 133, 20);
		contentPane.add(tdes);
		tdes.setColumns(10);
		
		JLabel name = new JLabel("Name");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(214, 92, 72, 14);
		contentPane.add(name);
		
		JLabel subject = new JLabel("Subject");
		subject.setHorizontalAlignment(SwingConstants.CENTER);
		subject.setBounds(214, 134, 72, 14);
		contentPane.add(subject);
		
		JLabel designation = new JLabel("Designation");
		designation.setHorizontalAlignment(SwingConstants.CENTER);
		designation.setBounds(214, 174, 72, 14);
		contentPane.add(designation);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tname.getText()==null) {
					JOptionPane.showMessageDialog(new Frame(),"Please Enter Valid Name","A plain message",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String n,s,d;
					n=tname.getText();
					s=tsub.getText();
					d=tdes.getText();
					try {
						new Faculty(n,s,d);
						JOptionPane.showMessageDialog(new Frame(),"Fauclty Added ","Add", JOptionPane.PLAIN_MESSAGE);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(293, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n,s,d;
				n=tname.getText();
				s=tsub.getText();
				d=tdes.getText();
				try {
					new Faculty(n);
					JOptionPane.showMessageDialog(new Frame(),"Fauclty Deleted","Deleted", JOptionPane.PLAIN_MESSAGE);
					} 
				catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(293, 239, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=(String) comboBox.getSelectedItem();
				if(i=="Logout") {
					dispose();
					new Login().frame.setVisible(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Change Password", "Logout"}));
		comboBox.setBounds(519, 11, 112, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Check FeedBacks");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new ShowFeedbacks().setVisible(true);;
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(263, 273, 142, 23);
		contentPane.add(btnNewButton_2);
	}
}
