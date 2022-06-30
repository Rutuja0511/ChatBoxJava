package NewChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class resetpassword extends JFrame {

	private JPanel contentPane;
	private JTextField textNP;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					resetpassword frame = new resetpassword();
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
	
	Connection con = null;
	private JTextField textFieldpasss;
	public resetpassword() {
		
		con= DB.dbconnect();
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 150, 648, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNP = new JLabel("Username");
		lblNP.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNP.setBounds(49, 53, 142, 38);
		contentPane.add(lblNP);
		
		JLabel lblVerifyPassword = new JLabel("Reset Password");
		lblVerifyPassword.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblVerifyPassword.setBounds(43, 229, 164, 38);
		contentPane.add(lblVerifyPassword);
		
		textNP = new JTextField();
		textNP.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		textNP.setBounds(221, 53, 230, 38);
		contentPane.add(textNP);
		textNP.setColumns(10);
		
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Username =  textNP.getText();
				String setPass = passwordField.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatsignup","root","rutu05p");
					//Statement st =con.createStatement();
					PreparedStatement pst = (PreparedStatement) con
	                        .prepareStatement("Update registerdata set password=? where username=?");
					
					pst.setString(1, setPass);
                    pst.setString(2, Username);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(btnreset, "Password has been successfully changed");
			
					
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "error");
				}
				
				
//				if(textNP.getText()==passwordField.getText()) {
//					try {
//						String updateQuery = "UPDATE 'registerdata' SET 'password'=? WHERE ="+user+"";
//						
//						PreparedStatement pst = con.prepareStatement(updateQuery);
//						pst.setString(8,passwordField.getText());
//						pst.executeUpdate();
//						JOptionPane.showMessageDialog(null, "successful");
//						
//					}catch(Exception es) {}
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "failed");
//				}
			}
		});
		btnreset.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnreset.setText("RESET");
		btnreset.setBackground(new Color(153, 255, 153));
		btnreset.setBounds(387, 309, 142, 49);
		contentPane.add(btnreset);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(221, 229, 249, 38);
		contentPane.add(passwordField);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblOldPassword.setBounds(43, 158, 148, 38);
		contentPane.add(lblOldPassword);
		
		textFieldpasss = new JTextField();
		textFieldpasss.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		textFieldpasss.setColumns(10);
		textFieldpasss.setBounds(221, 158, 249, 38);
		contentPane.add(textFieldpasss);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Bell MT", Font.BOLD, 23));
		btnSearch.setBackground(new Color(0, 0, 139));
		btnSearch.setForeground(new Color(255, 228, 225));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = textNP.getText();
				

				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatsignup","root","rutu05p");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select password from registerdata where username ='"+Username+"'");
					if(rs.next())
					{
						textFieldpasss.setText(rs.getString(1));
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Enter correct username");
					}
				}catch(Exception ef) {}
				
			}
		});
		btnSearch.setBounds(342, 101, 109, 31);
		contentPane.add(btnSearch);
		
		JButton btnBTL = new JButton("Back to Login");
		btnBTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDemo ld = new LoginDemo();
				ld.setVisible(true);
				
				setVisible(false);
			}
		});
		btnBTL.setBackground(new Color(255, 153, 255));
		btnBTL.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnBTL.setBounds(99, 310, 173, 49);
		contentPane.add(btnBTL);
		
		
		JLabel lblBgImage = new JLabel("");
		lblBgImage.setIcon(new ImageIcon(LoginDemo.class.getResource("/NewChat/signup.png")));
		lblBgImage.setBounds(0,0,634,428);
		getContentPane().add(lblBgImage);
		
		
	}
}
