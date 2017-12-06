/**
 * 
 */
package containers;

import java.util.ArrayList;

/**
 * @author Diss
 * Holds/Loads/Saves PostContainers
 */
public class JobContainer {
	
	ArrayList<PostContainer> posts;
	int jobCount;
	
	public JobContainer(){
		posts = new ArrayList<PostContainer>();
		jobCount = 0;
		
		createBlankJob();
	}

	public int count() {
		return posts.size();
	}
	
	public PostContainer getJob(int jobIndex){
		return posts.get(jobIndex);
	}
	/**
	 * 
	 * @return new job Index
	 */
	public int createBlankJob(){
		posts.add(new PostContainer(jobCount));
		jobCount++;
		return posts.size();
	}
	
	/**
	 * 
	 * @return new job Index
	 */
	public void deleteJob(int jobIndex){
		posts.remove(jobIndex);
	}

}
