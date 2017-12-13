package containers;
import java.util.HashMap;

import sitePlugins.Interfaces.PluginData;
import sitePlugins.Interfaces.PluginInterface;

/**
 * 
 */

/**
 * @author Diss
 * Used to Hold Post info
 */
public class PostContainer {
	
	
	//Image
	Object image;
	
	//Generic Values
	int postUUID; //Internal ID for posts
	String postTitle, postTags,postDescription;
	int postRating;
	
	String postStatus;
	
	
	
	HashMap<String,PluginData> postPluginData;
	
	
	public PostContainer(int PostUUID){
		postUUID = PostUUID;
		postTitle = "New Post";
		postTags = "";
		postDescription="";
		postRating = 0;
		postStatus = "Not Ready";
		postPluginData = new HashMap<String, PluginData>();
	}

	/**
	 * @return the postTags
	 */
	public String getTags() {
		return postTags;
	}

	/**
	 * @param postTags the postTags to set
	 */
	public void setTags(String postTags) {
		this.postTags = postTags;
	}

	/**
	 * @return the postDescription
	 */
	public String getDescription() {
		return postDescription;
	}

	/**
	 * @param postDescription the postDescription to set
	 */
	public void setDescription(String postDescription) {
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
	 * @return the postUUID
	 */
	public int getPostUUID() {
		return postUUID;
	}

	/**
	 * @param postStatus the postStatus to set
	 */
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	public String getTitle() {
		return postTitle;
	}

	public String getStatus() {
		return postStatus;
	}

	public HashMap<String, PluginData> getPluginData() {
		return postPluginData;
		
	}

	/**
	 * Updates Generic Title Text
	 * @param text
	 */
	public void setTitle(String text) {
		postTitle= text;
	}
	
	
	
	
	

}
