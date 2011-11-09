package ru.semikov.sea.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameView extends JFrame {
	private GameModel model;
	private GameController controller;

	private JMenuItem mntmNewGame;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JMenuItem mntm5;
	private JMenuItem mntm10;
	private JMenuItem mntm15;
	private JMenuItem mntm20;

	public PanelFieldPlayer panelPlayerPlayer;
	public PanelFieldOpponent panelPlayerOpponent;
	private ScoreField panelScore;
	
	public GameView(GameModel model) {
		this.model = model;
		buildUI();
		this.model.register(panelPlayerPlayer);
		this.model.register(panelPlayerOpponent);
		this.model.register(panelScore);
		this.controller=new GameController(this, model);
		attachController();
	}

	/**
	 * обновляем данные на форме
	 */
	public void update() {
		panelPlayerPlayer.repaint();
		panelPlayerOpponent.repaint();
		panelScore.repaint();
		System.out.println("view update");
	}

	/**
	 * добавление слушателей формы и направляем их на контроллер 
	 */
	public void attachController() {
		mntmAbout.addActionListener(controller);
		mntmNewGame.addActionListener(controller);
		mntmExit.addActionListener(controller);
		mntm5.addActionListener(controller);
		mntm10.addActionListener(controller);
		mntm15.addActionListener(controller);
		mntm20.addActionListener(controller);
		panelPlayerOpponent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				controller.mousePressed(arg0);
			}
		});
	}

	/**
	 * построение интерфейса пользователя
	 */
	private void buildUI() {
		this.setTitle("SeaBattle");
		this.setResizable(false);
		this.setBounds(400, 300, 483, 228);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width-this.getWidth())/2, (screenSize.height-this.getHeight())/2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		panelPlayerPlayer = new PanelFieldPlayer(model.playerFieldPlayer);
		panelPlayerPlayer.setBounds(20, 31, 151, 151);
		this.getContentPane().add(panelPlayerPlayer);
		
		panelPlayerOpponent = new PanelFieldOpponent(model.playerFieldOpponent);
		panelPlayerOpponent.setBounds(190, 31, 151, 151);
		this.getContentPane().add(panelPlayerOpponent);
		
		panelScore = new ScoreField(model);
		
		panelScore.setBounds(370, 31, 90, 151);
		panelScore.setBackground(new Color(225, 225, 255));
		this.getContentPane().add(panelScore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 477, 21);
		this.getContentPane().add(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		mntmNewGame = new JMenuItem("New game");
		mnGame.add(mntmNewGame);
		
		mntmExit = new JMenuItem("Exit");
		mnGame.add(mntmExit);

		JMenu mnProperties = new JMenu("Properties");
		menuBar.add(mnProperties);
		
		mntm5 = new JMenuItem("5 x 5");
		mnProperties.add(mntm5);
		
		mntm10 = new JMenuItem("10 x 10");
		mnProperties.add(mntm10);
		
		mntm15 = new JMenuItem("15 x 15");
		mnProperties.add(mntm15);
		
		mntm20 = new JMenuItem("20 x 20");
		mnProperties.add(mntm20);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}


}
