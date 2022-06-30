package NewChat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;



import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;

import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextPane;
import java.awt.event.*;
import java.net.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import java.awt.*; 


import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;





public class serverdesign extends JFrame implements ActionListener {

	JPanel contentPane;
	static JPanel p3= new JPanel();
	static JPanel p2= new JPanel();
	static JPanel left= new JPanel();
	
	 static Box vertical = Box.createVerticalBox();

	 Image img_dp = new ImageIcon(serverdesign.class.getResource("jerryS.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	 //Image img_phone = new ImageIcon(serverdesign.class.getResource("phonesignNew.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	 //Image img_video = new ImageIcon(serverdesign.class.getResource("videosignNew.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	 Image img_thumbsup = new ImageIcon(serverdesign.class.getResource("thumbsup.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	 Image img_smile = new ImageIcon(serverdesign.class.getResource("smile.png")).getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	 Image img_heart = new ImageIcon(serverdesign.class.getResource("heart.png")).getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	 Image img_Fire = new ImageIcon(serverdesign.class.getResource("Fire.png")).getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	 Image img_laugh = new ImageIcon(serverdesign.class.getResource("laugh.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	 Image img_sad = new ImageIcon(serverdesign.class.getResource("sad.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	 Image img_bgchatboxx = new ImageIcon(serverdesign.class.getResource("bgchatboxx.png")).getImage().getScaledInstance(448, 353, Image.SCALE_SMOOTH);
	 
	 JTextField textField;
	
	

	/**
	 * Create the frame.
	 */
	
	static JPanel a1;
	
	static ServerSocket skt;
	static Socket s;
	
	static DataInputStream din1;
	static DataOutputStream dout1;
	static DataOutputStream dout;
	
	Boolean typing;
	private final Action action = new SwingAction();
	
	
	serverdesign() {
		
		JPanel p1;
		p1 = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLocation(100, 100);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(210, 165, 58, -66);
		contentPane.add(list);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(0, 0, 139));
		panelInfo.setBounds(9, 0, 167, 309);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblIconLogo = new JLabel("New label");
		lblIconLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconLogo.setBounds(44, 32, 86, 86);
		lblIconLogo.setIcon(new ImageIcon(img_dp));
		panelInfo.add(lblIconLogo);
		
		JLabel lblClientname = new JLabel("Jerry");
		lblClientname.setForeground(new Color(255, 255, 255));
		lblClientname.setFont(new Font("Segoe UI Symbol", Font.BOLD, 17));
		lblClientname.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientname.setBounds(27, 10, 103, 25);
		panelInfo.add(lblClientname);
		
		JLabel lblActiveNow = new JLabel("Active Now");
		lblActiveNow.setForeground(new Color(255, 255, 255));
		lblActiveNow.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		lblActiveNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveNow.setBounds(34, 115, 96, 25);
		panelInfo.add(lblActiveNow);
		
		JLabel lblmobileno = new JLabel("+91 9757055341");
		lblmobileno.setForeground(Color.WHITE);
		lblmobileno.setBackground(Color.WHITE);
		lblmobileno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblmobileno.setHorizontalAlignment(SwingConstants.CENTER);
		lblmobileno.setBounds(27, 150, 109, 13);
		panelInfo.add(lblmobileno);
		
		JButton btnThumbsup = new JButton("");
		btnThumbsup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String img_name = "thumbsup.png";
				System.out.println("MouseClick1");
				p2 = formatLabelImage(img_name);
				left = new JPanel(new BorderLayout());
				left.add(p2, BorderLayout.LINE_END);
				vertical.add(left);
			
				
			}
		});
		btnThumbsup.setAction(action);
		btnThumbsup.setBackground(new Color(0, 0, 128));
		btnThumbsup.setBounds(7, 170, 47, 52);
		btnThumbsup.setIcon(new ImageIcon(img_thumbsup));
		panelInfo.add(btnThumbsup);
		
		
		JButton btnheart = new JButton("");
		btnheart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String img_name = "heart.png";
				System.out.println("MouseClick1");
				p2 = formatLabelImage(img_name);
				left = new JPanel(new BorderLayout());
				left.add(p2, BorderLayout.LINE_END);
				vertical.add(left);
			}
		});
		btnheart.setBackground(new Color(0, 0, 128));
		btnheart.setBounds(58, 170, 47, 52);
		btnheart.setIcon(new ImageIcon(img_heart));
		panelInfo.add(btnheart);
		
		
		
		
						
		
		JButton btnSmile = new JButton("");
		btnSmile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String img_name = "smile.png";
				System.out.println("MouseClick1");
				p2 = formatLabelImage(img_name);
				left = new JPanel(new BorderLayout());
				left.add(p2, BorderLayout.LINE_END);
				vertical.add(left);
			}
		});
		btnSmile.setBackground(new Color(0, 0, 128));
		btnSmile.setBounds(109, 170, 51, 52);
		btnSmile.setIcon(new ImageIcon(img_smile));
		panelInfo.add(btnSmile);
		
		
		JButton btnFire = new JButton("");
		btnFire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String img_name = "Fire.png";
				System.out.println("MouseClick1");
				p2 = formatLabelImage(img_name);
				left = new JPanel(new BorderLayout());
				left.add(p2, BorderLayout.LINE_END);
				vertical.add(left);
			}
		});
		btnFire.setBackground(new Color(0, 0, 128));
		btnFire.setBounds(7, 232, 47, 52);
		btnFire.setIcon(new ImageIcon(img_Fire));
		panelInfo.add(btnFire);
		
		
		JButton btnlaugh = new JButton("");
		btnlaugh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String img_name = "laugh.png";
				System.out.println("MouseClick1");
				p2 = formatLabelImage(img_name);
				left = new JPanel(new BorderLayout());
				left.add(p2, BorderLayout.LINE_END);
				vertical.add(left);
			}
		});
		btnlaugh.setBackground(new Color(0, 0, 128));
		btnlaugh.setBounds(58, 232, 47, 52);
		btnlaugh.setIcon(new ImageIcon(img_laugh));
		panelInfo.add(btnlaugh);
		
		
		JButton btnsad = new JButton("");
		btnsad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String img_name = "sad.png";
				System.out.println("MouseClick1");
				p2 = formatLabelImage(img_name);
				left = new JPanel(new BorderLayout());
				left.add(p2, BorderLayout.LINE_END);
				vertical.add(left);
			}
		});
		btnsad.setBackground(new Color(0, 0, 128));
		btnsad.setBounds(109, 232, 51, 52);
		btnsad.setIcon(new ImageIcon(img_sad));
		panelInfo.add(btnsad);
		
		
		
		
		

		
		
		Timer t = new Timer(1, new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
				if(!typing) {
					lblActiveNow.setText("Active Now");
				}
			}
		});
		
		t.setInitialDelay(1000);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(10, 363, 166, 34);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(186, 363, 448, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		a1 = new JPanel();
		a1.setBounds(176, 0, 448, 353);
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
	
		contentPane.add(a1);
		a1.setLayout(null);
		JLabel lblchatboxx = new JLabel("");
		lblchatboxx.setBounds(10, 0, 448, 353);
		a1.add(lblchatboxx);
		
		JScrollPane sp = new JScrollPane(a1);
		sp.setBounds(180,5,451,355);
		
		
		ScrollBarUI ui = new BasicScrollBarUI() {
			protected JButton createDecreaseButton(int orientation){
				JButton button = super.createDecreaseButton(orientation);
				button.setBackground(new Color(0, 0, 128));
				button.setForeground(Color.white);
				this.thumbColor = new Color(177, 237, 239);
				return button;
			}
			
			protected JButton createIncreaseButton(int orientation){
				JButton button = super.createIncreaseButton(orientation);
				button.setBackground(new Color(0, 0, 128));
				button.setForeground(Color.white);
				return button;
			}
		};
		
		
		sp.getVerticalScrollBar().setUI(ui);
		contentPane.add(sp);
		
		JButton btnNewButton_1 = new JButton("Games");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Games gg = new Games();
				gg.setVisible(true);

				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(177, 237, 239));
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_1.setBounds(9, 319, 167, 34);
		contentPane.add(btnNewButton_1);
		
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				lblActiveNow.setText("Typing...");
				
				t.stop();
				
				typing = true;
				
			}
			
			public void keyReleased(KeyEvent ke) {
				typing = false;
				
				if(!t.isRunning()){
					t.start();
					
				}
			}
		});
		
		
	}

	private ActionListener newActionListener() {
		// TODO Auto-generated method stub
		return null;
	}
		public void actionPerformed(ActionEvent ae) {
	
			try {
			String out =textField.getText();
			sendTextToFile(out);
			JPanel p2 = formatLabel(out);
			
			a1.setLayout(new BorderLayout());
			
			JPanel right = new JPanel(new BorderLayout());
			right.add(p2, BorderLayout.LINE_END);
			vertical.add(right);
			vertical.add(Box.createVerticalStrut(11));
			
			a1.add(vertical, BorderLayout.PAGE_START);
			//a1.add(p2);
			textField.setText("JERRY:");
			dout1.writeUTF(out);
			
			
					
			}catch(Exception e) {}
			

		}
		
		
		
		
			
		
		public void sendTextToFile(String message) throws FileNotFoundException {
			try(FileWriter f =  new FileWriter("chat.txt"); 
					PrintWriter p = new PrintWriter(new BufferedWriter(f));){
				
				p.println("Jerry : "+ message);
			}catch (Exception e) {
				e.printStackTrace();
			}
			}
		
		
		
		
		

		
		public static JPanel formatLabel(String out) {
			 
			p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
			
			JLabel l1 = new JLabel("<html><p style = \"width : 150px\">" + out+"</p></html>");
		
		    l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			l1.setBackground(new Color(177, 237, 239));
			l1.setOpaque(true);
			l1.setBorder(new EmptyBorder(10, 10, 10, 60));
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			
			JLabel l2 = new JLabel();
			l2.setText(sdf.format(cal.getTime()));
			
			p3.add(l1);
			p3.add(l2);
			return p3;
		
		}
		public static JPanel formatLabelImage(String image) {
			 
			
			JLabel l1=new JLabel();
			l1.setIcon(new ImageIcon(new ImageIcon(serverdesign.class.getResource(image)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			System.out.println("Image set");
			l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			l1.setBackground(new Color(177, 237, 239));
			l1.setOpaque(true);
			l1.setBorder(new EmptyBorder(10, 10, 10, 60));
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			
			JLabel l2 = new JLabel();
			l2.setText(sdf.format(cal.getTime()));
			
			p3.add(l1);
			p3.add(l2);
			return p3;
		
		}
		
		
		
		    public static void main(String[] args) {
		    	new serverdesign().setVisible(true);
		    	
		    	String msginput = "";
				try {
					skt = new ServerSocket(8699);
					while(true) {
					s= skt.accept();
					
					
					 din1 =  new DataInputStream(s.getInputStream());
					 dout1 = new DataOutputStream(s.getOutputStream());
					 
					 while(true) {
						 msginput = din1.readUTF();
						
					p2 = formatLabel(msginput);
					left = new JPanel(new BorderLayout());
							left.add(p2, BorderLayout.LINE_START);
							vertical.add(left);
				
					 }
					 
				}
					 
					}catch (Exception e) {}
				
			//EventQueue.invokeLater(new Runnable() {
				//public void run() {
					//try {
					//	serverdesign frame = new serverdesign();
					//	frame.setVisible(true);
					//} catch (Exception e) {
					//	e.printStackTrace();
					//}
					
					
		//}
	//});
}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}


