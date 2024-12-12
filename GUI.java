package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	
	private JTextArea mainDisplay;
	private JTextField input;
	
	public GUI() {
		buildWindow();
		if(mainDisplay == null || input == null) {
			System.out.println("GUI cannot run.");
		}
	}
	
	private void buildWindow() {
		setTitle("Home");
		setLayout(new BorderLayout());
	
	
	mainDisplay = new JTextArea();
	input = new JTextField();
	
	JPanel southPanel = new JPanel(new GridLayout(3, 1));
	JLabel label = new JLabel("What do you want to do?");
	JButton button = new JButton("Execute");
	button.addActionListener(this);
	southPanel.add(label);
	southPanel.add(input);
	southPanel.add(button);
	
	add(mainDisplay, BorderLayout.CENTER);
	add(southPanel, BorderLayout.SOUTH);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500, 500);
	setLocationRelativeTo(null);
	setVisible(true);
}
	
	public void print(Object obj) {
		mainDisplay.append(obj.toString()+"\n");
	}
	
	public void actionPerformed(ActionEvent e) {
		Game.processCommand(input.getText());
		input.setText("");
	}
}

