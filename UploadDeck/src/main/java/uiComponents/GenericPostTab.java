/**
 * 
 */
package uiComponents;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import sitePlugins.Interfaces.postTab;
import containers.PostContainer;

/**
 * @author Diss
 *
 */
public class GenericPostTab extends JPanel implements postTab {
	//TabID is used by PostContainer to know where pass info
	final static private String TabID = "Generic";
	
	// Rating Combo box
	JComboBox<String> comboRating;
	
	
	// Combo Box Values
	// Should be 0 - General, 1 - Mature, 2 - Adult
	final private String[] ratingStrings = {"General Audience","Mature Audience","Adult Audience"};
	

	private JTextField textTitle;
	private JTextField textTags;
	private JTextArea textDescription;
	
	private PostContainer post;
	

	public GenericPostTab(){
		initPane();
	}
	
	public GenericPostTab(PostContainer pc){
		post = pc;
		initPane();
	}
	
	private void initPane() {
		// Create a General Info Panel
		JPanel TabGenericInfoPanel = this;
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
		
		
		//Focus Listeners, for when box is deselected (Trigger updates, etc.)

				/*textTitle.addFocusListener(new FocusAdapter() {
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
				});*/
	}

	/* (non-Javadoc)
	 * @see sitePlugins.Interfaces.postTab#updateTitle(java.lang.String)
	 */
	public void updateTitle(String text) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sitePlugins.Interfaces.postTab#updateDescription(java.lang.String)
	 */
	public void updateDescription(String text) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sitePlugins.Interfaces.postTab#updateTags(java.lang.String)
	 */
	public void updateTags(String text) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sitePlugins.Interfaces.postTab#updateRating(int)
	 */
	public void updateRating(int rating) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sitePlugins.Interfaces.postTab#enableTab()
	 */
	public void enableTab() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sitePlugins.Interfaces.postTab#disableTab()
	 */
	public postTab disableTab() {
		// TODO Auto-generated method stub
		return null;
	}

}
