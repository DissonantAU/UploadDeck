package containers;
import java.util.HashMap;

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
	
	
	
	HashMap<String,PluginInterface> postPlugins;
	
	
	public PostContainer(int PostUUID){
		postUUID = PostUUID;
		postTitle = "New Post";
		postTags = "";
		postDescription="";
		postRating = 0;
		postStatus = "Not Ready";
	}

	public String getTitle() {
		return postTitle;
	}

	public String getStatus() {
		return postStatus;
	}
	
	
	
	
	

}
