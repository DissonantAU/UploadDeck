package uiComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
import net.miginfocom.swing.MigLayout;
import sitePlugins.Interfaces.postTab;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class postPane extends JSplitPane {
	// Bottom Tab Pane for displaying/entering Post details (Description, Tags, etc.)
	private JTabbedPane jobTabbedPane;

	// Upper Pane for showing the image(s) to be uploaded and sites
	private JSplitPane jobDisplaySplitPane;

	//Buttons under Job Site List
	private JButton btnJobSiteOption;

	//Image display - label used to display image(s)
	private JLabel postImage;
	
	
	// Rating Combo box
	JComboBox<String> comboRating;
	
	
	// Combo Box Values
	// Should be 0 - General, 1 - Mature, 2 - Adult
	final private String[] ratingStrings = {"General Audience","Mature Audience","Adult Audience"};
	
	
	//postTab objects - visual object updates are triggered on these to update text, etc.
	ArrayList<postTab> postTabs;
	

	//List to display/set which sites the post is uploaded to
	private JTable JobSiteTable;
	private JTextField textTitle;
	private JTextField textTags;
	private JTextArea textDescription;

	public postPane() {
		super(JSplitPane.VERTICAL_SPLIT);
		this.setMinimumSize(new Dimension(300, 400));

		initTopPane();
		initBottomPane();

		this.setTopComponent(jobDisplaySplitPane);
		this.setBottomComponent(jobTabbedPane);
	}

	private void initBottomPane(){
		// Create a General Info Panel
		JPanel TabGenericInfoPanel = new JPanel();
		TabGenericInfoPanel.setMinimumSize(new Dimension(100, 100));
		TabGenericInfoPanel.setLayout(new MigLayout("", "[][grow]", "[][grow][][][]"));
		
		// Title. Used for Post Job Name field
		JLabel lblTitle = new JLabel("Title");
		TabGenericInfoPanel.add(lblTitle, "cell 0 0,alignx trailing");
		
		textTitle = new JTextField();
		TabGenericInfoPanel.add(textTitle, "cell 1 0,growx");
		
		// Post Text field and label (aka description)
		JLabel lblPostText = new JLabel("Description");
		TabGenericInfoPanel.add(lblPostText, "cell 0 1,alignx trailing");
		
		textDescription = new JTextArea();
		textDescription.setLineWrap(true);
		textDescription.setRows(8);
		TabGenericInfoPanel.add(textDescription, "cell 1 1,grow");
		
		// Tag box and label. (Tags should be separated by commas)
		JLabel lblTags = new JLabel("Tags");
		TabGenericInfoPanel.add(lblTags, "cell 0 2,alignx trailing");
		
		textTags = new JTextField();
		TabGenericInfoPanel.add(textTags, "cell 1 2,growx");
		
		// Rating Drop Down box and label
		JLabel lblRating = new JLabel("Rating");
		TabGenericInfoPanel.add(lblRating, "cell 0 3,alignx trailing");
		
		
		comboRating = new JComboBox<String>(new DefaultComboBoxModel<String>(ratingStrings));
		TabGenericInfoPanel.add(comboRating, "cell 1 3,growx");

		//Init postTab ArrayList
		postTabs = new ArrayList<postTab>();
		
		//Set up tabs and add panels
		jobTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		jobTabbedPane.setMinimumSize(new Dimension(200, 100));
		jobTabbedPane.addTab("General", null, TabGenericInfoPanel, "Info entered here is copied to the other sites");
		
		
		
		
		//Focus Listeners, for when box is deselected (Trigger updates, etc.)

		textTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String text = textTitle.getText();
				//Push update to each tab
				for (postTab tab:postTabs){
					tab.updateTitle(text);
				}
			}
		});
		
		textDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String text = textDescription.getText();
				//Push update to each tab
				for (postTab tab:postTabs){
					tab.updateDescription(text);
				}
			}
		});
		
		textTags.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String text = textTags.getText();
				//Push update to each tab
				for (postTab tab:postTabs){
					tab.updateTags(text);
				}
			}
		});
		
		comboRating.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int val = comboRating.getSelectedIndex();
				//Push update to each tab
				for (postTab tab:postTabs){
					tab.updateRating(val);
				}
			}
		});
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
		//JobSiteButtonPanel.setPreferredSize(new Dimension(90, 40));

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
		/* Name : text
		 * Status : text
		 */	
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
