import java.awt.*;
import javax.swing.*;

public class VideoPoker {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Video Poker");
		frame.setResizable(false);
		
		PokerPanel poker = new PokerPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(poker);
		frame.pack();
		frame.setVisible(true);
		
		/*JFrame frame2 = new JFrame("TEST FRAME PLEASE IGNORE");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		ImageIcon icon = new ImageIcon("cards/blank.jpg");
		JLabel label = new JLabel(icon);
		panel.setPreferredSize(new Dimension(300, 400));
		panel.setBackground(Color.cyan);
		panel.add(label);
		
		frame2.getContentPane().add(panel);
		frame2.pack();
		frame2.setVisible(true);
		*/

	}

}
