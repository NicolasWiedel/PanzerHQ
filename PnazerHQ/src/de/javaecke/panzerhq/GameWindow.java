package de.javaecke.panzerhq;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameWindow extends JFrame{
	
		// GamePanel
	private final GamePanel panzerGamePanel;
	
	public GameWindow(){
		
		this.panzerGamePanel = new GamePanel();
		
		registerWindowListener();
		createMenu();
		
		add(panzerGamePanel);
		pack();
		
		setTitle("PanzerHQ");
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
	}
	
	private void registerWindowListener(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				// Spiel pausieren
				panzerGamePanel.pauseGame();
			}
			@Override
			public void windowActivated(WindowEvent e) {
				// Spiel fortsetzen
				panzerGamePanel.continueGame();
			}
		});
	}
	
	private void createMenu(){
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenu gameMenu = new JMenu("Game");
		JMenu prefMenu = new JMenu("Preferences");
		
		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
		menuBar.add(prefMenu);
		
		addFileMenuItems(fileMenu);
		addGameMenuItems(gameMenu);
		addPrefMenuItems(prefMenu);
		
	}
	
	private void addFileMenuItems(JMenu fileMenu){
		
		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		quitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void addGameMenuItems(JMenu gameMenu){
		JMenuItem pauseItem = new JMenuItem("Pause");
		gameMenu.add(pauseItem);
		pauseItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panzerGamePanel.pauseGame();
			}
		});
		
		JMenuItem continueItem = new JMenuItem("Continue");
		gameMenu.add(continueItem);
		continueItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panzerGamePanel.continueGame();
			}
		});
		
		gameMenu.addSeparator();
		JMenuItem restartItem = new JMenuItem("Restart");
		gameMenu.add(restartItem);
		restartItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panzerGamePanel.restartGame();
			}
		});
	}
	
	private void addPrefMenuItems(JMenu prefMenu){
		
		JMenu subMenu = new JMenu("Choose Background");
		prefMenu.add(subMenu);
		
		JMenuItem menuItem = new JMenuItem("Mud Area");
		subMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panzerGamePanel.setBackgroundImage(0);
				repaint();
			}
		});
		
		menuItem = new JMenuItem("Snow Area");
		subMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panzerGamePanel.setBackgroundImage(1);
				repaint();
			}
		});
		
		menuItem = new JMenuItem("Desert Area");
		subMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panzerGamePanel.setBackgroundImage(2);
				repaint();
			}
		});
	}
}
