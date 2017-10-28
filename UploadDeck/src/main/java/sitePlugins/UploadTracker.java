package sitePlugins;

public interface UploadTracker {

	/**
	 * Executed by an upload plugin to update and registered UI, etc.
	 * @param totalKB total file size in KB
	 * @param uploadedKB uploaded data amount in KB
	 */
	public void uploadStatusUpdated(int totalKB, int uploadedKB);
	
	/**
	 * Executed on upload finish - either failure or success.
	 * Check object for result
	 * @param result Object containing results of upload
	 */
	public void uploadFinished(UploadResult result);
}
