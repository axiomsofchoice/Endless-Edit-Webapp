/**
 * 
 */
package com.np_compete.endless_edit;

/**
 * <p>An abstract representation of the article the collaborators are
 * working on</p>
 * 
 * @author axiomsofchoice
 *
 */
public class Article {

	/**
	 * 
	 */
	public Article(int articleLength) {
		this.length = articleLength ;
	}

	// The length of the document (measured in Unicode characters)
	private int length;

	/**
	 * <p>Get the value of the length of this article.</p>
	 * 
	 * <p><em>At present the length of article is a read-only value
	 * established when and Article object is constructed.</em></p>
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}
	
}
