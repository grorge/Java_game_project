import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;


public class g_Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833925668554977150L;


	public JFrame frame;
	
	
	public g_Window(int w, int h, String title, Game game) {
		
		JFrame frame = new JFrame();
		
		Dimension windowSize = new Dimension(w, h);
		frame.setPreferredSize(windowSize);
		frame.setMaximumSize(windowSize);
		frame.setMinimumSize(windowSize);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		
		frame.add(game);
		game.start(); 
	} 
	 
} 
