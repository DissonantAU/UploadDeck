/**
 * 
 */
package sitePlugins;

/**
 * @author Diss
 *
 * Abstract Class to base any Plugins on
 * Each Plugin Object should hold a single account login and be saveable/loadable
 * The upload process is handled by the plugin
 */
public class AbstractSitePlugin {
	
/**
 * Name to display - should default to site name, but may be changed if multiple account are set up
 */
private String siteName = "Site Name";
/**
 * Max number of images that can be upload per post.
 * Some sites allow multiple images to be attached to a post.
 */
private int maxImagesPerPost = 1;
/**
 * Time to wait between uploading images to site
 * Useful if a site makes the use wait between uploads
 */
private int uploadWaitTime = 10;

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
 * Object for tracking/updating upload status
 * Returned by prepareUpload
 */
private UploadStatus uploadStatus = null;
/**
 * UI Element which is tracking upload - push updates to this
 */
private UploadTracker uploadStatusTracker = null;






public AbstractSitePlugin(){
}

/**
 * Initiate Plugin with existing data
 * @param isLoggedIn
 * @param siteLoginToken
 */
public AbstractSitePlugin(boolean isLoggedIn, Object siteLoginToken){
	setLoggedIn(isLoggedIn);
	setLoginToken(siteLoginToken);
}

/**
 * @return the siteName
 */
public String getSiteName() {
	return siteName;
}

/**
 * @param siteName the siteName to set
 */
public void setSiteName(String siteName) {
	this.siteName = siteName;
}

/**
 * @return the maxImagesPerPost
 */
public int getMaxImagesPerPost() {
	return maxImagesPerPost;
}

/**
 * @param maxImagesPerPost the maxImagesPerPost to set
 */
public void setMaxImagesPerPost(int maxImagesPerPost) {
	this.maxImagesPerPost = maxImagesPerPost;
}

/**
 * Gets the minimum wait time between uploads (Seconds)
 * @return the uploadWaitTime
 */
public int getUploadWaitTime() {
	return uploadWaitTime;
}

/**
 * The minimum wait time between uploads to set (Seconds)
 * @param uploadWaitTime the minimum wait time to set
 */
public void setUploadWaitTime(int uploadWaitTime) {
	this.uploadWaitTime = uploadWaitTime;
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

public void finishUpload(){
	boolean resultSuccess = false;
	String postURL = "";
	
	
	UploadResult result =new UploadResult(resultSuccess, postURL);
	// Push result
	uploadStatusTracker.uploadFinished(result);
	
	
}

}