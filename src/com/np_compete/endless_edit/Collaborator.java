/**
 * 
 */
package com.np_compete.endless_edit;

/**
 * <p>Collaborators are the users of the system. They may either
 * be real or bots, in the latter case entirely interacting with
 * the system via an API.
 * 
 * A collaborator must declare one or more goals for their
 * participation in the system. By satisfying goals to varying
 * degrees collaborators gain points with the meta-goal of
 * obtaining higher and higher scores.</p>
 * 
 * <p>A collaborator has no control of the position they occupy
 * in the document and so to determine this they must consult the
 * encompassing collaboration.</p>
 * 
 * @author axiomsofchoice
 *
 */
public class Collaborator {

	// The system identifier for the colaborator
	// TODO: Must be unique so perhaps this is not the best
	// place for it to be stored.
	private String collaboratorId ;
	
	// The author name in general corresponds to a "real-world name"
	private String authorName ;
	
	// The contributed string to the article from this author
	private String contribution ;
	
	/**
	 * @param userName TODO
	 * 
	 */
	public Collaborator(String userId, String userName) {
		this.collaboratorId = userId ;
		this.authorName = userName;
		// TODO: Change this default and allow it to be updated more than once
		this.contribution = "" ;
	}

	/**
	 * Get the "real-world" name of this collaborator as
	 * appropriate for populating the author list.
	 * 
	 * @return
	 */
	public String getAuthorName() {
		return this.authorName;
	}

	/**
	 * Update the contribution made by this author.
	 */
	public void updateContribution(String latestContribution) {
		// TODO: log this as an event
		
		// TODO: assign scores as a result of this event taking place
		
		this.contribution = latestContribution ;
		
	}
	
	/**
	 * Get the complete current contribution for this collaborator.
	 * The collaboration object so the first n characters from the
	 * string returned by the method as appropriate for the purpose
	 * of constructing the complete article.
	 * 
	 * @return
	 */

	public String getAuthorContribution() {
		return this.contribution;
	}

	/**
	 * 
	 * @return
	 */
	public String getAuthorId() {
		// TODO Auto-generated method stub
		return this.collaboratorId;
	}

}
