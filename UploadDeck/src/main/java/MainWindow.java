import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTable;


public class MainWindow {

	private JFrame frame;
	private JTable jobTable;
	private JTable JobSiteTable;
	
	
	//
	final String[] jobColumnNames = {"Name","Status"};
	final String[] uploadColumnNames = {"Site","Upload","Status"};
	

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

	private static Object[][] initJobList(){
		Object[][] jobList = {
				{"No Image Selected",new Boolean(false), "Not selected"}
		};
		
		return jobList;
	}
	
	private static Object[][] initJobSiteList(){
		Object[][] jobList = {
				{"No Sites","Empty"}
		};
		
		return jobList;
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
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JSplitPane splitPaneHorizontal = new JSplitPane();
		frame.getContentPane().add(splitPaneHorizontal, BorderLayout.CENTER);
		
		JSplitPane jobSplitPane = new JSplitPane();
		jobSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneHorizontal.setRightComponent(jobSplitPane);
		
		JTabbedPane jobTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		jobTabbedPane.setMinimumSize(new Dimension(200, 100));
		jobSplitPane.setRightComponent(jobTabbedPane);
		
		JPanel GenericInfoPanel = new JPanel();
		GenericInfoPanel.setMinimumSize(new Dimension(100, 100));
		jobTabbedPane.addTab("New tab", null, GenericInfoPanel, null);
		
		JSplitPane jobDisplaySplitPane = new JSplitPane();
		jobDisplaySplitPane.setMinimumSize(new Dimension(50, 100));
		jobSplitPane.setLeftComponent(jobDisplaySplitPane);
		
		JPanel ImageDisplayPanel = new JPanel();
		ImageDisplayPanel.setMinimumSize(new Dimension(100, 100));
		jobDisplaySplitPane.setLeftComponent(ImageDisplayPanel);
		ImageDisplayPanel.setLayout(new MigLayout("", "[78px]", "[16px]"));
		
		JLabel label = new JLabel("No Image Set");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setMinimumSize(new Dimension(100, 100));
		ImageDisplayPanel.add(label, "cell 0 0,grow");
		
		JobSiteTable = new JTable(new JobSiteTableModel());
		JobSiteTable.setFillsViewportHeight(true);
		JobSiteTable.setMinimumSize(new Dimension(100, 100));
		JScrollPane jobListScrollPane = new JScrollPane(JobSiteTable);
		jobListScrollPane.setPreferredSize(new Dimension(200, 200));
		jobListScrollPane.setMinimumSize(new Dimension(120, 120));
		jobDisplaySplitPane.setRightComponent(jobListScrollPane);
		
		jobTable = new JTable(new JobTableModel());
		jobTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		jobTable.setFillsViewportHeight(true);
		jobTable.setMinimumSize(new Dimension(200, 200));
		JScrollPane jobTableScrollPane = new JScrollPane(jobTable);
		jobTableScrollPane.setMinimumSize(new Dimension(120, 120));
		splitPaneHorizontal.setLeftComponent(jobTableScrollPane);
	}

	class JobTableModel extends AbstractTableModel {
	    private String[] columnNames = jobColumnNames;
	    private Object[][] data = initJobList();

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
	
	class JobSiteTableModel extends AbstractTableModel {
	    private String[] columnNames = jobColumnNames;
	    private Object[][] data = initJobList();

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

