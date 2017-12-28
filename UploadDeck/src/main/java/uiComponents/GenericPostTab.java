/**
 * 
 */
package uiComponents;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
public class GenericPostTab extends JPanel  implements postTab, DocumentListener, FocusListener {
	//TabID is used by PostContainer to know where pass info
	final static private String TabID = "Generic";
	
	final static private String FIELD_ID = "FIELD";
	final static private String FIELD_TITLE = "Title";
	final static private String FIELD_TEXT = "Description";
	final static private String FIELD_TAGS = "Tags";
	
	
	//UI Update Tracking
	private boolean fieldUpdatedTitle, fieldUpdatedText, fieldUpdatedTags;
	
	// Combo Box Values
	// Should be 0 - General, 1 - Mature, 2 - Adult
	final private String[] ratingStrings = {"General Audience","Mature Audience","Adult Audience"};
	
	// UI Elements
	private JTextField textTitle;
	private JTextField textTags;
	private JTextArea textDescription;
	
	// Rating Combo box
	private JComboBox<String> comboRating;
	
	
	//Contains post data
	private PostContainer postDataContainer;
	
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
		textTitle.addFocusListener(this);
		fieldUpdatedTitle=false;
		textTitle.getDocument().addDocumentListener(this);
		textTitle.getDocument().putProperty(FIELD_ID, FIELD_TITLE);
		TabGenericInfoPanel.add(textTitle, "cell 1 0,growx");
		
		// Post Text field and label (aka description)
		JLabel lblPostText = new JLabel("Description");
		TabGenericInfoPanel.add(lblPostText, "cell 0 1,alignx trailing");
		
		textDescription = new JTextArea();
		textDescription.setLineWrap(true);
		textDescription.setRows(8);
		textDescription.addFocusListener(this);
		fieldUpdatedText=false;
		textDescription.getDocument().addDocumentListener(this);
		textDescription.getDocument().putProperty(FIELD_ID, FIELD_TEXT);
		TabGenericInfoPanel.add(textDescription, "cell 1 1,grow");
		
		// Tag box and label. (Tags should be separated by commas)
		JLabel lblTags = new JLabel("Tags");
		TabGenericInfoPanel.add(lblTags, "cell 0 2,alignx trailing");
		
		textTags = new JTextField();
		textTags.addFocusListener(this);
		fieldUpdatedTags=false;
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

	/**
	 * Does nothing in Generic Tab
	 * @see sitePlugins.Interfaces.postTab#updateTitle(java.lang.String)
	 */
	public void updateTitle() {}

	/**
	 * Does nothing in Generic Tab
	 * @see sitePlugins.Interfaces.postTab#updateDescription(java.lang.String)
	 */
	public void updateDescription() {}

	/**
	 * Does nothing in Generic Tab
	 * @see sitePlugins.Interfaces.postTab#updateTags(java.lang.String)
	 */
	public void updateTags() {}

	/**
	 * Does nothing in Generic Tab
	 * @see sitePlugins.Interfaces.postTab#updateRating(int)
	 */
	public void updateRating() {}

	/**
	 * Does nothing in Generic Tab
	 * @see sitePlugins.Interfaces.postTab#enableTab()
	 */
	public void enableTab() {}

	/**
	 * Does nothing in Generic Tab
	 * @see sitePlugins.Interfaces.postTab#disableTab()
	 */
	public postTab disableTab() {
		return null;
	}

	/**
	 * Updates Job displayed by Tab
	 */
	public void setJob(PostContainer currentJob) {
		postDataContainer = currentJob;
		
		updateUIFields();
	}
	
	/**
	 * Updated all fields from Data Container
	 */
	private void updateUIFields(){
		// Text Fields
		textTitle.setText(postDataContainer.getTitle());
		textTags.setText(postDataContainer.getTags());
		textDescription.setText(postDataContainer.getDescription());
		
		// Rating Combo box
		comboRating.setSelectedIndex(postDataContainer.getPostRating());
	}
	
	// ## Field Change Methods
	/**
	 * Marks field as being dirty. On Focus Lost, the new text will be handled by fieldUpdateCheck
	 * @param fieldUpdated
	 * @see fieldUpdateCheck
	 */
	private void fieldUpdated(Object fieldUpdated){
		System.out.println("fieldUpdated: '" + FIELD_ID + "' = " + fieldUpdated);

		if (fieldUpdated == FIELD_TITLE){
			//Title Updated
			fieldUpdatedTitle=true;
		}else if (fieldUpdated == FIELD_TEXT){
			//Description Updated
			fieldUpdatedText=true;
		}else if (fieldUpdated == FIELD_TAGS){
			//Tags Updated
			fieldUpdatedTags=true;
		}
	}
	
	/**
	 * Checks if field has been marked dirty, passes updated value to postPane and updated postContainer
	 * @param updateSource
	 */
	private void fieldUpdateCheck(Object updateSource){
		if (updateSource==textTitle && fieldUpdatedTitle){
			//if Title Field was updated
			postDataContainer.setTitle(textTitle.getText()); //Update Title in data container
			PostPane.updatedTitle(); // Report update to PostPane
			
			fieldUpdatedTitle=false;
		} else if (updateSource==textDescription && fieldUpdatedText){
			//if Description Field was updated
			postDataContainer.setDescription(textDescription.getText());
			
			fieldUpdatedText=false;
		} else if (updateSource==textTags && fieldUpdatedTags){
			//if Tag Field was updated
			postDataContainer.setTags(textTags.getText());

			fieldUpdatedTags=false;
		}
				
		
	}
	
	// #### EVENT LISTENER METHODS ####
	// ## Document Listener Events ##

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		Object fieldUpdated = arg0.getDocument().getProperty(FIELD_ID);
		System.out.println("GenericPostTab - Document: changedUpdate '" + FIELD_ID + "' = " + fieldUpdated);
		
		// Pass updated filed ID to filedUpdated (Marks field as changed for fieldUpdateCheck)
		fieldUpdated(fieldUpdated);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		Object fieldUpdated = arg0.getDocument().getProperty(FIELD_ID);
		System.out.println("GenericPostTab - Document: insertUpdate '" + FIELD_ID+"' = " + fieldUpdated);

		// Pass updated filed ID to filedUpdated (Marks field as changed for fieldUpdateCheck)
		fieldUpdated(fieldUpdated);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		Object fieldUpdated = arg0.getDocument().getProperty(FIELD_ID);
		System.out.println("GenericPostTab - Document: removeUpdate '" + FIELD_ID+"' = " + fieldUpdated);
		
		// Pass updated filed ID to filedUpdated (Marks field as changed for fieldUpdateCheck)
		fieldUpdated(fieldUpdated);
	}

	// ## Focus Listener Events ##
	@Override
	public void focusGained(FocusEvent arg0) {
		// Do nothing
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		//Send Source to method to check if fields have updated, etc.
		fieldUpdateCheck(arg0.getSource());		
	}
	
	// #### EVENT LISTENER METHODS ####
	
}