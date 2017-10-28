package sitePlugins;

public class UploadResult{
	private boolean Success = false;
	private String postURL = null;
	
	UploadResult(boolean wasSuccessful, String PostURL){
		Success = wasSuccessful;
		postURL = PostURL;
	}
	
	/**
	 * @return the whether the upload was successful
	 */
	public boolean wasSuccessful() {
		return Success;
	}

	/**
	 * @return the get the URL of the post.
	 */
	public String getPostURL() {
		return postURL;
	}

	
}
