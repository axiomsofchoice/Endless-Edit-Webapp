/**
 * 
 */
package com.np_compete.endless_edit;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A collaboration is collection of collaborators. As such
 * it is the responsibility of the collaboration object to
 * oversee the operation of the project. For instance, the
 * collaboration object will enforce the access control
 * constraints the ensure collaborators can only write to
 * the parts of the document to which they are assigned
 * as well as assign appropriate positions to new
 * collaborators and .</p>
 * 
 * <p>When a new collaborator is added to the system the
 * collaboration object must ensure that.</p>
 * 
 * @author axiomsofchoice
 *
 */
public class Collaboration {

	public Collaboration(int articleLength) {
		this.article = new Article(articleLength) ;
		this.collaborators = new ArrayList<Collaborator>();
	}

	// The collection of collaborators
	List<Collaborator> collaborators ;
	
	// The document the collaborators are working on
	Article article ;
	
	/**
	 * <p>A factory method that will find a suitable location
	 * to add the new collaborator, construct a new collaborator
	 * object and add them to the collaboration.</p>
	 * @param userName TODO
	 */
	Collaborator AddCollaborator(String userId, String userName) {
		
		Collaborator collaborator = new Collaborator(userId, userName) ;
		
		// TODO: ensure all appropriate default values have been setup
		
		collaborators.add(collaborator) ;
		return collaborator ;
	}
	
	/**
	 * Get the authors who have contributed to the article as
	 * a List of Strings.
	 */
	public List<String> getAuthorsList() {
		List<String> authorList = new ArrayList<String>() ;
		
		// Populate the list of authors
		for(Collaborator c: collaborators) {
			authorList.add(c.getAuthorName()) ;
		}
		return authorList ;
	}
	
	/**
	 * Returns the collaborator based on their id string.
	 * @return
	 */
	public Collaborator getCollaboratorById(String id) {
		Collaborator foundCollaborator = null ;
		
		for(Collaborator c: this.collaborators) {
			if( id.compareTo(c.getAuthorId()) == 0 ) {
				foundCollaborator = c ;
				break ;
			}
		}
		
		// TODO: Throw exception if collaborator with id could not be found
		
		return foundCollaborator ;
	}
	

	/**
	 * Obtain a copy of the current state of the document by
	 * piecing together the components from each of the
	 * collaborators.
	 */
	String getCurrentArticleBody() {
		String currentArticleBody = "" ;
		
		// Work out how much of the contribute each athor makes
		// should be accepted
		int contributionLengths = article.getLength() / collaborators.size() ;
		
		// Populate the article body string based on
		// the contributions of the the various collaborators
		for(Collaborator c: collaborators) {
			
			String authorContrib = c.getAuthorContribution() ;
			
			// Pad out or trim the author contribution as appropriate
			if(authorContrib.length() >= contributionLengths) {
				currentArticleBody += authorContrib.substring(0, contributionLengths - 1) ;
			} else {
				currentArticleBody += authorContrib ;
				for(int i = 0 ; i < contributionLengths-authorContrib.length() ; i++) {
					currentArticleBody += " " ;
				}
			}
		}
		
		return currentArticleBody ;
	}

}
