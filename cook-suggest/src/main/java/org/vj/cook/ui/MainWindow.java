package org.vj.cook.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MainWindow extends JFrame implements ActionListener{
	private static final Logger logger = LoggerFactory.getLogger(MainWindow.class);
	private JDesktopPane desktopPane ;
	
	/**
	 * Create the application.
	 */
	public MainWindow() {
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			logger.error("Error in setting the look and feel of the application", e);
		}
		initialize();
	}
		
	/**
	 * Launch the Main Window form.
	 */
	@PostConstruct
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void initialize() {
		setTitle("The Cooking Helper Application");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		desktopPane = new JDesktopPane();
		//Make dragging a little faster but perhaps uglier.
	    desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

	    springLayout.putConstraint(SpringLayout.NORTH, desktopPane, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, desktopPane, -122, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, desktopPane, -170, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, desktopPane, -121, SpringLayout.EAST, getContentPane());
		add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, getContentPane());
		setJMenuBar(menuBar);
		
		JMenuItem mntmSearch = new JMenuItem("Search!");
		mntmSearch.addActionListener(this);
		menuBar.add(mntmSearch);
		
		JMenuItem mntmAddNewRecipe = new JMenuItem("Add New Recipe!");
		mntmAddNewRecipe.addActionListener(this);
		menuBar.add(mntmAddNewRecipe);
	}

	/**
	 * First version of the appl.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		logger.debug("action via {}",e);
		SuggestWindow suggest = new SuggestWindow();
        suggest.pack();
        desktopPane.add(suggest);
        suggest.setVisible(true); //necessary as of 1.3
        try {
            suggest.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
        	ex.printStackTrace();
        }
	}
}
