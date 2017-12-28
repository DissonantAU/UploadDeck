package uiComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import containers.PostContainer;
import containers.JobContainer;


public class jobPanel extends JPanel implements ActionListener, ListSelectionListener {

	final static private String AC_New = "ACNEW";
	final static private String AC_Delete = "ACDELETE";
	final static private String AC_Options = "ACOPTIONS";


	private JobContainer jobDataContainer;


	private int selectedTableRow;

	//Post pane that has been passed a Job
	private postPane postPaneUI;

	// #### UI Elements ####

	//Table which will hold all Post Jobs
	private JTable uploadJobTable;
	private JobTableModel uploadTableModel;

	private JButton btnUploadJobOption, 
	btnUploadJobAdd,
	btnUploadJobDel;

	// #### UI Elements ####


	public jobPanel() {
		super(new BorderLayout());
		this.setMinimumSize(new Dimension(250, 300));
		initJobPanel();
	}


	public jobPanel(JobContainer jobData) {

	}

	public jobPanel(postPane jobPostPane) {
		super(new BorderLayout());
		this.setMinimumSize(new Dimension(250, 300));
		initJobPanel();

		postPaneUI=jobPostPane;
	}


	public void setData(JobContainer jobData){
		jobDataContainer = jobData;
		
		//Select First Row in Table
		selectedTableRow=0;
		
		uploadJobTable.setRowSelectionInterval(selectedTableRow, selectedTableRow);
	}

	private void initJobPanel(){

		//Create Post Job Panel and put into a Scroll Pane
		uploadTableModel = new JobTableModel();
		uploadJobTable = new JTable(uploadTableModel);
		uploadJobTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		uploadJobTable.setMinimumSize(new Dimension(200, 200));
		uploadJobTable.setFillsViewportHeight(true);
		uploadJobTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane uploadJobTableScrollPane = new JScrollPane(uploadJobTable);
		uploadJobTableScrollPane.setMinimumSize(new Dimension(120, 120));
		uploadJobTableScrollPane.setPreferredSize(new Dimension(200, 200));

		//Create Button Panel and buttons
		JPanel JobSiteButtonPanel = new JPanel();
		JobSiteButtonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));

		btnUploadJobAdd = new JButton("New");
		btnUploadJobAdd.setActionCommand(AC_New);
		btnUploadJobAdd.addActionListener(this);

		btnUploadJobDel = new JButton("Delete");
		btnUploadJobDel.setActionCommand(AC_Delete);
		btnUploadJobDel.addActionListener(this);

		btnUploadJobOption = new JButton("Options");
		btnUploadJobOption.setActionCommand(AC_Options);
		btnUploadJobOption.addActionListener(this);

		JobSiteButtonPanel.add(btnUploadJobAdd);
		JobSiteButtonPanel.add(btnUploadJobDel);
		JobSiteButtonPanel.add(btnUploadJobOption);

		//Setup Selection Listener for Table
		uploadJobTable.getSelectionModel().addListSelectionListener(this);


		// Add to Master JPanel and return
		this.add(uploadJobTableScrollPane, BorderLayout.CENTER);
		this.add(JobSiteButtonPanel, BorderLayout.SOUTH);

	}

	// ##### UI ACTION LISTNENERS #####

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == AC_New){
			System.out.println("Job Panel - New Pressed");
			jobDataContainer.createBlankJob();
			selectedTableRow++;
			//Update Table
			uploadTableModel.fireTableDataChanged();
		}else if (e.getActionCommand() == AC_Delete){
			System.out.println("Job Panel - Delete Pressed");
			int selectedRow = uploadJobTable.getSelectedRow();
			if (selectedRow ==-1){
				//Do nothing, no job selected
			}else{
				//Delete Selected Job
				jobDataContainer.deleteJob(selectedTableRow);
				selectedTableRow--;

				// If now Jobs left, make a blank one
				if (jobDataContainer.count()==0){
					jobDataContainer.createBlankJob();
					selectedTableRow=0;
				}
				//Update Table
				uploadTableModel.fireTableDataChanged();
			}

		} else if (e.getActionCommand() == AC_Options){
			System.out.println("Job Panel - Options Pressed");
		}  else {
			System.out.println("Job Panel - Unknown Pressed: "+e.getActionCommand());
		}

	} 

	public void JobUIUpdate(){
		System.out.println("Job Panel - JobUIUpdate Triggered");
		//Update Table
		uploadTableModel.fireTableDataChanged();
	}

	public void valueChanged(ListSelectionEvent event) {
		int selectedRow = uploadJobTable.getSelectedRow();
		if (selectedRow ==-1){
			uploadJobTable.setRowSelectionInterval(selectedTableRow, selectedTableRow);
		}else{
			selectedTableRow = selectedRow;
			System.out.println("Job Panel - Selected '" + uploadJobTable.getValueAt(selectedRow, 0).toString()+"' at row " + selectedRow);

			//Pass Job to postPane
			postPaneUI.setJob(jobDataContainer.getJob(selectedRow),this);
		}
	}


	// ##### ACTION LISTNENERS #####

	class JobTableModel extends AbstractTableModel {
		/* Title : text
		 * Status : text
		 */

		final private String[] columnNames = {"Title","Status"};

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			if (jobDataContainer==null){
				return 0;
			}
			return jobDataContainer.count();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			PostContainer job = jobDataContainer.getJob(row);
			if (col==1){
				return job.getStatus();
			}
			return job.getTitle();
		}

		public Class<? extends Object> getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
	}

	/**
	 * Run when a post's title is updated
	 */
	public void updateTitle() {
		//Update Table
		uploadTableModel.fireTableCellUpdated(uploadJobTable.getSelectedRow(), 0);
	}

	/**
	 * Run when a post's status is updated
	 */
	public void updateStatus() {
		//Update Table
		uploadTableModel.fireTableCellUpdated(uploadJobTable.getSelectedRow(), 1);
	}

}
