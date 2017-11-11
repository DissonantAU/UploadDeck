/**
 * 
 */
package sitePlugins.ExamplePlugin;

import java.util.HashMap;

import sitePlugins.LoginException;
import sitePlugins.UploadImage;
import sitePlugins.UploadResult;
import sitePlugins.UploadTracker;
import sitePlugins.Interfaces.PluginInterface;

/**
 * @author Diss
 *
 * Abstract Class to base any Plugins on
 * Each Plugin Object should hold a single account login and be saveable/loadable
 * The upload process is handled by the plugin
 */
public class ExampleSitePlugin implements PluginInterface {
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




	public ExampleSitePlugin(){
		ImagesToUpload = new HashMap<String,UploadImage>();
	}

	/**
	 * Initiate Plugin with existing data
	 * @param isLoggedIn
	 * @param siteLoginToken
	 */
	public ExampleSitePlugin(boolean isLoggedIn, Object siteLoginToken){
		setLoggedIn(isLoggedIn);
		setLoginToken(siteLoginToken);
		ImagesToUpload = new HashMap<String,UploadImage>();
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#getSiteName()
	 */
	public String getSiteName() {
		return siteName;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#getMaxImagesPerPost()
	 */
	public int getMaxImagesPerPost() {
		return maxImagesPerPost;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#getUploadWaitTime()
	 */
	public int getUploadWaitTime() {
		return uploadWaitTime;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#getLoginToken()
	 */
	public Object getLoginToken() {
		return loginToken;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#setLoginToken(java.lang.Object)
	 */
	public void setLoginToken(Object loginToken) {
		this.loginToken = loginToken;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#isLoggedIn()
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#setLoggedIn(boolean)
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#loginSite()
	 */
	public boolean loginSite() throws LoginException{
		setLoggedIn(true);
		setLoginToken(new Object());



		return loggedIn;
	}
	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#logoutSite()
	 */
	public void logoutSite(){
		setLoggedIn(false);
		setLoginToken(null);
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#executeUpload(sitePlugins.UploadTracker)
	 */
	public void executeUpload(UploadTracker tracker){
		uploadStatusTracker = tracker;
	}
	
	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#updateUploadStatus()
	 */
	public void updateUploadStatus(){
		
		
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#finishUpload()
	 */
	public void finishUpload(){
		boolean resultSuccess = false;
		String postURL = "";


		UploadResult result = new UploadResult(resultSuccess, postURL);
		// Push result
		uploadStatusTracker.uploadFinished(result);
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#getJobName()
	 */
	public String getJobName() {
		return jobName;
	}

	/* (non-Javadoc)
	 * @see sitePlugins.PluginInterface#setJobName(java.lang.String)
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}