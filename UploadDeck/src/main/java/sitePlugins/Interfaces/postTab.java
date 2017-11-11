/**
 * 
 */
package sitePlugins.Interfaces;

/**
 * Interface for post tabs.
 * 
 * 
 * 
 * Tabs should  implement this, and extend JPanel and be returned by the plugin when enabled as part of a job
 * @author Diss
 *
 */
public interface postTab {
	
	/**
	 * Triggered when the Title field is updated in the General Tab
	 */
	public void updateTitle(String text);
	
	/**
	 * Triggered when the Description field is updated in the General Tab
	 */
	public void updateDescription(String text);
	
	/**
	 * Triggered when the Tags field is updated in the General Tab
	 */
	public void updateTags(String text);

	/**
	 * Triggered when the Rating Combo Box is updated in the General Tab
	 * 0 is General, 1 is Mature, 2 is Adult
	 */
	public void updateRating(int rating);
}
