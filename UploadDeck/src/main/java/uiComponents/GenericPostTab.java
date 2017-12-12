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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import sitePlugins.Interfaces.postTab;
import containers.PostContainer;

/**
 * @author Diss
 *
 */
public class GenericPostTab extends JPanel implements postTab, DocumentListener {
	//TabID is used by PostContainer to know where pass info
	final static private String TabID = "Generic";
	
	final static private String FIELD_ID = "FIELD";
	final static private String FIELD_TITLE = "Title";
	final static private String FIELD_TEXT = "Text";
	final static private String FIELD_TAGS = "Tags";
	
	// Rating Combo box
	JComboBox<String> comboRating;
	
	
	// Combo Box Values
	// Should be 0 - General, 1 - Mature, 2 - Adult
	final private String[] ratingStrings = {"General Audience","Mature Audience","Adult Audience"};
	

	private JTextField textTitle;
	private JTextField textTags;
	private JTextArea textDescription;
	
	//COntatins post data
	private PostContainer post;
	
	//UI element that contains this tab. Should be passed UI update events
	private postPane PostPane;
	
	
	public GenericPostTab(postPane postPane) {
		PostPane = postPane;
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
		textTitle.getDocument().addDocumentListener(this);
		textTitle.getDocument().putProperty(FIELD_ID, FIELD_TITLE);
		TabGenericInfoPanel.add(textTitle, "cell 1 0,growx");
		
		// Post Text field and label (aka description)
		JLabel lblPostText = new JLabel("Description");
		TabGenericInfoPanel.add(lblPostText, "cell 0 1,alignx trailing");
		
		textDescription = new JTextArea();
		textDescription.setLineWrap(true);
		textDescription.setRows(8);
		textDescription.getDocument().addDocumentListener(this);
		textDescription.getDocument().putProperty(FIELD_ID, FIELD_TEXT);
		TabGenericInfoPanel.add(textDescription, "cell 1 1,grow");
		
		// Tag box and label. (Tags should be separated by commas)
		JLabel lblTags = new JLabel("Tags");
		TabGenericInfoPanel.add(lblTags, "cell 0 2,alignx trailing");
		
		textTags = new JTextField();
		textTags.getDocument().addDocumentListener(this);
		textTags.getDocument().putProperty(FIELD_ID, FIELD_TAGS);
		TabGenericInfoPanel.add(textTags, "cell 1 2,growx");
		
		// Rating Drop Down box and label
		JLabel lblRating = new JLabel("Rating");
		TabGenericInfoPanel.add(lblRating, "cell 0 3,alignx trailing");
		
		
		comboRating = new JComboBox<String>(new DefaultComboBoxModel<String>(ratingStrings));
		TabGenericInfoPanel.add(comboRating, "cell 1 3,growx");
		//TODO Put Listener for value change
		
		
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

	public void setJob(PostContainer currentJob) {
		post = currentJob;
		//TODO Update elements
	}
	

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		Object owner = arg0.getDocument().getProperty(FIELD_ID);
		System.out.println("GenericPostTab - Document: changedUpdate '" + FIELD_ID+"' = "+owner);

		if (owner ==FIELD_TITLE){
			//Title Updated
			System.out.println("GenericPostTab - Document: changedUpdate triggered by "+FIELD_TITLE);
			
		}else if (owner == FIELD_TEXT){
			//Text Updated
			System.out.println("GenericPostTab - Document: changedUpdate triggered by "+FIELD_TITLE);
			
		}else if (owner == FIELD_TAGS){
			//Tags Updated
			System.out.println("GenericPostTab - Document: changedUpdate triggered by "+FIELD_TITLE);
			
		}
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		Object owner = arg0.getDocument().getProperty(FIELD_ID);
		System.out.println("GenericPostTab - Document: insertUpdate '" + FIELD_ID+"' = "+owner);

		if (owner ==FIELD_TITLE){
			//Title Updated
			System.out.println("GenericPostTab - Document: insertUpdate triggered by "+FIELD_TITLE);
			
		}else if (owner == FIELD_TEXT){
			//Text Updated
			System.out.println("GenericPostTab - Document: insertUpdate triggered by "+FIELD_TITLE);
			
		}else if (owner == FIELD_TAGS){
			//Tags Updated
			System.out.println("GenericPostTab - Document: insertUpdate triggered by "+FIELD_TITLE);
			
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		Object owner = arg0.getDocument().getProperty(FIELD_ID);
		System.out.println("GenericPostTab - Document: removeUpdate '" + FIELD_ID+"' = "+owner);

		if (owner ==FIELD_TITLE){
			//Title Updated
			System.out.println("GenericPostTab - Document: removeUpdate triggered by "+FIELD_TITLE);
			
		}else if (owner == FIELD_TEXT){
			//Text Updated
			System.out.println("GenericPostTab - Document: removeUpdate triggered by "+FIELD_TITLE);
			
		}else if (owner == FIELD_TAGS){
			//Tags Updated
			System.out.println("GenericPostTab - Document: removeUpdate triggered by "+FIELD_TITLE);
			
		}
	}
}