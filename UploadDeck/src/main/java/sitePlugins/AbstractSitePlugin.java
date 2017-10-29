/**
 * 
 */
package sitePlugins;

import java.util.HashMap;

/**
 * @author Diss
 *
 * Abstract Class to base any Plugins on
 * Each Plugin Object should hold a single account login and be saveable/loadable
 * The upload process is handled by the plugin
 */
public class AbstractSitePlugin {
	/**
	 * Site name - should be site name and unique. Used with UploadImage Object to track versions of images for upload
	 */
	static private String siteName = "Site Name";
	/**
	 * Name to display - should default to site name, but may be changed if multiple account are set up
	 */
	private String jobName = siteName;
	/**
	 * Max number of images that can be upload per post.
	 * Some sites allow multiple images to be attached to a post.
	 */
	static private int maxImagesPerPost = 1;
	/**
	 * Time to wait between uploading images to site
	 * Useful if a site makes the use wait between uploads
	 */
	static private int uploadWaitTime = 10;
	/**
	 * Generic Object to hold any login tokens, cookies, etc.
	 * No password should be held here
	 */
	private Object loginToken = null;
	/** 
	 * Login status
	 * Is used by program to see if the user needs to be prompted to log in
	 */
	private boolean loggedIn = false;
	/**
	 * UI Element which is tracking upload - push updates to this
	 */
	private UploadTracker uploadStatusTracker = null;

	private HashMap<String,UploadImage> ImagesToUpload = null;




	public AbstractSitePlugin(){
		ImagesToUpload = new HashMap<String,UploadImage>();
	}

	/**
	 * Initiate Plugin with existing data
	 * @param isLoggedIn
	 * @param siteLoginToken
	 */
	public AbstractSitePlugin(boolean isLoggedIn, Object siteLoginToken){
		setLoggedIn(isLoggedIn);
		setLoginToken(siteLoginToken);
		ImagesToUpload = new HashMap<String,UploadImage>();
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @return the maxImagesPerPost
	 */
	public int getMaxImagesPerPost() {
		return maxImagesPerPost;
	}

	/**
	 * Gets the minimum wait time between uploads (Seconds)
	 * @return the uploadWaitTime
	 */
	public int getUploadWaitTime() {
		return uploadWaitTime;
	}

	/**
	 * Gets the data needed to login with, usually for saving
	 * @return the loginToken
	 */
	public Object getLoginToken() {
		return loginToken;
	}

	/**
	 * Sets the data needed to login with. Should be used when loading.
	 * @param loginToken the loginToken to set
	 */
	public void setLoginToken(Object loginToken) {
		this.loginToken = loginToken;
	}

	/**
	 * Returns whether the plugin has a working login.
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Sets whether logged in value is set, should only be used when loading.
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	/**
	 * Log into site and 
	 * @return login success
	 */
	public boolean loginSite() throws LoginException{
		setLoggedIn(true);
		setLoginToken(new Object());



		return loggedIn;
	}
	/** Logout site - ideally log out API/Site then clear Login token and set LoggedIn to false 
	 * 
	 */
	public void logoutSite(){
		setLoggedIn(false);
		setLoginToken(null);
	}

	/**
	 * Uploads file and returns result
	 * Use UploadStatus returned by prepareUpload to track upload
	 * @param tracker object implementing UploadTracker which should be notified of progress 
	 * @return
	 */
	public void executeUpload(UploadTracker tracker){
		uploadStatusTracker = tracker;
	}
	
	public void updateUploadStatus(){
		
		
	}

	public void finishUpload(){
		boolean resultSuccess = false;
		String postURL = "";


		UploadResult result =new UploadResult(resultSuccess, postURL);
		// Push result
		uploadStatusTracker.uploadFinished(result);


	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}