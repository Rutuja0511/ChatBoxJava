package NewChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupSuccesful extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupSuccesful frame = new SignupSuccesful();
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
	public SignupSuccesful() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 150, 648, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(177, 237, 239));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Back to Login Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginDemo s = new LoginDemo();
				s.setVisible(true);
				
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(173, 297, 284, 54);
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		
		
		JLabel lblBgImage = new JLabel("");
		lblBgImage.setIcon(new ImageIcon(SignupSuccesful.class.getResource("/NewChat/BoxxIMG.png")));
		lblBgImage.setBounds(0, 0,648, 438);
		contentPane.add(lblBgImage);
		
		
		
	}

}
