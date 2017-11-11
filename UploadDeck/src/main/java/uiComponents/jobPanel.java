package uiComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class jobPanel extends JPanel {

	//Table which will hold all Post Jobs
	private JTable uploadJobTable;
	
	private JButton btnUploadJobOption, 
					btnUploadJobAdd,
					btnUploadJobDel;

	final String[] jobColumnNames = {"Name","Status"};


	public jobPanel() {
		super(new BorderLayout());
		this.setMinimumSize(new Dimension(250, 300));
		initJobPanel();
	}


	private void initJobPanel(){

		//Create Post Job Panel and put into a Scroll Pane
		uploadJobTable = new JTable(new JobTableModel());
		uploadJobTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		uploadJobTable.setMinimumSize(new Dimension(200, 200));
		uploadJobTable.setFillsViewportHeight(true);

		JScrollPane uploadJobTableScrollPane = new JScrollPane(uploadJobTable);
		uploadJobTableScrollPane.setMinimumSize(new Dimension(120, 120));
		uploadJobTableScrollPane.setPreferredSize(new Dimension(200, 200));

		//Create Button Panel and buttons
		JPanel JobSiteButtonPanel = new JPanel();
		JobSiteButtonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));

		btnUploadJobAdd = new JButton("New");
		btnUploadJobDel = new JButton("Delete");
		btnUploadJobOption = new JButton("Options");
		
		JobSiteButtonPanel.add(btnUploadJobAdd);
		JobSiteButtonPanel.add(btnUploadJobDel);
		JobSiteButtonPanel.add(btnUploadJobOption);

		// Add to Master JPanel and return
		this.add(uploadJobTableScrollPane, BorderLayout.CENTER);
		this.add(JobSiteButtonPanel, BorderLayout.SOUTH);

	}

	private static Object[][] initJobList(){
		Object[][] jobList = {
				{"No Image Selected",new Boolean(false), "Not selected"}
		};

		return jobList;
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


}
