package NewChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxSession.Reset;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class forgetpassword extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldenterEmail;
	private JTextField textFieldVC;
	int randomCode;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgetpassword frame = new forgetpassword();
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
	public forgetpassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 150, 648, 438);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		textFieldenterEmail = new JTextField();
		textFieldenterEmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		textFieldenterEmail.setBounds(189, 62, 254, 42);
		contentPane.add(textFieldenterEmail);
		textFieldenterEmail.setColumns(10);
		
		JLabel lblEA = new JLabel("Email address");
		lblEA.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblEA.setBounds(25, 68, 212, 36);
		contentPane.add(lblEA);
		
		JLabel lblVC = new JLabel("Verify Code");
		lblVC.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblVC.setBounds(25, 226, 200, 36);
		contentPane.add(lblVC);
		
		textFieldVC = new JTextField();
		textFieldVC.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		textFieldVC.setColumns(10);
		textFieldVC.setBounds(189, 220, 254, 42);
		contentPane.add(textFieldVC);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(textFieldVC.getText())==randomCode) {
					resetpassword rsp = new resetpassword();
					rsp.setVisible(true);
					
					setVisible(false);
							
				}
				else {
					JOptionPane.showMessageDialog(null, "verification code did not match");
				}
				
				
			}
		});
		btnVerify.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		btnVerify.setBounds(324, 283, 120, 36);
		contentPane.add(btnVerify);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    

			    	Random rand = new Random();
			    	randomCode= rand.nextInt(999999);
				    	
				        // Recipient's email ID needs to be mentioned.
				        String to = "rutujapatil0511@gmail.com";

				        // Sender's email ID needs to be mentioned
				        String from = "patilrutuja861@gmail.com";

				        // Assuming you are sending email from through gmails smtp
				        String host = "smtp.gmail.com";

				        // Get system properties
				        Properties properties = System.getProperties();

				        // Setup mail server
				        properties.put("mail.smtp.host", host);
				        properties.put("mail.smtp.port", "465");
				        properties.put("mail.smtp.ssl.enable", "true");
				        properties.put("mail.smtp.auth", "true");

				        // Get the Session object.// and pass username and password
				        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

				            protected PasswordAuthentication getPasswordAuthentication() {

				                return new PasswordAuthentication("patilrutuja861@gmail.com", "doremon@1");

				            }

				        });

				        // Used to debug SMTP issues
				        session.setDebug(true);

				        try {
				            // Create a default MimeMessage object.
				            MimeMessage message = new MimeMessage(session);

				            // Set From: header field of the header.
				            message.setFrom(new InternetAddress(from));

				            // Set To: header field of the header.
				            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				            // Set Subject: header field
				            message.setSubject("Verification code for your account!");

				            // Now set the actual message
				            message.setText("Your security code is "+randomCode);

				            System.out.println("sending...");
				            // Send message
				            Transport.send(message);
				            System.out.println("Sent message successfully....");
				        } catch (MessagingException mex) {
				            mex.printStackTrace();
				        }

				    

				


			}
		});
		btnSend.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		btnSend.setBounds(324, 127, 120, 36);
		contentPane.add(btnSend);
		
		
		JLabel lblBgImage = new JLabel("");
		lblBgImage.setIcon(new ImageIcon(LoginDemo.class.getResource("/NewChat/signup.png")));
		lblBgImage.setBounds(0,0,634,401);
		getContentPane().add(lblBgImage);
		
		
		
		
	}
}
