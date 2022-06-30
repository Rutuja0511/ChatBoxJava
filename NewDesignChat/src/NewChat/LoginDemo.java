package NewChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class LoginDemo extends JFrame {
private JPanel contentPane;
private JTextField username;
private JPasswordField password;
/**
* Launch the application.
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDemo frame = new LoginDemo();
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
	
public LoginDemo() {
	
	con= DB.dbconnect();
	
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setBounds(390, 150, 648, 438);
   contentPane = new JPanel();
   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   setContentPane(contentPane);
   contentPane.setLayout(null);
   
   	JLabel lblUsername = new JLabel("Username");
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblUsername.setBounds(65, 77, 114, 23);
	contentPane.add(lblUsername);

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblPassword.setBounds(65, 139, 114, 23);
	contentPane.add(lblPassword);

	username = new JTextField();
	username.setBounds(189, 78, 158, 29);
	contentPane.add(username);
	username.setColumns(10);

	password = new JPasswordField();
	password.setBounds(189, 140, 158, 29);
	contentPane.add(password);

	JButton login = new JButton("LOGIN");
	login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
				try {
					String user= username.getText();
					String pwd =  String.valueOf(password.getPassword());
					PreparedStatement pst= con.prepareStatement("select * from registerdata where username=? and password=?");
					
					pst.setString(1,  user);
					pst.setString(2, pwd);
					ResultSet r= pst.executeQuery();
					
					if(r.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successful");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid credentials");
					}
					
					
				}catch(Exception e3) {}
				
				
			}
	});
	login.setBorder(new EmptyBorder(0, 0, 0, 0));
	login.setFont(new Font("Segoe UI", Font.BOLD, 18));
	login.setText("LOG IN");
	login.setBackground(new Color(255, 167, 228));
	login.setBounds(218, 247, 158, 38);
	contentPane.add(login);

	JButton login1 = new JButton("SIGN UP");
	login1.setBorder(new EmptyBorder(0, 0, 0, 0));
	login1.setFont(new Font("Segoe UI", Font.BOLD, 18));
	login1.setText("SIGN UP");
	login1.setBackground(new Color(255, 167, 228));
	login1.setBounds(218, 295, 158, 38);
	contentPane.add(login1);
	
	JLabel lblFP = new JLabel("Forget Password?");
	lblFP.addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
			lblFP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	});
	lblFP.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			forgetpassword fp =  new forgetpassword();
			fp.setVisible(true);
			
			setVisible(false);
		}
	});
	lblFP.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	lblFP.setBounds(10, 362, 169, 29);
	contentPane.add(lblFP);

	login1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			SignUpFormm s = new SignUpFormm();
			s.setVisible(true);
			
			setVisible(false);
		}		
	});

	JLabel lblBgImage = new JLabel("Password");
	lblBgImage.setIcon(new ImageIcon(LoginDemo.class.getResource("/NewChat/BoxxBG.png")));
	lblBgImage.setBounds(0,0,638,428);
	getContentPane().add(lblBgImage);
	
	
	
	}
}