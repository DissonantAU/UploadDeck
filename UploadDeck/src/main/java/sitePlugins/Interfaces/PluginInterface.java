package sitePlugins.Interfaces;

import sitePlugins.LoginException;
import sitePlugins.UploadTracker;

public interface PluginInterface {

	/**
	 * @return the siteName
	 */
	String getSiteName();

	/**
	 * @return the maxImagesPerPost
	 */
	int getMaxImagesPerPost();

	/**
	 * Gets the minimum wait time between uploads (Seconds)
	 * @return the uploadWaitTime
	 */
	int getUploadWaitTime();

	/**
	 * Gets the data needed to login with, usually for saving
	 * @return the loginToken
	 */
	Object getLoginToken();

	/**
	 * Sets the data needed to login with. Should be used when loading.
	 * @param loginToken the loginToken to set
	 */
	void setLoginToken(Object loginToken);

	/**
	 * Returns whether the plugin has a working login.
	 * @return the loggedIn
	 */
	boolean isLoggedIn();

	/**
	 * Sets whether logged in value is set, should only be used when loading.
	 * @param loggedIn the loggedIn to set
	 */
	void setLoggedIn(boolean loggedIn);

	/**
	 * Log into site and 
	 * @return login success
	 */
	boolean loginSite() throws LoginException;

	/** Logout site - ideally log out API/Site then clear Login token and set LoggedIn to false 
	 * 
	 */
	void logoutSite();

	/**
	 * Uploads file and returns result
	 * Use UploadStatus returned by prepareUpload to track upload
	 * @param tracker object implementing UploadTracker which should be notified of progress 
	 * @return
	 */
	void executeUpload(UploadTracker tracker);

	void updateUploadStatus();

	void finishUpload();

	/**
	 * @return the jobName
	 */
	String getJobName();

	/**
	 * @param jobName the jobName to set
	 */
	void setJobName(String jobName);

}