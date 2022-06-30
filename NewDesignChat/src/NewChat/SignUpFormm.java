package NewChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUpFormm extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textFieldMNO;
	private JTextField textFieldDOB;
	private JTextField textFieldEA;
	private JPasswordField passwordField;
	private JTextField textFieldun;
	JRadioButton Female;
	JRadioButton malee;
	String genderr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SignUpFormm frame = new SignUpFormm();
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
	private JTextField textFieldg;
	
	public SignUpFormm() {
		
		con=DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 150, 648, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(45, 128, 122, -71);
		contentPane.add(lblNewLabel);
	
		
		JLabel Name = new JLabel("Mobile Number");
		Name.setForeground(new Color(0, 0, 102));
		Name.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		Name.setBounds(54, 163, 172, 21);
		contentPane.add(Name);
		
		JLabel lblNewLabel_1 = new JLabel(" Sign Up");
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(200, 13, 248, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNewLabel_2.setBackground(Color.BLUE);
		lblNewLabel_2.setBounds(54, 74, 80, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNewLabel_3.setBounds(54, 118, 151, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNewLabel_5.setBounds(55, 249, 100, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel elab = new JLabel("");
		elab.setFont(new Font("Tahoma", Font.PLAIN, 13));
		elab.setForeground(new Color(255, 51, 51));
		elab.setBounds(458, 202, 152, 28);
		contentPane.add(elab);
		
		JLabel plab = new JLabel("");
		plab.setForeground(Color.RED);
		plab.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		plab.setBounds(458, 163, 166, 21);
		contentPane.add(plab);
		
		
		JLabel slab = new JLabel("");
		slab.setForeground(Color.RED);
		slab.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		slab.setBounds(458, 330, 152, 30);
		contentPane.add(slab);
		
		textName = new JTextField();
		textName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textName.setBounds(236, 70, 212, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textFieldMNO = new JTextField();
		textFieldMNO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[0-9]{10}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldMNO.getText());
				if(!match.matches()) {
					plab.setText("Enter 10 digit mobile number");
					
				}
				else {
					plab.setText(null);
				}
			}
		});
		textFieldMNO.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldMNO.setBounds(236, 160, 212, 28);
		contentPane.add(textFieldMNO);
		textFieldMNO.setColumns(10);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldDOB.setBounds(236, 113, 212, 30);
		contentPane.add(textFieldDOB);
		textFieldDOB.setColumns(10);
		
		textFieldEA = new JTextField();
		textFieldEA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(textFieldEA.getText());
				if(!match.matches()) {
					elab.setText("Enter valid email address!");
					
				}
				else {
					elab.setText(null);
				}
			}
		});
		textFieldEA.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldEA.setBounds(236, 202, 212, 30);
		contentPane.add(textFieldEA);
		textFieldEA.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(255, 153, 255));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String firstname = textName.getText();
					String mobilenumber =textFieldMNO.getText();
					String emailid =textFieldEA.getText();
					
					String dateofbirth =textFieldDOB.getText();
					String usernamee =textFieldun.getText();
					String pass =passwordField.getText();
					
				
					PreparedStatement pst= con.prepareStatement("insert into registerdata(name, mobileno, emailaddress, gender, dob, username, password) values(?,?,?,?,?,?,?)");
					pst.setString(1, firstname);
					pst.setString(2, mobilenumber);
					pst.setString(3, emailid);
					if(malee.isSelected()) {
						genderr = "male";
					}
					if(Female.isSelected()) {
						genderr ="female";
					}
					pst.setString(4, genderr);
					
					pst.setString(4, genderr);
					pst.setString(5, dateofbirth);
					pst.setString(6, usernamee);
					pst.setString(7, pass);
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data saved successfully"); 	
							
				}catch(Exception e4) {}
				
				
		
			
				SignupSuccesful s = new SignupSuccesful();
				s.setVisible(true);
			
				setVisible(false);
				
				
		}
		});
		btnNewButton.setBounds(212, 365, 182, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Email Address");
		lblNewLabel_4.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setBounds(54, 209, 172, 18);
		contentPane.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Username");
		lblNewLabel_6.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setBounds(54, 295, 162, 21);
		contentPane.add(lblNewLabel_6);
		
		passwordField = new JPasswordField();
//		passwordField.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
//				Pattern patt = Pattern.compile(PATTERN);
//				Matcher match = patt.matcher(textFieldMNO.getText());
//				if(!match.matches()) {
//					plab.setText("Enter 10 digit mobile number");
//					
//				}
//				else {
//					plab.setText(null);
//				}
//				
//			}
//		});
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		passwordField.setBounds(236, 328, 212, 30);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_6_1 = new JLabel("Set Password");
		lblNewLabel_6_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_6_1.setFont(new Font("Lucida Bright", Font.BOLD, 21));
		lblNewLabel_6_1.setBounds(54, 334, 162, 21);
		contentPane.add(lblNewLabel_6_1);
		
		textFieldun = new JTextField();
		textFieldun.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldun.setColumns(10);
		textFieldun.setBounds(236, 287, 212, 30);
		contentPane.add(textFieldun);
	
		
		
		malee = new JRadioButton("Male");
		malee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(malee.isSelected())
				{
					Female.setSelected(false);
				}
			}
		});
		malee.setBackground(new Color(204, 204, 255));
		malee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		malee.setBounds(236, 244, 103, 30);
		contentPane.add(malee);
		
		Female = new JRadioButton("Female");
		Female.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Female.isSelected())
				{
					malee.setSelected(false);
				}
			}
			
		});
		Female.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Female.setBackground(new Color(204, 204, 255));
		Female.setBounds(345, 244, 103, 30);
		contentPane.add(Female);
		
		
		JLabel lblBgImage = new JLabel("");
		lblBgImage.setForeground(new Color(0, 0, 102));
		lblBgImage.setIcon(new ImageIcon(LoginDemo.class.getResource("/NewChat/signup.png")));
		lblBgImage.setBounds(0,0,638,428);
		getContentPane().add(lblBgImage);
		
		JLabel ELID = new JLabel("00");
		ELID.setBounds(436, 365, 45, 13);
		contentPane.add(ELID);
		
		JLabel lblNewLabel_8 = new JLabel("00");
		lblNewLabel_8.setBounds(469, 388, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		
		
		
		
		
		
		
	}
	}		
		
		
	