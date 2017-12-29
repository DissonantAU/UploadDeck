/**
 * 
 */
package sitePlugins.ExamplePlugin;

import sitePlugins.Interfaces.PluginData;
import sitePlugins.Interfaces.PluginInterface;

/**
 * @author Diss
 *
 */
public class ExamplePluginData implements PluginData {

	//Customise Tracking - should be false by default and changed if the value should be customised
	private boolean customiseTitleEnabled, customiseDescEnabled, customiseTagsEnabled,customiseRatingEnabled;
	
	//Text Values
	
	private String postTitle, postTags, postDescription;
	private int postRating;
	private String postStatus;
	
	
	
	/**
	 * @return the customiseTitleEnabled
	 */
	public boolean isCustomiseTitleEnabled() {
		return customiseTitleEnabled;
	}

	/**
	 * @param customiseTitleEnabled the customiseTitleEnabled to set
	 */
	public void setCustomiseTitleEnabled(boolean customiseTitleEnabled) {
		this.customiseTitleEnabled = customiseTitleEnabled;
	}

	/**
	 * @return the customiseDescEnabled
	 */
	public boolean isCustomiseDescEnabled() {
		return customiseDescEnabled;
	}

	/**
	 * @param customiseDescEnabled the customiseDescEnabled to set
	 */
	public void setCustomiseDescEnabled(boolean customiseDescEnabled) {
		this.customiseDescEnabled = customiseDescEnabled;
	}

	/**
	 * @return the customiseTagsEnabled
	 */
	public boolean isCustomiseTagsEnabled() {
		return customiseTagsEnabled;
	}

	/**
	 * @param customiseTagsEnabled the customiseTagsEnabled to set
	 */
	public void setCustomiseTagsEnabled(boolean customiseTagsEnabled) {
		this.customiseTagsEnabled = customiseTagsEnabled;
	}

	/**
	 * @return the customiseRatingEnabled
	 */
	public boolean isCustomiseRatingEnabled() {
		return customiseRatingEnabled;
	}

	/**
	 * @param customiseRatingEnabled the customiseRatingEnabled to set
	 */
	public void setCustomiseRatingEnabled(boolean customiseRatingEnabled) {
		this.customiseRatingEnabled = customiseRatingEnabled;
	}

	/**
	 * 
	 */
	public ExamplePluginData() {
		customiseTitleEnabled=false;
		customiseDescEnabled=false;
		customiseTagsEnabled=false;
		customiseRatingEnabled=false;
		
		postTitle = "";
		postTags = "";
		postDescription="";
		postRating = 0;
		
		postStatus = "";
	}

	/**
	 * @return the postTitle
	 */
	public String getPostTitle() {
		return postTitle;
	}

	/**
	 * @param postTitle the postTitle to set
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	/**
	 * @return the postTags
	 */
	public String getPostTags() {
		return postTags;
	}

	/**
	 * @param postTags the postTags to set
	 */
	public void setPostTags(String postTags) {
		this.postTags = postTags;
	}

	/**
	 * @return the postDescription
	 */
	public String getPostDescription() {
		return postDescription;
	}

	/**
	 * @param postDescription the postDescription to set
	 */
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	/**
	 * @return the postRating
	 */
	public int getPostRating() {
		return postRating;
	}

	/**
	 * @param postRating the postRating to set
	 */
	public void setPostRating(int postRating) {
		this.postRating = postRating;
	}

	/**
	 * @return the postStatus
	 */
	public String getPostStatus() {
		return postStatus;
	}

	/**
	 * @param postStatus the postStatus to set
	 */
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	/** 
	 * Returns class of related logic plugin
	 * Used by PostContainer to separate   
	 * @see sitePlugins.Interfaces.PluginData#getPluginClass()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends PluginInterface> getPluginClass() {
		//Returns related Plugin's Class. May get rid of later
		return (Class<? extends PluginInterface>) ExamplePluginData.class;
	}

}
