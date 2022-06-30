package NewChat;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) {
		
		
		JFrame obj = new JFrame();

		Gameplay gamePlay= new Gameplay();
		
		obj.setBounds(400,50,700,680);
		obj.setTitle("BreakOut Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.getContentPane().add(gamePlay);
		gamePlay.setLayout(null);

	}

	
}
