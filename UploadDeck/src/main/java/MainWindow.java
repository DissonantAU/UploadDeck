import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import uiComponents.jobPanel;
import uiComponents.postPane;



public class MainWindow {

	private JFrame frame;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(700, 500));

		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		JSplitPane splitPaneHorizontal = new JSplitPane();
		frame.getContentPane().add(splitPaneHorizontal, BorderLayout.CENTER);


		// Table of Post Jobs - Selecting one should update the Post Pane to show which one was selected
		jobPanel uploadJobPane = new jobPanel();
		splitPaneHorizontal.setLeftComponent(uploadJobPane);


		//Pane which represents a Post Job - Images, Text, & sites which will be uploaded to.
		postPane jobPostPane = new postPane();
		splitPaneHorizontal.setRightComponent(jobPostPane);

	}





}

