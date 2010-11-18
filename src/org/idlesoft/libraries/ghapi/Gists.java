/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;


public class Gists extends APIAbstract {

	public Gists(GitHubAPI a) {
		super(a);
	}

	/**
	 * Get a Gist's Metadata
	 *
	 * @param gist_id
	 * @return
	 */
	public Response get_metadata(String gist_id) {
	    return HTTPGet("https://gist.github.com/api/v1/json/" + encode(gist_id));
	}

	/**
	 * Get a Gist's Content
	 *
	 * @param gist_id
	 * @param filename
	 * @return
	 */
	public Response get_content(String gist_id, String filename) {
	    return HTTPGet("https://gist.github.com/raw/" + encode(gist_id) + "/" + encode(filename));
	}

	/**
	 * List a User's Public Gists
	 *
	 * @param username
	 * @return
	 */
	public Response list_gists(String username) {
	    return HTTPGet("https://gist.github.com/api/v1/json/gists/" + encode(username));
	}
}