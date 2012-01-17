package org.vj.cook.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vj.cook.bo.Recipe;
import org.vj.cook.service.Suggestor;

@Component
public class SuggestWindow extends JInternalFrame implements ActionListener{

//	private JFrame frmSuggestRecipes;
	private JTable table;
	private DefaultTableModel dtm;
	
	private Suggestor suggestor;
	
	private static final Logger logger = LoggerFactory.getLogger(SuggestWindow.class); 

	/**
	 * Launch the Main Window form.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuggestWindow window = new SuggestWindow();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuggestWindow() {
		super("Something!",true, true, true, true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frmSuggestRecipes = new JFrame();
		setTitle("Suggest Recipes");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton btnSuggestARecipe = new JButton("Suggest a Recipe!");
		btnSuggestARecipe.addActionListener(this);
		springLayout.putConstraint(SpringLayout.NORTH, btnSuggestARecipe, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSuggestARecipe, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnSuggestARecipe);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, btnSuggestARecipe);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 219, SpringLayout.SOUTH, btnSuggestARecipe);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 424, SpringLayout.WEST, getContentPane());
		getContentPane().add(scrollPane);
		
		table = new JTable();
		dtm = new DefaultTableModel(
				new Object[][] {},
					new String[] {
						"#", "Name"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				};

		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
	}

	@Autowired
	public void setSuggestor(Suggestor suggestor) {
		this.suggestor = suggestor;
	}

	private void btnSuggestActionPerformed(ActionEvent evt) {
		logger.debug("Suggest Button Clicked");
		try{
			List<Recipe> suggestions = suggestor.suggest();
			for (Recipe recipe : suggestions) {
				dtm.addRow(new Object[]{recipe.getId(), recipe.getName()});	
			}
			
		}catch (RuntimeException e) {
			logger.error("Error in retriving Suggestions!",e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btnSuggestActionPerformed(e);
	}

}
