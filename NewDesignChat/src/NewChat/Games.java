package NewChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Games extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Games frame = new Games();
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
	public Games() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 150, 648, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlayss = new JButton("Snake Game");
		btnPlayss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Snake tt = new Snake();
				tt.setVisible(true);
				setVisible(false);
			}
		});
		btnPlayss.setFont(new Font("Segoe Print", Font.BOLD, 25));
		btnPlayss.setForeground(new Color(255, 255, 204));
		btnPlayss.setBackground(new Color(0, 0, 102));
		btnPlayss.setBounds(162, 329, 241, 47);
		btnPlayss.setFocusable(false);
		contentPane.add(btnPlayss);
		
		JButton btnPlayBB = new JButton("Brick Game");
		btnPlayBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				 		JFrame obj = new JFrame();

				 		Gameplay gamePlay= new Gameplay();
				 		
				 		obj.setBounds(380,100,700,600);
				 		obj.setTitle("Brick Game");
				 		obj.setResizable(false);
				 		obj.setVisible(true);
				 		obj.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				 		obj.add(gamePlay);

				}
			
			}
		
		);
		
		btnPlayBB.setFont(new Font("Segoe Print", Font.BOLD, 27));
		btnPlayBB.setForeground(new Color(255, 255, 204));
		btnPlayBB.setBackground(new Color(0, 0, 102));
		btnPlayBB.setBounds(240, 189, 241, 47);
		btnPlayBB.setFocusable(false);
		contentPane.add(btnPlayBB);
		
		
		JButton btnchat = new JButton("Back to Chat");
		btnchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverdesign sd = new serverdesign();
				sd.setVisible(true);
				
				setVisible(false);
			}
		});
		btnchat.setBackground(new Color(255, 204, 204));
		btnchat.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnchat.setBounds(10, 10, 173, 49);
		btnchat.setFocusable(false);
		contentPane.add(btnchat);
		
		
		
		JLabel lblBgImage = new JLabel("");
		lblBgImage.setIcon(new ImageIcon(LoginDemo.class.getResource("/NewChat/GameBG.png")));
		lblBgImage.setBounds(0,0,634,428);
		getContentPane().add(lblBgImage);
		
		
	}
}
