/**
 * 
 */
package sitePlugins.Interfaces;

import containers.PostContainer;

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
	public void updateTitle();
	
	/**
	 * Triggered when the Description field is updated in the General Tab
	 */
	public void updateDescription();
	
	/**
	 * Triggered when the Tags field is updated in the General Tab
	 */
	public void updateTags();

	/**
	 * Triggered when the Rating Combo Box is updated in the General Tab
	 * 0 is General, 1 is Mature, 2 is Adult
	 */
	public void updateRating();
	
	/**
	 * Triggered when site is enabled for post
	 */
	public void enableTab();
	
	/**
	 * Triggered when site is disabled for post
	 * Should return same Tab and values used as earlier and update
	 */
	public postTab disableTab();

	/**
	 * Sets Job Data Container. Should update UI from contents
	 * @param currentJob
	 */
	public void setJob(PostContainer currentJob);
	
	
}
