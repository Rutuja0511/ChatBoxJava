package NewChat;



import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class Snake extends JFrame{

    Snake(){
    	
        super("Snake Game");
        Board board = new Board();
        getContentPane().add(board);
        board.setLayout(null);
        
        JButton btnBACK = new JButton("Back");
        btnBACK.setBackground(new Color(255, 255, 255));
        btnBACK.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Games g= new Games();
        		g.setVisible(true);
        		
        		setVisible(false);
        	}
        	
        });
        btnBACK.setBounds(22, 314, 254, 35);
        btnBACK.setFont(new Font("Lucida Bright", Font.BOLD, 24));
        board.add(btnBACK);
        pack();
        
        setLocationRelativeTo(null);
//        setTitle("Snake Game");
        setResizable(false);
        
      
    }
    
    
    public static void main(String[] args){
        new Snake().setVisible(true);
    
    }
}