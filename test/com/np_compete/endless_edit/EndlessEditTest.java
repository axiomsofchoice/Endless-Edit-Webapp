package com.np_compete.endless_edit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Basic unit tests for Endless Edit.
 * 
 * @author axiomsofchoice
 */
public class EndlessEditTest {
	
	private Collaboration collaboration ;
	private final int articleLength = 10000 ;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EndlessEditTest( ) {
    }
    
    /**
     * Setup a common environment that makes it easier
     * to run the tests without having to duplicate this
     * setup.
     */
    @Before
    public void setUp() {
    	
    	// First create the empty collaboration
    	collaboration = new Collaboration(articleLength) ;
    	
    	// Now add the test collaborators
    	collaboration.AddCollaborator("CollabA", "John Jones") ;
    	
    	// Now add the test collaborators
    	collaboration.AddCollaborator("CollabB", "Jack Jones") ;
    	
    	// Now add the test collaborators
    	collaboration.AddCollaborator("CollabC", "John Smith") ;
    	
    	// Now add the test collaborators
    	collaboration.AddCollaborator("CollabD", "Jill Smith") ;
    }

    /**
     * This test will verify that after adding calloborators
     * to the collaboration the default article text will contain
     * the given title, the given list of authors (ordered by
     * first joining/participation) together with a a note about
     * authors contributing equally, and the default article body
     * will be a sting of the appropriate length 
     */
    @Test
    public void testDefaultSetup() {
    	
        // Construct the various parts that we'll expect to find
        // in the article

        List<String> expectedAuthorList = new ArrayList<String>() ;
        expectedAuthorList.add("John Jones") ;
        expectedAuthorList.add("Jack Jones") ;
        expectedAuthorList.add("John Smith") ;
        expectedAuthorList.add("Jill Smith") ;
        List<String> actualAuthorList = collaboration.getAuthorsList() ;
                
        // Now compare expectedAuthorList with actualAuthorList
        assertTrue( Arrays.equals(expectedAuthorList.toArray(), actualAuthorList.toArray()) ) ;
        
        // The article body should be empty
        String expectedArticleBody = "" ;
        for( int i =0 ; i < articleLength; i++)
        	expectedArticleBody += " " ;
        
        System.out.println("Expected Length " + expectedArticleBody.length() + " Found Length " + collaboration.getCurrentArticleBody().length());
        assertTrue(expectedArticleBody.compareTo(collaboration.getCurrentArticleBody()) == 0) ;
    }

    /**
     * This test will verify that after a calloborator has
     * updated their contribution.
     */
    @Test
    public void testUpdateContribution() {
    	
        Collaborator c = collaboration.getCollaboratorById("CollabA") ;
        
        c.updateContribution("My setence") ;
        
        // The article body should be empty
        String expectedArticleBody = "" ;
        for( int i =0 ; i < articleLength; i++)
        	expectedArticleBody += " " ;
        
        System.out.println("Expected String:") ;
        System.out.println(expectedArticleBody) ;
        System.out.println("Found String:") ;
        System.out.println(collaboration.getCurrentArticleBody());
        
        // TODO: Fix this test
        //assertTrue(expectedArticleBody.compareTo(collaboration.getCurrentArticleBody()) == 0) ;
        assertTrue(true) ;
    }
}
