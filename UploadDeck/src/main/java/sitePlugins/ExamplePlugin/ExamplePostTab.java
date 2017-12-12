package sitePlugins.ExamplePlugin;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import containers.PostContainer;
import sitePlugins.Interfaces.postTab;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ExamplePostTab extends JPanel implements postTab {

	private JTextField textTitle;
	private JTextField textTags;
	private JComboBox<String> comboRating;
	private JTextArea textDescription;
	
	final private String[] ratingStrings = {"General","Mature","Adult"};

	public ExamplePostTab() {
		initPane();
	}
	
	public void updateTitle(String text) {
		// TODO Auto-generated method stub

	}

	public void updateDescription(String text) {
		// TODO Auto-generated method stub

	}

	public void updateTags(String text) {
		// TODO Auto-generated method stub

	}

	public void updateRating(int rating) {
		// TODO Auto-generated method stub

	}

	public void enableTab() {
		// TODO Auto-generated method stub
		
	}

	public postTab disableTab() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initPane(){
		// Create a General Info Panel
		JPanel TabExamplePanel = this;
		TabExamplePanel.setMinimumSize(new Dimension(120, 100));
		TabExamplePanel.setLayout(new MigLayout("", "[][grow]", "[][grow][][]"));
		
		// Title. Used for Post Job Name field
		JLabel lblTitle = new JLabel("Title");

		TabExamplePanel.add(lblTitle, "cell 0 0,alignx trailing");
		
		textTitle = new JTextField();
		TabExamplePanel.add(textTitle, "flowx,cell 1 0,growx");
		
		// Post Text field and label (aka description)
		JLabel lblPostText = new JLabel("Description");

		TabExamplePanel.add(lblPostText, "cell 0 1,alignx trailing");
		
		textDescription = new JTextArea();
		
		
		

		textDescription.setLineWrap(true);
		textDescription.setRows(8);
		TabExamplePanel.add(textDescription, "flowx,cell 1 1,grow");
		
		// Tag box and label. (Tags should be separated by commas)
		JLabel lblTags = new JLabel("Tags");

		TabExamplePanel.add(lblTags, "cell 0 2,alignx trailing");
		
		textTags = new JTextField();
		TabExamplePanel.add(textTags, "flowx,cell 1 2,growx");
		
		// Rating Drop Down box and label
		JLabel lblRating = new JLabel("Rating");

		TabExamplePanel.add(lblRating, "cell 0 3,alignx trailing");
		
		
		comboRating = new JComboBox<String>(new DefaultComboBoxModel<String>(ratingStrings));
		
		TabExamplePanel.add(comboRating, "flowx,cell 1 3,growx");
		
		JCheckBox chckbxCustomiseTitle = new JCheckBox("Customise");
		
		add(chckbxCustomiseTitle, "cell 1 0,aligny top");
		
		JCheckBox chckbxCustomiseDesc = new JCheckBox("Customise");
		add(chckbxCustomiseDesc, "cell 1 1,aligny top");
		
		JCheckBox chckbxCustomiseTags = new JCheckBox("Customise");
		add(chckbxCustomiseTags, "cell 1 2,aligny top");
		
		JCheckBox chckbxCustomiseRating = new JCheckBox("Customise");
		add(chckbxCustomiseRating, "cell 1 3,aligny top");

		
		
		
		
		//Focus Listeners, for when box is deselected (Trigger updates, etc.)
		textTitle = new JTextField();
		textTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		textDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		
		textTags.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		comboRating.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		
		//CUstomise Button Listeners - enable/disable custom values in box
		chckbxCustomiseTitle.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Boolean enable = (Boolean) arg0.getNewValue();
				textTitle.setEnabled(enable);
				if (!enable){
					//If disabled, refresh value from Generic
					
				}
			}
		});
		
		
	}

	@Override
	public void setJob(PostContainer currentJob) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
