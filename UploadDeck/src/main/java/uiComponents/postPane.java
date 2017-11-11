package uiComponents;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class postPane extends JSplitPane {
	// Bottom Tab Pane for displaying/entering Post details (Description, Tags, etc.)
	private JTabbedPane jobTabbedPane;

	// Upper Pane for showing the image(s) to be uploaded and sites
	private JSplitPane jobDisplaySplitPane;

	//Buttons under Job Site List
	JButton btnJobSiteOption;


	//Image display - label used to display image(s)
	JLabel postImage;

	//List to display/set which sites the post is uploaded to
	private JTable JobSiteTable;

	public postPane() {
		super(JSplitPane.VERTICAL_SPLIT);
		this.setMinimumSize(new Dimension(300, 400));

		initTopPane();
		initBottomPane();

		this.setTopComponent(jobDisplaySplitPane);
		this.setBottomComponent(jobTabbedPane);
	}

	private void initBottomPane(){
		JPanel TabGenericInfoPanel = new JPanel();
		TabGenericInfoPanel.setMinimumSize(new Dimension(100, 100));

		jobTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		jobTabbedPane.setMinimumSize(new Dimension(200, 100));
		jobTabbedPane.addTab("New tab", null, TabGenericInfoPanel, null);

	}

	private void initTopPane(){
		jobDisplaySplitPane = new JSplitPane();
		jobDisplaySplitPane.setMinimumSize(new Dimension(350, 100));
		jobDisplaySplitPane.setLeftComponent(initImageDisplay());
		jobDisplaySplitPane.setRightComponent(initJobUploadPane());

	}

	private JPanel initImageDisplay(){
		JPanel imageDisplayPanel = new JPanel();
		imageDisplayPanel.setMinimumSize(new Dimension(100, 100));
		jobDisplaySplitPane.setLeftComponent(imageDisplayPanel);

		postImage = new JLabel("No Image Set");
		postImage.setHorizontalAlignment(SwingConstants.CENTER);
		postImage.setMinimumSize(new Dimension(100, 100));
		imageDisplayPanel.add(postImage, "cell 0 0,grow");
		return imageDisplayPanel;
	}

	private JPanel initJobUploadPane(){
		// Master JPanel which contains the Table showing the Sites to upload to, and buttons
		JPanel JobUploadPanel = new JPanel();
		JobUploadPanel.setLayout(new BorderLayout());

		//Create Job site Panel and put into a Scroll Pane
		JobSiteTable = new JTable(new JobSiteTableModel());
		JobSiteTable.setFillsViewportHeight(true);
		JobSiteTable.setMinimumSize(new Dimension(100, 100));
		JScrollPane jobListScrollPane = new JScrollPane(JobSiteTable);
		jobListScrollPane.setMinimumSize(new Dimension(120, 120));
		jobListScrollPane.setPreferredSize(new Dimension(200, 200));

		//Create Button Panel and buttons
		JPanel JobSiteButtonPanel = new JPanel();
		JobSiteButtonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		JobSiteButtonPanel.setPreferredSize(new Dimension(90, 30));

		btnJobSiteOption = new JButton("Options");
		JobSiteButtonPanel.add(btnJobSiteOption);

		// Add to Master JPanel and return
		JobUploadPanel.add(jobListScrollPane, BorderLayout.CENTER);
		JobUploadPanel.add(JobSiteButtonPanel, BorderLayout.SOUTH);		

		return JobUploadPanel;
	}

	private static Object[][] initJobSiteList(){
		//Returns all sites that the post can be uploaded to
		Object[][] jobSiteList = {
				{"Site 1",new Boolean(false),"Not Selected"},
				{"Site 2",new Boolean(false),"Not Selected"}
		};

		return jobSiteList;
	}

	class JobSiteTableModel extends AbstractTableModel {
		final private String[] columnNames = {"Site","Upload","Status"};
		private Object[][] data = initJobSiteList();

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

}